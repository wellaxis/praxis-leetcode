package com.witalis.praxis.leetcode.task.h16.p1547.option;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.util.Arrays;

/**
 * ID: 1547
 * Name: Minimum Cost to Cut a Stick
 * URL: <a href="https://leetcode.com/problems/minimum-cost-to-cut-a-stick/">Minimum Cost to Cut a Stick</a>
 * Note: the best found solution (external programming)
 */
@Slf4j
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Solution {
    private int units;
    private int[] cuts;

    public Integer process() {
        return minCost(units, cuts);
    }

    public int minCost(int n, int[] cuts) {
        int m = cuts.length;
        int[] newCuts = new int[m + 2];
        System.arraycopy(cuts, 0, newCuts, 1, m);
        newCuts[m + 1] = n;
        Arrays.sort(newCuts);

        int[][] dp = new int[m + 2][m + 2];

        for (int diff = 2; diff < m + 2; ++diff) {
            for (int left = 0; left < m + 2 - diff; ++left) {
                int right = left + diff;
                int ans = Integer.MAX_VALUE;
                for (int mid = left + 1; mid < right; ++mid) {
                    ans = Math.min(ans, dp[left][mid] + dp[mid][right] + newCuts[right] - newCuts[left]);
                }
                dp[left][right] = ans;
            }
        }

        return dp[0][m + 1];
    }
}
