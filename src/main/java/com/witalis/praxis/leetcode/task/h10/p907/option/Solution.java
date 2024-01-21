package com.witalis.praxis.leetcode.task.h10.p907.option;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

/**
 * ID: 907
 * Name: Sum of Subarray Minimums
 * URL: <a href="https://leetcode.com/problems/sum-of-subarray-minimums/">Sum of Subarray Minimums</a>
 * Note: the best found solution (external programming)
 */
@Slf4j
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Solution {
    private int[] array;

    public Integer process() {
        return sumSubarrayMins(array);
    }

    public static final int MOD = (int) 1e9 + 7;

    public int sumSubarrayMins(int[] arr) {
        int n = arr.length + 1;

        int[] ext = new int[n];
        System.arraycopy(arr, 0, ext, 1, n - 1);

        int[] left = new int[n];
        int[] sums = new int[n];

        int res = 0;
        for (int i = 1; i < n; i++) {
            int cur = ext[i];
            int l = i - 1;
            while (ext[l] >= cur) l = left[l];

            left[i] = l;
            sums[i] = sums[l] + cur * (i - l);
            res = (res + sums[i]) % MOD;
        }

        return res;
    }
}
