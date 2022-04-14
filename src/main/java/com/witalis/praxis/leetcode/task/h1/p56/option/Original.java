package com.witalis.praxis.leetcode.task.h1.p56.option;

import com.witalis.praxis.leetcode.task.h1.p56.content.Interval;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * ID: 56
 * Name: Merge Intervals
 * URL: <a href="https://leetcode.com/problems/merge-intervals/">Merge Intervals</a>
 * Note: the real test solution (code writing with timing)
 */
@Slf4j
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Original {
    private int[][] intervals;

    public int[][] process() {
        return merge(intervals);
    }

    public int[][] merge(int[][] intervals) {
        if (intervals == null || intervals.length <= 1) return intervals;

        List<Interval> intervalList = new ArrayList<>();

        Interval[] intervalArray = new Interval[intervals.length];
        for (int i = 0; i < intervals.length; i++) {
            intervalArray[i] = new Interval(intervals[i][0], intervals[i][1]);
        }
        Arrays.sort(intervalArray);

        Interval previous = intervalArray[0];
        int counter = 1;
        while (counter < intervalArray.length) {
            Interval current = intervalArray[counter];
            if (previous.end >= current.start) {
                previous.end = Math.max(previous.end, current.end);
            } else {
                intervalList.add(previous);
                previous = current;
            }
            counter++;
        }
        intervalList.add(previous);

        return intervalList.stream().map(
            i -> new int[]{i.start, i.end}
        ).toArray(int[][]::new);
    }
}
