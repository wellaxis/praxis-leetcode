package com.witalis.praxis.leetcode.task.h10.p941.option;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

/**
 * ID: 941
 * Name: Valid Mountain Array
 * URL: <a href="https://leetcode.com/problems/valid-mountain-array/">Valid Mountain Array</a>
 * Note: the best found solution (external programming)
 */
@Slf4j
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Solution {
    private int[] numbers;

    public Boolean process() {
        return validMountainArray(numbers);
    }

    public boolean validMountainArray(int[] arr) {
        int n = arr.length;
        int i = 0;

        while (i + 1 < n && arr[i] < arr[i + 1])
            i++;

        if (i == 0 || i == n - 1)
            return false;

        while (i + 1 < n && arr[i] > arr[i + 1])
            i++;

        return i == n - 1;
    }
}
