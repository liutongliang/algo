package com.ltl.algo;

import com.ltl.algo.test.SortTest;
import com.ltl.algo.util.SortUtils;

public class InsertionSort {
    public static void insertionSort(int[] arr) {
        if (arr == null || arr.length < 2) {
            return;
        }
        // 0 ~ 0 想有序
        // 0 ~ 1 想有序
        // 0 ~ 2 想有序
        // ...
        // 0 ~ n-1 想有序
        for (int i = 1; i < arr.length; i++) {
            // 0 ~ i 想有序
            for (int j = i - 1; j >= 0 && arr[j + 1] < arr[j]; j--) {
                SortUtils.swap(arr, j, j + 1);
            }
        }
    }

    public static void main(String[] args) {
        int testTime = 500_000;
        int maxSize = 100;
        int maxValue = 1000;
        SortTest.testSort(InsertionSort::insertionSort, testTime, maxSize, maxValue);
    }
}
