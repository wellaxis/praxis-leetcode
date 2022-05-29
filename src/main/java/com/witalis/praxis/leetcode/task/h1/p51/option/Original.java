package com.witalis.praxis.leetcode.task.h1.p51.option;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.util.*;

/**
 * ID: 51
 * Name: N-Queens
 * URL: <a href="https://leetcode.com/problems/n-queens/">N-Queens</a>
 * Note: the real test solution (code writing with timing)
 */
@Slf4j
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Original {
    private int number;

    public List<List<String>> process() {
        return solveNQueens(number);
    }

    public List<List<String>> solveNQueens(int n) {
        if (n <= 0) return Collections.emptyList();

        List<List<String>> solutions = new ArrayList<>();
        recursiveSolve(new boolean[n][n], 0, solutions);

        return solutions;
    }

    private void recursiveSolve(boolean[][] chessboard, int col, List<List<String>> solutions) {
        if (col == chessboard.length) {
            storeSolution(solutions, chessboard);
            return;
        }

        for (int row = 0; row < chessboard.length; row++) {
            if (noAttack(chessboard, row, col)) {
                chessboard[row][col] = true;
                recursiveSolve(chessboard, col + 1, solutions);
                chessboard[row][col] = false;
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

    private void storeSolution(List<List<String>> solutions, boolean[][] chessboard) {
        List<String> solution = new ArrayList<>();
        for (int row = 0; row < chessboard.length; row++) {
            StringBuilder builder = new StringBuilder();
            for (int col = 0; col < chessboard.length; col++) {
                if (chessboard[row][col]) {
                    builder.append('Q');
                } else {
                    builder.append('.');
                }
            }
            solution.add(builder.toString());
        }
        solutions.add(solution);
    }
}
