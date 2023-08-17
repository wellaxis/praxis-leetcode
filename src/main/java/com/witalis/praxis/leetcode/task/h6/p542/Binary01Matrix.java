package com.witalis.praxis.leetcode.task.h6.p542;

import com.witalis.praxis.leetcode.task.LeetCodeTask;
import com.witalis.praxis.leetcode.task.h6.p542.option.*;
import com.witalis.praxis.leetcode.utils.LeetCode;
import com.witalis.praxis.leetcode.utils.TaskDifficulty;
import com.witalis.praxis.leetcode.utils.TaskRevision;

import lombok.extern.slf4j.Slf4j;
import java.util.Arrays;
import java.util.concurrent.ThreadLocalRandom;

import static com.witalis.praxis.leetcode.utils.TaskTag.*;

@Slf4j
@LeetCode(
    id = 542,
    description = "01 Matrix",
    difficulty = TaskDifficulty.MEDIUM,
    tags = {ARRAY, DYNAMIC_PROGRAMMING, BREADTH_FIRST_SEARCH, MATRIX}
)
public class Binary01Matrix extends LeetCodeTask<int[][]> {
    public static final int LEN = 10_000;

    private int[][] matrix;

    public static final String INFORMATION = """

        Description:
            Given an m x n binary matrix mat, return the distance of the nearest 0 for each cell.

            The distance between two adjacent cells is 1.

        Example:
            Input: mat = [[0,0,0],[0,1,0],[1,1,1]]
            Output: [[0,0,0],[0,1,0],[1,2,1]]""";

    public Binary01Matrix(int id, String description, TaskRevision revision) {
        super(id, description, revision);
        initialization();
    }

    private void initialization() {
        final var random = ThreadLocalRandom.current();

        int rows = random.nextInt(1, LEN + 1);
        int cols = random.nextInt(1, LEN + 1);

        this.matrix = new int[rows][cols];
        for (int m = 0; m < rows; m++)
            for (int n = 0; n < cols; n++)
                matrix[m][n] = random.nextBoolean() ? 1 : 0;

        log.info("Matrix is:");
        for (int[] row : matrix) {
            log.info("{}", Arrays.toString(row));
        }
    }

    private static void printMatrix(int[][] matrix) {
        var format = "%1d";

        log.info("-".repeat(2 * matrix[0].length + 1));
        for (int[] row : matrix) {
            var builder = new StringBuilder("| ");
            for (int value : row) {
                builder
                    .append(String.format(format, value))
                    .append(" | ");
            }
            log.info(builder.toString());
            log.info("-".repeat(2 * matrix[0].length + 1));
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

    // time = 4852967 ms
    @Override
    protected int[][] original() {
        var original = new Original(cloneMatrix(matrix));
        return original.process();
    }

    // time = 1316819 ms
    @Override
    protected int[][] practice() {
        var practice = new Practice(cloneMatrix(matrix));
        return practice.process();
    }

    // time = 218306 ms
    @Override
    protected int[][] solution() {
        var solution = new Solution(cloneMatrix(matrix));
        return solution.process();
    }
}
