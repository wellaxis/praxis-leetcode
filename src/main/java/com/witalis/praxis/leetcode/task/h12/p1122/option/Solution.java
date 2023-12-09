package com.witalis.praxis.leetcode.task.h12.p1122.option;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.util.Arrays;

/**
 * ID: 1122
 * Name: Relative Sort Array
 * URL: <a href="https://leetcode.com/problems/relative-sort-array/">Relative Sort Array</a>
 * Note: the best found solution (external programming)
 */
@Slf4j
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Solution {
    private int[] array1;
    private int[] array2;

    public int[] process() {
        return relativeSortArray(array1, array2);
    }

    public int[] relativeSortArray(int[] arr1, int[] arr2) {
        int max = 0;
        for (int number : arr1)
            max = Math.max(number, max);

        int[] arr3 = new int[max + 1];
        int[] ans = new int[arr1.length + arr2.length];

        for (int number : arr1)
            arr3[number]++;

        int count = 0;
        for (int i = 0; i < arr2.length; i++) {
            while (arr3[arr2[i]] > 0) {
                ans[count++] = arr2[i];
                arr3[arr2[i]]--;
            }
        }

        for (int i = 0; i < arr3.length; i++) {
            while (arr3[i] > 0) {
                ans[count++] = i;
                arr3[i]--;
            }
        }

        return Arrays.copyOfRange(ans, 0, count);
    }
}
