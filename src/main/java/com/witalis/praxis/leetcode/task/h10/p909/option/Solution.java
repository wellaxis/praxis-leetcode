package com.witalis.praxis.leetcode.task.h10.p909.option;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.util.LinkedList;
import java.util.Queue;

/**
 * ID: 909
 * Name: Snakes and Ladders
 * URL: <a href="https://leetcode.com/problems/snakes-and-ladders/">Snakes and Ladders</a>
 * Note: the best found solution (external programming)
 */
@Slf4j
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Solution {
    private int[][] board;

    public Integer process() {
        return snakesAndLadders(board);
    }

    public int snakesAndLadders(int[][] board) {
        final int n = board.length;
        final int finish = n * n;
        Queue<Integer> queue = new LinkedList<>();
        queue.add(1);
        boolean[] visited = new boolean[finish + 5];
        visited[0] = true;
        int moves = 1;

        while (!queue.isEmpty()) {
            int queueN = queue.size();

            for (int i = 0; i < queueN; i++) {
                int current = queue.poll();
                // track the max normal roll (no snakes or ladders)
                int maxNormal = -1;
                for (int next = current + 1; next <= current + 6; next++) {
                    int event = board(board, next);
                    if (event == -1) {
                        // no snakes or ladders => update max normal roll
                        maxNormal = next;
                    } else {
                        if (!visited[event - 1]) {
                            // check if reached finish
                            if (event >= finish) {
                                return moves;
                            }
                            // add any events to queue
                            visited[event - 1] = true;
                            queue.add(event);
                        }
                    }
                }

                if (maxNormal != -1 && !visited[maxNormal - 1]) {
                    // check if reached finish
                    if (maxNormal >= finish) {
                        return moves;
                    }
                    // add max normal roll to queue
                    visited[maxNormal - 1] = true;
                    queue.add(maxNormal);
                }
            }
            moves++;
        }
        return -1;
    }

    private int board(int[][] board, int square) {
        final int n = board.length;
        if (square >= n * n) {
            return -1;
        }

        int row = (n - 1) - (square - 1) / n;
        int col = (square - 1) % n;
        if (((square - 1) / n) % 2 == 1) {
            col = (n - 1) - col;
        }

        return board[row][col];
    }
}
