package com.witalis.praxis.leetcode.task.h1.p54;

import com.witalis.praxis.leetcode.task.LeetCodeTask;
import com.witalis.praxis.leetcode.task.h1.p54.option.*;
import com.witalis.praxis.leetcode.utils.LeetCode;
import com.witalis.praxis.leetcode.utils.TaskDifficulty;
import com.witalis.praxis.leetcode.utils.TaskRevision;

import lombok.extern.slf4j.Slf4j;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

import static com.witalis.praxis.leetcode.utils.TaskTag.*;

@Slf4j
@LeetCode(
    id = 54,
    description = "Spiral Matrix",
    difficulty = TaskDifficulty.MEDIUM,
    tags = {ARRAY, MATRIX, SIMULATION}
)
public class SpiralMatrix extends LeetCodeTask<List<Integer>> {
    public static final int LEN = 10;
    public static final int VALUE = 100;

    private int[][] matrix;

    public static final String INFORMATION = """

        Given an m x n matrix, return all elements of the matrix in spiral order.

        Example:
            Input: matrix = [[1,2,3,4],[5,6,7,8],[9,10,11,12]]
            Output: [1,2,3,4,8,12,11,10,9,5,6,7]""";

    public SpiralMatrix(int id, String description, TaskRevision revision) {
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

    // time = 599 ms
    @Override
    protected List<Integer> original() {
        var original = new Original(cloneMatrix(matrix));
        return original.process();
    }

    // time = 632 ms
    @Override
    protected List<Integer> practice() {
        var practice = new Practice(cloneMatrix(matrix));
        return practice.process();
    }

    // time = 563 ms
    @Override
    protected List<Integer> solution() {
        var solution = new Solution(cloneMatrix(matrix));
        return solution.process();
    }
}
