package com.witalis.praxis.leetcode.task.h1.p36.option;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.util.HashSet;
import java.util.Set;

/**
 * ID: 36
 * Name: Valid Sudoku
 * URL: <a href="https://leetcode.com/problems/valid-sudoku/">Valid Sudoku</a>
 * Note: try to find the better solution (without timing)
 */
@Slf4j
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Practice {
    private char[][] board;

    public Boolean process() {
        return isValidSudoku(board);
    }

    public boolean isValidSudoku(char[][] board) {
        final int dimension = 9;

        if (board == null || board.length != dimension) return false;

        for (int i = 0; i < board.length; i++) {
            // row-by-row
            char[] row = board[i];
            if (incorrectCells(row)) return false;
            // column-by-column
            char[] column = new char[dimension];
            for (int j = 0; j < row.length; j++) {
                column[j] = board[j][i];
                // square-by-square
                if (i % 3 == 0 && j % 3 == 0) {
                    char[] square = new char[dimension];
                    var counter = 0;
                    for (int k = 0; k < 3; k++) {
                        for (int l = 0; l < 3; l++) {
                            square[counter++] = board[i + k][j + l];
                        }
                    }
                    if (incorrectCells(square)) return false;
                }
            }
            if (incorrectCells(column)) return false;
        }

        return true;
    }

    private boolean incorrectCells(char[] cells) {
        Set<Integer> items = new HashSet<>();
        return !String.valueOf(cells).chars()
            .filter(Character::isDigit)
            .map(ch -> ch - '0')
            .allMatch(items::add);
    }
}
