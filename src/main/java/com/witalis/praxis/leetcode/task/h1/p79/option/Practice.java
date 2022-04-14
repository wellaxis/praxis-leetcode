package com.witalis.praxis.leetcode.task.h1.p79.option;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

/**
 * ID: 79
 * Name: Word Search
 * URL: <a href="https://leetcode.com/problems/word-search/">Word Search</a>
 * Note: try to find the better solution (without timing)
 */
@Slf4j
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Practice {
    private char[][] board;
    private String word;

    public Boolean process() {
        return exist(board, word);
    }

    public boolean exist(char[][] board, String word) {
        if (board == null || board[0] == null || word == null) return false;

        int rows = board.length;
        int cols = board[0].length;
        int len = word.length();

        if (len > rows * cols) return false;

        for (int r = 0; r < rows; r++) {
            for (int c = 0; c < cols; c++) {
                if (board[r][c] == word.charAt(0) && recursiveExist(board, word, 0, r, c)) return true;
            }
        }

        return false;
    }

    private boolean recursiveExist(char[][] board, String word, int index, int row, int col) {
        final char substitute = '.';

        if (row < 0 || row >= board.length) return false;
        if (col < 0 || col >= board[0].length) return false;

        char cell = board[row][col];
        char letter = word.charAt(index);

        if (letter != cell) return false;
        if (index == word.length() - 1) return true;

        board[row][col] = substitute;

        // short-circuiting
        boolean existence =
            // left
            recursiveExist(board, word, index + 1, row, col - 1) ||
            // up
            recursiveExist(board, word, index + 1, row - 1, col) ||
            // right
            recursiveExist(board, word, index + 1, row, col + 1) ||
            // down
            recursiveExist(board, word, index + 1, row + 1, col);

        board[row][col] = letter;

        return existence;
    }
}
