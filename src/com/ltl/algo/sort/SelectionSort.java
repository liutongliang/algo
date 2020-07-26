package com.ltl.algo.sort;

import com.ltl.algo.test.SortTest;
import com.ltl.algo.util.SortUtils;

/**
 * 选择排序
 */
public class SelectionSort {

    public static void selectionSort(int[] arr) {
        if (arr == null || arr.length < 2) {
            return;
        }
        // 0 ~ n-1
        // 1 ~ n-1
        // 2 ~
        for (int i = 0; i < arr.length - 1; i++) { // 0 ~ n-2 剩下一个数时不用比较
            // 最小值在哪个位置上 i ~ n-1
            int minIndex = i;
            for (int j = i + 1; j < arr.length; j++) { // i ~ n-1 上找最小值的下标
                if (arr[minIndex] > arr[j]) {
                    minIndex = j;
                }
            }
            SortUtils.swap(arr, i, minIndex);
        }
    }


    public static void main(String[] args) {
        int testTime = 500_000;
        int maxSize = 100;
        int maxValue = 1000;
        SortTest.testSort(SelectionSort::selectionSort, testTime, maxSize, maxValue);
    }
}