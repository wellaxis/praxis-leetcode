package com.witalis.praxis.leetcode.task.h10.p999;

import com.witalis.praxis.leetcode.task.LeetCodeTask;
import com.witalis.praxis.leetcode.task.h10.p999.option.*;
import com.witalis.praxis.leetcode.utils.LeetCode;
import com.witalis.praxis.leetcode.utils.TaskDifficulty;
import com.witalis.praxis.leetcode.utils.TaskRevision;

import lombok.extern.slf4j.Slf4j;
import java.util.concurrent.ThreadLocalRandom;

import static com.witalis.praxis.leetcode.utils.TaskTag.*;

@Slf4j
@LeetCode(
    id = 999,
    description = "Available Captures for Rook",
    difficulty = TaskDifficulty.EASY,
    tags = {ARRAY, MATRIX, SIMULATION}
)
public class AvailableCapturesForRook extends LeetCodeTask<Integer> {
    public static final int SIZE = 8;

    private char[][] board;

    public static final String INFORMATION = """

        Description:
            On an 8 x 8 chessboard, there is exactly one white rook 'R'
                and some number of white bishops 'B', black pawns 'p', and empty squares '.'.

            When the rook moves, it chooses one of four cardinal directions (north, east, south, or west),
                then moves in that direction until it chooses to stop, reaches the edge of the board,
                captures a black pawn, or is blocked by a white bishop.
                A rook is considered attacking a pawn if the rook can capture the pawn on the rook's turn.
                The number of available captures for the white rook is the number of pawns that the rook is attacking.

            Return the number of available captures for the white rook.

        Example:
            Input: board =
            [
                [".",".",".",".",".",".",".","."],
                [".",".",".","p",".",".",".","."],
                [".",".",".","R",".",".",".","p"],
                [".",".",".",".",".",".",".","."],
                [".",".",".",".",".",".",".","."],
                [".",".",".","p",".",".",".","."],
                [".",".",".",".",".",".",".","."],
                [".",".",".",".",".",".",".","."]
            ]
            Output: 3
            Explanation: In this example, the rook is attacking all the pawns.""";

    public AvailableCapturesForRook(int id, String description, TaskRevision revision) {
        super(id, description, revision);
        initialization();
    }

    private void initialization() {
        this.board = generate(SIZE);

        log.info("Board [{} x {}]:", SIZE, SIZE);
        printBoard(board);
    }

    private char[][] generate(final int size) {
        final var random = ThreadLocalRandom.current();

        final char[][] generatedBoard = new char[size][size];
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                if (random.nextBoolean()) {
                    generatedBoard[i][j] = '.';
                } else {
                    if (random.nextInt(0, 3) == 0) {
                        generatedBoard[i][j] = 'B';
                    } else {
                        generatedBoard[i][j] = 'p';
                    }
                }
            }
        }

        generatedBoard[random.nextInt(0, SIZE)][random.nextInt(0, SIZE)] = 'R';

        return generatedBoard;
    }

    private static void printBoard(char[][] matrix) {
        log.info("-".repeat(4 * matrix[0].length + 1));
        for (char[] row : matrix) {
            var builder = new StringBuilder("| ");
            for (char value : row) {
                builder
                    .append(value)
                    .append(" | ");
            }
            log.info(builder.toString());
            log.info("-".repeat(4 * matrix[0].length + 1));
        }

        log.info("Board [{}][{}] has been generated successfully.", matrix.length, matrix[0].length);
    }

    @Override
    protected String getInformation() {
        return INFORMATION;
    }

    // time = 791 ms
    @Override
    protected Integer original() {
        var original = new Original(board);
        return original.process();
    }

    // time = 586 ms
    @Override
    protected Integer practice() {
        var practice = new Practice(board);
        return practice.process();
    }

    // time = 453 ms
    @Override
    protected Integer solution() {
        var solution = new Solution(board);
        return solution.process();
    }
}
