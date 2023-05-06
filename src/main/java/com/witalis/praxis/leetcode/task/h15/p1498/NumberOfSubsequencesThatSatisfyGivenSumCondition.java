package com.witalis.praxis.leetcode.task.h15.p1498;

import com.witalis.praxis.leetcode.task.LeetCodeTask;
import com.witalis.praxis.leetcode.task.h15.p1498.option.*;
import com.witalis.praxis.leetcode.utils.LeetCode;
import com.witalis.praxis.leetcode.utils.TaskDifficulty;
import com.witalis.praxis.leetcode.utils.TaskRevision;

import lombok.extern.slf4j.Slf4j;
import java.util.Arrays;
import java.util.concurrent.ThreadLocalRandom;

import static com.witalis.praxis.leetcode.utils.TaskTag.*;

@Slf4j
@LeetCode(
    id = 1498,
    description = "Number of Subsequences That Satisfy the Given Sum Condition",
    difficulty = TaskDifficulty.MEDIUM,
    tags = {ARRAY, TWO_POINTERS, BINARY_SEARCH, SORTING}
)
public class NumberOfSubsequencesThatSatisfyGivenSumCondition extends LeetCodeTask<Integer> {
    public static final int LEN = 100_000;
    public static final int VALUE = 1_000_000;

    private int[] numbers;
    private int target;

    public static final String INFORMATION = """

        Description:
            You are given an array of integers nums and an integer target.

            Return the number of non-empty subsequences of nums such that
                the sum of the minimum and maximum element on it is less or equal to target.
                Since the answer may be too large, return it modulo 10^9 + 7.

        Example:
            Input: nums = [3,5,6,7], target = 9
            Output: 4
            Explanation: There are 4 subsequences that satisfy the condition.
                [3] -> Min value + max value <= target (3 + 3 <= 9)
                [3,5] -> (3 + 5 <= 9)
                [3,5,6] -> (3 + 6 <= 9)
                [3,6] -> (3 + 6 <= 9)""";

    public NumberOfSubsequencesThatSatisfyGivenSumCondition(int id, String description, TaskRevision revision) {
        super(id, description, revision);
        initialization();
    }

    private void initialization() {
        final var random = ThreadLocalRandom.current();

        this.numbers = random.ints(
            random.nextInt(1, LEN + 1),
            1,
            VALUE + 1
        ).toArray();
        this.target = random.nextInt(1, VALUE + 1);

        log.info("Numbers: {}", Arrays.toString(numbers));
        log.info("Target: {}", target);
    }

    @Override
    protected String getInformation() {
        return INFORMATION;
    }

    // time = 336345 ms, time limit exceeded
    @Override
    protected Integer original() {
        var original = new Original(numbers.clone(), target);
        return original.process();
    }

    // time = 6475 ms
    @Override
    protected Integer practice() {
        var practice = new Practice(numbers.clone(), target);
        return practice.process();
    }

    // time = 6002 ms
    @Override
    protected Integer solution() {
        var solution = new Solution(numbers.clone(), target);
        return solution.process();
    }
}
