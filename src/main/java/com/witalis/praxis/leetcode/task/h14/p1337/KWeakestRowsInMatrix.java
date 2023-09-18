package com.witalis.praxis.leetcode.task.h14.p1337;

import com.witalis.praxis.leetcode.task.LeetCodeTask;
import com.witalis.praxis.leetcode.task.h14.p1337.option.*;
import com.witalis.praxis.leetcode.utils.LeetCode;
import com.witalis.praxis.leetcode.utils.TaskDifficulty;
import com.witalis.praxis.leetcode.utils.TaskRevision;

import lombok.extern.slf4j.Slf4j;
import java.util.concurrent.ThreadLocalRandom;

import static com.witalis.praxis.leetcode.utils.TaskTag.*;

@Slf4j
@LeetCode(
    id = 1337,
    description = "The K Weakest Rows in a Matrix",
    difficulty = TaskDifficulty.EASY,
    tags = {ARRAY, BINARY_SEARCH, SORTING, HEAP, MATRIX}
)
public class KWeakestRowsInMatrix extends LeetCodeTask<int[]> {
    public static final int LEN = 100;

    private int[][] matrix;
    private int quantity;

    public static final String INFORMATION = """

        Description:
            You are given an m x n binary matrix mat of 1's (representing soldiers) and 0's (representing civilians).
                The soldiers are positioned in front of the civilians.
                That is, all the 1's will appear to the left of all the 0's in each row.

            A row i is weaker than a row j if one of the following is true:
                * The number of soldiers in row i is less than the number of soldiers in row j.
                * Both rows have the same number of soldiers and i < j.

            Return the indices of the k weakest rows in the matrix ordered from weakest to strongest.

        Example:
            Input: mat =
                [[1,1,0,0,0],
                 [1,1,1,1,0],
                 [1,0,0,0,0],
                 [1,1,0,0,0],
                 [1,1,1,1,1]],
                k = 3
            Output: [2,0,3]
            Explanation:
                The number of soldiers in each row is:
                    - Row 0: 2
                    - Row 1: 4
                    - Row 2: 1
                    - Row 3: 2
                    - Row 4: 5
                The rows ordered from weakest to strongest are [2,0,3,1,4].""";

    public KWeakestRowsInMatrix(int id, String description, TaskRevision revision) {
        super(id, description, revision);
        initialization();
    }

    private void initialization() {
        final var random = ThreadLocalRandom.current();

        int rows = random.nextInt(2, LEN + 1);
        int cols = random.nextInt(2, LEN + 1);
        this.matrix = new int[rows][cols];
        for (int row = 0; row < rows; row++) {
            int soldiers = random.nextInt(1, cols + 1);
            for (int col = 0; col < soldiers; col++) {
                matrix[row][col] = 1;
            }
        }
        this.quantity = random.nextInt(1, rows + 1);

        log.info("Matrix:");
        printMatrix(matrix);
        log.info("Weakest rows k: {}", quantity);
    }

    private static void printMatrix(int[][] matrix) {
        var format = "%1d";

        log.info("-".repeat(4 * matrix[0].length + 1));
        for (int[] row : matrix) {
            var builder = new StringBuilder("| ");
            for (int value : row) {
                builder
                    .append(String.format(format, value))
                    .append(" | ");
            }
            log.info(builder.toString());
            log.info("-".repeat(4 * matrix[0].length + 1));
        }
        log.info("Matrix [{}][{}] has been generated successfully.", matrix.length, matrix[0].length);
    }

    private int[][] cloneMatrix(int[][] matrix) {
        int[][] clone = new int[matrix.length][];
        for (int i = 0; i < matrix.length; i++)
            clone[i] = matrix[i].clone();
        return clone;
    }

    @Override
    protected String getInformation() {
        return INFORMATION;
    }

    // time = 1597 ms
    @Override
    protected int[] original() {
        var original = new Original(cloneMatrix(matrix), quantity);
        return original.process();
    }

    // time = 1165 ms
    @Override
    protected int[] practice() {
        var practice = new Practice(cloneMatrix(matrix), quantity);
        return practice.process();
    }

    // time = 684 ms
    @Override
    protected int[] solution() {
        var solution = new Solution(cloneMatrix(matrix), quantity);
        return solution.process();
    }
}
