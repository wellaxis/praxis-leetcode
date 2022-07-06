package com.witalis.praxis.leetcode.task.h5.p463.option;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

/**
 * ID: 463
 * Name: Island Perimeter
 * URL: <a href="https://leetcode.com/problems/island-perimeter/">Island Perimeter</a>
 * Note: the real test solution (code writing with timing)
 */
@Slf4j
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Original {
    private int[][] grid;

    public Integer process() {
        return islandPerimeter(grid);
    }

    public int islandPerimeter(int[][] grid) {
        return 0;
    }
}
