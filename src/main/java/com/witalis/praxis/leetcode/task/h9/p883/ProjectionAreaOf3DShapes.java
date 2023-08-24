package com.witalis.praxis.leetcode.task.h9.p883;

import com.witalis.praxis.leetcode.task.LeetCodeTask;
import com.witalis.praxis.leetcode.task.h9.p883.option.*;
import com.witalis.praxis.leetcode.utils.LeetCode;
import com.witalis.praxis.leetcode.utils.TaskDifficulty;
import com.witalis.praxis.leetcode.utils.TaskRevision;

import lombok.extern.slf4j.Slf4j;
import java.util.Arrays;
import java.util.concurrent.ThreadLocalRandom;

import static com.witalis.praxis.leetcode.utils.TaskTag.*;

@Slf4j
@LeetCode(
    id = 883,
    description = "Projection Area of 3D Shapes",
    difficulty = TaskDifficulty.EASY,
    tags = {ARRAY, MATH, GEOMETRY, MATRIX}
)
public class ProjectionAreaOf3DShapes extends LeetCodeTask<Integer> {
    public static final int LEN = 50;
    public static final int VALUE = 50;

    private int[][] grid;

    public static final String INFORMATION = """

        Description:
            You are given an n x n grid where we place some 1 x 1 x 1 cubes that are axis-aligned with the x, y, and z axes.

            Each value v = grid[i][j] represents a tower of v cubes placed on top of the cell (i, j).

            We view the projection of these cubes onto the xy, yz, and zx planes.

            A projection is like a shadow, that maps our 3-dimensional figure to a 2-dimensional plane.
                We are viewing the "shadow" when looking at the cubes from the top, the front, and the side.

            Return the total area of all three projections.

        Example:
            Input: grid = [[1,2],[3,4]]
            Output: 17
            Explanation: Here are the three projections ("shadows") of the shape made with each axis-aligned plane.""";

    public ProjectionAreaOf3DShapes(int id, String description, TaskRevision revision) {
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

    // time = 642 ms
    @Override
    protected Integer original() {
        var original = new Original(grid);
        return original.process();
    }

    // time = 598 ms
    @Override
    protected Integer practice() {
        var practice = new Practice(grid);
        return practice.process();
    }

    // time = 595 ms
    @Override
    protected Integer solution() {
        var solution = new Solution(grid);
        return solution.process();
    }
}
