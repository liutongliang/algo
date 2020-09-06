package com.ltl.algo.test;

import java.util.function.Consumer;

import com.ltl.algo.util.SortUtils;

public class SortTest {

    public static void testSort(Consumer<int[]> sortMethod, int testTime, int maxSize, int maxValue) {
        boolean success = true;
        for (int i = 0; i < testTime; i++) {
            int[] arr = SortUtils.generateRandomArray(maxSize, maxValue);
            int[] arr2 = SortUtils.copyArray(arr);
            sortMethod.accept(arr2);
            if (!SortUtils.isSort(arr2)) {
                success = false;
                SortUtils.printArray(arr);
                SortUtils.printArray(arr2);
                break;
            }
        }
        System.out.println(success ? "Nice" : "Fucking fucked!");
    }
}
