package com.witalis.praxis.leetcode.task.h1.p64;

import com.witalis.praxis.leetcode.task.LeetCodeTask;
import com.witalis.praxis.leetcode.task.h1.p64.option.*;
import com.witalis.praxis.leetcode.utils.LeetCode;
import com.witalis.praxis.leetcode.utils.TaskDifficulty;
import com.witalis.praxis.leetcode.utils.TaskRevision;

import lombok.extern.slf4j.Slf4j;
import java.util.Arrays;
import java.util.concurrent.ThreadLocalRandom;

import static com.witalis.praxis.leetcode.utils.TaskTag.*;

@Slf4j
@LeetCode(
    id = 64,
    description = "Minimum Path Sum",
    difficulty = TaskDifficulty.MEDIUM,
    tags = {ARRAY, DYNAMIC_PROGRAMMING, MATRIX}
)
public class MinimumPathSum extends LeetCodeTask<Integer> {
    public static final int LEN = 200;
    public static final int VALUE = 100;
    private int[][] grid;

    public static final String INFORMATION = """

            Given a m x n grid filled with non-negative numbers,
                find a path from top left to bottom right,
                which minimizes the sum of all numbers along its path.

            Note: You can only move either down or right at any point in time.

            Example:
                Input: grid = [[1,3,1],[1,5,1],[4,2,1]]
                Output: 7
                Explanation: Because the path 1 → 3 → 1 → 1 → 1 minimizes the sum.""";

    public MinimumPathSum(int id, String description, TaskRevision revision) {
        super(id, description, revision);
        initialization();
    }

    private void initialization() {
        var random = ThreadLocalRandom.current();
        int m = random.nextInt(1, LEN + 1);
        int n = random.nextInt(1, LEN + 1);

        this.grid = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                grid[i][j] = random.nextInt(0, VALUE + 1);
            }
        }

        var builder = new StringBuilder("\n");
        for (int[] array : grid) {
            builder.append(Arrays.toString(array)).append('\n');
        }

        log.info("Grid [{} x {}] is {}", m, n, builder);
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

    // time = 913 ms
    @Override
    protected Integer original() {
        var original = new Original(cloneMatrix(grid));
        return original.process();
    }

    // time = 818 ms
    @Override
    protected Integer practice() {
        var practice = new Practice(cloneMatrix(grid));
        return practice.process();
    }

    // time = 756 ms
    @Override
    protected Integer solution() {
        var solution = new Solution(cloneMatrix(grid));
        return solution.process();
    }
}
