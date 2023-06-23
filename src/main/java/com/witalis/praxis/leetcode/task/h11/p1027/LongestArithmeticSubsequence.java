package com.witalis.praxis.leetcode.task.h11.p1027;

import com.witalis.praxis.leetcode.task.LeetCodeTask;
import com.witalis.praxis.leetcode.task.h11.p1027.option.*;
import com.witalis.praxis.leetcode.utils.LeetCode;
import com.witalis.praxis.leetcode.utils.TaskDifficulty;
import com.witalis.praxis.leetcode.utils.TaskRevision;

import lombok.extern.slf4j.Slf4j;
import java.util.Arrays;
import java.util.concurrent.ThreadLocalRandom;

import static com.witalis.praxis.leetcode.utils.TaskTag.*;

@Slf4j
@LeetCode(
    id = 1027,
    description = "Longest Arithmetic Subsequence",
    difficulty = TaskDifficulty.MEDIUM,
    tags = {ARRAY, HASH_TABLE, BINARY_SEARCH, DYNAMIC_PROGRAMMING}
)
public class LongestArithmeticSubsequence extends LeetCodeTask<Integer> {
    public static final int LEN = 1_000;
    public static final int VALUE = 500;

    private int[] numbers;

    public static final String INFORMATION = """

        Description:
            Given an array nums of integers, return the length of the longest arithmetic subsequence in nums.

            Note that:
                * A subsequence is an array that can be derived from another array by deleting some
                  or no elements without changing the order of the remaining elements.
                * A sequence seq is arithmetic if seq[i + 1] - seq[i] are all the same value (for 0 <= i < seq.length - 1).

        Example:
            Input: nums = [20,1,15,3,10,5,8]
            Output: 4
            Explanation:  The longest arithmetic subsequence is [20,15,10,5].""";

    public LongestArithmeticSubsequence(int id, String description, TaskRevision revision) {
        super(id, description, revision);
        initialization();
    }

    private void initialization() {
        final var random = ThreadLocalRandom.current();

        this.numbers = random.ints(
            random.nextInt(2, LEN + 1),
            0, VALUE + 1
        ).toArray();

        log.info("Numbers: {}", Arrays.toString(numbers));
    }

    @Override
    protected String getInformation() {
        return INFORMATION;
    }

    // time = 6056 ms
    @Override
    protected Integer original() {
        var original = new Original(numbers.clone());
        return original.process();
    }

    // time = 5385 ms
    @Override
    protected Integer practice() {
        var practice = new Practice(numbers.clone());
        return practice.process();
    }

    // time = 1449 ms
    @Override
    protected Integer solution() {
        var solution = new Solution(numbers.clone());
        return solution.process();
    }
}
