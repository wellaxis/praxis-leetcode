package com.witalis.praxis.leetcode.task.h10.p980;

import com.witalis.praxis.leetcode.task.LeetCodeTask;
import com.witalis.praxis.leetcode.task.h10.p980.option.*;
import com.witalis.praxis.leetcode.utils.LeetCode;
import com.witalis.praxis.leetcode.utils.TaskDifficulty;
import com.witalis.praxis.leetcode.utils.TaskRevision;

import lombok.extern.slf4j.Slf4j;
import java.util.Arrays;
import java.util.concurrent.ThreadLocalRandom;

import static com.witalis.praxis.leetcode.utils.TaskTag.*;

@Slf4j
@LeetCode(
    id = 980,
    description = "Unique Paths III",
    difficulty = TaskDifficulty.HARD,
    tags = {ARRAY, BACKTRACKING, BIT_MANIPULATION, MATRIX}
)
public class UniquePathsIII extends LeetCodeTask<Integer> {
    public static final int LEN = 10;
    private int[][] grid;

    public static final String INFORMATION = """

        Description:
            You are given an m x n integer array grid where grid[i][j] could be:
                * 1 representing the starting square. There is exactly one starting square.
                * 2 representing the ending square. There is exactly one ending square.
                * 0 representing empty squares we can walk over.
                * -1 representing obstacles that we cannot walk over.

            Return the number of 4-directional walks from the starting square to the ending square,
                that walk over every non-obstacle square exactly once.

        Example:
            Input: grid = [[1,0,0,0],[0,0,0,0],[0,0,2,-1]]
            Output: 2
            Explanation: We have the following two paths:\s
                1. (0,0),(0,1),(0,2),(0,3),(1,3),(1,2),(1,1),(1,0),(2,0),(2,1),(2,2)
                2. (0,0),(1,0),(2,0),(2,1),(1,1),(0,1),(0,2),(0,3),(1,3),(1,2),(2,2)""";

    public UniquePathsIII(int id, String description, TaskRevision revision) {
        super(id, description, revision);
        initialization();
    }

    private void initialization() {
        final var random = ThreadLocalRandom.current();

        int rows = random.nextInt(1, LEN + 1);
        int cols = random.nextInt(1, LEN + 1);

        this.grid = new int[rows][cols];

        int row = random.nextInt(0, rows);
        int col = random.nextInt(0, cols);
        grid[row][col] = 1;
        while (true) {
            row = random.nextInt(0, rows);
            col = random.nextInt(0, cols);
            if (grid[row][col] == 0) {
                grid[row][col] = 2;
                break;
            }
        }

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (grid[i][j] == 0) {
                    grid[i][j] = random.nextInt(0, 5) == 0 ? -1 : 0;
                }
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

    // time = 2117 ms
    @Override
    protected Integer original() {
        var original = new Original(cloneMatrix(grid));
        return original.process();
    }

    // time = 3234 ms
    @Override
    protected Integer practice() {
        var practice = new Practice(cloneMatrix(grid));
        return practice.process();
    }

    // time = 1921 ms
    @Override
    protected Integer solution() {
        var solution = new Solution(cloneMatrix(grid));
        return solution.process();
    }
}
