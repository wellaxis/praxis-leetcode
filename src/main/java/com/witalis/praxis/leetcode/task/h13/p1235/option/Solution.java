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
 * Note: the best found solution (external programming)
 */
@Slf4j
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Solution {
    private int[] startTime;
    private int[] endTime;
    private int[] profit;

    public Integer process() {
        return jobScheduling(startTime, endTime, profit);
    }

    static class Job {
        int startTime;
        int endTime;
        int profit;

        public Job(int startTime, int endTime, int profit){
            this.startTime = startTime;
            this.endTime = endTime;
            this.profit = profit;
        }
    }

    public int jobScheduling(int[] startTime, int[] endTime, int[] profit) {
        int n = startTime.length;

        Job[] jobs = new Job[n];
        for(int i = 0; i < n; ++i){
            jobs[i] = new Job(startTime[i], endTime[i], profit[i] );
        }

        Arrays.sort(jobs, Comparator.comparingInt(a -> a.endTime));

        int[] dp = new int[n + 1];
        dp[0] = 0;

        for(int i = 1; i <= n; ++i){
            int k = binarySearch(jobs, i - 1, jobs[i - 1].startTime);

            dp[i] = Math.max(dp[i - 1], dp[k] + jobs[i - 1].profit);
        }

        return dp[n];
    }

    public int binarySearch(Job[] jobs, int right, int target) {
        int left = 0;
        while(left < right){
            int mid = left + ((right - left) >> 1);

            if(jobs[mid].endTime > target){
                right = mid;
            } else {
                left = mid + 1;
            }
        }

        return left;
    }
}
