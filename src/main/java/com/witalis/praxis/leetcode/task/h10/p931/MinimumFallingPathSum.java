package com.witalis.praxis.leetcode.task.h10.p931;

import com.witalis.praxis.leetcode.task.LeetCodeTask;
import com.witalis.praxis.leetcode.task.h10.p931.option.*;
import com.witalis.praxis.leetcode.utils.LeetCode;
import com.witalis.praxis.leetcode.utils.TaskDifficulty;
import com.witalis.praxis.leetcode.utils.TaskRevision;

import lombok.extern.slf4j.Slf4j;
import java.util.Arrays;
import java.util.concurrent.ThreadLocalRandom;

import static com.witalis.praxis.leetcode.utils.TaskTag.*;

@Slf4j
@LeetCode(
    id = 931,
    description = "Minimum Falling Path Sum",
    difficulty = TaskDifficulty.MEDIUM,
    tags = {ARRAY, DYNAMIC_PROGRAMMING, MATRIX}
)
public class MinimumFallingPathSum extends LeetCodeTask<Integer> {
    public static final int LEN = 100;
    public static final int VALUE = 100;
    private int[][] matrix;

    public static final String INFORMATION = """

        Description:
            Given an n x n array of integers matrix, return the minimum sum of any falling path through matrix.

            A falling path starts at any element in the first row and chooses the element in the next row
                that is either directly below or diagonally left/right.
                Specifically, the next element from position (row, col) will be
                (row + 1, col - 1), (row + 1, col), or (row + 1, col + 1).

        Example:
            Input: matrix = [[2,1,3],[6,5,4],[7,8,9]]
            Output: 13
            Explanation: There are two falling paths with a minimum sum as shown.""";

    public MinimumFallingPathSum(int id, String description, TaskRevision revision) {
        super(id, description, revision);
        initialization();
    }

    private void initialization() {
        this.matrix = generate();

        log.info("Matrix[{} x {}]:", matrix.length, matrix.length);
        printMatrix(matrix);
    }

    private int[][] generate() {
        final var random = ThreadLocalRandom.current();

        int size = random.nextInt(1, LEN + 1);
        int[][] generatedMatrix = new int[size][size];
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                generatedMatrix[i][j] = random.nextInt(-VALUE + 1, VALUE);
            }
        }
        return generatedMatrix;
    }

    private static void printMatrix(int[][] matrix) {
        var format = "%" + String.valueOf(VALUE).length() + "d";

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
        var original = new Original(cloneMatrix(matrix));
        return original.process();
    }

    // time = 1098 ms
    @Override
    protected Integer practice() {
        var practice = new Practice(cloneMatrix(matrix));
        return practice.process();
    }

    // time = 823 ms
    @Override
    protected Integer solution() {
        var solution = new Solution(cloneMatrix(matrix));
        return solution.process();
    }
}
