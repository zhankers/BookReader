package com.ibook.component.collectors;

import java.util.*;
import java.util.function.*;
import java.util.stream.Collector;

/**
 * @Description:
 * @Authr: yaunde
 * @Date: 2018-11-17 22:35
 */
public class PrimeNumberCollector implements Collector<Integer, Map<Boolean, List<Integer>>, Map<Boolean, List<Integer>>> {

    @Override
    public Supplier<Map<Boolean, List<Integer>>> supplier() {
        return () -> new HashMap<Boolean, List<Integer>>(2){{
            put(true, new ArrayList<>());
            put(false, new ArrayList<>());
        }};
    }

    @Override
    public BiConsumer<Map<Boolean, List<Integer>>, Integer> accumulator() {
        return (Map<Boolean, List<Integer>> acc, Integer candidate) -> {
            acc.get(isPrimeNumber(acc.get(true), candidate)).add(candidate);
        };
    }

    /**
     * 当为并行流时，合并两个或多个结果容器
     *
     * @return
     */
    @Override
    public BinaryOperator<Map<Boolean, List<Integer>>> combiner() {
        return (Map<Boolean, List<Integer>> acc1, Map<Boolean, List<Integer>> acc2) ->{
            acc1.get(true).addAll(acc2.get(true));
            acc1.get(false).addAll(acc2.get(false));
            return acc1;
        };
    }

    /**
     * 对结果容器进行转换
     *
     * @return
     */
    @Override
    public Function<Map<Boolean, List<Integer>>, Map<Boolean, List<Integer>>> finisher() {
        return Function.identity();
    }

    /**
     *
     * @return
     */
    @Override
    public Set<Characteristics> characteristics() {
        return Collections.unmodifiableSet(EnumSet.of(Characteristics.IDENTITY_FINISH));
    }

    public static boolean isPrimeNumber(List<Integer> primaes, int candidate) {
        int candidateRoot = (int)Math.sqrt((double) candidate);
        return takeWhile(primaes, i -> i <= candidateRoot).stream().noneMatch(p -> candidate % p == 0);
    }

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
}
