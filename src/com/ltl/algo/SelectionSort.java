package com.ltl.algo;

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
        for (int i = 0; i < testTime; i++) {
            int[] arr = SortUtils.generateRandomArray(maxSize, maxValue);
            selectionSort(arr);
            if (!SortUtils.isSort(arr)) {
                System.out.print("Fucking fucked!");
                SortUtils.printArray(arr);
                break;
            }
        }
        int[] arr = SortUtils.generateRandomArray(maxSize, maxValue);
        SortUtils.printArray(arr);
        selectionSort(arr);
        SortUtils.printArray(arr);
    }
}
