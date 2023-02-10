package com.witalis.praxis.leetcode.task.h12.p1162.option;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

/**
 * ID: 200
 * Name: Number of Islands
 * URL: <a href="https://leetcode.com/problems/number-of-islands/">Number of Islands</a>
 * Note: try to find the better solution (without timing)
 */
@Slf4j
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Practice {
    private int[][] grid;

    public Integer process() {
        return maxDistance(grid);
    }

    public int maxDistance(int[][] grid) {
        return -1;
    }
}
