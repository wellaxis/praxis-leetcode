package com.witalis.praxis.leetcode.task.h9.p892;

import com.witalis.praxis.leetcode.task.LeetCodeTask;
import com.witalis.praxis.leetcode.task.h9.p892.option.*;
import com.witalis.praxis.leetcode.utils.LeetCode;
import com.witalis.praxis.leetcode.utils.TaskDifficulty;
import com.witalis.praxis.leetcode.utils.TaskRevision;

import lombok.extern.slf4j.Slf4j;
import java.util.Arrays;
import java.util.concurrent.ThreadLocalRandom;

import static com.witalis.praxis.leetcode.utils.TaskTag.*;

@Slf4j
@LeetCode(
    id = 892,
    description = "Surface Area of 3D Shapes",
    difficulty = TaskDifficulty.EASY,
    tags = {ARRAY, MATH, GEOMETRY, MATRIX}
)
public class SurfaceAreaOf3DShapes extends LeetCodeTask<Integer> {
    public static final int LEN = 50;
    public static final int VALUE = 50;

    private int[][] grid;

    public static final String INFORMATION = """

        Description:
            You are given an n x n grid where you have placed some 1 x 1 x 1 cubes.
                Each value v = grid[i][j] represents a tower of v cubes placed on top of cell (i, j).

            After placing these cubes, you have decided to glue any directly adjacent cubes to each other,
                forming several irregular 3D shapes.

            Return the total surface area of the resulting shapes.

            Note: The bottom face of each shape counts toward its surface area.

        Example:
            Input: grid = [[1,2],[3,4]]
            Output: 34""";

    public SurfaceAreaOf3DShapes(int id, String description, TaskRevision revision) {
        super(id, description, revision);
        initialization();
    }

    private void initialization() {
        final var random = ThreadLocalRandom.current();

        int size = random.nextInt(1, LEN + 1);
        this.grid = new int[size][size];
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                grid[i][j] = random.nextInt(0, VALUE + 1);
            }
        }

        log.info("Grid [{} x {}]: {}", size, size, Arrays.deepToString(grid));
    }

    @Override
    protected String getInformation() {
        return INFORMATION;
    }

    // time = 502 ms
    @Override
    protected Integer original() {
        var original = new Original(grid);
        return original.process();
    }

    // time = 500 ms
    @Override
    protected Integer practice() {
        var practice = new Practice(grid);
        return practice.process();
    }

    // time = 456 ms
    @Override
    protected Integer solution() {
        var solution = new Solution(grid);
        return solution.process();
    }
}
