package com.witalis.praxis.leetcode.task.h1.p73;

import com.witalis.praxis.leetcode.task.LeetCodeTask;
import com.witalis.praxis.leetcode.task.h1.p73.option.*;
import com.witalis.praxis.leetcode.utils.LeetCode;
import com.witalis.praxis.leetcode.utils.TaskDifficulty;
import com.witalis.praxis.leetcode.utils.TaskRevision;

import lombok.extern.slf4j.Slf4j;
import java.util.Arrays;
import java.util.concurrent.ThreadLocalRandom;

import static com.witalis.praxis.leetcode.utils.TaskTag.*;

@Slf4j
@LeetCode(
    id = 73,
    description = "Set Matrix Zeroes",
    difficulty = TaskDifficulty.MEDIUM,
    tags = {ARRAY, HASH_TABLE, MATRIX}
)
public class SetMatrixZeroes extends LeetCodeTask<int[][]> {
    public static final int LEN = 200;
    public static final int VALUE = 50;

    private int[][] matrix;

    public static final String INFORMATION = """

        Given an m x n integer matrix matrix,
            if an element is 0, set its entire row and column to 0's,
            and return the matrix.

        You must do it in place.

        Example:
            Input: matrix = [[0,1,2,0],[3,4,5,2],[1,3,1,5]]
            Output: [[0,0,0,0],[0,4,5,0],[0,3,1,0]]""";

    public SetMatrixZeroes(int id, String description, TaskRevision revision) {
        super(id, description, revision);
        initialization();
    }

    private void initialization() {
        var random = ThreadLocalRandom.current();
        int rows = random.nextInt(1, LEN + 1);
        int columns = random.nextInt(1, LEN + 1);

        this.matrix = new int[rows][columns];
        for (int m = 0; m < rows; m++)
            for (int n = 0; n < columns; n++)
                matrix[m][n] = random.nextInt(-VALUE, VALUE + 1);

        log.info("Matrix is:");
        for (int[] row : matrix) {
            log.info("{}", Arrays.toString(row));
        }
    }

    private int[][] cloneMatrix(int[][] matrix) {
        int[][] clone = new int[matrix.length][];
        for (int i = 0; i < matrix.length; i++)
            clone[i] = matrix[i].clone();
        return clone;
    }

    @Override
    protected String getInformation() {
        return INFORMATION;
    }

    // time = 3594 ms
    @Override
    protected int[][] original() {
        var original = new Original(cloneMatrix(matrix));
        return original.process();
    }

    // time = 1764 ms
    @Override
    protected int[][] practice() {
        var practice = new Practice(cloneMatrix(matrix));
        return practice.process();
    }

    // time = 1613 ms
    @Override
    protected int[][] solution() {
        var solution = new Solution(cloneMatrix(matrix));
        return solution.process();
    }
}
