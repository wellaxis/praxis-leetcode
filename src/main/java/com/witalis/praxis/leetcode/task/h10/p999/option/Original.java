package com.witalis.praxis.leetcode.task.h10.p999.option;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

/**
 * ID: 999
 * Name: Available Captures for Rook
 * URL: <a href="https://leetcode.com/problems/available-captures-for-rook/">Available Captures for Rook</a>
 * Note: the real test solution (code writing with timing)
 */
@Slf4j
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Original {
    private char[][] board;

    public Integer process() {
        return numRookCaptures(board);
    }

    record Position(int row, int col) {}

    enum Direction {
        NORTH(-1, 0),
        NORTH_EAST(-1, 1),
        EAST(0, 1),
        SOUTH_EAST(1, 1),
        SOUTH(1, 0),
        SOUTH_WEST(1, -1),
        WEST(0, -1),
        NORTH_WEST(-1, 1);

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
                    final Position rock = new Position(row, col);

                    return
                        rookCapture(board, rock, Direction.NORTH) +
                        rookCapture(board, rock, Direction.EAST) +
                        rookCapture(board, rock, Direction.SOUTH) +
                        rookCapture(board, rock, Direction.WEST);
                }
            }
        }

        return 0;
    }

    private int rookCapture(char[][] board, Position position, Direction direction) {
        int row = position.row + direction.row;
        int col = position.col + direction.col;
        while (row >= 0 && row < 8 && col >= 0 && col < 8) {
            if (board[row][col] == 'B') {
                return 0;
            } else if (board[row][col] == 'p') {
                return 1;
            }

            row += direction.row;
            col += direction.col;
        }

        return 0;
    }

    private int rookCaptureSafe(char[][] board, Position position, Direction direction) {
        int row = position.row + direction.row;
        int col = position.col + direction.col;
        while (row >= 0 && row < 8 && col >= 0 && col < 8) {
            if (board[row][col] == 'B') {
                return 0;
            } else if (board[row][col] == 'p') {
                position = new Position(row, col);
                final boolean block =
                    bishopBlock(board, position, Direction.NORTH_EAST) ||
                    bishopBlock(board, position, Direction.SOUTH_EAST) ||
                    bishopBlock(board, position, Direction.SOUTH_WEST) ||
                    bishopBlock(board, position, Direction.NORTH_WEST);

                return block ? 0 : 1;
            }

            row += direction.row;
            col += direction.col;
        }

        return 0;
    }

    private boolean bishopBlock(char[][] board, Position position, Direction direction) {
        int row = position.row + direction.row;
        int col = position.col + direction.col;
        while (row >= 0 && row < 8 && col >= 0 && col < 8) {
            if (board[row][col] == 'p') {
                return false;
            } else if (board[row][col] == 'B') {
                return true;
            }

            row += direction.row;
            col += direction.col;
        }

        return false;
    }
}
