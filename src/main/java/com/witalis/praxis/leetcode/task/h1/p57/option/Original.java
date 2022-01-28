package com.witalis.praxis.leetcode.task.h1.p57.option;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

/**
 * ID: 57
 * Name: Insert Interval
 * URL: https://leetcode.com/problems/insert-interval/
 * Note: the real test solution (code writing with timing)
 */
@Slf4j
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Original {
    private int[][] intervals;
    private int[] newInterval;

    public int[][] process() {
        return insert(intervals, newInterval);
    }

    public int[][] insert(int[][] intervals, int[] newInterval) {
        if (intervals == null || intervals.length == 0) return new int[][] {newInterval};
        if (newInterval == null || newInterval.length == 0) return intervals;

        int[][] result;

        int[] left = recursiveIndex(intervals, newInterval[0], 0, intervals.length - 1);
        if (left[0] >= intervals.length) {
            result = new int[intervals.length + 1][];
            System.arraycopy(intervals, 0, result, 0, intervals.length);
            result[result.length - 1] = newInterval;
            return result;
        }

        int[] right = recursiveIndex(intervals, newInterval[1], 0, intervals.length - 1);
        if (right[1] < 0) right[0]--;
        if (right[0] < 0) {
            result = new int[intervals.length + 1][];
            result[0] = newInterval;
            System.arraycopy(intervals, 0, result, 1, intervals.length);
            return result;
        }

        int[] intervalLeft = intervals[left[0]];
        int[] intervalRight = intervals[right[0]];

        int diff = right[0] - left[0];
        if (diff < 0 && newInterval[1] < intervalLeft[0]) {
            result = new int[intervals.length + 1][];
            System.arraycopy(intervals, 0, result, 0, left[0]);
            result[left[0]] = newInterval;
            System.arraycopy(intervals, left[0], result, left[0] + 1, result.length - (left[0] + 1));
            return result;
        } else {
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

    private int[] recursiveIndex(int[][] intervals, int intervalLeft, int l, int r) {
        if (l > r) return new int[] {l, -1};

        int[] left = intervals[l];
        if (intervalLeft >= left[0] && intervalLeft <= left[1]) return new int[] {l, 0};

        int[] right = intervals[r];
        if (intervalLeft >= right[0] && intervalLeft <= right[1]) return new int[] {r, 0};

        int m = l + (r - l) / 2;

        int[] mid = intervals[m];
        if (intervalLeft >= mid[0] && intervalLeft <= mid[1]) return new int[] {m, 0};

        if (mid[0] >= intervalLeft) {
            return recursiveIndex(intervals, intervalLeft, l, m - 1);
        } else {
            return recursiveIndex(intervals, intervalLeft, m + 1, r);
        }
    }
}
