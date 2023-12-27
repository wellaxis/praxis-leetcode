package com.witalis.praxis.leetcode.task.h16.p1578.option;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

/**
 * ID: 1578
 * Name: Minimum Time to Make Rope Colorful
 * URL: <a href="https://leetcode.com/problems/minimum-time-to-make-rope-colorful/">Minimum Time to Make Rope Colorful</a>
 * Note: the best found solution (external programming)
 */
@Slf4j
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Solution {
    private String colors;
    private int[] neededTime;

    public Integer process() {
        return minCost(colors, neededTime);
    }

    public int minCost(String colors, int[] neededTime) {
        int needed = 0;

        int n = neededTime.length;
        char[] chc = colors.toCharArray();
        int curMax = neededTime[0];
        for (int i = 1; i < n; i++) {
            if (chc[i - 1] != chc[i]) {
                curMax = neededTime[i];
            } else {
                needed += Math.min(curMax, neededTime[i]);
                curMax = Math.max(curMax, neededTime[i]);
            }
        }

        return needed;
    }
}
