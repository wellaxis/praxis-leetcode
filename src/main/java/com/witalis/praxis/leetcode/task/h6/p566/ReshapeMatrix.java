package com.witalis.praxis.leetcode.task.h6.p566;

import com.witalis.praxis.leetcode.task.LeetCodeTask;
import com.witalis.praxis.leetcode.task.h6.p566.option.*;
import com.witalis.praxis.leetcode.utils.LeetCode;
import com.witalis.praxis.leetcode.utils.TaskDifficulty;
import com.witalis.praxis.leetcode.utils.TaskRevision;

import lombok.extern.slf4j.Slf4j;
import java.util.Arrays;
import java.util.concurrent.ThreadLocalRandom;

import static com.witalis.praxis.leetcode.utils.TaskTag.*;

@Slf4j
@LeetCode(
    id = 566,
    description = "Reshape the Matrix",
    difficulty = TaskDifficulty.EASY,
    tags = {ARRAY, MATRIX, SIMULATION}
)
public class ReshapeMatrix extends LeetCodeTask<int[][]> {
    public static final int LEN_ORIGINAL = 100;
    public static final int LEN_RESHAPED = 300;
    public static final int VALUE = 1_000;
    private int[][] matrix;
    private int rows;
    private int cols;

    public static final String INFORMATION = """

        In MATLAB, there is a handy function called reshape which can reshape an m x n matrix
            into a new one with a different size r x c keeping its original data.

        You are given an m x n matrix mat and two integers r and c
            representing the number of rows and the number of columns of the wanted reshaped matrix.

        The reshaped matrix should be filled with all the elements of the original matrix
            in the same row-traversing order as they were.

        If the reshape operation with given parameters is possible and legal,
            output the new reshaped matrix; Otherwise, output the original matrix.

        Example:
            Input: mat = [[1,2],[3,4]], r = 1, c = 4
            Output: [[1,2,3,4]]""";

    public ReshapeMatrix(int id, String description, TaskRevision revision) {
        super(id, description, revision);
        initialization();
    }

    private void initialization() {
        this.matrix = generate();
        this.rows = ThreadLocalRandom.current().nextInt(1, LEN_RESHAPED);
        this.cols = ThreadLocalRandom.current().nextInt(1, LEN_RESHAPED);

        log.info("Matrix:");
        printMatrix(matrix);

        log.info("Rows: {}, Columns: {}", rows, cols);
    }

    private int[][] generate() {
        var random = ThreadLocalRandom.current();
        int matrixRows = random.nextInt(1, LEN_ORIGINAL + 1);
        int matrixCols = random.nextInt(1, LEN_ORIGINAL + 1);

        int[][] generatedMatrix = new int[matrixRows][matrixCols];
        for (int i = 0; i < matrixRows; i++) {
            for (int j = 0; j < matrixCols; j++) {
                generatedMatrix[i][j] = random.nextInt(-VALUE + 1, VALUE);
            }
        }
        return generatedMatrix;
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
        if (matrix == null) return new int[0][0];

        return Arrays.stream(matrix)
            .map(int[]::clone)
            .toArray(int[][]::new);
    }

    @Override
    protected String getInformation() {
        return INFORMATION;
    }

    // time = 2718 ms
    @Override
    protected int[][] original() {
        var original = new Original(matrix, rows, cols);
        return original.process();
    }

    // time = 1421 ms
    @Override
    protected int[][] practice() {
        var practice = new Practice(matrix, rows, cols);
        return practice.process();
    }

    // time = 749 ms
    @Override
    protected int[][] solution() {
        var solution = new Solution(matrix, rows, cols);
        return solution.process();
    }
}
