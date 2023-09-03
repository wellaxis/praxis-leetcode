package com.witalis.praxis.leetcode.task.h9.p896;

import com.witalis.praxis.leetcode.task.LeetCodeTask;
import com.witalis.praxis.leetcode.task.h9.p896.option.*;
import com.witalis.praxis.leetcode.utils.LeetCode;
import com.witalis.praxis.leetcode.utils.TaskDifficulty;
import com.witalis.praxis.leetcode.utils.TaskRevision;

import lombok.extern.slf4j.Slf4j;
import java.util.Arrays;
import java.util.concurrent.ThreadLocalRandom;

import static com.witalis.praxis.leetcode.utils.TaskTag.*;

@Slf4j
@LeetCode(
    id = 896,
    description = "Monotonic Array",
    difficulty = TaskDifficulty.EASY,
    tags = {ARRAY}
)
public class MonotonicArray extends LeetCodeTask<Boolean> {
    public static final int LEN = 100_000;
    public static final int VALUE = 100_000;

    private int[] numbers;

    public static final String INFORMATION = """

        Description:
            An array is monotonic if it is either monotone increasing or monotone decreasing.

            An array nums is monotone increasing if for all i <= j, nums[i] <= nums[j].
            An array nums is monotone decreasing if for all i <= j, nums[i] >= nums[j].

            Given an integer array nums, return true if the given array is monotonic, or false otherwise.

        Example:
            Input: nums = [1,2,2,3]
            Output: true""";

    public MonotonicArray(int id, String description, TaskRevision revision) {
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

    // time = 549 ms
    @Override
    protected Boolean original() {
        var original = new Original(numbers);
        return original.process();
    }

    // time = 461 ms
    @Override
    protected Boolean practice() {
        var practice = new Practice(numbers);
        return practice.process();
    }

    // time = 443 ms
    @Override
    protected Boolean solution() {
        var solution = new Solution(numbers);
        return solution.process();
    }
}
