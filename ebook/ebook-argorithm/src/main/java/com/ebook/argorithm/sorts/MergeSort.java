package com.ebook.argorithm.sorts;

import java.util.Arrays;
import java.util.stream.Stream;

/**
 * @Description:
 * @Authr: yaunde
 * @Date: 2019-10-28 15:44
 */
public class MergeSort {

    public static void main(String[] args) {
        int[] ints = {1, 2, 5, 6, 3, 4, 7};
        int[] sorted = mergeSort(ints);

        for (int aSorted : sorted) {
            System.out.print(aSorted + " ");
        }




        // Arrays.asList(sorted).stream().forEach(i -> System.out.println(i.length + " "));

    }

    public static int[] mergeSort(int[] arr) {
        int middle = arr.length / 2;
        int[] tmp = new int[arr.length];
        int i = 0;
        int j = middle + 1;
        int k = 0;

        while (i <= middle && j < arr.length) {
            if (arr[i] <= arr[j]) {
                tmp[k] = arr[i];
                k++;
                i++;

            } else {
                tmp[k] = arr[j];
                k++;
                j++;

            }
        }

        while (i <= middle) {
            tmp[k] = arr[i];
            k++;
            i++;
        }

        while (j < arr.length) {
            tmp[k++] = arr[j++];
        }

        return tmp;

    }
}
