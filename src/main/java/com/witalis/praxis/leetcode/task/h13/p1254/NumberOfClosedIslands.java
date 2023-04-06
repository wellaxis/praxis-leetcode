package com.witalis.praxis.leetcode.task.h13.p1254;

import com.witalis.praxis.leetcode.task.LeetCodeTask;
import com.witalis.praxis.leetcode.task.h13.p1254.option.*;
import com.witalis.praxis.leetcode.utils.LeetCode;
import com.witalis.praxis.leetcode.utils.TaskDifficulty;
import com.witalis.praxis.leetcode.utils.TaskRevision;

import lombok.extern.slf4j.Slf4j;
import java.util.Arrays;
import java.util.concurrent.ThreadLocalRandom;

import static com.witalis.praxis.leetcode.utils.TaskTag.*;

@Slf4j
@LeetCode(
    id = 1254,
    description = "Number of Closed Islands",
    difficulty = TaskDifficulty.MEDIUM,
    tags = {ARRAY, DEPTH_FIRST_SEARCH, BREADTH_FIRST_SEARCH, UNION_FIND, MATRIX}
)
public class NumberOfClosedIslands extends LeetCodeTask<Integer> {
    public static final int LEN = 100;

    private int[][] grid;

    public static final String INFORMATION = """

        Description:
            Given a 2D grid consists of 0s (land) and 1s (water).
                An island is a maximal 4-directionally connected group of 0s
                and a closed island is an island totally (all left, top, right, bottom) surrounded by 1s.

            Return the number of closed islands.

        Example:
            Input: grid = [[1,1,1,1,1,1,1,0],[1,0,0,0,0,1,1,0],[1,0,1,0,1,1,1,0],[1,0,0,0,0,1,0,1],[1,1,1,1,1,1,1,0]]
            Output: 2
            Explanation: Islands in gray are closed because they are completely surrounded by water (group of 1s).""";

    public NumberOfClosedIslands(int id, String description, TaskRevision revision) {
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

    // time = 1392 ms
    @Override
    protected Integer original() {
        var original = new Original(cloneGrid(grid));
        return original.process();
    }

    // time = 1177 ms
    @Override
    protected Integer practice() {
        var practice = new Practice(cloneGrid(grid));
        return practice.process();
    }

    // time = 817 ms
    @Override
    protected Integer solution() {
        var solution = new Solution(cloneGrid(grid));
        return solution.process();
    }
}
