package com.witalis.praxis.leetcode.task.h20.p1964.option;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

/**
 * ID: 1964
 * Name: Find the Longest Valid Obstacle Course at Each Position
 * URL: <a href="https://leetcode.com/problems/find-the-longest-valid-obstacle-course-at-each-position/">Find the Longest Valid Obstacle Course at Each Position</a>
 * Note: the real test solution (code writing with timing)
 */
@Slf4j
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Original {
    private int[] obstacles;

    public int[] process() {
        return longestObstacleCourseAtEachPosition(obstacles);
    }

    public int[] longestObstacleCourseAtEachPosition(int[] obstacles) {
        final int n = obstacles.length;

        final int[] ans = new int[n];
        final int[] lis = new int[n];

        int lisLen = 0;
        for (int i = 0; i < n; ++i) {
            int currHeight = obstacles[i];
            int idx = binarySearchRightMostPositionToInsert(lis, lisLen, currHeight);
            if (idx == lisLen)
                ++lisLen;

            lis[idx] = currHeight;
            ans[i] = idx + 1;
        }

        return ans;
    }

    public int binarySearchRightMostPositionToInsert(int[] lis, int len, int val) {
        int start = 0;
        int end = len;
        while (start < end) {
            int mid = (start + end) / 2;

            int midVal = lis[mid];
            if (midVal <= val) {
                start = mid + 1;
            } else {
                end = mid;
            }
        }

        return start;
    }
}
