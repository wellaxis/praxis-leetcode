package com.witalis.praxis.leetcode.task.h19.p1846.option;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.util.Arrays;

/**
 * ID: 1846
 * Name: Maximum Element After Decreasing and Rearranging
 * URL: <a href="https://leetcode.com/problems/maximum-element-after-decreasing-and-rearranging/">Maximum Element After Decreasing and Rearranging</a>
 * Note: try to find the better solution (without timing)
 */
@Slf4j
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Practice {
    private int[] array;

    public Integer process() {
        return maximumElementAfterDecrementingAndRearranging(array);
    }

    public int maximumElementAfterDecrementingAndRearranging(int[] arr) {
        if (arr == null) return 0;

        Arrays.sort(arr);
        final int n = arr.length;

        arr[0] = 1;
        for (int i = 0; i < n - 1; i++)
            if (arr[i + 1] - arr[i] > 1)
                arr[i + 1] = arr[i] + 1;

        return arr[n - 1];
    }
}
