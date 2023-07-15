package com.witalis.praxis.leetcode.task.h18.p1751.option;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.util.Arrays;
import java.util.Comparator;

/**
 * ID: 1751
 * Name: Maximum Number of Events That Can Be Attended II
 * URL: <a href="https://leetcode.com/problems/maximum-number-of-events-that-can-be-attended-ii/">Maximum Number of Events That Can Be Attended II</a>
 * Note: try to find the better solution (without timing)
 */
@Slf4j
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Practice {
    private int[][] events;
    private int attendance;

    public Practice(int[][] events, int attendance) {
        this.events = events;
        this.attendance = attendance;
    }

    public Integer process() {
        return maxValue(events, attendance);
    }

    private int[][] dp;

    public int maxValue(int[][] events, int k) {
        if (events == null || k <= 0) return 0;

        final int n = events.length;
        Arrays.sort(events, Comparator.comparingInt(e -> e[0]));

        this.dp = new int[n][k + 1];
        for (int[] event : dp) Arrays.fill(event, -1);

        return helper(events, k, 0, 0);
    }

    private int helper(int[][] events, int k, int i, int end) {
        if (i == events.length || k == 0) return 0;

        if (events[i][0] <= end) return helper(events, k, i + 1, end);

        if (dp[i][k] != -1) return dp[i][k];

        int max = Math.max(
            events[i][2] + helper(events, k - 1, i + 1, events[i][1]),
            helper(events, k, i + 1, end)
        );

        return dp[i][k] = max;
    }
}
