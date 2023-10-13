package com.witalis.praxis.leetcode.task.h11.p1089.option;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

/**
 * ID: 1089
 * Name: Duplicate Zeros
 * URL: <a href="https://leetcode.com/problems/duplicate-zeros/">Duplicate Zeros</a>
 * Note: the best found solution (external programming)
 */
@Slf4j
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Solution {
    private int[] numbers;

    public int[] process() {
        duplicateZeros(numbers);

        return numbers;
    }

    public void duplicateZeros(int[] arr) {
        int n = arr.length;
        // create a new array to store the result
        int[] result = new int[n];
        // index for the result array
        int j = 0;

        for (int i = 0; i < n && j < n; i++) {
            // copy the current element
            result[j++] = arr[i];

            if (arr[i] == 0 && j < n) {
                // duplicate zero if there's space
                result[j++] = 0;
            }
        }

        // copy the result array back to the original array
        System.arraycopy(result, 0, arr, 0, n);
    }
}
