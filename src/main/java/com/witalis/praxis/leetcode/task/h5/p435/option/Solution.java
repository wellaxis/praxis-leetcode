package com.witalis.praxis.leetcode.task.h5.p435.option;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.util.Arrays;
import java.util.Comparator;

/**
 * ID: 435
 * Name: Non-overlapping Intervals
 * URL: <a href="https://leetcode.com/problems/non-overlapping-intervals/">Non-overlapping Intervals</a>
 * Note: the best found solution (external programming)
 */
@Slf4j
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Solution {
    private int[][] intervals;

    public Integer process() {
        return eraseOverlapIntervals(intervals);
    }

    public int eraseOverlapIntervals(int[][] intervals) {
        Arrays.sort(intervals, Comparator.comparingInt(a -> a[1]));

        int ans = 0;
        int k = Integer.MIN_VALUE;
        for (int[] interval : intervals) {
            int x = interval[0];
            int y = interval[1];

            if (x >= k) {
                // case 1
                k = y;
            } else {
                // case 2
                ans++;
            }
        }

        return ans;
    }
}
