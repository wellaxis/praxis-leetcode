package com.witalis.praxis.leetcode.task.h20.p1964.option;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.util.List;

/**
 * ID: 1964
 * Name: Find the Longest Valid Obstacle Course at Each Position
 * URL: <a href="https://leetcode.com/problems/find-the-longest-valid-obstacle-course-at-each-position/">Find the Longest Valid Obstacle Course at Each Position</a>
 * Note: the best found solution (external programming)
 */
@Slf4j
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Solution {
    private int[] obstacles;

    public int[] process() {
        return longestObstacleCourseAtEachPosition(obstacles);
    }

    public int[] longestObstacleCourseAtEachPosition(int[] obstacles) {
        final int n = obstacles.length;

        final int[] longestObstacleCourse = new int[n];
        final int[] temps = new int[n];

        int temp = 0;
        for (int i = 0; i < n; i++) {
            int left = 0;
            int right = temp;

            while (left < right) {
                int middle = (left + right) >> 1;

                if (temps[middle] <= obstacles[i]) {
                    left = middle + 1;
                } else {
                    right = middle;
                }
            }

            if (left >= temp || temps[left] > obstacles[i]) {
                temps[left] = obstacles[i];
            }

            if (left == temp) {
                temp++;
            }

            longestObstacleCourse[i] = left + 1;
        }

        return longestObstacleCourse;
    }
}
