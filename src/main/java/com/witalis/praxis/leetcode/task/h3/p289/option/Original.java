package com.witalis.praxis.leetcode.task.h3.p289.option;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.util.HashSet;
import java.util.Set;

/**
 * ID: 289
 * Name: Game of Life
 * URL: <a href="https://leetcode.com/problems/game-of-life/">Game of Life</a>
 * Note: the real test solution (code writing with timing)
 */
@Slf4j
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Original {
    private int[][] board;

    public int[][] process() {
        gameOfLife(board);
        return board;
    }

    record Cell(int row, int col) {}

    public void gameOfLife(int[][] board) {
        if (board == null) return;

        int rows = board.length;
        int cols = board[0].length;

        Set<Cell> changes = new HashSet<>();

        int existence;
        int neighbors;
        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < cols; col++) {
                // count neighbors
                neighbors = 0;
                for (int r = row - 1; r <= row + 1; r++) {
                    for (int c = col - 1; c <= col + 1; c++) {
                        if (r == row && c == col) continue;
                        if (r >= 0 && r < rows && c >= 0 && c < cols) {
                            Cell cell = new Cell(r, c);
                            if ((board[r][c] == 0 && changes.contains(cell)) || (board[r][c] == 1 && !changes.contains(cell))) {
                                neighbors++;
                            }
                        }
                    }
                }
                // check existence
                existence = board[row][col];
                switch (existence) {
                    case 0: {
                        if (neighbors == 3) {
                            board[row][col] = 1;
                            changes.add(new Cell(row, col));
                        }
                        break;
                    }
                    case 1: {
                        if (neighbors < 2 || neighbors > 3) {
                            board[row][col] = 0;
                            changes.add(new Cell(row, col));
                        }
                        break;
                    }
                }
            }
        }
    }
}
