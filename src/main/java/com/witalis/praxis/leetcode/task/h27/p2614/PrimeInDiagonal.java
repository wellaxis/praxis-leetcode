package com.witalis.praxis.leetcode.task.h27.p2614;

import com.witalis.praxis.leetcode.task.LeetCodeTask;
import com.witalis.praxis.leetcode.task.h27.p2614.option.*;
import com.witalis.praxis.leetcode.utils.LeetCode;
import com.witalis.praxis.leetcode.utils.TaskDifficulty;
import com.witalis.praxis.leetcode.utils.TaskRevision;

import lombok.extern.slf4j.Slf4j;

import java.util.Arrays;
import java.util.concurrent.ThreadLocalRandom;

import static com.witalis.praxis.leetcode.utils.TaskTag.*;

@Slf4j
@LeetCode(
    id = 2614,
    description = "Prime In Diagonal",
    difficulty = TaskDifficulty.EASY,
    tags = {ARRAY, MATH, MATRIX, NUMBER_THEORY}
)
public class PrimeInDiagonal extends LeetCodeTask<Integer> {
    public static final int LEN = 300;
    public static final int VALUE = 4_000_000;

    private int[][] matrix;

    public static final String INFORMATION = """

        Description:
            You are given a 0-indexed two-dimensional integer array nums.

            Return the largest prime number that lies on at least one of the diagonals of nums.
                In case, no prime is present on any of the diagonals, return 0.

            Note that:
                * An integer is prime if it is greater than 1 and has no positive integer divisors other than 1 and itself.
                * An integer val is on one of the diagonals of nums if there exists an integer i for which nums[i][i] = val
                  or an i for which nums[i][nums.length - i - 1] = val.

        Example:
            Input: nums = [[1,2,3],[5,6,7],[9,10,11]]
            Output: 11
            Explanation: The numbers 1, 3, 6, 9, and 11 are the only numbers present on at least one of the diagonals. Since 11 is the largest prime, we return 11.""";

    public PrimeInDiagonal(int id, String description, TaskRevision revision) {
        super(id, description, revision);
        initialization();
    }

    private void initialization() {
        final var random = ThreadLocalRandom.current();

        int size = random.nextInt(1, LEN + 1);
        this.matrix = new int[size][size];
        for (int i = 0; i < size; i++) {
            matrix[i] = random.ints(size, 1, VALUE + 1).toArray();
        }

        log.info("Matrix [{} x {}]: {}", size, size, Arrays.deepToString(matrix));
    }

    @Override
    protected String getInformation() {
        return INFORMATION;
    }

    // time = 4203 ms
    @Override
    protected Integer original() {
        var original = new Original(matrix);
        return original.process();
    }

    // time = 658 ms
    @Override
    protected Integer practice() {
        var practice = new Practice(matrix);
        return practice.process();
    }

    // time = 628 ms
    @Override
    protected Integer solution() {
        var solution = new Solution(matrix);
        return solution.process();
    }
}
