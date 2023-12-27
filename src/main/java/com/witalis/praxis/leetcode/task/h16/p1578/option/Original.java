package com.witalis.praxis.leetcode.task.h16.p1578.option;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.util.Arrays;

/**
 * ID: 1578
 * Name: Minimum Time to Make Rope Colorful
 * URL: <a href="https://leetcode.com/problems/minimum-time-to-make-rope-colorful/">Minimum Time to Make Rope Colorful</a>
 * Note: the real test solution (code writing with timing)
 */
@Slf4j
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Original {
    private String colors;
    private int[] neededTime;

    public Integer process() {
        return minCost(colors, neededTime);
    }

    public int minCost(String colors, int[] neededTime) {
        if (colors == null || colors.isEmpty() || neededTime == null) return 0;

        final int n = colors.length();
        if (n != neededTime.length) return -1;

        int[] dp = new int[n + 1];

        Arrays.fill(dp, 0);

        char previousColor = '-';
        int previousTime = 0;
        for (int i = 1; i <= n; i++) {
            if (colors.charAt(i - 1) == previousColor) {
                dp[i] = dp[i - 1] + Math.min(neededTime[i - 1], previousTime);
                previousTime = Math.max(neededTime[i - 1], previousTime);
            } else {
                dp[i] = dp[i - 1];
                previousColor = colors.charAt(i - 1);
                previousTime = neededTime[i - 1];
            }
        }

        return dp[n];
    }
}
