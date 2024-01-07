package com.witalis.praxis.leetcode.task.h13.p1235.option;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.util.Arrays;
import java.util.Comparator;

/**
 * ID: 1235
 * Name: Maximum Profit in Job Scheduling
 * URL: <a href="https://leetcode.com/problems/maximum-profit-in-job-scheduling/">Maximum Profit in Job Scheduling</a>
 * Note: the real test solution (code writing with timing)
 */
@Slf4j
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Original {
    private int[] startTime;
    private int[] endTime;
    private int[] profit;

    public Integer process() {
        return jobScheduling(startTime, endTime, profit);
    }

    record Job(int startTime, int endTime, int profit) {}

    public int jobScheduling(int[] startTime, int[] endTime, int[] profit) {
        if (startTime == null || endTime == null || profit == null) return 0;

        final int n = startTime.length;

        int[] dp = new int[n];
        Arrays.fill(dp, -1);

        Job[] jobs = new Job[n];
        for (int i = 0; i < n; i++) {
            jobs[i] = new Job(startTime[i], endTime[i], profit[i]);
        }

        Arrays.sort(jobs, Comparator.comparing(Job::startTime));

        return getMaxProfit(jobs, dp, 0);
    }

    private int getMaxProfit(Job[] jobs, int[] dp, int index) {
        if (index >= jobs.length) return 0;
        if (dp[index] != -1) return dp[index];

        int profitIfNotIncluded = getMaxProfit(jobs, dp, index + 1);
        int nextPossibleIndex = findNextPossibleIndex(jobs, index);
        int profitIfIncluded = jobs[index].profit + getMaxProfit(jobs, dp, nextPossibleIndex);

        dp[index] = Math.max(profitIfIncluded, profitIfNotIncluded);

        return dp[index];
    }

    private int findNextPossibleIndex(Job[] jobs, int index) {
        final int n = jobs.length;

        int lastJobEndTime = jobs[index].endTime;

        int start = index + 1;
        int end = n - 1;
        while (start <= end) {
            int mid = (start + end) / 2;

            if (jobs[mid].startTime < lastJobEndTime) {
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }

        return start;
    }
}
