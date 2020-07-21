package com.ltl.algo.test;

import java.util.function.Consumer;

import com.ltl.algo.util.SortUtils;

public class SortTest {

    public static void testSort(Consumer<int[]> sortMethod, int testTime, int maxSize, int maxValue) {
        for (int i = 0; i < testTime; i++) {
            int[] arr = SortUtils.generateRandomArray(maxSize, maxValue);
            sortMethod.accept(arr);
            if (!SortUtils.isSort(arr)) {
                System.out.print("Fucking fucked!");
                SortUtils.printArray(arr);
                break;
            }
        }
        int[] arr = SortUtils.generateRandomArray(maxSize, maxValue);
        SortUtils.printArray(arr);
        sortMethod.accept(arr);
        SortUtils.printArray(arr);
    }
}
