package com.witalis.praxis.leetcode.task.h1.p52.option;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

/**
 * ID: 52
 * Name: N-Queens II
 * URL: <a href="https://leetcode.com/problems/n-queens-ii/">N-Queens II</a>
 * Note: try to find the better solution (without timing)
 */
@Slf4j
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Practice {
    private int number;

    public Practice(int number) {
        this.number = number;
    }

    public Integer process() {
        return totalNQueens(number);
    }

    private int counter;

    public int totalNQueens(int n) {
        if (n <= 0) return 0;

        recursiveSolve(new boolean[n][n], 0);

        return counter;
    }

    private void recursiveSolve(boolean[][] chessboard, int col) {
        if (col == chessboard.length) {
            counter++;
        } else {
            for (int row = 0; row < chessboard.length; row++) {
                if (noAttack(chessboard, row, col)) {
                    chessboard[row][col] = true;
                    recursiveSolve(chessboard, col + 1);
                    chessboard[row][col] = false;
                }
            }
        }
    }

    private boolean noAttack(boolean[][] chessboard, int row, int col) {
        int n = chessboard.length;

        // check row
        for (int r = 0; r < n; r++) {
            if (chessboard[r][col]) return false;
        }
        // check col
        for (int c = 0; c < n; c++) {
            if (chessboard[row][c]) return false;
        }
        // main diagonal
        for (int r = row, c = col; r >= 0 && c >= 0; r--, c--) {
            if (chessboard[r][c]) return false;
        }
        for (int r = row, c = col; r < n && c < n; r++, c++) {
            if (chessboard[r][c]) return false;
        }
        // reverse diagonal
        for (int r = row, c = col; r < n && c >= 0; r++, c--) {
            if (chessboard[r][c]) return false;
        }
        for (int r = row, c = col; r >= 0 && c < n; r--, c++) {
            if (chessboard[r][c]) return false;
        }

        return true;
    }
}
