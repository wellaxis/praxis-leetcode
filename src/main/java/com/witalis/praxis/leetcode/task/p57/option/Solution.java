package com.witalis.praxis.leetcode.task.p57.option;

import com.witalis.praxis.leetcode.task.p57.content.Interval;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * ID: 57
 * Name: Insert Interval
 * URL: https://leetcode.com/problems/insert-interval/
 * Note: the best found solution (external programming)
 */
@Slf4j
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Solution {
    private int[][] intervals;
    private int[] newInterval;

    public int[][] process() {
        return insert(intervals, newInterval);
    }

    public int[][] insert(int[][] intervals, int[] newInterval) {
        var intervalsList = Arrays.stream(intervals)
            .map(arr -> new Interval(arr[0], arr[1]))
            .collect(Collectors.toList());
        var interval = new Interval(newInterval[0], newInterval[1]);

        intervalsList = insert(intervalsList, interval);

        int[][] result = new int[intervalsList.size()][];

        final int[] counter = {0};
        intervalsList.forEach(i -> {
            result[counter[0]] = new int[]{i.start, i.end};
            counter[0]++;
        });

        return result;
    }

    public List<Interval> insert(List<Interval> intervals, Interval newInterval) {
        List<Interval> result = new ArrayList<>();

        if (intervals.size() == 0) {
            result.add(newInterval);
            return result;
        }

        int p = helper(intervals, newInterval);
        result.addAll(intervals.subList(0, p));

        for (int i = p; i < intervals.size(); i++) {
            Interval interval = intervals.get(i);
            if (interval.end < newInterval.start) {
                result.add(interval);
            } else if (interval.start > newInterval.end) {
                result.add(newInterval);
                newInterval = interval;
            } else if (interval.end >= newInterval.start || interval.start <= newInterval.end) {
                newInterval = new Interval(Math.min(interval.start, newInterval.start), Math.max(newInterval.end, interval.end));
            }
        }

        result.add(newInterval);

        return result;
    }

    public int helper(List<Interval> intervals, Interval newInterval) {
        int low = 0;
        int high = intervals.size() - 1;

        while (low < high) {
            int mid = low + (high - low) / 2;

            if (newInterval.start <= intervals.get(mid).start) {
                high = mid;
            } else {
                low = mid + 1;
            }
        }

        return high == 0 ? 0 : high - 1;
    }
}
