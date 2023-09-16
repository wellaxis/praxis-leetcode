package com.witalis.praxis.leetcode.task.h17.p1631;

import com.witalis.praxis.leetcode.task.LeetCodeTask;
import com.witalis.praxis.leetcode.task.h17.p1631.option.*;
import com.witalis.praxis.leetcode.utils.LeetCode;
import com.witalis.praxis.leetcode.utils.TaskDifficulty;
import com.witalis.praxis.leetcode.utils.TaskRevision;

import lombok.extern.slf4j.Slf4j;
import java.util.Arrays;
import java.util.concurrent.ThreadLocalRandom;

import static com.witalis.praxis.leetcode.utils.TaskTag.*;

@Slf4j
@LeetCode(
    id = 1631,
    description = "Path With Minimum Effort",
    difficulty = TaskDifficulty.MEDIUM,
    tags = {ARRAY, BINARY_SEARCH, DEPTH_FIRST_SEARCH, BREADTH_FIRST_SEARCH, UNION_FIND, HEAP, MATRIX}
)
public class PathWithMinimumEffort extends LeetCodeTask<Integer> {
    public static final int LEN = 100;
    public static final int VALUE = 1_000_000;

    private int[][] heights;

    public static final String INFORMATION = """

        Description:
            You are a hiker preparing for an upcoming hike. You are given heights, a 2D array of size rows x columns,
                where heights[row][col] represents the height of cell (row, col).
                You are situated in the top-left cell, (0, 0), and you hope to travel to the bottom-right cell,
                (rows-1, columns-1) (i.e., 0-indexed). You can move up, down, left, or right,
                and you wish to find a route that requires the minimum effort.

            A route's effort is the maximum absolute difference in heights between two consecutive cells of the route.

            Return the minimum effort required to travel from the top-left cell to the bottom-right cell.

        Example:
            Input: heights = [[1,2,2],[3,8,2],[5,3,5]]
            Output: 2
            Explanation: The route of [1,3,5,3,5] has a maximum absolute difference of 2 in consecutive cells.
                This is better than the route of [1,2,2,2,5], where the maximum absolute difference is 3.""";

    public PathWithMinimumEffort(int id, String description, TaskRevision revision) {
        super(id, description, revision);
        initialization();
    }

    private void initialization() {
        final var random = ThreadLocalRandom.current();

        int rows = random.nextInt(1, LEN + 1);
        int cols = random.nextInt(1, LEN + 1);
        this.heights = new int[rows][cols];
        for (int row = 0; row < rows; row++)
            for (int col = 0; col < cols; col++)
                heights[row][col] = random.nextInt(1, VALUE + 1);

        log.info("Heights [{} x {}]: {}", rows, cols, Arrays.deepToString(heights));
    }

    @Override
    protected String getInformation() {
        return INFORMATION;
    }

    // time = 9663 ms
    @Override
    protected Integer original() {
        var original = new Original(heights);
        return original.process();
    }

    // time = 1667 ms
    @Override
    protected Integer practice() {
        var practice = new Practice(heights);
        return practice.process();
    }

    // time = 3648 ms
    @Override
    protected Integer solution() {
        var solution = new Solution(heights);
        return solution.process();
    }
}
