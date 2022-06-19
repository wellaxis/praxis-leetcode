package com.witalis.praxis.leetcode.task.h1.p85;

import com.witalis.praxis.leetcode.task.LeetCodeTask;
import com.witalis.praxis.leetcode.task.h1.p85.option.*;
import com.witalis.praxis.leetcode.utils.LeetCode;
import com.witalis.praxis.leetcode.utils.TaskDifficulty;
import com.witalis.praxis.leetcode.utils.TaskRevision;

import lombok.extern.slf4j.Slf4j;
import java.util.Arrays;
import java.util.concurrent.ThreadLocalRandom;

import static com.witalis.praxis.leetcode.utils.TaskTag.*;

@Slf4j
@LeetCode(
    id = 85,
    description = "Maximal Rectangle",
    difficulty = TaskDifficulty.HARD,
    tags = {ARRAY, DYNAMIC_PROGRAMMING, STACK, MATRIX, MONOTONIC_STACK}
)
public class MaximalRectangle extends LeetCodeTask<Integer> {
    public static final int LEN = 200;
    private char[][] matrix;

    public static final String INFORMATION = """

        Given a rows x cols binary matrix filled with 0's and 1's,
            find the largest rectangle containing only 1's and return its area.

        Example:
            Input: matrix = [["1","0","1","0","0"],["1","0","1","1","1"],["1","1","1","1","1"],["1","0","0","1","0"]]
            Output: 6
            Explanation: The maximal rectangle is shown in the above picture.""";

    public MaximalRectangle(int id, String description, TaskRevision revision) {
        super(id, description, revision);
        initialization();
    }

    private void initialization() {
        this.matrix = generate();

        log.info("Matrix:");
        printImage(matrix);
    }

    private static char[][] generate() {
        var random = ThreadLocalRandom.current();

        int height = random.nextInt(1, LEN + 1);
        int width = random.nextInt(1, LEN + 1);

        char[][] binaryMatrix = new char[height][width];
        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                binaryMatrix[i][j] = random.nextInt(0, 5) == 0 ? '0' : '1';
            }
        }
        return binaryMatrix;
    }

    private static void printImage(char[][] matrix) {
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
        log.info("Matrix [{}][{}] has been generated successfully.", matrix.length, matrix[0].length);
    }

    private static char[][] cloneMatrix(char[][] image) {
        if (image == null) return new char[0][0];

        return Arrays.stream(image)
            .map(char[]::clone)
            .toArray(char[][]::new);
    }

    @Override
    protected String getInformation() {
        return INFORMATION;
    }

    // time = 3717 ms, time limit exceeded
    @Override
    protected Integer original() {
        var original = new Original(matrix);
        return original.process();
    }

    // time = 8664 ms
    @Override
    protected Integer practice() {
        var practice = new Practice(matrix);
        return practice.process();
    }

    // time = 2975 ms
    @Override
    protected Integer solution() {
        var solution = new Solution(matrix);
        return solution.process();
    }
}
