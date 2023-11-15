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
 * Note: the real test solution (code writing with timing)
 */
@Slf4j
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Original {
    private int[] array;

    public Integer process() {
        return maximumElementAfterDecrementingAndRearranging(array);
    }

    public int maximumElementAfterDecrementingAndRearranging(int[] arr) {
        if (arr == null) return 0;

        Arrays.sort(arr);
        final int n = arr.length;

        int max = 1;
        arr[0] = max;
        for (int i = 0; i < n - 1; i++) {
            if (arr[i + 1] - arr[i] > 1) {
                arr[i + 1] = arr[i] + 1;
            }
        }

        return max = arr[n - 1];
    }
}
