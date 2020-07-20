package com.ltl.algo;

import java.util.Arrays;

public class SortUtils {
    public static void swap(int[] arr, int i, int j) {
       int tmp = arr[i];
       arr[i] = arr[j];
       arr[j] = tmp;
    }

    public static int[] generateRandomArray(int maxSize, int maxValue) {
        // Math.random() [0, 1)
        // Math.random() * N [0, N)
        // (int) Math.random() * N [0, N-1]
        int[] arr = new int[(int) (Math.random() * (maxSize + 1))]; // [0, maxSize]
        for (int i = 0; i < arr.length; i++) {
            arr[i] = (int) (Math.random() * (maxValue + 1)) + (int) (Math.random() * (maxValue + 1));
        }
        return arr;
    }

    public static boolean isSort(int[] arr) {
       if (arr == null || arr.length < 2) {
           return true;
       }
        for (int i = 0; i < arr.length - 1; i++) {
            if (arr[i] > arr[i + 1]) {
                return false;
            }
        }
        return true;
    }

    public static void printArray(int[] arr) {
        System.out.println(Arrays.toString(arr));
    }
}
