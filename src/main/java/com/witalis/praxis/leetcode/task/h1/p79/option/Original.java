package com.witalis.praxis.leetcode.task.h1.p79.option;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

/**
 * ID: 79
 * Name: Word Search
 * URL: <a href="https://leetcode.com/problems/word-search/">Word Search</a>
 * Note: the real test solution (code writing with timing)
 */
@Slf4j
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Original {
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
                if (recursiveExist(board, word, "", r, c)) return true;
            }
        }

        return false;
    }

    private boolean recursiveExist(char[][] board, String word, String letters, int row, int col) {
        final char substitute = '.';

        if (letters.equals(word)) return true;

        if (row < 0 || row > board.length - 1) return false;
        if (col < 0 || col > board[0].length - 1) return false;

        char cell = board[row][col];
        char letter = word.substring(letters.length()).charAt(0);

        if (letter == substitute || letter != cell) return false;

        board[row][col] = substitute;

        // left
        if (recursiveExist(board, word, letters + letter, row, col - 1)) return true;
        // up
        if (recursiveExist(board, word, letters + letter, row - 1, col)) return true;
        // right
        if (recursiveExist(board, word, letters + letter, row, col + 1)) return true;
        // down
        if (recursiveExist(board, word, letters + letter, row + 1, col)) return true;

        board[row][col] = letter;

        return false;
    }
}
