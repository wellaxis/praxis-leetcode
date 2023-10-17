package com.witalis.praxis.leetcode.task.h11.p1001;

import com.witalis.praxis.leetcode.task.LeetCodeTask;
import com.witalis.praxis.leetcode.task.h11.p1001.option.*;
import com.witalis.praxis.leetcode.utils.LeetCode;
import com.witalis.praxis.leetcode.utils.TaskDifficulty;
import com.witalis.praxis.leetcode.utils.TaskRevision;

import lombok.extern.slf4j.Slf4j;
import java.util.Arrays;
import java.util.concurrent.ThreadLocalRandom;

import static com.witalis.praxis.leetcode.utils.TaskTag.*;

@Slf4j
@LeetCode(
    id = 1001,
    description = "Grid Illumination",
    difficulty = TaskDifficulty.HARD,
    tags = {ARRAY, HASH_TABLE}
)
public class GridIllumination extends LeetCodeTask<int[]> {
    public static final int SIZE = 1_000_000_000;
    public static final int LEN = 20_000;

    private int size;
    private int[][] lamps;
    private int[][] queries;

    public static final String INFORMATION = """

        Description:
            There is a 2D grid of size n x n where each cell of this grid has a lamp that is initially turned off.

            You are given a 2D array of lamp positions lamps, where lamps[i] = [rowi, coli] indicates
                that the lamp at grid[rowi][coli] is turned on. Even if the same lamp is listed more than once, it is turned on.

            When a lamp is turned on, it illuminates its cell and all other cells in the same row, column, or diagonal.

            You are also given another 2D array queries, where queries[j] = [rowj, colj].
                For the jth query, determine whether grid[rowj][colj] is illuminated or not.
                After answering the jth query, turn off the lamp at grid[rowj][colj] and its 8 adjacent lamps if they exist.
                A lamp is adjacent if its cell shares either a side or corner with grid[rowj][colj].

            Return an array of integers ans, where ans[j] should be 1 if the cell in the jth query was illuminated,
                or 0 if the lamp was not.

        Example:
            Input: n = 5, lamps = [[0,0],[4,4]], queries = [[1,1],[1,0]]
            Output: [1,0]
            Explanation: We have the initial grid with all lamps turned off.
                In the above picture we see the grid after turning on the lamp at grid[0][0] then turning on the lamp at grid[4][4].
                The 0th query asks if the lamp at grid[1][1] is illuminated or not (the blue square).
                It is illuminated, so set ans[0] = 1. Then, we turn off all lamps in the red square.
                The 1st query asks if the lamp at grid[1][0] is illuminated or not (the blue square).
                It is not illuminated, so set ans[1] = 0. Then, we turn off all lamps in the red rectangle.""";

    public GridIllumination(int id, String description, TaskRevision revision) {
        super(id, description, revision);
        initialization();
    }

    private void initialization() {
        final var random = ThreadLocalRandom.current();

        this.size = random.nextInt(1, SIZE + 1);
        this.lamps = generate(size);
        this.queries = generate(size);

        log.info("Size 'n': {}", size);
        log.info("Lamps: {}", Arrays.deepToString(lamps));
        log.info("Queries: {}", Arrays.deepToString(queries));
    }

    private static int[][] generate(int size) {
        final var random = ThreadLocalRandom.current();

        int len = random.nextInt(0, LEN + 1);

        int[][] grid = new int[len][2];
        for (int i = 0; i < len; i++) {
            grid[i] = new int[] {
                random.nextInt(0, size),
                random.nextInt(0, size)
            };
        }
        return grid;
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

    // time = 28154 ms
    @Override
    protected int[] original() {
        var original = new Original(size, cloneGrid(lamps), cloneGrid(queries));
        return original.process();
    }

    // time = 26959 ms
    @Override
    protected int[] practice() {
        var practice = new Practice(size, cloneGrid(lamps), cloneGrid(queries));
        return practice.process();
    }

    // time = 14186 ms
    @Override
    protected int[] solution() {
        var solution = new Solution(size, cloneGrid(lamps), cloneGrid(queries));
        return solution.process();
    }
}
