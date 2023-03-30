package com.witalis.praxis.leetcode.task.h10.p999.option;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

/**
 * ID: 999
 * Name: Available Captures for Rook
 * URL: <a href="https://leetcode.com/problems/available-captures-for-rook/">Available Captures for Rook</a>
 * Note: try to find the better solution (without timing)
 */
@Slf4j
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Practice {
    private char[][] board;

    public Integer process() {
        return numRookCaptures(board);
    }

    enum Direction {
        NORTH(-1, 0),
        EAST(0, 1),
        SOUTH(1, 0),
        WEST(0, -1);

        final int row;
        final int col;

        Direction(int row, int col) {
            this.row = row;
            this.col = col;
        }
    }

    public int numRookCaptures(char[][] board) {
        if (board == null) return 0;

        final int size = board.length;
        for (int row = 0; row < size; row++) {
            for (int col = 0; col < size; col++) {
                if (board[row][col] == 'R') {
                    int captures = 0;

                    for (final Direction direction : Direction.values()) {
                        int r = row + direction.row;
                        int c = col + direction.col;

                        while (r >= 0 && r < 8 && c >= 0 && c < 8) {
                            if (board[r][c] == 'B') break;

                            if (board[r][c] == 'p') {
                                captures++;
                                break;
                            }

                            r += direction.row;
                            c += direction.col;
                        }
                    }

                    return captures;
                }
            }
        }

        return 0;
    }
}
