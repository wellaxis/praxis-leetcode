package com.witalis.praxis.leetcode.task.h16.p1572;

import com.witalis.praxis.leetcode.task.LeetCodeTask;
import com.witalis.praxis.leetcode.task.h16.p1572.option.*;
import com.witalis.praxis.leetcode.utils.LeetCode;
import com.witalis.praxis.leetcode.utils.TaskDifficulty;
import com.witalis.praxis.leetcode.utils.TaskRevision;

import lombok.extern.slf4j.Slf4j;
import java.util.Arrays;
import java.util.concurrent.ThreadLocalRandom;

import static com.witalis.praxis.leetcode.utils.TaskTag.*;

@Slf4j
@LeetCode(
    id = 1572,
    description = "Matrix Diagonal Sum",
    difficulty = TaskDifficulty.EASY,
    tags = {ARRAY, MATRIX}
)
public class MatrixDiagonalSum extends LeetCodeTask<Integer> {
    public static final int LEN = 100;
    public static final int VALUE = 100;

    private int[][] matrix;

    public static final String INFORMATION = """

        Description:
            Given a square matrix mat, return the sum of the matrix diagonals.

            Only include the sum of all the elements on the primary diagonal and
                all the elements on the secondary diagonal that are not part of the primary diagonal.

        Example:
            Input: mat = [
                [1,2,3],
                [4,5,6],
                [7,8,9]
            ]
            Output: 25
            Explanation: Diagonals sum: 1 + 5 + 9 + 3 + 7 = 25
                Notice that element mat[1][1] = 5 is counted only once.""";

    public MatrixDiagonalSum(int id, String description, TaskRevision revision) {
        super(id, description, revision);
        initialization();
    }

    private void initialization() {
        final var random = ThreadLocalRandom.current();

        int size = random.nextInt(1, LEN + 1);
        this.matrix = new int[size][size];
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                matrix[i][j] = random.nextInt(1, VALUE + 1);
            }
        }

        log.info("Matrix:");
        printMatrix(matrix);
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
        log.info("Matrix [{}][{}] has been generated successfully.", matrix.length, matrix[0].length);
    }

    @Override
    protected String getInformation() {
        return INFORMATION;
    }

    // time = 559 ms
    @Override
    protected Integer original() {
        var original = new Original(matrix);
        return original.process();
    }

    // time = 512 ms
    @Override
    protected Integer practice() {
        var practice = new Practice(matrix);
        return practice.process();
    }

    // time = 520 ms
    @Override
    protected Integer solution() {
        var solution = new Solution(matrix);
        return solution.process();
    }
}
