package com.witalis.praxis.leetcode.task.h10.p941.option;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

/**
 * ID: 941
 * Name: Valid Mountain Array
 * URL: <a href="https://leetcode.com/problems/valid-mountain-array/">Valid Mountain Array</a>
 * Note: try to find the better solution (without timing)
 */
@Slf4j
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Practice {
    private int[] numbers;

    public Boolean process() {
        return validMountainArray(numbers);
    }

    public boolean validMountainArray(int[] arr) {
        if (arr == null) return false;

        final int n = arr.length;

        if (n < 3) return false;
        if (arr[0] >= arr[1]) return false;
        if (arr[n - 1] >= arr[n - 2]) return false;

        int i = 1;
        while (i < n && arr[i] > arr[i - 1]) i++;

        if (arr[i] == arr[i - 1]) return false;

        while (i < n - 1 && arr[i] > arr[i + 1]) i++;

        return i == n - 1;
    }
}
