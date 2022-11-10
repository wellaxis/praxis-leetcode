package com.witalis.praxis.leetcode.task.h13.p1232.option;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

/**
 * ID: 1232
 * Name: Check If It Is a Straight Line
 * URL: <a href="https://leetcode.com/problems/check-if-it-is-a-straight-line/">Check If It Is a Straight Line</a>
 * Note: the real test solution (code writing with timing)
 */
@Slf4j
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Original {
    private int[][] coordinates;

    public Boolean process() {
        return checkStraightLine(coordinates);
    }

    public boolean checkStraightLine(int[][] coordinates) {
        if (coordinates == null || coordinates.length <= 1) return false;

        double slope = 0;
        double intercept;

        int counter = 1;
        while (counter < coordinates.length) {
            if (coordinates[counter][0] != coordinates[counter - 1][0]) {
                slope = (double) (coordinates[counter][1] - coordinates[counter - 1][1]) / (coordinates[counter][0] - coordinates[counter - 1][0]);
                break;
            }
            counter++;
        }
        if (counter == coordinates.length) return true;

        intercept = coordinates[0][1] - slope * coordinates[0][0];

        for (int i = 2; i < coordinates.length; i++)
            if (coordinates[i][1] != slope * coordinates[i][0] + intercept)
                return false;

        return true;
    }
}
