package com.witalis.praxis.leetcode.task.h25.p2482;

import com.witalis.praxis.leetcode.task.LeetCodeTask;
import com.witalis.praxis.leetcode.task.h25.p2482.option.*;
import com.witalis.praxis.leetcode.utils.LeetCode;
import com.witalis.praxis.leetcode.utils.TaskDifficulty;
import com.witalis.praxis.leetcode.utils.TaskRevision;

import lombok.extern.slf4j.Slf4j;
import java.util.Arrays;
import java.util.concurrent.ThreadLocalRandom;

import static com.witalis.praxis.leetcode.utils.TaskTag.*;

@Slf4j
@LeetCode(
    id = 2482,
    description = "Difference Between Ones and Zeros in Row and Column",
    difficulty = TaskDifficulty.MEDIUM,
    tags = {ARRAY, MATRIX, SIMULATION}
)
public class DifferenceBetweenOnesAndZerosInRowAndColumn extends LeetCodeTask<int[][]> {
    public static final int LEN = 1_000;

    private int[][] matrix;

    public static final String INFORMATION = """

        Description:
            Given a 0-indexed n x n integer matrix grid,
                return the number of pairs (ri, cj) such that row ri and column cj are equal.

            A row and column pair is considered equal if they contain
                the same elements in the same order (i.e., an equal array).

        Example:
            Input: grid = [[1,1,1],[1,1,1]]
            Output: [[5,5,5],[5,5,5]]
            Explanation:
                - diff[0][0] = onesRow0 + onesCol0 - zerosRow0 - zerosCol0 = 3 + 2 - 0 - 0 = 5
                - diff[0][1] = onesRow0 + onesCol1 - zerosRow0 - zerosCol1 = 3 + 2 - 0 - 0 = 5
                - diff[0][2] = onesRow0 + onesCol2 - zerosRow0 - zerosCol2 = 3 + 2 - 0 - 0 = 5
                - diff[1][0] = onesRow1 + onesCol0 - zerosRow1 - zerosCol0 = 3 + 2 - 0 - 0 = 5
                - diff[1][1] = onesRow1 + onesCol1 - zerosRow1 - zerosCol1 = 3 + 2 - 0 - 0 = 5
                - diff[1][2] = onesRow1 + onesCol2 - zerosRow1 - zerosCol2 = 3 + 2 - 0 - 0 = 5""";

    public DifferenceBetweenOnesAndZerosInRowAndColumn(int id, String description, TaskRevision revision) {
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
                matrix[row][col] = random.nextBoolean() ? 1 : 0;
            }
        }

        log.info("Matrix [{}][{}]: {}", rows, cols, Arrays.deepToString(matrix));
    }

    @Override
    protected String getInformation() {
        return INFORMATION;
    }

    // time = 4969 ms
    @Override
    protected int[][] original() {
        var original = new Original(matrix);
        return original.process();
    }

    // time = 5045 ms
    @Override
    protected int[][] practice() {
        var practice = new Practice(matrix);
        return practice.process();
    }

    // time = 4412 ms
    @Override
    protected int[][] solution() {
        var solution = new Solution(matrix);
        return solution.process();
    }
}
