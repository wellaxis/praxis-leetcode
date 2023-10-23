package com.witalis.praxis.leetcode.task.h11.p1030;

import com.witalis.praxis.leetcode.task.LeetCodeTask;
import com.witalis.praxis.leetcode.task.h11.p1030.option.*;
import com.witalis.praxis.leetcode.utils.LeetCode;
import com.witalis.praxis.leetcode.utils.TaskDifficulty;
import com.witalis.praxis.leetcode.utils.TaskRevision;

import lombok.extern.slf4j.Slf4j;
import java.util.concurrent.ThreadLocalRandom;

import static com.witalis.praxis.leetcode.utils.TaskTag.*;

@Slf4j
@LeetCode(
    id = 1030,
    description = "Matrix Cells in Distance Order",
    difficulty = TaskDifficulty.EASY,
    tags = {ARRAY, MATH, GEOMETRY, SORTING, MATRIX}
)
public class MatrixCellsInDistanceOrder extends LeetCodeTask<int[][]> {
    public static final int LEN = 100;

    private int rows;
    private int cols;
    private int centerRow;
    private int centerCol;

    public static final String INFORMATION = """

        Description:
            You are given four integers row, cols, rCenter, and cCenter.
                There is a rows x cols matrix and you are on the cell with the coordinates (rCenter, cCenter).

            Return the coordinates of all cells in the matrix, sorted by their distance from (rCenter, cCenter)
                from the smallest distance to the largest distance. You may return the answer in any order that satisfies this condition.

            The distance between two cells (r1, c1) and (r2, c2) is |r1 - r2| + |c1 - c2|.

        Example:
            Input: rows = 2, cols = 2, rCenter = 0, cCenter = 1
            Output: [[0,1],[0,0],[1,1],[1,0]]
            Explanation: The distances from (0, 1) to other cells are: [0,1,1,2]
                The answer [[0,1],[1,1],[0,0],[1,0]] would also be accepted as correct.""";

    public MatrixCellsInDistanceOrder(int id, String description, TaskRevision revision) {
        super(id, description, revision);
        initialization();
    }

    private void initialization() {
        final var random = ThreadLocalRandom.current();

        this.rows = random.nextInt(1, LEN + 1);
        this.cols = random.nextInt(1, LEN + 1);
        this.centerRow = random.nextInt(0, rows);
        this.centerCol = random.nextInt(0, cols);

        log.info("Rows: {}", rows);
        log.info("Cols: {}", cols);
        log.info("Center: [{}, {}]", centerRow, centerCol);
    }

    @Override
    protected String getInformation() {
        return INFORMATION;
    }

    // time = 1684 ms
    @Override
    protected int[][] original() {
        var original = new Original(rows, cols, centerRow, centerCol);
        return original.process();
    }

    // time = 1108 ms
    @Override
    protected int[][] practice() {
        var practice = new Practice(rows, cols, centerRow, centerCol);
        return practice.process();
    }

    // time = 813 ms
    @Override
    protected int[][] solution() {
        var solution = new Solution(rows, cols, centerRow, centerCol);
        return solution.process();
    }
}
