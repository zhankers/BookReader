package com.ibook.component.collectors;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * @Description:
 * @Authr: yaunde
 * @Date: 2018-11-18 10:37
 */
public class PrimeNumberCollectors {

    public static Map<Boolean,List<Integer>> partitionPrimesWithCustomCollector(int n) {
        return IntStream.rangeClosed(2,n).boxed().collect(
                () -> new HashMap<Boolean, List<Integer>>(){{
                    put(true, new ArrayList<>());
                    put(false, new ArrayList<>());
                }},
                (Map<Boolean, List<Integer>> acc, Integer candidate) -> {
                    acc.get(isPrimeNumber(acc.get(true), candidate)).add(candidate);
                },
                (Map<Boolean, List<Integer>> acc1, Map<Boolean, List<Integer>> acc2) ->{
                    acc1.get(true).addAll(acc2.get(true));
                    acc1.get(false).addAll(acc2.get(false));
                }
        );
    }

    public static boolean isPrimeNumber(List<Integer> primaes, int candidate) {
        int candidateRoot = (int)Math.sqrt((double) candidate);
        return takeWhile(primaes, i -> i <= candidateRoot).stream().noneMatch(p -> candidate % p == 0);
    }

    /**
     * 取出比候选数开方数字以内的所有质数 因为不能被质数整除，说明也不会被其他数整除
     *
     * @param list
     * @param p
     * @param <A>
     * @return
     */
    public static <A> List<A> takeWhile(List<A> list, Predicate<A> p) {
        int i = 0;
        for (A item : list) {
            if (!p.test(item)) {
                return list.subList(0,i);
            }
            i++;
        }
        return list;
    }

    public static void main(String[] args) {

    }
    public static boolean isPrimeNumber2(List<Integer> primaes, int candidate) {
        int candidateRoot = (int)Math.sqrt((double) candidate);
        return takeWhile(primaes, i -> i <= candidateRoot).stream().noneMatch(p -> candidate % p == 0);
    }

    public static <A> List<A> takeWhile2(List<A> list, Predicate<A> p) {
        return list.stream().filter(p).collect(Collectors.toList());
    }
}
