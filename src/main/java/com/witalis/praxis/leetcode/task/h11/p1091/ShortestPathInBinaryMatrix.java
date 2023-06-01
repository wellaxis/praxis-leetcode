package com.witalis.praxis.leetcode.task.h11.p1091;

import com.witalis.praxis.leetcode.task.LeetCodeTask;
import com.witalis.praxis.leetcode.task.h11.p1091.option.*;
import com.witalis.praxis.leetcode.utils.LeetCode;
import com.witalis.praxis.leetcode.utils.TaskDifficulty;
import com.witalis.praxis.leetcode.utils.TaskRevision;

import lombok.extern.slf4j.Slf4j;

import java.util.Arrays;
import java.util.concurrent.ThreadLocalRandom;

import static com.witalis.praxis.leetcode.utils.TaskTag.*;

@Slf4j
@LeetCode(
    id = 1091,
    description = "Shortest Path in Binary Matrix",
    difficulty = TaskDifficulty.MEDIUM,
    tags = {ARRAY, BREADTH_FIRST_SEARCH, MATRIX}
)
public class ShortestPathInBinaryMatrix extends LeetCodeTask<Integer> {
    public static final int LEN = 100;

    private int[][] grid;

    public static final String INFORMATION = """

        Description:
            Given an n x n array of integers matrix, return the minimum sum of any falling path through matrix.

            A falling path starts at any element in the first row and chooses the element in the next row
                that is either directly below or diagonally left/right.
                Specifically, the next element from position (row, col) will be
                (row + 1, col - 1), (row + 1, col), or (row + 1, col + 1).

        Example:
            Input: matrix = [[2,1,3],[6,5,4],[7,8,9]]
            Output: 13
            Explanation: There are two falling paths with a minimum sum as shown.""";

    public ShortestPathInBinaryMatrix(int id, String description, TaskRevision revision) {
        super(id, description, revision);
        initialization();
    }

    private void initialization() {
        this.grid = generate();

        log.info("Grid[{} x {}]:", grid.length, grid.length);
        printMatrix(grid);
    }

    private int[][] generate() {
        final var random = ThreadLocalRandom.current();

        int size = random.nextInt(1, LEN + 1);
        int[][] generatedMatrix = new int[size][size];
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                generatedMatrix[i][j] = (random.nextInt(0, 3) == 0) ? 1 : 0;
            }
        }
        generatedMatrix[0][0] = 0;
        generatedMatrix[size - 1][size - 1] = 0;

        return generatedMatrix;
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
        log.debug("Matrix [{}][{}] has been generated successfully.", matrix.length, matrix[0].length);
    }

    private static int[][] cloneMatrix(int[][] matrix) {
        if (matrix == null) return new int[0][0];

        return Arrays.stream(matrix)
            .map(int[]::clone)
            .toArray(int[][]::new);
    }

    @Override
    protected String getInformation() {
        return INFORMATION;
    }

    // time = 5849 ms
    @Override
    protected Integer original() {
        var original = new Original(cloneMatrix(grid));
        return original.process();
    }

    // time = 4378 ms
    @Override
    protected Integer practice() {
        var practice = new Practice(cloneMatrix(grid));
        return practice.process();
    }

    // time = 3700 ms
    @Override
    protected Integer solution() {
        var solution = new Solution(cloneMatrix(grid));
        return solution.process();
    }
}
