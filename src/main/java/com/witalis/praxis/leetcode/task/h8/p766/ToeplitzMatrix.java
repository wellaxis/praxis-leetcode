package com.witalis.praxis.leetcode.task.h8.p766;

import com.witalis.praxis.leetcode.task.LeetCodeTask;
import com.witalis.praxis.leetcode.task.h8.p766.option.*;
import com.witalis.praxis.leetcode.utils.LeetCode;
import com.witalis.praxis.leetcode.utils.TaskDifficulty;
import com.witalis.praxis.leetcode.utils.TaskRevision;

import lombok.extern.slf4j.Slf4j;
import java.util.Arrays;
import java.util.concurrent.ThreadLocalRandom;

import static com.witalis.praxis.leetcode.utils.TaskTag.*;

@Slf4j
@LeetCode(
    id = 766,
    description = "Toeplitz Matrix",
    difficulty = TaskDifficulty.EASY,
    tags = {ARRAY, MATRIX}
)
public class ToeplitzMatrix extends LeetCodeTask<Boolean> {
    public static final int LEN = 20;
    public static final int VALUE = 100;

    private int[][] matrix;

    public static final String INFORMATION = """

        Description:
            Given an m x n matrix, return true if the matrix is Toeplitz. Otherwise, return false.

            A matrix is Toeplitz if every diagonal from top-left to bottom-right has the same elements.

        Example:
            Input: matrix = [[1,2,3,4],[5,1,2,3],[9,5,1,2]]
            Output: true
            Explanation:
                In the above grid, the diagonals are:
                "[9]", "[5, 5]", "[1, 1, 1]", "[2, 2, 2]", "[3, 3]", "[4]".
                In each diagonal all elements are the same, so the answer is True.""";

    public ToeplitzMatrix(int id, String description, TaskRevision revision) {
        super(id, description, revision);
        initialization();
    }

    private void initialization() {
        final var random = ThreadLocalRandom.current();
        int rows = random.nextInt(1, LEN + 1);
        int cols = random.nextInt(1, LEN + 1);

        this.matrix = new int[rows][cols];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                matrix[i][j] = random.nextInt(0, VALUE);
            }
        }

        log.info("Matrix[{} x {}]:", rows, cols);
        printMatrix(matrix);
    }

    private static void printMatrix(int[][] matrix) {
        var format = "%" + String.valueOf(VALUE).length() + "d";

        log.info("-".repeat(7 * matrix[0].length + 1));
        for (int[] row : matrix) {
            var builder = new StringBuilder("| ");
            for (int value : row) {
                builder
                    .append(String.format(format, value))
                    .append(" | ");
            }
            log.info(builder.toString());
            log.info("-".repeat(7 * matrix[0].length + 1));
        }
        log.info("Matrix [{}][{}] has been generated successfully.", matrix.length, matrix[0].length);
    }

    @Override
    protected String getInformation() {
        return INFORMATION;
    }

    // time = 527 ms
    @Override
    protected Boolean original() {
        var original = new Original(matrix);
        return original.process();
    }

    // time = 499 ms
    @Override
    protected Boolean practice() {
        var practice = new Practice(matrix);
        return practice.process();
    }

    // time = 462 ms
    @Override
    protected Boolean solution() {
        var solution = new Solution(matrix);
        return solution.process();
    }
}
