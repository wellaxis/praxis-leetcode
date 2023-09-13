package com.witalis.praxis.leetcode.task.h11.p1027.option;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.util.HashMap;
import java.util.Map;

/**
 * ID: 1027
 * Name: Longest Arithmetic Subsequence
 * URL: <a href="https://leetcode.com/problems/longest-arithmetic-subsequence/">Longest Arithmetic Subsequence</a>
 * Note: the real test solution (code writing with timing)
 */
@Slf4j
@Data
@NoArgsConstructor
@AllArgsConstructor
@SuppressWarnings("unchecked")
public class Original {
    private int[] numbers;

    public Integer process() {
        return longestArithSeqLength(numbers);
    }

    public int longestArithSeqLength(int[] nums) {
        if (nums == null) return 0;

        int n = nums.length;
        Map<Integer, Integer>[] dp = new HashMap[n];
        for (int i = 0; i < n; i++)
            dp[i] = new HashMap<>();

        int longestLength = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < i; j++) {
                int diff = nums[i] - nums[j];

                dp[i].put(diff, dp[j].getOrDefault(diff, 1) + 1);
                longestLength = Math.max(longestLength, dp[i].get(diff));
            }
        }

        return longestLength;
    }
}
