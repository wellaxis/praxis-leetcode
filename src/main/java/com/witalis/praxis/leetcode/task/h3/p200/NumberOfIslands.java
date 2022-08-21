package com.witalis.praxis.leetcode.task.h3.p200;

import com.witalis.praxis.leetcode.task.LeetCodeTask;
import com.witalis.praxis.leetcode.task.h3.p200.option.*;
import com.witalis.praxis.leetcode.utils.LeetCode;
import com.witalis.praxis.leetcode.utils.TaskDifficulty;
import com.witalis.praxis.leetcode.utils.TaskRevision;

import lombok.extern.slf4j.Slf4j;
import java.util.Arrays;
import java.util.concurrent.ThreadLocalRandom;

import static com.witalis.praxis.leetcode.utils.TaskTag.*;

@Slf4j
@LeetCode(
    id = 200,
    description = "Number of Islands",
    difficulty = TaskDifficulty.MEDIUM,
    tags = {ARRAY, DEPTH_FIRST_SEARCH, BREADTH_FIRST_SEARCH, UNION_FIND, MATRIX}
)
public class NumberOfIslands extends LeetCodeTask<Integer> {
    public static final int LEN = 300;
    private char[][] grid;

    public static final String INFORMATION = """

        Given an m x n 2D binary grid grid which represents a map
            of '1's (land) and '0's (water), return the number of islands.

        An island is surrounded by water and is formed
            by connecting adjacent lands horizontally or vertically.
            You may assume all four edges of the grid are all surrounded by water.

        Example:
            Input: grid = [
              ["1","1","0","0","0"],
              ["1","1","0","0","0"],
              ["0","0","1","0","0"],
              ["0","0","0","1","1"]
            ]
            Output: 3""";

    public NumberOfIslands(int id, String description, TaskRevision revision) {
        super(id, description, revision);
        initialization();
    }

    private void initialization() {
        final var random = ThreadLocalRandom.current();
        int rows = random.nextInt(1, LEN + 1);
        int cols = random.nextInt(1, LEN + 1);

        this.grid = new char[rows][cols];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                grid[i][j] = random.nextBoolean() ? '1' : '0';
            }
        }

        var builder = new StringBuilder("\n");
        for (char[] array : grid) {
            builder.append(Arrays.toString(array)).append('\n');
        }

        log.info("Grid [{} x {}] is {}", rows, cols, builder);
    }

    private static char[][] cloneMatrix(char[][] matrix) {
        if (matrix == null) return new char[0][0];

        return Arrays.stream(matrix)
            .map(char[]::clone)
            .toArray(char[][]::new);
    }

    @Override
    protected String getInformation() {
        return INFORMATION;
    }

    // time = 3239 ms
    @Override
    protected Integer original() {
        var original = new Original(cloneMatrix(grid));
        return original.process();
    }

    // time = 1639 ms
    @Override
    protected Integer practice() {
        var practice = new Practice(cloneMatrix(grid));
        return practice.process();
    }

    // time = 1697 ms
    @Override
    protected Integer solution() {
        var solution = new Solution(cloneMatrix(grid));
        return solution.process();
    }
}
