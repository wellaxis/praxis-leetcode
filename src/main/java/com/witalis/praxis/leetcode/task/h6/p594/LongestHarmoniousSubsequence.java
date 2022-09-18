package com.witalis.praxis.leetcode.task.h6.p594;

import com.witalis.praxis.leetcode.task.LeetCodeTask;
import com.witalis.praxis.leetcode.task.h6.p594.option.*;
import com.witalis.praxis.leetcode.utils.LeetCode;
import com.witalis.praxis.leetcode.utils.TaskDifficulty;
import com.witalis.praxis.leetcode.utils.TaskRevision;

import lombok.extern.slf4j.Slf4j;
import java.util.Arrays;
import java.util.concurrent.ThreadLocalRandom;

import static com.witalis.praxis.leetcode.utils.TaskTag.*;

@Slf4j
@LeetCode(
    id = 594,
    description = "Longest Harmonious Subsequence",
    difficulty = TaskDifficulty.EASY,
    tags = {ARRAY, HASH_TABLE, SORTING}
)
public class LongestHarmoniousSubsequence extends LeetCodeTask<Integer> {
    public static final int LEN = 20_000;
    public static final int VALUE = (int) Math.pow(10, 9);
    private int[] numbers;

    public static final String INFORMATION = """

        We define a harmonious array as an array where the difference
            between its maximum value and its minimum value is exactly 1.

        Given an integer array nums, return the length of its longest
            harmonious subsequence among all its possible subsequences.

        A subsequence of array is a sequence that can be derived from the array
            by deleting some or no elements without changing the order of the remaining elements.

        Example:
            Input: nums = [1,3,2,2,5,2,3,7]
            Output: 5
            Explanation: The longest harmonious subsequence is [3,2,2,2,3].""";

    public LongestHarmoniousSubsequence(int id, String description, TaskRevision revision) {
        super(id, description, revision);
        initialization();
    }

    private void initialization() {
        final var random = ThreadLocalRandom.current();

        this.numbers = random.ints(
            random.nextInt(1, LEN + 1),
            -VALUE,
            VALUE + 1
        ).toArray();

        log.info("Numbers are {}", Arrays.toString(numbers));
    }

    @Override
    protected String getInformation() {
        return INFORMATION;
    }

    // time = 6708 ms
    @Override
    protected Integer original() {
        var original = new Original(numbers);
        return original.process();
    }

    // time = 5616 ms
    @Override
    protected Integer practice() {
        var practice = new Practice(numbers);
        return practice.process();
    }

    // time = 4177 ms
    @Override
    protected Integer solution() {
        var solution = new Solution(numbers);
        return solution.process();
    }
}
