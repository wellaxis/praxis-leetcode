package com.witalis.praxis.leetcode.task.h24.p2328;

import com.witalis.praxis.leetcode.task.LeetCodeTask;
import com.witalis.praxis.leetcode.task.h24.p2328.option.*;
import com.witalis.praxis.leetcode.utils.LeetCode;
import com.witalis.praxis.leetcode.utils.TaskDifficulty;
import com.witalis.praxis.leetcode.utils.TaskRevision;

import lombok.extern.slf4j.Slf4j;
import java.util.concurrent.ThreadLocalRandom;

import static com.witalis.praxis.leetcode.utils.TaskTag.*;

@Slf4j
@LeetCode(
    id = 2328,
    description = "Number of Increasing Paths in a Grid",
    difficulty = TaskDifficulty.HARD,
    tags = {ARRAY, DYNAMIC_PROGRAMMING, DEPTH_FIRST_SEARCH, BREADTH_FIRST_SEARCH, GRAPH, TOPOLOGICAL_SORT, MEMOIZATION, MATRIX}
)
public class NumberOfIncreasingPathsInGrid extends LeetCodeTask<Integer> {
    public static final int LEN = 1_000;
    public static final int VALUE = 100_000;

    private int[][] grid;

    public static final String INFORMATION = """

        Description:
            You are given an m x n integer matrix grid, where you can move from a cell to any adjacent cell in all 4 directions.

            Return the number of strictly increasing paths in the grid such that you can start from any cell and end at any cell.
                Since the answer may be very large, return it modulo 10^9 + 7.

            Two paths are considered different if they do not have exactly the same sequence of visited cells.

        Example:
            Input: grid = [[1,1],[3,4]]
            Output: 8
            Explanation: The strictly increasing paths are:
                - Paths with length 1: [1], [1], [3], [4].
                - Paths with length 2: [1 -> 3], [1 -> 4], [3 -> 4].
                - Paths with length 3: [1 -> 3 -> 4].
                The total number of paths is 4 + 3 + 1 = 8.""";

    public NumberOfIncreasingPathsInGrid(int id, String description, TaskRevision revision) {
        super(id, description, revision);
        initialization();
    }

    private void initialization() {
        final var random = ThreadLocalRandom.current();

        int rows = random.nextInt(1, LEN + 1);
        int cols = random.nextInt(1, LEN + 1);
        this.grid = new int[rows][cols];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                grid[i][j] = random.nextInt(1, VALUE + 1);
            }
        }

        log.info("Matrix:");
        printMatrix(grid);
    }

    private static void printMatrix(int[][] matrix) {
        var format = "%" + String.valueOf(VALUE).length() + "d";

        log.info("-".repeat(9 * matrix[0].length + 1));
        for (int[] row : matrix) {
            var builder = new StringBuilder("| ");
            for (int value : row) {
                builder
                    .append(String.format(format, value))
                    .append(" | ");
            }
            log.info(builder.toString());
            log.info("-".repeat(9 * matrix[0].length + 1));
        }
        log.info("Matrix [{}][{}] has been generated successfully.", matrix.length, matrix[0].length);
    }

    @Override
    protected String getInformation() {
        return INFORMATION;
    }

    // time = 46939 ms
    @Override
    protected Integer original() {
        var original = new Original(grid);
        return original.process();
    }

    // time = 14196 ms
    @Override
    protected Integer practice() {
        var practice = new Practice(grid);
        return practice.process();
    }

    // time = 11718 ms
    @Override
    protected Integer solution() {
        var solution = new Solution(grid);
        return solution.process();
    }
}
