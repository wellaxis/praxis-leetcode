package com.witalis.praxis.leetcode.task.h3.p221;

import com.witalis.praxis.leetcode.task.LeetCodeTask;
import com.witalis.praxis.leetcode.task.h3.p221.option.*;
import com.witalis.praxis.leetcode.utils.LeetCode;
import com.witalis.praxis.leetcode.utils.TaskDifficulty;
import com.witalis.praxis.leetcode.utils.TaskRevision;

import lombok.extern.slf4j.Slf4j;
import java.util.Arrays;
import java.util.concurrent.ThreadLocalRandom;

import static com.witalis.praxis.leetcode.utils.TaskTag.*;

@Slf4j
@LeetCode(
    id = 221,
    description = "Maximal Square",
    difficulty = TaskDifficulty.MEDIUM,
    tags = {ARRAY, DYNAMIC_PROGRAMMING, MATRIX}
)
public class MaximalSquare extends LeetCodeTask<Integer> {
    public static final int LEN = 300;
    private char[][] matrix;

    public static final String INFORMATION = """

        Given an m x n binary matrix filled with 0's and 1's,
            find the largest square containing only 1's and return its area.

        Example:
            Input: matrix = [["1","0","1","0","0"],["1","0","1","1","1"],["1","1","1","1","1"],["1","0","0","1","0"]]
            Output: 4""";

    public MaximalSquare(int id, String description, TaskRevision revision) {
        super(id, description, revision);
        initialization();
    }

    private void initialization() {
        this.matrix = generate();

        log.info("Matrix:");
        printImage(matrix);
    }

    private char[][] generate() {
        var random = ThreadLocalRandom.current();

        int height = random.nextInt(1, LEN + 1);
        int width = random.nextInt(1, LEN + 1);

        char[][] binaryMatrix = new char[height][width];
        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                binaryMatrix[i][j] = random.nextBoolean() ? '1' : '0';
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

    // time = 1737 ms
    @Override
    protected Integer original() {
        var original = new Original(matrix);
        return original.process();
    }

    // time = 1481 ms
    @Override
    protected Integer practice() {
        var practice = new Practice(matrix);
        return practice.process();
    }

    // time = 1071 ms
    @Override
    protected Integer solution() {
        var solution = new Solution(matrix);
        return solution.process();
    }
}
