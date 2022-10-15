package com.witalis.praxis.leetcode.task.h4.p300;

import com.witalis.praxis.leetcode.task.LeetCodeTask;
import com.witalis.praxis.leetcode.task.h4.p300.option.*;
import com.witalis.praxis.leetcode.utils.LeetCode;
import com.witalis.praxis.leetcode.utils.TaskDifficulty;
import com.witalis.praxis.leetcode.utils.TaskRevision;

import lombok.extern.slf4j.Slf4j;
import java.util.Arrays;
import java.util.concurrent.ThreadLocalRandom;

import static com.witalis.praxis.leetcode.utils.TaskTag.*;

@Slf4j
@LeetCode(
    id = 300,
    description = "Longest Increasing Subsequence",
    difficulty = TaskDifficulty.MEDIUM,
    tags = {ARRAY, BINARY_SEARCH, DYNAMIC_PROGRAMMING}
)
public class LongestIncreasingSubsequence extends LeetCodeTask<Integer> {
    public static final int LEN = 2_500;
    public static final int VALUE = 10_000;
    private int[] numbers;

    public static final String INFORMATION = """

        Description:
            Given an integer array nums, return the length of the longest strictly increasing subsequence.

            A subsequence is a sequence that can be derived from an array by deleting some or no elements
                without changing the order of the remaining elements.
                For example, [3,6,2,7] is a subsequence of the array [0,3,1,6,2,2,7].

        Example:
            Input: nums = [10,9,2,5,3,7,101,18]
            Output: 4
            Explanation: The longest increasing subsequence is [2,3,7,101], therefore the length is 4.""";

    public LongestIncreasingSubsequence(int id, String description, TaskRevision revision) {
        super(id, description, revision);
        initialization();
    }

    private void initialization() {
        final var random = ThreadLocalRandom.current();

        this.numbers = random.ints(
            random.nextInt(1, LEN + 1),
            -VALUE, VALUE + 1
        ).toArray();

        log.info("Numbers are {}", Arrays.toString(numbers));
    }

    @Override
    protected String getInformation() {
        return INFORMATION;
    }

    // time = 4421 ms
    @Override
    protected Integer original() {
        var original = new Original(numbers);
        return original.process();
    }

    // time = 4253 ms
    @Override
    protected Integer practice() {
        var practice = new Practice(numbers);
        return practice.process();
    }

    // time = 1439 ms
    @Override
    protected Integer solution() {
        var solution = new Solution(numbers);
        return solution.process();
    }
}
