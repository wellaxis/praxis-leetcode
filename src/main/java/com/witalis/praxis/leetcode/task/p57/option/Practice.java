package com.witalis.praxis.leetcode.task.p57.option;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

/**
 * ID: 57
 * Name: Insert Interval
 * URL: https://leetcode.com/problems/insert-interval/
 * Note: try to find the better solution (without timing)
 */
@Slf4j
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Practice {
    private int[][] intervals;
    private int[] newInterval;

    public int[][] process() {
        return insert(intervals, newInterval);
    }

    public int[][] insert(int[][] intervals, int[] newInterval) {
        if (intervals == null || intervals.length == 0) return new int[][] {newInterval};
        if (newInterval == null || newInterval.length == 0) return intervals;

        int[][] result;

        // position for left border of a new interval
        int[] left = recursiveIndex(intervals, newInterval[0], 0, intervals.length - 1);
        // check, whether a new interval is after the last position into intervals
        if (left[0] >= intervals.length) {
            result = new int[intervals.length + 1][];
            System.arraycopy(intervals, 0, result, 0, intervals.length);
            result[result.length - 1] = newInterval;
            return result;
        }

        // position for right border of a new interval
        int[] right = recursiveIndex(intervals, newInterval[1], 0, intervals.length - 1);
        if (right[1] < 0) right[0]--;
        // check, whether a new interval is before the first position into intervals
        if (right[0] < 0) {
            result = new int[intervals.length + 1][];
            result[0] = newInterval;
            System.arraycopy(intervals, 0, result, 1, intervals.length);
            return result;
        }

        int[] intervalLeft = intervals[left[0]];
        int[] intervalRight = intervals[right[0]];

        // calculate difference to remove overlapping intervals
        int diff = right[0] - left[0];
        if (diff < 0 && newInterval[1] < intervalLeft[0]) {
            // a new interval is fully between two adjacent intervals
            result = new int[intervals.length + 1][];
            System.arraycopy(intervals, 0, result, 0, left[0]);
            result[left[0]] = newInterval;
            System.arraycopy(intervals, left[0], result, left[0] + 1, result.length - (left[0] + 1));
            return result;
        } else {
            // merge an existing interval with a new one
            intervalLeft[0] = Math.min(intervalLeft[0], newInterval[0]);
            intervalLeft[1] = Math.max(intervalRight[1], newInterval[1]);
            if (diff == 0) {
                return intervals;
            } else {
                result = new int[intervals.length - diff][];
                System.arraycopy(intervals, 0, result, 0, left[0] + 1);
                System.arraycopy(intervals, right[0] + 1, result, left[0] + 1, result.length - (left[0] + 1));
                return result;
            }
        }
    }

    /**
     * It searches the position for a new interval.
     * It uses for both interval borders (left & right).
     * Algorithm: recursive binary search.
     * <p/>
     * @param intervals an array of all intervals
     * @param value     value to search
     * @param l         the left index
     * @param r         the right index
     * @return an array with two values: [0] is a position, [1] 0, if value into interval, -1, otherwise.
     */
    private int[] recursiveIndex(int[][] intervals, int value, int l, int r) {
        if (l > r) return new int[] {l, -1};

        int[] left = intervals[l];
        if (value >= left[0] && value <= left[1]) return new int[] {l, 0};

        int[] right = intervals[r];
        if (value >= right[0] && value <= right[1]) return new int[] {r, 0};

        int m = l + (r - l) / 2;

        int[] mid = intervals[m];
        if (value >= mid[0] && value <= mid[1]) return new int[] {m, 0};

        if (mid[0] >= value) {
            return recursiveIndex(intervals, value, l, m - 1);
        } else {
            return recursiveIndex(intervals, value, m + 1, r);
        }
    }
}
