package com.witalis.praxis.leetcode.task.h13.p1218.option;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.util.Arrays;

/**
 * ID: 1218
 * Name: Longest Arithmetic Subsequence of Given Difference
 * URL: <a href="https://leetcode.com/problems/longest-arithmetic-subsequence-of-given-difference/">Longest Arithmetic Subsequence of Given Difference</a>
 * Note: the real test solution (code writing with timing)
 */
@Slf4j
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Original {
    private int[] numbers;
    private int difference;

    public Integer process() {
        return longestSubsequence(numbers, difference);
    }

    public int longestSubsequence(int[] arr, int difference) {
        if (arr == null) return 0;

        final int n = arr.length;
        final int[] dp = new int[n];
        Arrays.fill(dp, 1);

        for (int i = 1; i < n; i++)
            for (int j = 0; j < i; j++)
                if (arr[i] - arr[j] == difference)
                    dp[i] = dp[j];

        int max = 0;
        for (int count : dp)
            if (count > max)
                max = count;

        return max;
    }
}
