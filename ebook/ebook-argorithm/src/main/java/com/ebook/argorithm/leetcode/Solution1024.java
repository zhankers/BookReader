package com.ebook.argorithm.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Objects;


class Solution1024 {
    public int[] findDiagonalOrder(List<List<Integer>> nums) {
//        Map<Integer, List<Integer>> treeMap = new TreeMap<>();
        List<Integer>[] ijList = new LinkedList[100_000];

        for (int i = 0; i < nums.size(); i++) {
            for (int j = 0; j < nums.get(i).size(); j++) {
                List<Integer> list = ijList[i + j];
                if (list != null) {
                    list.add(nums.get(i).get(j));
                } else {
                    List<Integer> items = new LinkedList<>();
                    items.add(nums.get(i).get(j));
                    ijList[i + j] = items;
                }
            }
        }

        return Arrays.stream(ijList).parallel()
                .filter(Objects::nonNull)
                .peek(Collections::reverse)
                .flatMapToInt(list -> list.stream().mapToInt(Integer::intValue))
                .toArray();
    }

    public static void main(String[] args) {
        int[][] nums =
                {
                        {1, 2, 3},
                        {4, 5, 6},
                        {7, 8, 9}
                };
        List<List<Integer>> nunm = new ArrayList<>();
        List<Integer> _1 = new ArrayList<>();
        _1.add(1);
        _1.add(2);
        _1.add(3);
        List<Integer> _2 = new ArrayList<>();
        _2.add(4);
        _2.add(5);
        _2.add(6);
        List<Integer> _3 = new ArrayList<>();
        _3.add(7);
        _3.add(8);
        _3.add(9);

        nunm.add(_1);
        nunm.add(_2);
//        nunm.add(_3);
        int[] diagonalOrder = new Solution1024().findDiagonalOrder(nunm);
        System.out.println(Arrays.toString(diagonalOrder));
    }
}