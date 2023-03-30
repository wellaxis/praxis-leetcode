package com.witalis.praxis.leetcode.task.h10.p999.option;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

/**
 * ID: 999
 * Name: Available Captures for Rook
 * URL: <a href="https://leetcode.com/problems/available-captures-for-rook/">Available Captures for Rook</a>
 * Note: the best found solution (external programming)
 */
@Slf4j
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Solution {
    private char[][] board;

    public Integer process() {
        return numRookCaptures(board);
    }

    public int numRookCaptures(char[][] board) {
        int ans = 0;

        int iRook = 0;
        int jRook = 0;
        for (int i = 0; i < 8; ++i)
            for (int j = 0; j < 8; ++j)
                if (board[i][j] == 'R') {
                    iRook = i;
                    jRook = j;
                }

        for (int[] d : new int[][]{{1, 0}, {0, 1}, {-1, 0}, {0, -1}})
            for (int i = iRook + d[0], j = jRook + d[1]; 0 <= i && i < 8 && 0 <= j && j < 8; i += d[0], j += d[1]) {
                if (board[i][j] == 'p')
                    ++ans;
                if (board[i][j] != '.')
                    break;
            }

        return ans;
    }
}
