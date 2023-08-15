package com.witalis.praxis.leetcode.task.h9.p867;

import com.witalis.praxis.leetcode.task.LeetCodeTask;
import com.witalis.praxis.leetcode.task.h9.p867.option.*;
import com.witalis.praxis.leetcode.utils.LeetCode;
import com.witalis.praxis.leetcode.utils.TaskDifficulty;
import com.witalis.praxis.leetcode.utils.TaskRevision;

import lombok.extern.slf4j.Slf4j;
import java.util.concurrent.ThreadLocalRandom;

import static com.witalis.praxis.leetcode.utils.TaskTag.*;

@Slf4j
@LeetCode(
    id = 867,
    description = "Transpose Matrix",
    difficulty = TaskDifficulty.EASY,
    tags = {ARRAY, MATRIX, SIMULATION}
)
public class TransposeMatrix extends LeetCodeTask<int[][]> {
    public static final int LEN = 1_000;
    public static final int VALUE = 1_000;

    private int[][] matrix;

    public static final String INFORMATION = """

        Description:
            Given a 2D integer array matrix, return the transpose of matrix.

            The transpose of a matrix is the matrix flipped over its main diagonal, switching the matrix's row and column indices

        Example:
            Input: matrix = [[1,2,3],[4,5,6],[7,8,9]]
            Output: [[1,4,7],[2,5,8],[3,6,9]]""";

    public TransposeMatrix(int id, String description, TaskRevision revision) {
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
                matrix[i][j] = random.nextInt(1, VALUE + 1);
            }
        }

        log.info("Matrix:");
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

    private static int[][] cloneMatrix(int[][] matrix) {
        int[][] clone = new int[matrix.length][];
        for (int i = 0; i < matrix.length; i++)
            clone[i] = matrix[i].clone();
        return clone;
    }

    @Override
    protected String getInformation() {
        return INFORMATION;
    }

    // time = 1430 ms
    @Override
    protected int[][] original() {
        var original = new Original(cloneMatrix(matrix));
        return original.process();
    }

    // time = 1512 ms
    @Override
    protected int[][] practice() {
        var practice = new Practice(cloneMatrix(matrix));
        return practice.process();
    }

    // time = 1786 ms
    @Override
    protected int[][] solution() {
        var solution = new Solution(cloneMatrix(matrix));
        return solution.process();
    }
}
