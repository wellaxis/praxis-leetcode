package com.witalis.praxis.leetcode.task.h12.p1162;

import com.witalis.praxis.leetcode.task.LeetCodeTask;
import com.witalis.praxis.leetcode.task.h12.p1162.option.*;
import com.witalis.praxis.leetcode.utils.LeetCode;
import com.witalis.praxis.leetcode.utils.TaskDifficulty;
import com.witalis.praxis.leetcode.utils.TaskRevision;

import lombok.extern.slf4j.Slf4j;
import java.util.Arrays;
import java.util.concurrent.ThreadLocalRandom;

import static com.witalis.praxis.leetcode.utils.TaskTag.*;

@Slf4j
@LeetCode(
    id = 1162,
    description = "As Far from Land as Possible",
    difficulty = TaskDifficulty.MEDIUM,
    tags = {ARRAY, DYNAMIC_PROGRAMMING, BREADTH_FIRST_SEARCH, MATRIX}
)
public class AsFarFromLandAsPossible extends LeetCodeTask<Integer> {
    public static final int LEN = 100;

    private int[][] grid;

    public static final String INFORMATION = """

        Description:
            Given an n x n grid containing only values 0 and 1, where 0 represents water and 1 represents land,
                find a water cell such that its distance to the nearest land cell is maximized, and return the distance.
                If no land or water exists in the grid, return -1.

            The distance used in this problem is the Manhattan distance:
                the distance between two cells (x0, y0) and (x1, y1) is |x0 - x1| + |y0 - y1|.

        Example:
            Input: grid = [[1,0,1],[0,0,0],[1,0,1]]
            Output: 2
            Explanation: The cell (1, 1) is as far as possible from all the land with distance 2.""";

    public AsFarFromLandAsPossible(int id, String description, TaskRevision revision) {
        super(id, description, revision);
        initialization();
    }

    private void initialization() {
        final var random = ThreadLocalRandom.current();

        int n = random.nextInt(1, LEN + 1);

        this.grid = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                grid[i][j] = random.nextInt(0, 4) == 0 ? 1 : 0;
            }
        }

        var builder = new StringBuilder("\n");
        for (int[] array : grid) {
            builder.append(Arrays.toString(array)).append('\n');
        }

        log.info("Grid [{} x {}] is {}", n, n, builder);
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

    // time = 12165 ms
    @Override
    protected Integer original() {
        var original = new Original(cloneMatrix(grid));
        return original.process();
    }

    // time = 8986 ms
    @Override
    protected Integer practice() {
        var practice = new Practice(cloneMatrix(grid));
        return practice.process();
    }

    // time = 4325 ms
    @Override
    protected Integer solution() {
        var solution = new Solution(cloneMatrix(grid));
        return solution.process();
    }
}
