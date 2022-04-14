package com.witalis.praxis.leetcode.task.h1.p37.option;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.util.*;

/**
 * ID: 37
 * Name: Sudoku Solver
 * URL: <a href="https://leetcode.com/problems/sudoku-solver/">Sudoku Solver</a>
 * Note: try to find the better solution (without timing)
 */
@Slf4j
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Practice {
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
                    int[] available = solvable(board, i, j);
                    for (int value : available) {
                        board[i][j] = (char) (value + '0');
                        if (solve(board)) return true;
                    }
                    board[i][j] = '.';
                    return false;
                }
            }
        }
        return true;
    }

    private int[] solvable(char[][] board, int row, int column) {
        int[] values = new int[dimension];

        // horizontal
        for (int i = 0; i < dimension; i++) {
            char cell = board[row][i];
            if (Character.isDigit(cell)) values[cell - 1 - '0' ]++;
        }

        // vertical
        for (int i = 0; i < dimension; i++) {
            char cell = board[i][column];
            if (Character.isDigit(cell)) values[cell - 1 - '0']++;
        }

        // square
        int square = (int) Math.sqrt(dimension);
        int baseRow = row - row % square;
        int baseColumn = column - column % square;
        for (int i = 0; i < square; i++) {
            for (int j = 0; j < square; j++) {
                char cell = board[baseRow + i][baseColumn + j];
                if (Character.isDigit(cell)) values[cell - 1 - '0']++;
            }
        }

        List<Integer> available = new ArrayList<>();
        for (int i = 0; i < dimension; i++) {
            if (values[i] == 0) available.add(i + 1);
        }
        return available.stream().mapToInt(Integer::intValue).toArray();
    }
}
