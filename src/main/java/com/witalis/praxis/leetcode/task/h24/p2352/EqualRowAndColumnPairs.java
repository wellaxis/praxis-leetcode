package com.witalis.praxis.leetcode.task.h24.p2352;

import com.witalis.praxis.leetcode.task.LeetCodeTask;
import com.witalis.praxis.leetcode.task.h24.p2352.option.*;
import com.witalis.praxis.leetcode.utils.LeetCode;
import com.witalis.praxis.leetcode.utils.TaskDifficulty;
import com.witalis.praxis.leetcode.utils.TaskRevision;

import lombok.extern.slf4j.Slf4j;
import java.util.concurrent.ThreadLocalRandom;

import static com.witalis.praxis.leetcode.utils.TaskTag.*;

@Slf4j
@LeetCode(
    id = 2352,
    description = "Equal Row and Column Pairs",
    difficulty = TaskDifficulty.MEDIUM,
    tags = {ARRAY, HASH_TABLE, MATRIX, SIMULATION}
)
public class EqualRowAndColumnPairs extends LeetCodeTask<Integer> {
    public static final int LEN = 200;
    public static final int VALUE = 1_000;

    private int[][] matrix;

    public static final String INFORMATION = """

        Description:
            Given a 0-indexed n x n integer matrix grid,
                return the number of pairs (ri, cj) such that row ri and column cj are equal.

            A row and column pair is considered equal if they contain
                the same elements in the same order (i.e., an equal array).

        Example:
            Input: grid = [[3,1,2,2],[1,4,4,5],[2,4,2,2],[2,4,2,2]]
            Output: 3
            Explanation: There are 3 equal row and column pairs:
                - (Row 0, Column 0): [3,1,2,2]
                - (Row 2, Column 2): [2,4,2,2]
                - (Row 3, Column 2): [2,4,2,2]""";

    public EqualRowAndColumnPairs(int id, String description, TaskRevision revision) {
        super(id, description, revision);
        initialization();
    }

    private void initialization() {
        final var random = ThreadLocalRandom.current();

        int size = random.nextInt(1, LEN + 1);
        this.matrix = new int[size][size];
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                matrix[i][j] = random.nextInt(1, VALUE);
            }
        }

        log.info("Matrix:");
        printMatrix(matrix);
    }

    private static void printMatrix(int[][] matrix) {
        var format = "%3d";

        log.info("-".repeat(6 * matrix[0].length + 1));
        for (int[] row : matrix) {
            var builder = new StringBuilder("| ");
            for (int value : row) {
                builder
                    .append(String.format(format, value))
                    .append(" | ");
            }
            log.info(builder.toString());
            log.info("-".repeat(6 * matrix[0].length + 1));
        }
        log.info("Matrix [{}][{}] has been generated successfully.", matrix.length, matrix[0].length);
    }

    @Override
    protected String getInformation() {
        return INFORMATION;
    }

    // time = 983 ms
    @Override
    protected Integer original() {
        var original = new Original(matrix);
        return original.process();
    }

    // time = 692 ms
    @Override
    protected Integer practice() {
        var practice = new Practice(matrix);
        return practice.process();
    }

    // time = 466 ms
    @Override
    protected Integer solution() {
        var solution = new Solution(matrix);
        return solution.process();
    }
}
