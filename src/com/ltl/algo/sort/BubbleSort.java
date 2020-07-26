package com.ltl.algo.sort;

import com.ltl.algo.test.SortTest;
import com.ltl.algo.util.SortUtils;

public class BubbleSort {

    public static void bubbleSort(int[] arr) {
        if (arr == null || arr.length < 2) {
            return;
        }
        // 0 ~ n-1
        // 0 ~ n-2
        // 0 ~ n-3
        //...
        // 0 ~ 1
        for (int i = arr.length - 1; i > 0; i--) {
            // 0 ~ i
            for (int j = 0; j < i; j++) {
                if (arr[j] > arr[j + 1]) {
                    SortUtils.swap(arr, j, j + 1);
                }
            }
        }
    }

    public static void main(String[] args) {
        int testTime = 500_000;
        int maxSize = 100;
        int maxValue = 1000;
        SortTest.testSort(BubbleSort::bubbleSort, testTime, maxSize, maxValue);
    }
}
