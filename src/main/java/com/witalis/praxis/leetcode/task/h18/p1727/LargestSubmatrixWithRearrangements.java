package com.witalis.praxis.leetcode.task.h18.p1727;

import com.witalis.praxis.leetcode.task.LeetCodeTask;
import com.witalis.praxis.leetcode.task.h18.p1727.option.*;
import com.witalis.praxis.leetcode.utils.LeetCode;
import com.witalis.praxis.leetcode.utils.TaskDifficulty;
import com.witalis.praxis.leetcode.utils.TaskRevision;

import lombok.extern.slf4j.Slf4j;
import java.util.Arrays;
import java.util.concurrent.ThreadLocalRandom;

import static com.witalis.praxis.leetcode.utils.TaskTag.*;

@Slf4j
@LeetCode(
    id = 1727,
    description = "Largest Submatrix With Rearrangements",
    difficulty = TaskDifficulty.MEDIUM,
    tags = {ARRAY, BREADTH_FIRST_SEARCH, MATRIX}
)
public class LargestSubmatrixWithRearrangements extends LeetCodeTask<Integer> {
    public static final int LEN = 1_000;

    private int[][] matrix;

    public static final String INFORMATION = """

        Description:
            You are given a binary matrix matrix of size m x n,
                and you are allowed to rearrange the columns of the matrix in any order.

            Return the area of the largest submatrix within matrix
                where every element of the submatrix is 1 after reordering the columns optimally.

        Example:
            Input: matrix = [[0,0,1],[1,1,1],[1,0,1]]
            Output: 4
            Explanation: You can rearrange the columns as shown above.
                The largest submatrix of 1s, in bold, has an area of 4.""";

    public LargestSubmatrixWithRearrangements(int id, String description, TaskRevision revision) {
        super(id, description, revision);
        initialization();
    }

    private void initialization() {
        this.matrix = generate();

        log.info("Grid[{} x {}]:", matrix.length, matrix[0].length);
        printMatrix(matrix);
    }

    private int[][] generate() {
        final var random = ThreadLocalRandom.current();

        int m = random.nextInt(1, LEN + 1);
        int n = random.nextInt(1, LEN + 1);
        int[][] generatedMatrix = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                generatedMatrix[i][j] = (random.nextInt(0, 3) == 0) ? 1 : 0;
            }
        }

        return generatedMatrix;
    }

    private static void printMatrix(int[][] matrix) {
        var format = "%1d";

        log.info("-".repeat(4 * matrix[0].length + 1));
        for (int[] row : matrix) {
            var builder = new StringBuilder("| ");
            for (int value : row) {
                builder
                    .append(String.format(format, value))
                    .append(" | ");
            }
            log.info(builder.toString());
            log.info("-".repeat(4 * matrix[0].length + 1));
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

    // time = 3555 ms
    @Override
    protected Integer original() {
        var original = new Original(cloneMatrix(matrix));
        return original.process();
    }

    // time = 3263 ms
    @Override
    protected Integer practice() {
        var practice = new Practice(cloneMatrix(matrix));
        return practice.process();
    }

    // time = 2578 ms
    @Override
    protected Integer solution() {
        var solution = new Solution(cloneMatrix(matrix));
        return solution.process();
    }
}
