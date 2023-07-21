package com.witalis.praxis.leetcode.task.h7.p673;

import com.witalis.praxis.leetcode.task.LeetCodeTask;
import com.witalis.praxis.leetcode.task.h7.p673.option.*;
import com.witalis.praxis.leetcode.utils.LeetCode;
import com.witalis.praxis.leetcode.utils.TaskDifficulty;
import com.witalis.praxis.leetcode.utils.TaskRevision;

import lombok.extern.slf4j.Slf4j;
import java.util.Arrays;
import java.util.concurrent.ThreadLocalRandom;

import static com.witalis.praxis.leetcode.utils.TaskTag.*;

@Slf4j
@LeetCode(
    id = 673,
    description = "Number of Longest Increasing Subsequence",
    difficulty = TaskDifficulty.MEDIUM,
    tags = {ARRAY, DYNAMIC_PROGRAMMING, BINARY_INDEXED_TREE, SEGMENT_TREE}
)
public class NumberOfLongestIncreasingSubsequence extends LeetCodeTask<Integer> {
    public static final int LEN = 2_000;
    public static final int VALUE = 1_000_000;

    private int[] numbers;

    public static final String INFORMATION = """

        Description:
            Given an integer array nums, return the number of longest increasing subsequences.

            Notice that the sequence has to be strictly increasing.

        Example:
            Input: nums = [1,3,5,4,7]
            Output: 2
            Explanation: The two longest increasing subsequences are [1, 3, 4, 7] and [1, 3, 5, 7].""";

    public NumberOfLongestIncreasingSubsequence(int id, String description, TaskRevision revision) {
        super(id, description, revision);
        initialization();
    }

    private void initialization() {
        final var random = ThreadLocalRandom.current();

        this.numbers = random.ints(
            random.nextInt(1, LEN + 1),
            -VALUE, VALUE + 1
        ).toArray();

        log.info("Numbers: {}", Arrays.toString(numbers));
    }

    @Override
    protected String getInformation() {
        return INFORMATION;
    }

    // time = 9513 ms
    @Override
    protected Integer original() {
        var original = new Original(numbers.clone());
        return original.process();
    }

    // time = 8156 ms
    @Override
    protected Integer practice() {
        var practice = new Practice(numbers.clone());
        return practice.process();
    }

    // time = 1750 ms
    @Override
    protected Integer solution() {
        var solution = new Solution(numbers.clone());
        return solution.process();
    }
}
