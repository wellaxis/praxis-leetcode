package com.witalis.praxis.leetcode.task.h29.p2815;

import com.witalis.praxis.leetcode.task.LeetCodeTask;
import com.witalis.praxis.leetcode.task.h29.p2815.option.Original;
import com.witalis.praxis.leetcode.task.h29.p2815.option.Practice;
import com.witalis.praxis.leetcode.task.h29.p2815.option.Solution;
import com.witalis.praxis.leetcode.utils.LeetCode;
import com.witalis.praxis.leetcode.utils.TaskDifficulty;
import com.witalis.praxis.leetcode.utils.TaskRevision;

import lombok.extern.slf4j.Slf4j;
import java.util.Arrays;
import java.util.concurrent.ThreadLocalRandom;

import static com.witalis.praxis.leetcode.utils.TaskTag.*;

@Slf4j
@LeetCode(
    id = 2815,
    description = "Max Pair Sum in an Array",
    difficulty = TaskDifficulty.EASY,
    tags = {ARRAY, BINARY_SEARCH, GREEDY}
)
public class MaxPairSumInArray extends LeetCodeTask<Integer> {
    public static final int LEN = 100;
    public static final int VALUE = 10_000;

    private int[] numbers;

    public static final String INFORMATION = """

        Description:
            You are given a 0-indexed integer array nums. You have to find the maximum sum of a pair of numbers
               from nums such that the maximum digit in both numbers are equal.

            Return the maximum sum or -1 if no such pair exists.

        Example:
            Input: nums = [51,71,17,24,42]
            Output: 88
            Explanation:
                For i = 1 and j = 2, nums[i] and nums[j] have equal maximum digits with a pair sum of 71 + 17 = 88.
                For i = 3 and j = 4, nums[i] and nums[j] have equal maximum digits with a pair sum of 24 + 42 = 66.
                It can be shown that there are no other pairs with equal maximum digits, so the answer is 88.""";

    public MaxPairSumInArray(int id, String description, TaskRevision revision) {
        super(id, description, revision);
        initialization();
    }

    private void initialization() {
        final var random = ThreadLocalRandom.current();

        this.numbers = random.ints(
            random.nextInt(2, LEN + 1), 1, VALUE + 1
        ).toArray();

        log.info("Numbers: {}", Arrays.toString(numbers));
    }

    @Override
    protected String getInformation() {
        return INFORMATION;
    }

    // time = 7907 ms
    @Override
    protected Integer original() {
        var original = new Original(numbers);
        return original.process();
    }

    // time = 7442 ms
    @Override
    protected Integer practice() {
        var practice = new Practice(numbers);
        return practice.process();
    }

    // time = 6735 ms
    @Override
    protected Integer solution() {
        var solution = new Solution(numbers);
        return solution.process();
    }
}
