package com.ltl.algo.sort.merge;

import com.ltl.algo.test.SortTest;

public class MergeSort {

    public static void mergeSort1(int[] arr) {
        if (arr == null || arr.length < 2) {
            return;
        }
        process(arr, 0, arr.length - 1);
    }

    public static void mergeSort2(int[] arr) {
        int N = arr.length;
        int mergeSize = 1;
        while (mergeSize < N) {
            int L = 0;
            while (L < N) {
                int mid = L + mergeSize - 1;
                if (mid >= N) {
                    break;
                }
                int R = Math.min(N - 1, mid + mergeSize);
                merge(arr, L, mid, R);
                L = R + 1;
            }

            if (mergeSize > N/2) {
                break;
            }
            mergeSize <<= 1;
        }
    }

    public static void process(int[] arr, int L, int R) {
        if (L == R) {
            return;
        }
        int mid = L + ((R - L) >> 1);
        process(arr, L, mid);
        process(arr, mid + 1, R);
        merge(arr, L, mid, R);
    }

    public static void merge(int[] arr, int L, int mid, int R) {
        int[] help = new int[R - L + 1];
        int p1 = L;
        int p2 = mid + 1;
        int index = 0;
        while (p1 <= mid && p2 <= R) {
           help[index++] = arr[p1] <= arr[p2] ? arr[p1++] : arr[p2++];
        }
        while (p1 <= mid) {
            help[index++] = arr[p1++];
        }
        while (p2 <= R) {
            help[index++] = arr[p2++];
        }
        for (int i = 0; i < help.length; i++) {
            arr[L + i] = help[i];
        }
    }

    public static void main(String[] args) {
        int testTime = 500_000;
        int maxSize = 100;
        int maxValue = 1000;
        SortTest.testSort(MergeSort::mergeSort1, testTime, maxSize, maxValue);
        SortTest.testSort(MergeSort::mergeSort2, testTime, maxSize, maxValue);
    }
}
