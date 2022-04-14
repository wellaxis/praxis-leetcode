package com.witalis.praxis.leetcode.task.h1.p79.option;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

/**
 * ID: 79
 * Name: Word Search
 * URL: <a href="https://leetcode.com/problems/word-search/">Word Search</a>
 * Note: the best found solution (external programming)
 */
@Slf4j
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Solution {
    private char[][] board;
    private String word;

    public Boolean process() {
        return exist(board, word);
    }

    public boolean exist(char[][] board, String word) {
        int m = board.length;
        int n = board[0].length;

        boolean result = false;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (dfs(board, word, i, j, 0)) {
                    result = true;
                }
            }
        }

        return result;
    }

    public boolean dfs(char[][] board, String word, int i, int j, int k) {
        int m = board.length;
        int n = board[0].length;

        if (i < 0 || j < 0 || i >= m || j >= n) {
            return false;
        }

        if (board[i][j] == word.charAt(k)) {
            char temp = board[i][j];
            board[i][j] = '#';
            if (k == word.length() - 1)
                return true;
            if (dfs(board, word, i - 1, j, k + 1)
                || dfs(board, word, i + 1, j, k + 1)
                || dfs(board, word, i, j - 1, k + 1)
                || dfs(board, word, i, j + 1, k + 1)
            ) {
                return true;
            }
            board[i][j] = temp;
        }

        return false;
    }
}
