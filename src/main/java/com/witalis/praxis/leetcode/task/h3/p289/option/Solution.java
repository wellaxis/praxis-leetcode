package com.witalis.praxis.leetcode.task.h3.p289.option;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

/**
 * ID: 289
 * Name: Game of Life
 * URL: <a href="https://leetcode.com/problems/game-of-life/">Game of Life</a>
 * Note: the best found solution (external programming)
 */
@Slf4j
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Solution {
    private int[][] board;

    public int[][] process() {
        gameOfLife(board);
        return board;
    }

    private static final int[][] DIRS = {
        {-1, -1}, // top-left
        {-1, 0},  // top
        {-1, 1},  // top-right
        {0, -1},  // left
        {0, 1},   // right
        {1, -1},  // bottom-left
        {1, 0},   // bottom
        {1, 1}    // bottom-right
    };

    public void gameOfLife(int[][] board) {
        var rows = board.length;
        var cols = board[0].length;
        playGame(board, rows, cols);
        updateBoard(board, rows, cols);
    }

    private void playGame(int[][] board, int rows, int cols) {
        // 2 -> changed from 0 to 1
        // 3 -> changed from 1 to 0
        for (var i = 0; i < rows; i++)
            for (var j = 0; j < cols; j++) {
                var alive = aliveNeighbors(board, rows, cols, i, j);
                // dead cell with 3 live neighbors becomes alive
                if (board[i][j] == 0 && alive == 3) board[i][j] = 2;
                // live cell with 2 or 3 live neighbors lives on
                else if (board[i][j] == 1 && (alive == 2 || alive == 3)) board[i][j] = 3;
            }
    }

    private int aliveNeighbors(int[][] board, int rows, int cols, int i, int j) {
        var alive = 0;
        for (var dir : DIRS) {
            var neighborX = i + dir[0];
            var neighborY = j + dir[1];
            if (!isOutOfBounds(rows, cols, neighborX, neighborY))
                alive += board[neighborX][neighborY] & 1;
        }
        return alive;
    }

    private boolean isOutOfBounds(int rows, int cols, int x, int y) {
        return x < 0 || x >= rows || y < 0 || y >= cols;
    }

    private void updateBoard(int[][] board, int rows, int cols) {
        for (var i = 0; i < rows; i++)
            for (var j = 0; j < cols; j++)
                // right shift 1 bit to replace old state with new state
                if (board[i][j] != 0) board[i][j] >>= 1;
    }
}
