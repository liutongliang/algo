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
            swap(arr, i, minIndex);
        }
    }

    public static void swap(int[] arr, int i, int j) {
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }

    public static int[] generateRandomArray(int maxSize, int maxValue) {
        // Math.random() [0, 1)
        // Math.random() * N [0, N)
        // (int) (Math.random() * N) [0, N-1]
        int[] arr = new int[(int) ((maxSize + 1) * Math.random())]; // [0, maxSize]
        for (int i = 0; i < arr.length; i++) {
            // [-|maxValue|, +|maxValue|]
            arr[i] = (int)((maxValue + 1) * Math.random()) - (int)((maxValue + 1) * Math.random());
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
        if (arr == null) {
            System.out.println("[]");
            return;
        }
        System.out.print("[");
        for (int i = 0; i < arr.length; i++) {
            if (i == arr.length - 1) {
                System.out.print(arr[i]);
            } else {
                System.out.print(arr[i] + ", ");
            }
        }
        System.out.println("]");
    }
    public static void main(String[] args) {
        int testTime = 50_0000;
        int maxSize = 100;
        int maxValue = 1000;
        for (int i = 0; i < testTime; i++) {
            int[] arr = generateRandomArray(maxSize, maxValue);
            selectionSort(arr);
            if (!isSort(arr)) {
                System.out.print("Fucking fucked!");
                printArray(arr);
                break;
            }
        }
        int[] arr = generateRandomArray(maxSize, maxValue);
        printArray(arr);
        selectionSort(arr);
        printArray(arr);
    }
}
