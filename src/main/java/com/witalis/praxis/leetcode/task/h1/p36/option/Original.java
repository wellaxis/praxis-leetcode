package com.witalis.praxis.leetcode.task.h1.p36.option;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.nio.CharBuffer;
import java.util.*;

/**
 * ID: 36
 * Name: Valid Sudoku
 * URL: <a href="https://leetcode.com/problems/valid-sudoku/">Valid Sudoku</a>
 * Note: the real test solution (code writing with timing)
 */
@Slf4j
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Original {
    private char[][] board;

    public Boolean process() {
        return isValidSudoku(board);
    }

    public boolean isValidSudoku(char[][] board) {
        final int dimension = 9;

        if (board == null || board.length != dimension) return false;

        List<char[]> combinations = new ArrayList<>(dimension * 3);
        for (int i = 0; i < board.length; i++) {
            // line-by-line
            char[] line = board[i];
            combinations.add(line);
            // column-by-column
            char[] column = new char[dimension];
            for (int j = 0; j < line.length; j++) {
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
                    combinations.add(square);
                }
            }
            combinations.add(column);
        }

        return combinations.stream()
            .allMatch(this::checkSudokuCells);
    }

    private boolean checkSudokuCells(char[] cells) {
        var ints = CharBuffer.wrap(cells).chars()
            .filter(Character::isDigit)
            .map(ch -> ch - '0')
            .sorted().toArray();
        int counter = 0;
        while (counter < ints.length - 1) {
            if (ints[counter] == ints[counter + 1]) return false;
            counter++;
        }
        return true;
    }
}
