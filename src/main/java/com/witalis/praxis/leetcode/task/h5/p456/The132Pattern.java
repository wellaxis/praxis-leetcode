package com.witalis.praxis.leetcode.task.h5.p456;

import com.witalis.praxis.leetcode.task.LeetCodeTask;
import com.witalis.praxis.leetcode.task.h5.p456.option.*;
import com.witalis.praxis.leetcode.utils.LeetCode;
import com.witalis.praxis.leetcode.utils.TaskDifficulty;
import com.witalis.praxis.leetcode.utils.TaskRevision;

import lombok.extern.slf4j.Slf4j;
import java.util.Arrays;
import java.util.concurrent.ThreadLocalRandom;

import static com.witalis.praxis.leetcode.utils.TaskTag.*;

@Slf4j
@LeetCode(
    id = 456,
    description = "132 Pattern",
    difficulty = TaskDifficulty.MEDIUM,
    tags = {ARRAY, BINARY_SEARCH, STACK, MONOTONIC_STACK, ORDERED_SET}
)
public class The132Pattern extends LeetCodeTask<Boolean> {
    public static final int LEN = 200_000;
    public static final int VALUE = (int) 1e9;

    private int[] numbers;

    public static final String INFORMATION = """

        Description:
            Given an array of n integers nums, a 132 pattern is a subsequence of three integers
                nums[i], nums[j] and nums[k] such that i < j < k and nums[i] < nums[k] < nums[j].

            Return true if there is a 132 pattern in nums, otherwise, return false.

        Example:
            Input: nums = [3,1,4,2]
            Output: true
            Explanation: There is a 132 pattern in the sequence: [1, 4, 2].""";

    public The132Pattern(int id, String description, TaskRevision revision) {
        super(id, description, revision);
        initialization();
    }

    private void initialization() {
        var random = ThreadLocalRandom.current();

        this.numbers = random.ints(
            random.nextLong(1, LEN + 1),
            -VALUE, VALUE
        ).toArray();

        log.info("Numbers: {}", Arrays.toString(numbers));
    }

    @Override
    protected String getInformation() {
        return INFORMATION;
    }

    // time = 1980 ms, times limit exceeded
    @Override
    protected Boolean original() {
        var original = new Original(numbers);
        return original.process();
    }

    // time = 797 ms
    @Override
    protected Boolean practice() {
        var practice = new Practice(numbers);
        return practice.process();
    }

    // time = 513 ms
    @Override
    protected Boolean solution() {
        var solution = new Solution(numbers);
        return solution.process();
    }
}
