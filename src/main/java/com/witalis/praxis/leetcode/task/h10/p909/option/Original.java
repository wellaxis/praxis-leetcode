package com.witalis.praxis.leetcode.task.h10.p909.option;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

/**
 * ID: 909
 * Name: Snakes and Ladders
 * URL: <a href="https://leetcode.com/problems/snakes-and-ladders/">Snakes and Ladders</a>
 * Note: the real test solution (code writing with timing)
 */
@Slf4j
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Original {
    private int[][] board;

    public Integer process() {
        return snakesAndLadders(board);
    }

    public int snakesAndLadders(int[][] board) {
        return 0;
    }
}
