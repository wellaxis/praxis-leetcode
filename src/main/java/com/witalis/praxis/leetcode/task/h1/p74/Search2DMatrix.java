package com.witalis.praxis.leetcode.task.h1.p74;

import com.witalis.praxis.leetcode.task.LeetCodeTask;
import com.witalis.praxis.leetcode.task.h1.p74.option.*;
import com.witalis.praxis.leetcode.utils.LeetCode;
import com.witalis.praxis.leetcode.utils.TaskDifficulty;
import com.witalis.praxis.leetcode.utils.TaskRevision;

import lombok.extern.slf4j.Slf4j;
import java.util.Arrays;
import java.util.concurrent.ThreadLocalRandom;

import static com.witalis.praxis.leetcode.utils.TaskTag.*;

@Slf4j
@LeetCode(
    id = 74,
    description = "Search a 2D Matrix",
    difficulty = TaskDifficulty.MEDIUM,
    tags = {ARRAY, BINARY_SEARCH, MATRIX}
)
public class Search2DMatrix extends LeetCodeTask<Boolean> {
    public static final int LEN = 100;
    public static final int VALUE = 10_000;

    private int[][] matrix;
    private int target;

    public static final String INFORMATION = """

        Write an efficient algorithm that searches for a value target
            in an m x n integer matrix matrix. This matrix has the following properties:
            * Integers in each row are sorted from left to right.
            * The first integer of each row is greater than the last integer of the previous row.

        Example:
            Input: matrix = [[1,3,5,7],[10,11,16,20],[23,30,34,60]], target = 3
            Output: true""";

    public Search2DMatrix(int id, String description, TaskRevision revision) {
        super(id, description, revision);
        initialization();
    }

    private void initialization() {
        var random = ThreadLocalRandom.current();
        int rows = random.nextInt(1, LEN + 1);
        int columns = random.nextInt(1, LEN + 1);

        this.matrix = new int[rows][columns];
        int step = 2 * VALUE / rows;
        for (int m = 0; m < rows; m++) {
            for (int n = 0; n < columns; n++) {
                matrix[m][n] = random.nextInt(-VALUE + m * step, -VALUE + (m + 1) * step);
            }
            Arrays.sort(matrix[m]);
        }

        this.target = random.nextInt(-VALUE, VALUE + 1);

        log.info("Matrix[{} x {}] is:", rows, columns);
        for (int[] row : matrix) {
            log.info("{}", Arrays.toString(row));
        }
        log.info("Target is {}", target);
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

    // time = 385 ms
    @Override
    protected Boolean original() {
        var original = new Original(cloneMatrix(matrix), target);
        return original.process();
    }

    // time = 350 ms
    @Override
    protected Boolean practice() {
        var practice = new Practice(cloneMatrix(matrix), target);
        return practice.process();
    }

    // time = 299 ms
    @Override
    protected Boolean solution() {
        var solution = new Solution(cloneMatrix(matrix), target);
        return solution.process();
    }
}
