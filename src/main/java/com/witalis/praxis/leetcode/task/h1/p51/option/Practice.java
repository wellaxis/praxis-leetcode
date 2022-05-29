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
 * Note: try to find the better solution (without timing)
 */
@Slf4j
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Practice {
    private int number;

    public List<List<String>> process() {
        return solveNQueens(number);
    }

    public List<List<String>> solveNQueens(int n) {
        if (n <= 0) return Collections.emptyList();

        List<List<String>> solutions = new ArrayList<>();
        recursiveSolve(initChessboard(n), 0, solutions);

        return solutions;
    }

    private char[][] initChessboard(int size) {
        char[][] chessboard = new char[size][size];
        for (int row = 0; row < size; row++) {
            Arrays.fill(chessboard[row], '.');
        }
        return chessboard;
    }

    private void recursiveSolve(char[][] chessboard, int col, List<List<String>> solutions) {
        if (col == chessboard.length) {
            storeSolution(solutions, chessboard);
        } else {
            for (int row = 0; row < chessboard.length; row++) {
                if (noAttack(chessboard, row, col)) {
                    chessboard[row][col] = 'Q';
                    recursiveSolve(chessboard, col + 1, solutions);
                    chessboard[row][col] = '.';
                }
            }
        }
    }

    private void storeSolution(List<List<String>> solutions, char[][] chessboard) {
        List<String> solution = new ArrayList<>();
        for (char[] chars : chessboard) {
            solution.add(String.valueOf(chars));
        }
        solutions.add(solution);
    }

    private boolean noAttack(char[][] chessboard, int row, int col) {
        int n = chessboard.length;

        // check row
        for (int r = 0; r < n; r++) {
            if (chessboard[r][col] == 'Q') return false;
        }
        // check col
        for (int c = 0; c < n; c++) {
            if (chessboard[row][c] == 'Q') return false;
        }
        // main diagonal
        for (int r = row, c = col; r >= 0 && c >= 0; r--, c--) {
            if (chessboard[r][c] == 'Q') return false;
        }
        for (int r = row, c = col; r < n && c < n; r++, c++) {
            if (chessboard[r][c] == 'Q') return false;
        }
        // reverse diagonal
        for (int r = row, c = col; r < n && c >= 0; r++, c--) {
            if (chessboard[r][c] == 'Q') return false;
        }
        for (int r = row, c = col; r >= 0 && c < n; r--, c++) {
            if (chessboard[r][c] == 'Q') return false;
        }

        return true;
    }
}
