package com.witalis.praxis.leetcode.task.h12.p1122.option;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * ID: 1122
 * Name: Relative Sort Array
 * URL: <a href="https://leetcode.com/problems/relative-sort-array/">Relative Sort Array</a>
 * Note: try to find the better solution (without timing)
 */
@Slf4j
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Practice {
    private int[] array1;
    private int[] array2;

    public int[] process() {
        return relativeSortArray(array1, array2);
    }

    public int[] relativeSortArray(int[] arr1, int[] arr2) {
        if (arr1 == null || arr2 == null) return new int[0];

        final int n1 = arr1.length;
        final int n2 = arr2.length;

        int[] relativeArray = new int[n1];

        if (n2 > n1) return relativeArray;
        if (n2 == n1) return arr2;

        Map<Integer, Integer> positions = new HashMap<>();
        for (int i = 0; i < n2; i++)
            positions.put(arr2[i], i);

        int[] frequencies = new int[n2];
        int[] notAppeared = new int[n1 - n2];
        Arrays.fill(notAppeared, -1);

        int index = 0;
        for (final int number : arr1)
            if (positions.containsKey(number))
                frequencies[positions.get(number)]++;
            else
                notAppeared[index++] = number;

        index = 0;
        for (int i = 0; i < n2; i++)
            Arrays.fill(relativeArray, index, index += frequencies[i], arr2[i]);

        Arrays.sort(notAppeared);

        int position;
        for (position = 0; position < n1 - n2; position++)
            if (notAppeared[position] >= 0)
                break;

        System.arraycopy(notAppeared, position, relativeArray, index, n1 - index);

        return relativeArray;
    }
}
