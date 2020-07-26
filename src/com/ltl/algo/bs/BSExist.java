package com.ltl.algo.bs;

import java.util.Arrays;

import com.ltl.algo.util.SortUtils;

/**
 * liutongliang
 * 2020-07-2020/7/27
 */
public class BSExist {

    public static boolean exist(int[] arr, int num) {
        if (arr == null || arr.length == 0) {
            return false;
        }
        int L = 0;
        int R = arr.length - 1;
        int mid = -1;
        while (L <= R) {
            mid = L + ((R - L) >> 1);
            if (arr[mid] > num) {
                R = mid - 1;
            } else if (arr[mid] < num) {
                L = mid + 1;
            } else {
                return true;
            }
        }
        return false;
    }

    public static boolean test(int[] arr, int num) {
        for (int i : arr) {
            if (i ==  num) {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        int testTime = 500_000;
        int maxSize = 100;
        int maxValue = 1000;
        boolean success = true;
        for (int i = 0; i < testTime; i++) {
            int[] arr = SortUtils.generateRandomArray(maxSize, maxValue);
            Arrays.sort(arr);
            int value = (int) (Math.random() * (maxValue + 1)) - (int) (Math.random() * (maxValue + 1));
            if (exist(arr, value) != test(arr, value)) {
                success = false;
                break;
            }
        }
        System.out.println(success ? "Nice!" : "Fucking fucked!");
    }
}
