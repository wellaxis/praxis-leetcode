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
 * Note: try to find the better solution (without timing)
 */
@Slf4j
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Practice {
    private int[][] intervals;

    public Integer process() {
        return eraseOverlapIntervals(intervals);
    }

    public int eraseOverlapIntervals(int[][] intervals) {
        if (intervals == null) return 0;

        Arrays.sort(intervals, Comparator.comparingInt(a -> a[1]));

        final int n = intervals.length;

        int index = 0;
        int count = 1;
        for (int i = 1; i < n; i++) {
            if (intervals[i][0] >= intervals[index][1]) {
                index = i;
                count++;
            }
        }

        return n - count;
    }
}
