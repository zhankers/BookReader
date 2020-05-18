package com.ebook.argorithm.sorts;

import java.util.Arrays;
import java.util.stream.Stream;

/**
 * @Description: 分别从初始序列“6 1 2 7 9 3 4 5 10 8”两端开始“探测”。先从右往左找一个小于6的数，
 * 再从左往右找一个大于6的数，然后交换他们。这里可以用两个变量i和j，分别指向序列最左边和最右边。我们
 * 为这两个变量起个好听的名字“哨兵i”和“哨兵j”。刚开始的时候让哨兵i指向序列的最左边（即i=1），指向数字6。
 * 让哨兵j指向序列的最右边（即=10），指向数字。
 * @Authr: yaunde
 * @Date: 2019-10-23 14:02
 */
public class QuickSort {

    public static void quickSort(int[] arr, int low, int high) {
        if (low > high) {
            return;
        }

        int i = low, j = high;

        while (i < j) {
            int curentData = arr[low];

            while (curentData < arr[j] && i < j) {
                j--;
            }

            while (curentData > arr[i] && i < j) {
                i++;
            }

            int temp = arr[i];
            arr[i] = arr[j];
            arr[j] = temp;
        }

        quickSort(arr, low, j - 1);
        quickSort(arr, j + 1, high);

    }

    public static void main(String[] args) {
        int[] arr = new int[]{6, 1, 2, 7, 9, 3, 19, 4, 5, 10, 8};

        quickSort(arr, 0, arr.length - 1);

        Stream.of(arr).forEach(item -> System.out.println(Arrays.toString(item) + " "));

    }

}
