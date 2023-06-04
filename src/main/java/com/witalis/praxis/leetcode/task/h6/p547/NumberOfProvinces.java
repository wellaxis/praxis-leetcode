package com.witalis.praxis.leetcode.task.h6.p547;

import com.witalis.praxis.leetcode.task.LeetCodeTask;
import com.witalis.praxis.leetcode.task.h6.p547.option.*;
import com.witalis.praxis.leetcode.utils.LeetCode;
import com.witalis.praxis.leetcode.utils.TaskDifficulty;
import com.witalis.praxis.leetcode.utils.TaskRevision;

import lombok.extern.slf4j.Slf4j;
import java.util.*;
import java.util.concurrent.ThreadLocalRandom;

import static com.witalis.praxis.leetcode.utils.TaskTag.*;

@Slf4j
@LeetCode(
    id = 547,
    description = "Number of Provinces",
    difficulty = TaskDifficulty.MEDIUM,
    tags = {DEPTH_FIRST_SEARCH, BREADTH_FIRST_SEARCH, UNION_FIND, GRAPH}
)
public class NumberOfProvinces extends LeetCodeTask<Integer> {
    public static final int LEN = 200;

    private int[][] isConnected;

    public static final String INFORMATION = """

        Description:
            There are n cities. Some of them are connected, while some are not.
                If city a is connected directly with city b, and city b is connected directly with city c,
                then city a is connected indirectly with city c.

            A province is a group of directly or indirectly connected cities and no other cities outside of the group.

            You are given an n x n matrix isConnected where isConnected[i][j] = 1 if the ith city and the jth city
                are directly connected, and isConnected[i][j] = 0 otherwise.

            Return the total number of provinces.

        Example:
            Input: isConnected = [[1,0,0],[0,1,0],[0,0,1]]
            Output: 3""";

    public NumberOfProvinces(int id, String description, TaskRevision revision) {
        super(id, description, revision);
        initialization();
    }

    private void initialization() {
        this.isConnected = generate();

        log.info("Matrix:");
        printMatrix(isConnected);
    }

    private int[][] generate() {
        var random = ThreadLocalRandom.current();

        int len = random.nextInt(1, LEN + 1);

        int[][] generatedMatrix = new int[len][len];
        for (int[] row : generatedMatrix)
            Arrays.fill(row, -1);

        for (int i = 0; i < len; i++) {
            for (int j = 0; j < len; j++) {
                if (generatedMatrix[i][j] != -1) continue;
                if (i == j) {
                    generatedMatrix[i][j] = 1;
                } else {
                    int value = random.nextBoolean() ? 0 : 1;
                    generatedMatrix[i][j] = value;
                    generatedMatrix[j][i] = value;
                }
            }
        }
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
        log.info("Matrix [{}][{}] has been generated successfully.", matrix.length, matrix[0].length);
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

    // time = 1572 ms
    @Override
    protected Integer original() {
        var original = new Original(isConnected);
        return original.process();
    }

    // time = 1240 ms
    @Override
    protected Integer practice() {
        var practice = new Practice(isConnected);
        return practice.process();
    }

    // time = 1079 ms
    @Override
    protected Integer solution() {
        var solution = new Solution(isConnected);
        return solution.process();
    }
}
