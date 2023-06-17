package com.witalis.praxis.leetcode.task.h12.p1187.option;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * ID: 1187
 * Name: Make Array Strictly Increasing
 * URL: <a href="https://leetcode.com/problems/make-array-strictly-increasing/">Make Array Strictly Increasing</a>
 * Note: the real test solution (code writing with timing)
 */
@Slf4j
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Original {
    private int[] array1;
    private int[] array2;

    public Integer process() {
        return makeArrayIncreasing(array1, array2);
    }

    public static final int THRESHOLD = 10_000;

    record Pair (int index, int value) {}

    public int makeArrayIncreasing(int[] arr1, int[] arr2) {
        if (arr1 == null || arr2 == null) return 0;

        Arrays.sort(arr2);

        Map<Pair, Integer> cache = new HashMap<>();

        int operations = recursiveIncreasing(arr1, arr2, cache, 0, -1);

        return operations >= THRESHOLD ? -1 : operations;
    }

    private int recursiveIncreasing(int[] arr1, int[] arr2, Map<Pair, Integer> cache, int index, int previous) {
        if (index >= arr1.length) return 0;

        Pair pair = new Pair(index, previous);
        if (cache.containsKey(pair)) {
            return cache.get(pair);
        }

        int operations = THRESHOLD;
        if (arr1[index] > previous) {
            operations = recursiveIncreasing(arr1, arr2, cache, index + 1, arr1[index]);
        }

        int prevIndex = findElement(arr2, previous);
        if (prevIndex < arr2.length) {
            operations = Math.min(operations, 1 + recursiveIncreasing(arr1, arr2, cache, index + 1, arr2[prevIndex]));
        }

        cache.put(pair, operations);

        return operations;
    }

    private static int findElement(int[] arr, int value) {
        final int n = arr.length;

        int l = 0;
        int r = n;
        while (l < r) {
            int mid = l + (r - l) / 2;
            if (arr[mid] <= value) {
                l = mid + 1;
            } else {
                r = mid;
            }
        }

        return l;
    }
}
