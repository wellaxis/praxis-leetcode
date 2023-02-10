package com.witalis.praxis.leetcode.task.h12.p1162.option;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

/**
 * ID: 1162
 * Name: As Far from Land as Possible
 * URL: <a href="https://leetcode.com/problems/as-far-from-land-as-possible/">As Far from Land as Possible</a>
 * Note: the real test solution (code writing with timing)
 */
@Slf4j
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Original {
    private int[][] grid;

    public Integer process() {
        return maxDistance(grid);
    }

    public int maxDistance(int[][] grid) {
        return -1;
    }
}
