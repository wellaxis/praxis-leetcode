package com.witalis.praxis.leetcode.task.h13.p1252;

import com.witalis.praxis.leetcode.task.LeetCodeTask;
import com.witalis.praxis.leetcode.task.h13.p1252.option.*;
import com.witalis.praxis.leetcode.utils.LeetCode;
import com.witalis.praxis.leetcode.utils.TaskDifficulty;
import com.witalis.praxis.leetcode.utils.TaskRevision;

import lombok.extern.slf4j.Slf4j;
import java.util.Arrays;
import java.util.concurrent.ThreadLocalRandom;

import static com.witalis.praxis.leetcode.utils.TaskTag.*;

@Slf4j
@LeetCode(
    id = 1252,
    description = "Cells with Odd Values in a Matrix",
    difficulty = TaskDifficulty.EASY,
    tags = {ARRAY, MATH, SIMULATION}
)
public class CellsWithOddValuesInMatrix extends LeetCodeTask<Integer> {
    public static final int SIZE = 50;
    public static final int LEN = 100;

    private int rows;
    private int cols;
    private int[][] indices;

    public static final String INFORMATION = """

        Description:
            There is an m x n matrix that is initialized to all 0's.
                There is also a 2D array indices where each indices[i] = [ri, ci] represents
                a 0-indexed location to perform some increment operations on the matrix.

            For each location indices[i], do both of the following:
                1. Increment all the cells on row ri.
                2. Increment all the cells on column ci.

            Given m, n, and indices, return the number of odd-valued cells in the matrix
                after applying the increment to all locations in indices.

        Example:
            Input: m = 2, n = 3, indices = [[0,1],[1,1]]
            Output: 6
            Explanation: Initial matrix = [[0,0,0],[0,0,0]].
                After applying first increment it becomes [[1,2,1],[0,1,0]].
                The final matrix is [[1,3,1],[1,3,1]], which contains 6 odd numbers.""";

    public CellsWithOddValuesInMatrix(int id, String description, TaskRevision revision) {
        super(id, description, revision);
        initialization();
    }

    private void initialization() {
        final var random = ThreadLocalRandom.current();

        this.rows = random.nextInt(1, SIZE + 1);
        this.cols = random.nextInt(1, SIZE + 1);

        int len = random.nextInt(1, LEN + 1);
        this.indices = new int[len][2];
        for (int i = 0; i < len; i++) {
            int row = random.nextInt(0, rows);
            int col = random.nextInt(0, cols);
            indices[i] = new int[] {row, col};
        }

        log.info("Rows 'm': {}", rows);
        log.info("Cols 'n': {}", cols);
        log.info("Indices: {}", Arrays.deepToString(indices));
    }

    @Override
    protected String getInformation() {
        return INFORMATION;
    }

    // time = 693 ms
    @Override
    protected Integer original() {
        var original = new Original(rows, cols, indices);
        return original.process();
    }

    // time = 685 ms
    @Override
    protected Integer practice() {
        var practice = new Practice(rows, cols, indices);
        return practice.process();
    }

    // time = 606 ms
    @Override
    protected Integer solution() {
        var solution = new Solution(rows, cols, indices);
        return solution.process();
    }
}
