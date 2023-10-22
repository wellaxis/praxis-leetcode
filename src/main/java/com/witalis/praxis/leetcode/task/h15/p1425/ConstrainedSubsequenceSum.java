package com.witalis.praxis.leetcode.task.h15.p1425;

import com.witalis.praxis.leetcode.task.LeetCodeTask;
import com.witalis.praxis.leetcode.task.h15.p1425.option.*;
import com.witalis.praxis.leetcode.utils.LeetCode;
import com.witalis.praxis.leetcode.utils.TaskDifficulty;
import com.witalis.praxis.leetcode.utils.TaskRevision;

import lombok.extern.slf4j.Slf4j;
import java.util.Arrays;
import java.util.concurrent.ThreadLocalRandom;

import static com.witalis.praxis.leetcode.utils.TaskTag.*;

@Slf4j
@LeetCode(
    id = 1425,
    description = "Constrained Subsequence Sum",
    difficulty = TaskDifficulty.HARD,
    tags = {ARRAY, DYNAMIC_PROGRAMMING, QUEUE, SLIDING_WINDOW, HEAP, MONOTONIC_QUEUE}
)
public class ConstrainedSubsequenceSum extends LeetCodeTask<Integer> {
    public static final int LEN = 100_000;
    public static final int VALUE = 10_000;

    private int[] numbers;
    private int gap;

    public static final String INFORMATION = """

        Description:
            Given an integer array nums and an integer k, return the maximum sum of a non-empty subsequence of that array such
                that for every two consecutive integers in the subsequence, nums[i] and nums[j], where i < j, the condition j - i <= k is satisfied.

            A subsequence of an array is obtained by deleting some number of elements (can be zero) from the array,
                leaving the remaining elements in their original order.

        Example:
            Input: nums = [10,2,-10,5,20], k = 2
            Output: 37
            Explanation: The subsequence is [10, 2, 5, 20].""";

    public ConstrainedSubsequenceSum(int id, String description, TaskRevision revision) {
        super(id, description, revision);
        initialization();
    }

    private void initialization() {
        final var random = ThreadLocalRandom.current();

        this.numbers = random.ints(
            random.nextInt(1, LEN + 1),
            -VALUE, VALUE + 1
        ).toArray();
        this.gap = random.nextInt(1, numbers.length + 1);

        log.info("Numbers: {}", Arrays.toString(numbers));
        log.info("Gap 'k': {}", gap);
    }

    @Override
    protected String getInformation() {
        return INFORMATION;
    }

    // time = 33406 ms
    @Override
    protected Integer original() {
        var original = new Original(numbers, gap);
        return original.process();
    }

    // time = 31465 ms
    @Override
    protected Integer practice() {
        var practice = new Practice(numbers, gap);
        return practice.process();
    }

    // time = 21846 ms
    @Override
    protected Integer solution() {
        var solution = new Solution(numbers, gap);
        return solution.process();
    }
}
