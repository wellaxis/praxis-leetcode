package com.witalis.praxis.leetcode.task.h1.p63;

import com.witalis.praxis.leetcode.task.LeetCodeTask;
import com.witalis.praxis.leetcode.task.h1.p63.option.*;
import com.witalis.praxis.leetcode.utils.LeetCode;
import com.witalis.praxis.leetcode.utils.TaskDifficulty;
import com.witalis.praxis.leetcode.utils.TaskRevision;

import lombok.extern.slf4j.Slf4j;
import java.util.Arrays;
import java.util.concurrent.ThreadLocalRandom;

import static com.witalis.praxis.leetcode.utils.TaskTag.*;

@Slf4j
@LeetCode(
    id = 63,
    description = "Unique Paths II",
    difficulty = TaskDifficulty.MEDIUM,
    tags = {ARRAY, DYNAMIC_PROGRAMMING, MATRIX}
)
public class UniquePathsII extends LeetCodeTask<Integer> {
    public static final int LEN = 100;
    private int[][] obstacleGrid;

    public static final String INFORMATION = """

            A robot is located at the top-left corner
                of a m x n grid (marked 'Start' in the diagram below).

            The robot can only move either down or right at any point in time.
                The robot is trying to reach the bottom-right corner
                of the grid (marked 'Finish' in the diagram below).

            Now consider if some obstacles are added to the grids.
                How many unique paths would there be?

            An obstacle and space is marked as 1 and 0 respectively in the grid.

            Example:
                Input: obstacleGrid = [[0,0,0],[0,1,0],[0,0,0]]
                Output: 2
                Explanation: There is one obstacle in the middle of the 3x3 grid above.
                    There are two ways to reach the bottom-right corner:
                    1. Right -> Right -> Down -> Down
                    2. Down -> Down -> Right -> Right""";

    public UniquePathsII(int id, String description, TaskRevision revision) {
        super(id, description, revision);
        initialization();
    }

    private void initialization() {
        var random = ThreadLocalRandom.current();
        int m = random.nextInt(1, LEN + 1);
        int n = random.nextInt(1, LEN + 1);
        int t = random.nextInt(1, LEN / 2);

        this.obstacleGrid = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                obstacleGrid[i][j] = random.nextInt(1, LEN) < t ? 1 : 0;
            }
        }

        var builder = new StringBuilder("\n");
        for (int[] array : obstacleGrid) {
            builder.append(Arrays.toString(array)).append('\n');
        }

        log.info("Obstacle grid [{} x {}] is {}", m, n, builder);
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

    // time = 948 ms
    @Override
    protected Integer original() {
        var original = new Original(cloneMatrix(obstacleGrid));
        return original.process();
    }

    // time = 417 ms
    @Override
    protected Integer practice() {
        var practice = new Practice(cloneMatrix(obstacleGrid));
        return practice.process();
    }

    // time = 362 ms
    @Override
    protected Integer solution() {
        var solution = new Solution(cloneMatrix(obstacleGrid));
        return solution.process();
    }
}
