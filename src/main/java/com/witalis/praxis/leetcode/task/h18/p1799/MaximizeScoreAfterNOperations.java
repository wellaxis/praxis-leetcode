package com.witalis.praxis.leetcode.task.h18.p1799;

import com.witalis.praxis.leetcode.task.LeetCodeTask;
import com.witalis.praxis.leetcode.task.h18.p1799.option.*;
import com.witalis.praxis.leetcode.utils.LeetCode;
import com.witalis.praxis.leetcode.utils.TaskDifficulty;
import com.witalis.praxis.leetcode.utils.TaskRevision;

import lombok.extern.slf4j.Slf4j;
import java.util.Arrays;
import java.util.concurrent.ThreadLocalRandom;

import static com.witalis.praxis.leetcode.utils.TaskTag.*;

@Slf4j
@LeetCode(
    id = 1799,
    description = "Maximize Score After N Operations",
    difficulty = TaskDifficulty.HARD,
    tags = {ARRAY, MATH, DYNAMIC_PROGRAMMING, BACKTRACKING, BIT_MANIPULATION, NUMBER_THEORY, BITMASK}
)
public class MaximizeScoreAfterNOperations extends LeetCodeTask<Integer> {
    public static final int LEN = 9;
    public static final int VALUE = 1_000_000;

    private int[] numbers;

    public static final String INFORMATION = """

        Description:
            You are given nums, an array of positive integers of size 2 * n. You must perform n operations on this array.

            In the i^th operation (1-indexed), you will:
                * Choose two elements, x and y.
                * Receive a score of i * gcd(x, y).
                * Remove x and y from nums.

            Return the maximum score you can receive after performing n operations.

            The function gcd(x, y) is the greatest common divisor of x and y.

        Example:
            Input: nums = [1,2,3,4,5,6]
            Output: 14
            Explanation: The optimal choice of operations is:
                (1 * gcd(1, 5)) + (2 * gcd(2, 4)) + (3 * gcd(3, 6)) = 1 + 4 + 9 = 14""";

    public MaximizeScoreAfterNOperations(int id, String description, TaskRevision revision) {
        super(id, description, revision);
        initialization();
    }

    private void initialization() {
        final var random = ThreadLocalRandom.current();

        this.numbers = random.ints(
            random.nextInt(1, 2 * (LEN + 1)),
            1, VALUE + 1
        ).toArray();

        log.info("Numbers: {}", Arrays.toString(numbers));
    }

    @Override
    protected String getInformation() {
        return INFORMATION;
    }

    // time = 619049 ms, time limit exceeded
    @Override
    protected Integer original() {
        var original = new Original(numbers);
        return original.process();
    }

    // time = 6523 ms
    @Override
    protected Integer practice() {
        var practice = new Practice(numbers);
        return practice.process();
    }

    // time = 4770 ms
    @Override
    protected Integer solution() {
        var solution = new Solution(numbers);
        return solution.process();
    }
}
