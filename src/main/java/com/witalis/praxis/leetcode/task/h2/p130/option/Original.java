package com.witalis.praxis.leetcode.task.h2.p130.option;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

/**
 * ID: 130
 * Name: Surrounded Regions
 * URL: <a href="https://leetcode.com/problems/surrounded-regions/">Surrounded Regions</a>
 * Note: the real test solution (code writing with timing)
 */
@Slf4j
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Original {
    private char[][] board;

    public char[][] process() {
        solve(board);
        return board;
    }

    public void solve(char[][] board) {
        if (board == null || board[0] == null) return;

        int rows = board.length;
        int cols = board[0].length;

        boolean[][] states = new boolean[rows][cols];

        for (int col = 0; col < cols; col++) {
            if (board[0][col] == 'O' && !states[0][col]) {
                recursiveSolve(board, 0, col, states);
            }
        }
        for (int row = 0; row < rows; row++) {
            if (board[row][0] == 'O' && !states[row][0]) {
                recursiveSolve(board, row, 0, states);
            }
        }
        for (int col = 0; col < cols; col++) {
            if (board[rows - 1][col] == 'O' && !states[rows - 1][col]) {
                recursiveSolve(board, rows - 1, col, states);
            }
        }
        for (int row = 0; row < rows; row++) {
            if (board[row][cols - 1] == 'O' && !states[row][cols - 1]) {
                recursiveSolve(board, row, cols - 1, states);
            }
        }

        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < cols; col++) {
                if (board[row][col] == 'O' && !states[row][col]) board[row][col] = 'X';
            }
        }
    }

    private void recursiveSolve(char[][] board, int row, int col, boolean[][] states) {
        states[row][col] = true;

        if (row - 1 >= 0 && !states[row - 1][col] && board[row - 1][col] == 'O') {
            recursiveSolve(board, row - 1, col, states);
        }
        if (col - 1 >= 0 && !states[row][col - 1] && board[row][col - 1] == 'O') {
            recursiveSolve(board, row, col - 1, states);
        }
        if (row + 1 <= board.length - 1 && !states[row + 1][col] && board[row + 1][col] == 'O') {
            recursiveSolve(board, row + 1, col, states);
        }
        if (col + 1 <= board[0].length - 1 && !states[row][col + 1] && board[row][col + 1] == 'O') {
            recursiveSolve(board, row, col + 1, states);
        }
    }
}
