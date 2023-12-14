package com.witalis.praxis.leetcode.task.h16.p1582;

import com.witalis.praxis.leetcode.task.LeetCodeTask;
import com.witalis.praxis.leetcode.task.h16.p1582.option.*;
import com.witalis.praxis.leetcode.utils.LeetCode;
import com.witalis.praxis.leetcode.utils.TaskDifficulty;
import com.witalis.praxis.leetcode.utils.TaskRevision;

import lombok.extern.slf4j.Slf4j;
import java.util.Arrays;
import java.util.concurrent.ThreadLocalRandom;

import static com.witalis.praxis.leetcode.utils.TaskTag.*;

@Slf4j
@LeetCode(
    id = 1582,
    description = "Special Positions in a Binary Matrix",
    difficulty = TaskDifficulty.EASY,
    tags = {ARRAY, MATRIX}
)
public class SpecialPositionsInBinaryMatrix extends LeetCodeTask<Integer> {
    public static final int LEN = 1_000;

    private int[][] matrix;

    public static final String INFORMATION = """

        Description:
            Given an m x n binary matrix mat, return the number of special positions in mat.

            A position (i, j) is called special if mat[i][j] == 1 and
                all other elements in row i and column j are 0 (rows and columns are 0-indexed).

        Example:
            Input: mat = [[1,0,0],[0,1,0],[0,0,1]]
            Output: 3
            Explanation: (0, 0), (1, 1) and (2, 2) are special positions.""";

    public SpecialPositionsInBinaryMatrix(int id, String description, TaskRevision revision) {
        super(id, description, revision);
        initialization();
    }

    private void initialization() {
        final var random = ThreadLocalRandom.current();

        int rows = random.nextInt(1, LEN + 1);
        int cols = random.nextInt(1, LEN + 1);
        this.matrix = new int[rows][cols];
        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < cols; col++) {
                matrix[row][col] = random.nextInt(0, 100) == 0 ? 1 : 0;
            }
        }

        log.info("Matrix [{}][{}]: {}", rows, cols, Arrays.deepToString(matrix));
    }

    @Override
    protected String getInformation() {
        return INFORMATION;
    }

    // time = 1982 ms
    @Override
    protected Integer original() {
        var original = new Original(matrix);
        return original.process();
    }

    // time = 1827 ms
    @Override
    protected Integer practice() {
        var practice = new Practice(matrix);
        return practice.process();
    }

    // time = 1305 ms
    @Override
    protected Integer solution() {
        var solution = new Solution(matrix);
        return solution.process();
    }
}
