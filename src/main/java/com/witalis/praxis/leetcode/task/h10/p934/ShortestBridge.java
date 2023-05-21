package com.witalis.praxis.leetcode.task.h10.p934;

import com.witalis.praxis.leetcode.task.LeetCodeTask;
import com.witalis.praxis.leetcode.task.h10.p934.option.*;
import com.witalis.praxis.leetcode.utils.LeetCode;
import com.witalis.praxis.leetcode.utils.TaskDifficulty;
import com.witalis.praxis.leetcode.utils.TaskRevision;

import lombok.extern.slf4j.Slf4j;
import java.util.Arrays;
import java.util.concurrent.ThreadLocalRandom;

import static com.witalis.praxis.leetcode.utils.TaskTag.*;

@Slf4j
@LeetCode(
    id = 934,
    description = "Shortest Bridge",
    difficulty = TaskDifficulty.MEDIUM,
    tags = {ARRAY, DEPTH_FIRST_SEARCH, BREADTH_FIRST_SEARCH, MATRIX}
)
public class ShortestBridge extends LeetCodeTask<Integer> {
    public static final int LEN = 100;

    private int[][] grid;

    public static final String INFORMATION = """

        Description:
            You are given an n x n binary matrix grid where 1 represents land and 0 represents water.

            An island is a 4-directionally connected group of 1's not connected to any other 1's.
                There are exactly two islands in grid.

            You may change 0's to 1's to connect the two islands to form one island.

            Return the smallest number of 0's you must flip to connect the two islands.

        Example:
            Input: grid = [[1,1,1,1,1],[1,0,0,0,1],[1,0,1,0,1],[1,0,0,0,1],[1,1,1,1,1]]
            Output: 1""";

    public ShortestBridge(int id, String description, TaskRevision revision) {
        super(id, description, revision);
        initialization();
    }

    private void initialization() {
        final var random = ThreadLocalRandom.current();

        int n = random.nextInt(1, LEN + 1);

        this.grid = new int[n][n];
        for (int t = 0; t < 2; t++) {
            int x1 = random.nextInt(1, n);
            int x2 = random.nextInt(x1 + 1, n + 1);
            int y1 = random.nextInt(1, n);
            int y2 = random.nextInt(y1 + 1, n + 1);
            for (int x = x1; x <= x2; x++) {
                grid[x][y1] = 1;
                grid[x][y2] = 1;
            }
            for (int y = y1; y <= y2; y++) {
                grid[x1][y] = 1;
                grid[x2][y] = 1;
            }
        }

        var builder = new StringBuilder("\n");
        for (int[] array : grid) {
            builder.append(Arrays.toString(array)).append('\n');
        }

        log.info("Grid[n = {}]:", grid.length);
        printGrid(grid);
    }

    private static void printGrid(int[][] grid) {
        var format = "%" + String.valueOf(6).length() + "d";

        for (int i = 0; i < grid.length; i++) {
            var row = grid[i];
            var builder = new StringBuilder(" | ");
            for (int value : row) {
                builder
                    .append(String.format(format, value))
                    .append(" | ");
            }
            log.info(builder.toString());
        }
        log.info("Grid [{}] has been generated successfully.", grid.length);
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

    // time = 3678 ms
    @Override
    protected Integer original() {
        var original = new Original(cloneMatrix(grid));
        return original.process();
    }

    // time = 2246 ms
    @Override
    protected Integer practice() {
        var practice = new Practice(cloneMatrix(grid));
        return practice.process();
    }

    // time = 1809 ms
    @Override
    protected Integer solution() {
        var solution = new Solution(cloneMatrix(grid));
        return solution.process();
    }
}
