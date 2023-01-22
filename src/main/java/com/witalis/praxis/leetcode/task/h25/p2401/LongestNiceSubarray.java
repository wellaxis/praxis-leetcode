package com.witalis.praxis.leetcode.task.h25.p2401;

import com.witalis.praxis.leetcode.task.LeetCodeTask;
import com.witalis.praxis.leetcode.task.h25.p2401.option.*;
import com.witalis.praxis.leetcode.utils.LeetCode;
import com.witalis.praxis.leetcode.utils.TaskDifficulty;
import com.witalis.praxis.leetcode.utils.TaskRevision;

import lombok.extern.slf4j.Slf4j;
import java.util.Arrays;
import java.util.concurrent.ThreadLocalRandom;

import static com.witalis.praxis.leetcode.utils.TaskTag.*;

@Slf4j
@LeetCode(
    id = 2401,
    description = "Longest Nice Subarray",
    difficulty = TaskDifficulty.MEDIUM,
    tags = {ARRAY, BIT_MANIPULATION, SLIDING_WINDOW}
)
public class LongestNiceSubarray extends LeetCodeTask<Integer> {
    public static final int LEN = 100_000;
    public static final int VALUE = 1_000_000_000;
    private int[] numbers;

    public static final String INFORMATION = """

        Description:
            You are given an array nums consisting of positive integers.

            We call a subarray of nums nice if the bitwise AND of every pair of elements
                that are in different positions in the subarray is equal to 0.

            Return the length of the longest nice subarray.

            A subarray is a contiguous part of an array.

            Note that subarrays of length 1 are always considered nice.

        Example:
            Input: nums = [1,3,8,48,10]
            Output: 3
            Explanation: The longest nice subarray is [3,8,48]. This subarray satisfies the conditions:
                - 3 AND 8 = 0.
                - 3 AND 48 = 0.
                - 8 AND 48 = 0.
                It can be proven that no longer nice subarray can be obtained, so we return 3.""";

    public LongestNiceSubarray(int id, String description, TaskRevision revision) {
        super(id, description, revision);
        initialization();
    }

    private void initialization() {
        final var random = ThreadLocalRandom.current();

        this.numbers = random.ints(
            random.nextInt(1, LEN + 1),
            1, VALUE + 1
        ).toArray();

        log.info("Numbers are {}", Arrays.toString(numbers));
    }

    @Override
    protected String getInformation() {
        return INFORMATION;
    }

    // time = 4260 ms
    @Override
    protected Integer original() {
        var original = new Original(numbers);
        return original.process();
    }

    // time = 3827 ms
    @Override
    protected Integer practice() {
        var practice = new Practice(numbers);
        return practice.process();
    }

    // time = 3348 ms
    @Override
    protected Integer solution() {
        var solution = new Solution(numbers);
        return solution.process();
    }
}
