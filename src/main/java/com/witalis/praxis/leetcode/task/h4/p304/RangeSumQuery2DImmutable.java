package com.witalis.praxis.leetcode.task.h4.p304;

import com.witalis.praxis.leetcode.task.LeetCodeTask;
import com.witalis.praxis.leetcode.task.h4.p304.option.*;
import com.witalis.praxis.leetcode.utils.LeetCode;
import com.witalis.praxis.leetcode.utils.TaskDifficulty;
import com.witalis.praxis.leetcode.utils.TaskRevision;

import lombok.extern.slf4j.Slf4j;
import java.util.AbstractMap;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

import static com.witalis.praxis.leetcode.utils.TaskTag.*;

@Slf4j
@LeetCode(
    id = 304,
    description = "Range Sum Query 2D - Immutable",
    difficulty = TaskDifficulty.MEDIUM,
    tags = {ARRAY, DESIGN, MATRIX, PREFIX_SUM}
)
public class RangeSumQuery2DImmutable extends LeetCodeTask<List<Integer>> {
    public static final int LEN = 200;
    public static final int VALUE = 10_000;
    private int[][] matrix;
    private List<AbstractMap.SimpleEntry<String, int[]>> operations;

    public static final String INFORMATION = """

        Description:
            Given a 2D matrix matrix, handle multiple queries of the following type:
            * Calculate the sum of the elements of matrix inside the rectangle defined by its
              upper left corner (row1, col1) and lower right corner (row2, col2).

            Implement the NumMatrix class:
            * NumMatrix(int[][] matrix) Initializes the object with the integer matrix matrix.
            * int sumRegion(int row1, int col1, int row2, int col2) Returns the sum of the elements of matrix
              inside the rectangle defined by its upper left corner (row1, col1) and lower right corner (row2, col2).

            You must design an algorithm where sumRegion works on O(1) time complexity.

        Example:
            Input:
                ["NumMatrix", "sumRegion", "sumRegion", "sumRegion"]
                [[[[3, 0, 1, 4, 2], [5, 6, 3, 2, 1], [1, 2, 0, 1, 5], [4, 1, 0, 1, 7], [1, 0, 3, 0, 5]]], [2, 1, 4, 3], [1, 1, 2, 2], [1, 2, 2, 4]]
            Output:
                [null, 8, 11, 12]
            Explanation:
                NumMatrix numMatrix = new NumMatrix([[3, 0, 1, 4, 2], [5, 6, 3, 2, 1], [1, 2, 0, 1, 5], [4, 1, 0, 1, 7], [1, 0, 3, 0, 5]]);
                numMatrix.sumRegion(2, 1, 4, 3); // return 8 (i.e sum of the red rectangle)
                numMatrix.sumRegion(1, 1, 2, 2); // return 11 (i.e sum of the green rectangle)
                numMatrix.sumRegion(1, 2, 2, 4); // return 12 (i.e sum of the blue rectangle)""";

    public RangeSumQuery2DImmutable(int id, String description, TaskRevision revision) {
        super(id, description, revision);
        initialization();
    }

    private void initialization() {
        final var random = ThreadLocalRandom.current();

        int rows = random.nextInt(1, LEN + 1);
        int cols = random.nextInt(1, LEN + 1);

        this.matrix = new int[rows][cols];
        for (int row = 0; row < rows; row++)
            for (int col = 0; col < cols; col++)
                matrix[row][col] = random.nextInt(-VALUE, VALUE + 1);

        log.info("Matrix[{} x {}] is:", rows, cols);
        for (int[] row : matrix) {
            log.info("{}", Arrays.toString(row));
        }

        operations = new ArrayList<>();
        List<int[]> regions = new ArrayList<>();
        int size = random.nextInt(1, VALUE + 1);
        for (int i = 0; i < size; i++) {
            int row1 = random.nextInt(0, rows);
            int row2 = random.nextInt(row1, rows);
            int col1 = random.nextInt(0, cols);
            int col2 = random.nextInt(col1, cols);
            int[] region = new int[] {row1, col1, row2, col2};
            regions.add(region);

            operations.add(new AbstractMap.SimpleEntry<>("sumRegion", region));
        }

        log.info("Regions are {}", regions);
    }

    @Override
    protected String getInformation() {
        return INFORMATION;
    }

    // time = 3517 ms
    @Override
    protected List<Integer> original() {
        var original = new Original(operations, matrix);
        return original.process();
    }

    // time = 2394 ms
    @Override
    protected List<Integer> practice() {
        var practice = new Practice(operations, matrix);
        return practice.process();
    }

    // time = 2371 ms
    @Override
    protected List<Integer> solution() {
        var solution = new Solution(operations, matrix);
        return solution.process();
    }
}
