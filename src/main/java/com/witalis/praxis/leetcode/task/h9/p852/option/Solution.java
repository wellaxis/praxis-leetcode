package com.witalis.praxis.leetcode.task.h9.p852.option;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

/**
 * ID: 852
 * Name: Peak Index in a Mountain Array
 * URL: <a href="https://leetcode.com/problems/loud-and-rich/">Peak Index in a Mountain Array</a>
 * Note: the best found solution (external programming)
 */
@Slf4j
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Solution {
    private int[] array;

    public Integer process() {
        return peakIndexInMountainArray(array);
    }

    public int peakIndexInMountainArray(int[] arr) {
        int l = 0;
        int r = arr.length - 1;

        while (l < r) {
            final int m = (l + r) / 2;
            if (arr[m] >= arr[m + 1])
                r = m;
            else
                l = m + 1;
        }

        return l;
    }
}
