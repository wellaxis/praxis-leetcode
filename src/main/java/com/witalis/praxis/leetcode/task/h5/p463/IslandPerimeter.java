package com.witalis.praxis.leetcode.task.h5.p463;

import com.witalis.praxis.leetcode.task.LeetCodeTask;
import com.witalis.praxis.leetcode.task.h5.p463.option.*;
import com.witalis.praxis.leetcode.utils.LeetCode;
import com.witalis.praxis.leetcode.utils.TaskDifficulty;
import com.witalis.praxis.leetcode.utils.TaskRevision;

import lombok.extern.slf4j.Slf4j;
import java.util.Arrays;
import java.util.concurrent.ThreadLocalRandom;

import static com.witalis.praxis.leetcode.utils.TaskTag.*;

@Slf4j
@LeetCode(
    id = 463,
    description = "Island Perimeter",
    difficulty = TaskDifficulty.EASY,
    tags = {ARRAY, DEPTH_FIRST_SEARCH, BREADTH_FIRST_SEARCH, MATRIX}
)
public class IslandPerimeter extends LeetCodeTask<Integer> {
    public static final int LEN = 100;
    private int[][] grid;

    public static final String INFORMATION = """

        You are given row x col grid representing a map
            where grid[i][j] = 1 represents land and grid[i][j] = 0 represents water.

        Grid cells are connected horizontally/vertically (not diagonally).
            The grid is completely surrounded by water, and there is exactly one island
            (i.e., one or more connected land cells).

        The island doesn't have "lakes", meaning the water inside isn't connected to the water around the island.
            One cell is a square with side length 1. The grid is rectangular, width and height don't exceed 100.
            Determine the perimeter of the island.

        Example:
            Input: grid = [[0,1,0,0],[1,1,1,0],[0,1,0,0],[1,1,0,0]]
            Output: 16
            Explanation: The perimeter is the 16 yellow stripes in the image above.""";

    public IslandPerimeter(int id, String description, TaskRevision revision) {
        super(id, description, revision);
        initialization();
    }

    private void initialization() {
        final var random = ThreadLocalRandom.current();
        int rows = random.nextInt(1, LEN + 1);
        int cols = random.nextInt(1, LEN + 1);

        this.grid = new int[rows][cols];
        int center = cols / 2;
        for (int i = 0; i < rows; i++) {
            int fill = random.nextInt(1, center);
            for (int j = center - fill; j <= center + fill; j++) {
                grid[i][j] = 1;
            }
        }

        var builder = new StringBuilder("\n");
        for (int[] array : grid) {
            builder.append(Arrays.toString(array)).append('\n');
        }

        log.info("Grid [{} x {}] is {}", rows, cols, builder);
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

    // time = 679 ms
    @Override
    protected Integer original() {
        var original = new Original(grid);
        return original.process();
    }

    // time = 528 ms
    @Override
    protected Integer practice() {
        var practice = new Practice(grid);
        return practice.process();
    }

    // time = 472 ms
    @Override
    protected Integer solution() {
        var solution = new Solution(grid);
        return solution.process();
    }
}
