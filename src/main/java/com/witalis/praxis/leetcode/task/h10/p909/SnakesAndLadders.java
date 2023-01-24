package com.witalis.praxis.leetcode.task.h10.p909;

import com.witalis.praxis.leetcode.task.LeetCodeTask;
import com.witalis.praxis.leetcode.task.h10.p909.option.*;
import com.witalis.praxis.leetcode.utils.LeetCode;
import com.witalis.praxis.leetcode.utils.TaskDifficulty;
import com.witalis.praxis.leetcode.utils.TaskRevision;

import lombok.extern.slf4j.Slf4j;
import java.util.Arrays;
import java.util.concurrent.ThreadLocalRandom;

import static com.witalis.praxis.leetcode.utils.TaskTag.*;

@Slf4j
@LeetCode(
    id = 909,
    description = "Snakes and Ladders",
    difficulty = TaskDifficulty.MEDIUM,
    tags = {ARRAY, BREADTH_FIRST_SEARCH, MATRIX}
)
public class SnakesAndLadders extends LeetCodeTask<Integer> {
    public static final int LEN = 20;
    private int[][] board;

    public static final String INFORMATION = """

        Description:
            You are given an n x n integer matrix board where the cells are labeled from 1 to n2
                in a Boustrophedon style starting from the bottom left of the board (i.e. board[n - 1][0])
                and alternating direction each row.

            You start on square 1 of the board. In each move, starting from square curr, do the following:
                * Choose a destination square next with a label in the range [curr + 1, min(curr + 6, n2)].
                  This choice simulates the result of a standard 6-sided die roll: i.e.,
                  there are always at most 6 destinations, regardless of the size of the board.
                * If next has a snake or ladder, you must move to the destination of that snake or ladder.
                  Otherwise, you move to next.
                * The game ends when you reach the square n2.

            A board square on row r and column c has a snake or ladder if board[r][c] != -1.
                The destination of that snake or ladder is board[r][c]. Squares 1 and n2 do not have a snake or ladder.

            Note that you only take a snake or ladder at most once per move.
                If the destination to a snake or ladder is the start of another snake or ladder,
                you do not follow the subsequent snake or ladder.

            For example, suppose the board is [[-1,4],[-1,3]], and on the first move, your destination square is 2.
                You follow the ladder to square 3, but do not follow the subsequent ladder to 4.

            Return the least number of moves required to reach the square n2.
                If it is not possible to reach the square, return -1.

        Example:
            Input: board = [[-1,-1,-1,-1,-1,-1],[-1,-1,-1,-1,-1,-1],[-1,-1,-1,-1,-1,-1],[-1,35,-1,-1,13,-1],[-1,-1,-1,-1,-1,-1],[-1,15,-1,-1,-1,-1]]
            Output: 4
            Explanation:
                In the beginning, you start at square 1 (at row 5, column 0).
                You decide to move to square 2 and must take the ladder to square 15.
                You then decide to move to square 17 and must take the snake to square 13.
                You then decide to move to square 14 and must take the ladder to square 35.
                You then decide to move to square 36, ending the game.
                This is the lowest possible number of moves to reach the last square, so return 4.""";

    public SnakesAndLadders(int id, String description, TaskRevision revision) {
        super(id, description, revision);
        initialization();
    }

    private void initialization() {
        this.board = generate();

        log.info("Matrix[{} x {}]:", board.length, board.length);
        printMatrix(board);
    }

    private int[][] generate() {
        final var random = ThreadLocalRandom.current();

        int size = random.nextInt(2, LEN + 1);
        int[][] generatedMatrix = new int[size][size];
        for (int i = 0; i < size; i++)
            for (int j = 0; j < size; j++)
                generatedMatrix[i][j] = -1;

        for (int i = 0; i < size / 2; i++) {
            int row = random.nextInt(0, size);
            int col = random.nextInt(0, size);
            int res = random.nextInt(1, size * size + 1);
            if ((row != 0 || col != 0) && (row != size - 1 || col != 0)) {
                generatedMatrix[row][col] = res;
            }
        }

        return generatedMatrix;
    }

    private static void printMatrix(int[][] matrix) {
        var format = "%" + String.valueOf(100).length() + "d";

        log.info("-".repeat(6 * matrix[0].length + 1));
        for (int[] row : matrix) {
            var builder = new StringBuilder("| ");
            for (int value : row) {
                builder
                    .append(String.format(format, value))
                    .append(" | ");
            }
            log.info(builder.toString());
            log.info("-".repeat(6 * matrix[0].length + 1));
        }
        log.debug("Matrix [{}][{}] has been generated successfully.", matrix.length, matrix[0].length);
    }

    private static int[][] cloneMatrix(int[][] matrix) {
        if (matrix == null) return new int[0][0];

        return Arrays.stream(matrix)
            .map(int[]::clone)
            .toArray(int[][]::new);
    }

    @Override
    protected String getInformation() {
        return INFORMATION;
    }

    // time = 2273 ms
    @Override
    protected Integer original() {
        var original = new Original(board);
        return original.process();
    }

    // time = 1098 ms
    @Override
    protected Integer practice() {
        var practice = new Practice(board);
        return practice.process();
    }

    // time = 823 ms
    @Override
    protected Integer solution() {
        var solution = new Solution(board);
        return solution.process();
    }
}
