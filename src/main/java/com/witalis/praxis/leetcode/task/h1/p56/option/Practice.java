package com.witalis.praxis.leetcode.task.h1.p56.option;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/**
 * ID: 56
 * Name: Merge Intervals
 * URL: https://leetcode.com/problems/merge-intervals/
 * Note: try to find the better solution (without timing)
 */
@Slf4j
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Practice {
    private int[][] intervals;

    public int[][] process() {
        return merge(intervals);
    }

    public int[][] merge(int[][] intervals) {
        if (intervals == null || intervals.length <= 1) return intervals;

        List<int[]> intervalList = new ArrayList<>();

        Arrays.sort(intervals, Comparator.comparingInt(x -> x[0]));

        int[] previous = intervals[0];
        int counter = 1;
        while (counter < intervals.length) {
            int[] current = intervals[counter];
            if (previous[1] >= current[0]) {
                previous[1] = Math.max(previous[1], current[1]);
            } else {
                intervalList.add(previous);
                previous = current;
            }
            counter++;
        }
        intervalList.add(previous);

        return intervalList.toArray(int[][]::new);
    }
}
