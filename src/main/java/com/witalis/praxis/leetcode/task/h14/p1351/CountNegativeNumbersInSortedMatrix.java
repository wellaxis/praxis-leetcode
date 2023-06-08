package com.witalis.praxis.leetcode.task.h14.p1351;

import com.witalis.praxis.leetcode.task.LeetCodeTask;
import com.witalis.praxis.leetcode.task.h14.p1351.option.*;
import com.witalis.praxis.leetcode.utils.LeetCode;
import com.witalis.praxis.leetcode.utils.TaskDifficulty;
import com.witalis.praxis.leetcode.utils.TaskRevision;

import lombok.extern.slf4j.Slf4j;
import java.util.concurrent.ThreadLocalRandom;

import static com.witalis.praxis.leetcode.utils.TaskTag.*;

@Slf4j
@LeetCode(
    id = 1351,
    description = "Count Negative Numbers in a Sorted Matrix",
    difficulty = TaskDifficulty.EASY,
    tags = {ARRAY, BINARY_SEARCH, MATRIX}
)
public class CountNegativeNumbersInSortedMatrix extends LeetCodeTask<Integer> {
    public static final int LEN = 100;
    public static final int VALUE = 100;

    private int[][] matrix;

    public static final String INFORMATION = """

        Description:
            Given a m x n matrix grid which is sorted in non-increasing order both row-wise and column-wise,
                return the number of negative numbers in grid.

        Example:
            Input: grid = [
                [4,3,2,-1],
                [3,2,1,-1],
                [1,1,-1,-2],
                [-1,-1,-2,-3]
            ]
            Output: 8
            Explanation: There are 8 negatives number in the matrix.""";

    public CountNegativeNumbersInSortedMatrix(int id, String description, TaskRevision revision) {
        super(id, description, revision);
        initialization();
    }

    private void initialization() {
        final var random = ThreadLocalRandom.current();

        int n = random.nextInt(1, LEN + 1);
        int m = random.nextInt(1, LEN + 1);
        this.matrix = new int[n][m];
        for (int i = 0; i < n; i++) {
            matrix[i] = random.ints(m, -VALUE, VALUE + 1).map(v -> -v).sorted().map(v -> -v).toArray();
        }

        log.info("Matrix:");
        printMatrix(matrix);
    }

    private static void printMatrix(int[][] matrix) {
        var format = "%" + String.valueOf(VALUE + 2).length() + "d";

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

    // time = 688 ms
    @Override
    protected Integer original() {
        var original = new Original(matrix);
        return original.process();
    }

    // time = 519 ms
    @Override
    protected Integer practice() {
        var practice = new Practice(matrix);
        return practice.process();
    }

    // time = 465 ms
    @Override
    protected Integer solution() {
        var solution = new Solution(matrix);
        return solution.process();
    }
}
