package com.witalis.praxis.leetcode.task.h1.p56.option;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.util.Arrays;
import java.util.LinkedList;

/**
 * ID: 56
 * Name: Merge Intervals
 * URL: <a href="https://leetcode.com/problems/merge-intervals/">Merge Intervals</a>
 * Note: the best found solution (external programming)
 */
@Slf4j
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Solution {
    private int[][] intervals;

    public int[][] process() {
        return merge(intervals);
    }

    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));
        LinkedList<int[]> merged = new LinkedList<>();
        for (int[] interval : intervals) {
            if (merged.isEmpty() || merged.getLast()[1] < interval[0]) {
                // if the list of merged intervals is empty or if the current
                // interval does not overlap with the previous, simply append it.
                merged.add(interval);
            } else {
                // otherwise, there is overlap, so we merge the current and previous intervals.
                merged.getLast()[1] = Math.max(merged.getLast()[1], interval[1]);
            }
        }
        return merged.toArray(new int[merged.size()][]);
    }
}
