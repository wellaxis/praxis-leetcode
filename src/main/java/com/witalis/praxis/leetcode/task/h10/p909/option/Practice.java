package com.witalis.praxis.leetcode.task.h10.p909.option;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * ID: 909
 * Name: Snakes and Ladders
 * URL: <a href="https://leetcode.com/problems/snakes-and-ladders/">Snakes and Ladders</a>
 * Note: try to find the better solution (without timing)
 */
@Slf4j
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Practice {
    private int[][] board;

    public Integer process() {
        return snakesAndLadders(board);
    }

    public int snakesAndLadders(int[][] board) {
        if (board == null || board.length == 0) return 0;

        final int len = board.length;
        final int[] squares = initSquares(board);

        final Queue<Integer> queue = new LinkedList<>(List.of(0));
        final boolean[] seen = new boolean[len * len];

        int steps = 0;
        while (!queue.isEmpty()) {
            for (int size = queue.size(); size > 0; size--) {
                int square = queue.poll();

                if (square == len * len - 1) return steps;
                if (seen[square]) continue;

                seen[square] = true;
                for (int step = 1; step <= 6 && square + step <= len * len - 1; step++) {
                    int nextSquare = square + step;

                    if (squares[nextSquare] > 0) nextSquare = squares[nextSquare] - 1;
                    if (!seen[nextSquare]) queue.offer(nextSquare);
                }
            }
            steps++;
        }

        return -1;
    }

    private int[] initSquares(int[][] board) {
        final int len = board.length;
        final int[] squares = new int[len * len];

        boolean direct = true;
        int index = 0;
        for (int row = len - 1; row >= 0; row--) {
            for (int col = 0; col < len; col++) {
                squares[index++] = direct ? board[row][col] : board[row][len - col - 1];
            }
            direct = !direct;
        }

        return squares;
    }
}
