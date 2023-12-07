package com.witalis.praxis.leetcode.task.h30.p2917;

import com.witalis.praxis.leetcode.task.LeetCodeTask;
import com.witalis.praxis.leetcode.task.h30.p2917.option.*;
import com.witalis.praxis.leetcode.utils.LeetCode;
import com.witalis.praxis.leetcode.utils.TaskDifficulty;
import com.witalis.praxis.leetcode.utils.TaskRevision;

import lombok.extern.slf4j.Slf4j;
import java.util.Arrays;
import java.util.concurrent.ThreadLocalRandom;

import static com.witalis.praxis.leetcode.utils.TaskTag.*;

@Slf4j
@LeetCode(
    id = 2917,
    description = "Find the K-or of an Array",
    difficulty = TaskDifficulty.EASY,
    tags = {ARRAY, BIT_MANIPULATION}
)
public class FindKOrOfArray extends LeetCodeTask<Integer> {
    public static final int LEN = 50;
    public static final int VALUE = Integer.MAX_VALUE;

    private int[] numbers;
    private int elements;

    public static final String INFORMATION = """

        Description:
            You are given a 0-indexed integer array nums, and an integer k.

            The K-or of nums is a non-negative integer that satisfies the following:
                * The i^th bit is set in the K-or if and only if there are at least k elements of nums in which bit i is set.

            Return the K-or of nums.

            Note that a bit i is set in x if (2i AND x) == 2i, where AND is the bitwise AND operator.

        Example:
            Input: nums = [7,12,9,8,9,15], k = 4
            Output: 9
            Explanation: Bit 0 is set at nums[0], nums[2], nums[4], and nums[5].
                Bit 1 is set at nums[0], and nums[5].
                Bit 2 is set at nums[0], nums[1], and nums[5].
                Bit 3 is set at nums[1], nums[2], nums[3], nums[4], and nums[5].
                Only bits 0 and 3 are set in at least k elements of the array, and bits i >= 4 are not set in any of the array's elements.
                Hence, the answer is 2^0 + 2^3 = 9.""";

    public FindKOrOfArray(int id, String description, TaskRevision revision) {
        super(id, description, revision);
        initialization();
    }

    private void initialization() {
        final var random = ThreadLocalRandom.current();

        this.numbers = random.ints(
            random.nextInt(1, LEN + 1),
            0, VALUE
        ).toArray();
        this.elements = random.nextInt(1, numbers.length + 1);

        log.info("Numbers: {}", Arrays.toString(numbers));
        log.info("Elements 'k': {}", elements);
    }

    @Override
    protected String getInformation() {
        return INFORMATION;
    }

    // time = 511 ms
    @Override
    protected Integer original() {
        var original = new Original(numbers, elements);
        return original.process();
    }

    // time = 495 ms
    @Override
    protected Integer practice() {
        var practice = new Practice(numbers, elements);
        return practice.process();
    }

    // time = 491 ms
    @Override
    protected Integer solution() {
        var solution = new Solution(numbers, elements);
        return solution.process();
    }
}
