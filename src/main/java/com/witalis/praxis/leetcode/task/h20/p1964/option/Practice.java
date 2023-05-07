package com.witalis.praxis.leetcode.task.h20.p1964.option;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

/**
 * ID: 1964
 * Name: Find the Longest Valid Obstacle Course at Each Position
 * URL: <a href="https://leetcode.com/problems/find-the-longest-valid-obstacle-course-at-each-position/">Find the Longest Valid Obstacle Course at Each Position</a>
 * Note: try to find the better solution (without timing)
 */
@Slf4j
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Practice {
    private int[] obstacles;

    public int[] process() {
        return longestObstacleCourseAtEachPosition(obstacles);
    }

    public int[] longestObstacleCourseAtEachPosition(int[] obstacles) {
        final int n = obstacles.length;

        final int[] ans = new int[n];
        final int[] lis = new int[n];

        int lisLen = 0;
        for (int i = 0; i < n; i++) {
            int currHeight = obstacles[i];
            int index = binarySearchRightMostPositionToInsert(lis, lisLen, currHeight);

            if (index == lisLen) lisLen++;

            lis[index] = currHeight;
            ans[i] = index + 1;
        }

        return ans;
    }

    public int binarySearchRightMostPositionToInsert(int[] lis, int len, int val) {
        int min = 0;
        int max = len;
        while (min < max) {
            final int mid = min + max >> 1;

            if (lis[mid] <= val) {
                min = mid + 1;
            } else {
                max = mid;
            }
        }

        return min;
    }
}
