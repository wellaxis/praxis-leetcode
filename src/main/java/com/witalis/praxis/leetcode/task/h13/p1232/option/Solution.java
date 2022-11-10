package com.witalis.praxis.leetcode.task.h13.p1232.option;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

/**
 * ID: 1232
 * Name: Check If It Is a Straight Line
 * URL: <a href="https://leetcode.com/problems/check-if-it-is-a-straight-line/">Check If It Is a Straight Line</a>
 * Note: the best found solution (external programming)
 */
@Slf4j
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Solution {
    private int[][] coordinates;

    public Boolean process() {
        return checkStraightLine(coordinates);
    }

    public boolean checkStraightLine(int[][] coordinates) {
        int x1 = coordinates[0][0];
        int y1 = coordinates[0][1];
        int x2 = coordinates[1][0];
        int y2 = coordinates[1][1];

        // equation = ax + by = c
        int a = (y2 - y1);
        int b = (x1 - x2);
        int c = a * x1 + b * y1;

        for (int i = 2; i < coordinates.length; i++)
            if (a * coordinates[i][0] + b * coordinates[i][1] != c)
                return false;

        return true;
    }
}
