package com.witalis.praxis.leetcode.task.h3.p240;

import com.witalis.praxis.leetcode.task.LeetCodeTask;
import com.witalis.praxis.leetcode.task.h3.p240.option.*;
import com.witalis.praxis.leetcode.utils.LeetCode;
import com.witalis.praxis.leetcode.utils.TaskDifficulty;
import com.witalis.praxis.leetcode.utils.TaskRevision;

import lombok.extern.slf4j.Slf4j;
import java.util.Arrays;
import java.util.concurrent.ThreadLocalRandom;

import static com.witalis.praxis.leetcode.utils.TaskTag.*;

@Slf4j
@LeetCode(
    id = 240,
    description = "Search a 2D Matrix II",
    difficulty = TaskDifficulty.MEDIUM,
    tags = {ARRAY, BINARY_SEARCH, DIVIDE_AND_CONQUER, MATRIX}
)
public class Search2DMatrixII extends LeetCodeTask<Boolean> {
    public static final int LEN = 300;

    private int[][] matrix;
    private int target;

    public static final String INFORMATION = """

        Write an efficient algorithm that searches for a value target
            in an m x n integer matrix matrix. This matrix has the following properties:
            * Integers in each row are sorted in ascending from left to right.
            * Integers in each column are sorted in ascending from top to bottom.

        Example:
            Input: matrix = [[1,4,7,11,15],[2,5,8,12,19],[3,6,9,16,22],[10,13,14,17,24],[18,21,23,26,30]], target = 5
            Output: true""";

    public Search2DMatrixII(int id, String description, TaskRevision revision) {
        super(id, description, revision);
        initialization();
    }

    private void initialization() {
        final var random = ThreadLocalRandom.current();

        int rows = random.nextInt(1, LEN + 1);
        int columns = random.nextInt(1, LEN + 1);

        this.matrix = new int[rows][columns];

        int step = Integer.MAX_VALUE / rows;
        for (int m = 0; m < rows; m++) {
            for (int n = 0; n < columns; n++) {
                matrix[m][n] = m * step + random.nextInt(0, step + 1);
            }
            Arrays.sort(matrix[m]);
        }

        this.target = random.nextBoolean()
            ? matrix[random.nextInt(1, rows + 1)][random.nextInt(1, columns + 1)]
            : random.nextInt(Integer.MIN_VALUE, Integer.MAX_VALUE);

        log.info("Matrix[{} x {}] is:", rows, columns);
        for (int[] row : matrix) {
            log.info("{}", Arrays.toString(row));
        }
        log.info("Target is {}", target);
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

    // time = 866 ms
    @Override
    protected Boolean original() {
        var original = new Original(matrix, target);
        return original.process();
    }

    // time = 523 ms
    @Override
    protected Boolean practice() {
        var practice = new Practice(matrix, target);
        return practice.process();
    }

    // time = 432 ms
    @Override
    protected Boolean solution() {
        var solution = new Solution(matrix, target);
        return solution.process();
    }
}
