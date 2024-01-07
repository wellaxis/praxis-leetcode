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
 * Note: try to find the better solution (without timing)
 */
@Slf4j
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Practice {
    private int[] startTime;
    private int[] endTime;
    private int[] profit;

    public Practice(int[] startTime, int[] endTime, int[] profit) {
        this.startTime = startTime;
        this.endTime = endTime;
        this.profit = profit;
    }

    public Integer process() {
        return jobScheduling(startTime, endTime, profit);
    }

    record Job(int startTime, int endTime, int profit) {}

    private Job[] jobs;
    private int[] dp;
    private int len;

    public int jobScheduling(int[] startTime, int[] endTime, int[] profit) {
        if (startTime == null || endTime == null || profit == null) return 0;

        this.len = startTime.length;

        this.dp = new int[len];
        Arrays.fill(dp, -1);

        this.jobs = new Job[len];
        for (int i = 0; i < len; i++)
            jobs[i] = new Job(startTime[i], endTime[i], profit[i]);
        Arrays.sort(jobs, Comparator.comparing(Job::startTime));

        return getMaxProfit(0);
    }

    private int getMaxProfit(int index) {
        if (index >= jobs.length) return 0;
        if (dp[index] != -1) return dp[index];

        int profitIfNotIncluded = getMaxProfit(index + 1);
        int nextPossibleIndex = findNextPossibleIndex(index);
        int profitIfIncluded = jobs[index].profit + getMaxProfit(nextPossibleIndex);

        dp[index] = Math.max(profitIfIncluded, profitIfNotIncluded);

        return dp[index];
    }

    private int findNextPossibleIndex(int index) {
        int lastJobEndTime = jobs[index].endTime;

        int start = index + 1;
        int end = len - 1;
        while (start <= end) {
            int mid = start + end >> 1;

            if (jobs[mid].startTime < lastJobEndTime)
                start = mid + 1;
            else
                end = mid - 1;
        }

        return start;
    }
}
