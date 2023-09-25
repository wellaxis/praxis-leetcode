package com.witalis.praxis.leetcode.task.h11.p1037.option;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

/**
 * ID: 1037
 * Name: Valid Boomerang
 * URL: <a href="https://leetcode.com/problems/valid-boomerang/">Valid Boomerang</a>
 * Note: the best found solution (external programming)
 */
@Slf4j
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Solution {
    private int[][] points;

    public Boolean process() {
        return isBoomerang(points);
    }

    public boolean isBoomerang(int[][] points) {
        return (points[1][0] - points[0][0]) * (points[2][1] - points[1][1])
            != (points[1][1] - points[0][1]) * (points[2][0] - points[1][0]);
    }
}
