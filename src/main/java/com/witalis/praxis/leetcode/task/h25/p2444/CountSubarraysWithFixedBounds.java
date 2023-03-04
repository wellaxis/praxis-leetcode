package com.witalis.praxis.leetcode.task.h25.p2444;

import com.witalis.praxis.leetcode.task.LeetCodeTask;
import com.witalis.praxis.leetcode.task.h25.p2444.option.*;
import com.witalis.praxis.leetcode.utils.LeetCode;
import com.witalis.praxis.leetcode.utils.TaskDifficulty;
import com.witalis.praxis.leetcode.utils.TaskRevision;

import lombok.extern.slf4j.Slf4j;
import java.util.Arrays;
import java.util.concurrent.ThreadLocalRandom;

import static com.witalis.praxis.leetcode.utils.TaskTag.*;

@Slf4j
@LeetCode(
    id = 2444,
    description = "Count Subarrays With Fixed Bounds",
    difficulty = TaskDifficulty.HARD,
    tags = {ARRAY, QUEUE, SLIDING_WINDOW, MONOTONIC_QUEUE}
)
public class CountSubarraysWithFixedBounds extends LeetCodeTask<Long> {
    public static final int LEN = 100_000;
    public static final int VALUE = 1_000_000;

    private int[] numbers;
    private int minimum;
    private int maximum;

    public static final String INFORMATION = """

        Description:
            You are given an integer array nums and two integers minK and maxK.

            A fixed-bound subarray of nums is a subarray that satisfies the following conditions:
                * The minimum value in the subarray is equal to minK.
                * The maximum value in the subarray is equal to maxK.

            Return the number of fixed-bound subarrays.

            A subarray is a contiguous part of an array.

        Example:
            Input: nums = [1,3,5,2,7,5], minK = 1, maxK = 5
            Output: 2
            Explanation: The fixed-bound subarrays are [1,3,5] and [1,3,5,2].""";

    public CountSubarraysWithFixedBounds(int id, String description, TaskRevision revision) {
        super(id, description, revision);
        initialization();
    }

    private void initialization() {
        final var random = ThreadLocalRandom.current();

        this.numbers = random.ints(
            random.nextInt(2, LEN + 1),
            1,
            VALUE + 1
        ).toArray();

        this.minimum = random.nextInt(1, VALUE + 1);
        this.maximum = random.nextInt(minimum, VALUE + 1);

        log.info("Numbers: {}", Arrays.toString(numbers));
        log.info("Minimum: {}", minimum);
        log.info("Maximum: {}", maximum);
    }

    @Override
    protected String getInformation() {
        return INFORMATION;
    }

    // time = 3995 ms
    @Override
    protected Long original() {
        var original = new Original(numbers, minimum, maximum);
        return original.process();
    }

    // time = 4094 ms
    @Override
    protected Long practice() {
        var practice = new Practice(numbers, minimum, maximum);
        return practice.process();
    }

    // time = 3563 ms
    @Override
    protected Long solution() {
        var solution = new Solution(numbers, minimum, maximum);
        return solution.process();
    }
}
