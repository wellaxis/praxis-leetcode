package com.witalis.praxis.leetcode.task.p36.option;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.util.HashSet;
import java.util.Set;

/**
 * ID: 36
 * Name: Valid Sudoku
 * URL: https://leetcode.com/problems/valid-sudoku/
 * Note: the best found solution (external programming)
 */
@Slf4j
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Solution {
    private char[][] board;

    public Boolean process() {
        return isValidSudoku(board);
    }

    public boolean isValidSudoku(char[][] board) {
        for (int i = 0; i < 9; i++) {
            Set<Character> rows = new HashSet<>();
            Set<Character> columns = new HashSet<>();
            Set<Character> cube = new HashSet<>();

            for (int j = 0; j < 9; j++) {
                // Check row
                if (board[i][j] != '.' && !rows.add(board[i][j])) {
                    return false;
                }

                // Check column
                if (board[j][i] != '.' && !columns.add(board[j][i])) {
                    return false;
                }

                // Check cube
                int rowIndex = 3 * (i / 3); // row index of current cube
                int colIndex = 3 * (i % 3); // col index of current cube
                if (board[rowIndex + j / 3][colIndex + j % 3] != '.' &&
                    !cube.add(board[rowIndex + j / 3][colIndex + j % 3])) {
                    return false;
                }
            }
        }
        return true;
    }
}
