package com.witalis.praxis.leetcode.task.h18.p1793;

import com.witalis.praxis.leetcode.task.LeetCodeTask;
import com.witalis.praxis.leetcode.task.h18.p1793.option.*;
import com.witalis.praxis.leetcode.utils.LeetCode;
import com.witalis.praxis.leetcode.utils.TaskDifficulty;
import com.witalis.praxis.leetcode.utils.TaskRevision;

import lombok.extern.slf4j.Slf4j;
import java.util.Arrays;
import java.util.concurrent.ThreadLocalRandom;

import static com.witalis.praxis.leetcode.utils.TaskTag.*;

@Slf4j
@LeetCode(
    id = 1793,
    description = "Maximum Score of a Good Subarray",
    difficulty = TaskDifficulty.HARD,
    tags = {ARRAY, TWO_POINTERS, BINARY_SEARCH, STACK, MONOTONIC_STACK}
)
public class MaximumScoreOfGoodSubarray extends LeetCodeTask<Integer> {
    public static final int LEN = 100_000;
    public static final int VALUE = 20_000;

    private int[] numbers;
    private int gap;

    public static final String INFORMATION = """

        Description:
            You are given an array of integers nums (0-indexed) and an integer k.

            The score of a subarray (i, j) is defined as min(nums[i], nums[i+1], ..., nums[j]) * (j - i + 1).
                A good subarray is a subarray where i <= k <= j.

            Return the maximum possible score of a good subarray.

        Example:
            Input: nums = [1,4,3,7,4,5], k = 3
            Output: 15
            Explanation: The optimal subarray is (1, 5) with a score of min(4,3,7,4,5) * (5-1+1) = 3 * 5 = 15.""";

    public MaximumScoreOfGoodSubarray(int id, String description, TaskRevision revision) {
        super(id, description, revision);
        initialization();
    }

    private void initialization() {
        final var random = ThreadLocalRandom.current();

        this.numbers = random.ints(
            random.nextInt(1, LEN + 1),
            1, VALUE + 1
        ).toArray();
        this.gap = random.nextInt(0, numbers.length);

        log.info("Numbers: {}", Arrays.toString(numbers));
        log.info("Gap 'k': {}", gap);
    }

    @Override
    protected String getInformation() {
        return INFORMATION;
    }

    // time = 6943 ms
    @Override
    protected Integer original() {
        var original = new Original(numbers, gap);
        return original.process();
    }

    // time = 6875 ms
    @Override
    protected Integer practice() {
        var practice = new Practice(numbers, gap);
        return practice.process();
    }

    // time = 5639 ms
    @Override
    protected Integer solution() {
        var solution = new Solution(numbers, gap);
        return solution.process();
    }
}
