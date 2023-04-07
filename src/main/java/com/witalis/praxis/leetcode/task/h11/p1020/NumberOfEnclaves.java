package com.witalis.praxis.leetcode.task.h11.p1020;

import com.witalis.praxis.leetcode.task.LeetCodeTask;
import com.witalis.praxis.leetcode.task.h11.p1020.option.*;
import com.witalis.praxis.leetcode.utils.LeetCode;
import com.witalis.praxis.leetcode.utils.TaskDifficulty;
import com.witalis.praxis.leetcode.utils.TaskRevision;

import lombok.extern.slf4j.Slf4j;
import java.util.Arrays;
import java.util.concurrent.ThreadLocalRandom;

import static com.witalis.praxis.leetcode.utils.TaskTag.*;

@Slf4j
@LeetCode(
    id = 1020,
    description = "Number of Enclaves",
    difficulty = TaskDifficulty.MEDIUM,
    tags = {ARRAY, DEPTH_FIRST_SEARCH, BREADTH_FIRST_SEARCH, UNION_FIND, MATRIX}
)
public class NumberOfEnclaves extends LeetCodeTask<Integer> {
    public static final int LEN = 500;

    private int[][] grid;

    public static final String INFORMATION = """

        Description:
            You are given an m x n binary matrix grid, where 0 represents a sea cell and 1 represents a land cell.

            A move consists of walking from one land cell to another adjacent (4-directionally) land cell or walking off the boundary of the grid.

            Return the number of land cells in grid for which we cannot walk off the boundary of the grid in any number of moves.

        Example:
            Input: grid = [[0,0,0,0],[1,0,1,0],[0,1,1,0],[0,0,0,0]]
            Output: 3
            Explanation: There are three 1s that are enclosed by 0s, and one 1 that is not enclosed because its on the boundary.""";

    public NumberOfEnclaves(int id, String description, TaskRevision revision) {
        super(id, description, revision);
        initialization();
    }

    private void initialization() {
        this.grid = generate();

        log.info("Grid:");
        printGrid(grid);
    }

    private static int[][] generate() {
        var random = ThreadLocalRandom.current();

        int height = random.nextInt(1, LEN + 1);
        int width = random.nextInt(1, LEN + 1);

        int[][] binaryGrid = new int[height][width];
        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                binaryGrid[i][j] = random.nextBoolean() ? 1 : 0;
            }
        }
        return binaryGrid;
    }

    private static void printGrid(int[][] matrix) {
        log.info("-".repeat(4 * matrix[0].length + 1));
        for (int[] row : matrix) {
            var builder = new StringBuilder("| ");
            for (int value : row) {
                builder
                    .append(value)
                    .append(" | ");
            }
            log.info(builder.toString());
            log.info("-".repeat(4 * matrix[0].length + 1));
        }
        log.info("Grid [{}][{}] has been generated successfully.", matrix.length, matrix[0].length);
    }

    private static int[][] cloneGrid(int[][] grid) {
        if (grid == null) return new int[0][0];

        return Arrays.stream(grid)
            .map(int[]::clone)
            .toArray(int[][]::new);
    }

    @Override
    protected String getInformation() {
        return INFORMATION;
    }

    // time = 6586 ms
    @Override
    protected Integer original() {
        var original = new Original(cloneGrid(grid));
        return original.process();
    }

    // time = 5122 ms
    @Override
    protected Integer practice() {
        var practice = new Practice(cloneGrid(grid));
        return practice.process();
    }

    // time = 4272 ms
    @Override
    protected Integer solution() {
        var solution = new Solution(cloneGrid(grid));
        return solution.process();
    }
}
