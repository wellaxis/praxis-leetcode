package com.witalis.praxis.leetcode.task.p48;

import com.witalis.praxis.leetcode.task.LeetCodeTask;
import com.witalis.praxis.leetcode.task.p48.option.*;
import com.witalis.praxis.leetcode.utils.LeetCode;
import com.witalis.praxis.leetcode.utils.TaskRevision;

import lombok.extern.slf4j.Slf4j;

import java.util.Arrays;
import java.util.concurrent.ThreadLocalRandom;

import static com.witalis.praxis.leetcode.utils.TaskTag.*;

@Slf4j
@LeetCode(
    id = 48,
    description = "Rotate Image",
    tags = {ARRAY, MATH, MATRIX}
)
public class RotateImage extends LeetCodeTask<int[][]> {
    public static final int SIZE = 20;
    public static final int VALUE = 1_000;
    private int[][] matrix;

    public static final String INFORMATION = """

        You are given an n x n 2D matrix representing an image,
            rotate the image by 90 degrees (clockwise).

        You have to rotate the image in-place, which means you
            have to modify the input 2D matrix directly.
            DO NOT allocate another 2D matrix and do the rotation.

        Example:
            Input: matrix = [[1,2,3],[4,5,6],[7,8,9]]
            Output: [[7,4,1],[8,5,2],[9,6,3]]""";

    public RotateImage(int id, String description, TaskRevision revision) {
        super(id, description, revision);
        initialization();
    }

    private void initialization() {
        this.matrix = generate();

        log.info("Matrix:");
        printMatrix(matrix);
    }

    private int[][] generate() {
        var random = ThreadLocalRandom.current();
        var size = random.nextInt(1, SIZE + 1);

        int[][] generatedMatrix = new int[size][size];
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                generatedMatrix[i][j] = random.nextInt(-VALUE, VALUE + 1);
            }
        }
        return generatedMatrix;
    }

    private static void printMatrix(int[][] matrix) {
        var format = "%" + String.valueOf(VALUE).length() + "d";

        log.info("-".repeat(7 * matrix.length + 1));
        for (int[] row : matrix) {
            var builder = new StringBuilder("| ");
            for (int value : row) {
                builder
                    .append(String.format(format, value))
                    .append(" | ");
            }
            log.info(builder.toString());
            log.info("-".repeat(7 * matrix.length + 1));
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

    // time = 1209 ms
    @Override
    protected int[][] original() {
        var original = new Original(cloneMatrix(matrix));
        return original.process();
    }

    // time = 745 ms
    @Override
    protected int[][] practice() {
        var practice = new Practice(cloneMatrix(matrix));
        return practice.process();
    }

    // time = 589 ms
    @Override
    protected int[][] solution() {
        var solution = new Solution(cloneMatrix(matrix));
        return solution.process();
    }
}
