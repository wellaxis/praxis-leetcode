package com.witalis.praxis.leetcode.task.h1.p37.option;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

/**
 * ID: 37
 * Name: Sudoku Solver
 * URL: https://leetcode.com/problems/sudoku-solver/
 * Note: the best found solution (external programming)
 */
@Slf4j
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Solution {
    private char[][] board;
    private int[][] rows;
    private int[][] cols;
    private int[][] boxs;

    public Solution(char[][] board) {
        this.board = board;
        this.rows = new int[9][10];
        this.cols = new int[9][10];
        this.boxs = new int[9][10];
    }

    public char[][] process() {
        solveSudoku(board);
        return board;
    }

    public void solveSudoku(char[][] board) {
        for (int i = 0; i < board.length; ++i) {
            for (int j = 0; j < board[i].length; ++j) {
                if (board[i][j] != '.') {
                    int k = board[i][j] - '0';
                    rows[i][k] = 1;
                    cols[j][k] = 1;
                    int bx = i / 3;
                    int by = j / 3;
                    boxs[bx + by * 3][k] = 1;
                }
            }
        }
        dfs(board, 0, 0);
    }

    private boolean dfs(char[][] board, int r, int c) {
        if (r == 9) return true;

        int nextR = r;
        int nextC = (c + 1) % 9;
        if (nextC == 0) nextR = r + 1;
        if (board[r][c] != '.') return dfs(board, nextR, nextC);
        for (int i = 1; i <= 9; ++i) {
            int bx = r / 3;
            int by = c / 3;
            int boxIndex = bx + by * 3;
            if (rows[r][i] == 0 && cols[c][i] == 0 && boxs[boxIndex][i] == 0) {
                rows[r][i] = 1;
                cols[c][i] = 1;
                boxs[boxIndex][i] = 1;
                board[r][c] = (char) (i + '0');
                if (dfs(board, nextR, nextC)) return true;
                rows[r][i] = 0;
                cols[c][i] = 0;
                boxs[boxIndex][i] = 0;
                board[r][c] = '.';
            }
        }
        return false;
    }
}
