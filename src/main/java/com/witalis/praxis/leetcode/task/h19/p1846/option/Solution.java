package com.witalis.praxis.leetcode.task.h19.p1846.option;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

/**
 * ID: 1846
 * Name: Maximum Element After Decreasing and Rearranging
 * URL: <a href="https://leetcode.com/problems/maximum-element-after-decreasing-and-rearranging/">Maximum Element After Decreasing and Rearranging</a>
 * Note: the best found solution (external programming)
 */
@Slf4j
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Solution {
    private int[] array;

    public Integer process() {
        return maximumElementAfterDecrementingAndRearranging(array);
    }

    public int maximumElementAfterDecrementingAndRearranging(int[] arr) {
        int n = arr.length;
        int[] counts = new int[n + 1];

        for (int num : arr) {
            counts[Math.min(num, n)]++;
        }

        int ans = 1;
        for (int num = 2; num <= n; num++) {
            ans = Math.min(ans + counts[num], num);
        }

        return ans;
    }
}
