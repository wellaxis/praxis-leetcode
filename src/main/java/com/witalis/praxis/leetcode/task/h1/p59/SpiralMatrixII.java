package com.witalis.praxis.leetcode.task.h1.p59;

import com.witalis.praxis.leetcode.task.LeetCodeTask;
import com.witalis.praxis.leetcode.task.h1.p59.option.*;
import com.witalis.praxis.leetcode.utils.LeetCode;
import com.witalis.praxis.leetcode.utils.TaskDifficulty;
import com.witalis.praxis.leetcode.utils.TaskRevision;

import lombok.extern.slf4j.Slf4j;
import java.util.concurrent.ThreadLocalRandom;

import static com.witalis.praxis.leetcode.utils.TaskTag.*;

@Slf4j
@LeetCode(
    id = 59,
    description = "Spiral Matrix II",
    difficulty = TaskDifficulty.MEDIUM,
    tags = {ARRAY, MATRIX, SIMULATION}
)
public class SpiralMatrixII extends LeetCodeTask<int[][]> {
    public static final int LEN = 20;

    private int n;

    public static final String INFORMATION = """

        Given a positive integer n, generate an n x n matrix
            filled with elements from 1 to n^2 in spiral order.

        Example:
            Input: n = 3
            Output: [[1,2,3],[8,9,4],[7,6,5]]""";

    public SpiralMatrixII(int id, String description, TaskRevision revision) {
        super(id, description, revision);
        initialization();
    }

    private void initialization() {
        this.n = ThreadLocalRandom.current().nextInt(1, LEN + 1);

        log.info("Number is {}", n);
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

    // time = 460 ms
    @Override
    protected int[][] original() {
        var original = new Original(n);
        return original.process();
    }

    // time = 512 ms
    @Override
    protected int[][] practice() {
        var practice = new Practice(n);
        return practice.process();
    }

    // time = 358 ms
    @Override
    protected int[][] solution() {
        var solution = new Solution(n);
        return solution.process();
    }
}
