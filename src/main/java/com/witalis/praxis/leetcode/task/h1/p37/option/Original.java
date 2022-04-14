package com.witalis.praxis.leetcode.task.h1.p37.option;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

/**
 * ID: 37
 * Name: Sudoku Solver
 * URL: <a href="https://leetcode.com/problems/sudoku-solver/">Sudoku Solver</a>
 * Note: the real test solution (code writing with timing)
 */
@Slf4j
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Original {
    public static int dimension = 9;
    private char[][] board;

    public char[][] process() {
        solveSudoku(board);
        return board;
    }

    public void solveSudoku(char[][] board) {
        if (board != null && board.length == dimension) {
            solve(board);
        }
    }

    public boolean solve(char[][] board) {
        for (int i = 0; i < dimension; i++) {
            for (int j = 0; j < dimension; j++) {
                if (!Character.isDigit(board[i][j])) {
                    for (int k = 0; k < dimension; k++) {
                        board[i][j] = (char) (k + '1');
                        if (solvable(board, i, j) && solve(board)) {
                            return true;
                        }
                    }
                    board[i][j] = '.';
                    return false;
                }
            }
        }
        return true;
    }

    private boolean solvable(char[][] board, int row, int column) {
        int[] values;

        // horizontal
        values = new int[dimension];
        for (int i = 0; i < dimension; i++) {
            char cell = board[row][i];
            if (Character.isDigit(cell)) {
                if (values[cell - 1 - '0'] > 0) return false;
                values[cell - 1 - '0']++;
            }
        }

        // vertical
        values = new int[dimension];
        for (int i = 0; i < dimension; i++) {
            char cell = board[i][column];
            if (Character.isDigit(cell)) {
                if (values[cell - 1 - '0'] > 0) return false;
                values[cell - 1 - '0']++;
            }
        }

        // square
        values = new int[dimension];
        int square = (int) Math.sqrt(dimension);
        int baseRow = row - row % square;
        int baseColumn = column - column % square;
        for (int i = 0; i < square; i++) {
            for (int j = 0; j < square; j++) {
                char cell = board[baseRow + i][baseColumn + j];
                if (Character.isDigit(cell)) {
                    if (values[cell - 1 - '0'] > 0) return false;
                    values[cell - 1 - '0']++;
                }
            }
        }

        return true;
    }
}
