package com.witalis.praxis.leetcode.task.h1.p51.option;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.util.*;

/**
 * ID: 51
 * Name: N-Queens
 * URL: <a href="https://leetcode.com/problems/n-queens/">N-Queens</a>
 * Note: the best found solution (external programming)
 */
@Slf4j
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Solution {
    private int number;

    public Solution(int number) {
        this.number = number;
    }

    public List<List<String>> process() {
        return solveNQueens(number);
    }

    private List<List<String>> ans;
    private char[][] board;

    public List<List<String>> solveNQueens(int N) {
        ans = new ArrayList<>();
        board = new char[N][N];
        for (char[] row : board) Arrays.fill(row, '.');
        place(0, 0, 0, 0);
        return ans;
    }

    private void place(int i, int vert, int ldiag, int rdiag) {
        int N = board.length;
        if (i == N) {
            List<String> res = new ArrayList<>();
            for (char[] row : board) res.add(new String(row));
            ans.add(res);
            return;
        }
        for (int j = 0; j < N; j++) {
            int vmask = 1 << j;
            int lmask = 1 << (i + j);
            int rmask = 1 << (N - i - 1 + j);
            if ((vert & vmask) + (ldiag & lmask) + (rdiag & rmask) > 0) continue;
            board[i][j] = 'Q';
            place(i + 1, vert | vmask, ldiag | lmask, rdiag | rmask);
            board[i][j] = '.';
        }
    }
}
