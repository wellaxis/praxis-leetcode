package com.witalis.praxis.leetcode.task.h9.p852.option;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

/**
 * ID: 852
 * Name: Peak Index in a Mountain Array
 * URL: <a href="https://leetcode.com/problems/loud-and-rich/">Peak Index in a Mountain Array</a>
 * Note: try to find the better solution (without timing)
 */
@Slf4j
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Practice {
    private int[] array;

    public Integer process() {
        return peakIndexInMountainArray(array);
    }

    public int peakIndexInMountainArray(int[] arr) {
        if (arr == null) return -1;

        final int n = arr.length;

        int l = 0;
        int r = n - 1;
        while (l < r) {
            int mid = l + r + 1 >> 1;
            if (mid > 0 && arr[mid] > arr[mid - 1] && mid < n - 1 && arr[mid] > arr[mid + 1]) {
                return mid;
            }
            if (arr[mid] > arr[mid + 1]) {
                r = mid;
            } else {
                l = mid + 1;
            }
        }

        return l;
    }
}
