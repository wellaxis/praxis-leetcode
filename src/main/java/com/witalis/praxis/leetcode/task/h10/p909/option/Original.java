package com.witalis.praxis.leetcode.task.h10.p909.option;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.util.ArrayDeque;
import java.util.Queue;

/**
 * ID: 909
 * Name: Snakes and Ladders
 * URL: <a href="https://leetcode.com/problems/snakes-and-ladders/">Snakes and Ladders</a>
 * Note: the real test solution (code writing with timing)
 */
@Slf4j
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Original {
    private int[][] board;

    public Integer process() {
        return snakesAndLadders(board);
    }

    public int snakesAndLadders(int[][] board) {
        if (board == null || board.length == 0) return 0;

        int len = board.length;
        int[] squares = initSquares(board);

        Queue<Integer> queue = new ArrayDeque<>();
        queue.offer(1);
        boolean[] seen = new boolean[len * len];

        int steps = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = size; i > 0; i--) {
                int square = queue.poll();

                if (square == len * len) return steps;
                if (seen[square - 1]) continue;

                seen[square - 1] = true;
                for (int j = 1; j <= 6 && square + j <= len * len; j++) {
                    int nextSquare = square + j;
                    int position = squares[nextSquare - 1];
                    if (position > 0) nextSquare = position;
                    if (!seen[nextSquare - 1]) queue.offer(nextSquare);
                }
            }
            steps++;
        }

        return -1;
    }

    private int[] initSquares(int[][] board) {
        int len = board.length;
        int[] squares = new int[len * len];

        boolean direct = true;
        int index = 0;
        for (int r = len - 1; r >= 0; r--) {
            for (int c = 0; c < len; c++) {
                squares[index++] = direct ? board[r][c] : board[r][len - c - 1];
            }
            direct = !direct;
        }

        return squares;
    }
}
