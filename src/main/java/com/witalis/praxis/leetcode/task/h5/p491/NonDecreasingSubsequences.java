package com.witalis.praxis.leetcode.task.h5.p491;

import com.witalis.praxis.leetcode.task.LeetCodeTask;
import com.witalis.praxis.leetcode.task.h5.p491.option.*;
import com.witalis.praxis.leetcode.utils.LeetCode;
import com.witalis.praxis.leetcode.utils.TaskDifficulty;
import com.witalis.praxis.leetcode.utils.TaskRevision;

import lombok.extern.slf4j.Slf4j;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

import static com.witalis.praxis.leetcode.utils.TaskTag.*;

@Slf4j
@LeetCode(
    id = 491,
    description = "Non-decreasing Subsequences",
    difficulty = TaskDifficulty.MEDIUM,
    tags = {ARRAY, HASH_TABLE, BACKTRACKING, BIT_MANIPULATION}
)
public class NonDecreasingSubsequences extends LeetCodeTask<List<List<Integer>>> {
    public static final int LEN = 15;
    public static final int VALUE = 100;
    private int[] numbers;

    public static final String INFORMATION = """

        Description:
            Given an integer array nums, return all the different possible non-decreasing subsequences
                of the given array with at least two elements. You may return the answer in any order.

        Example:
            Input: nums = [4,6,7,7]
            Output: [[4,6],[4,6,7],[4,6,7,7],[4,7],[4,7,7],[6,7],[6,7,7],[7,7]]""";

    public NonDecreasingSubsequences(int id, String description, TaskRevision revision) {
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

    // time = 3956 ms
    @Override
    protected List<List<Integer>> original() {
        var original = new Original(numbers);
        return original.process();
    }

    // time = 1725 ms
    @Override
    protected List<List<Integer>> practice() {
        var practice = new Practice(numbers);
        return practice.process();
    }

    // time = 5604 ms
    @Override
    protected List<List<Integer>> solution() {
        var solution = new Solution(numbers);
        return solution.process();
    }
}
