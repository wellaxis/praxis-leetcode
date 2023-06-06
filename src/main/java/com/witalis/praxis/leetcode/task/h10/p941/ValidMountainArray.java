package com.witalis.praxis.leetcode.task.h10.p941;

import com.witalis.praxis.leetcode.task.LeetCodeTask;
import com.witalis.praxis.leetcode.task.h10.p941.option.*;
import com.witalis.praxis.leetcode.utils.LeetCode;
import com.witalis.praxis.leetcode.utils.TaskDifficulty;
import com.witalis.praxis.leetcode.utils.TaskRevision;

import lombok.extern.slf4j.Slf4j;
import java.util.Arrays;
import java.util.concurrent.ThreadLocalRandom;

import static com.witalis.praxis.leetcode.utils.TaskTag.*;

@Slf4j
@LeetCode(
    id = 941,
    description = "Valid Mountain Array",
    difficulty = TaskDifficulty.EASY,
    tags = {ARRAY}
)
public class ValidMountainArray extends LeetCodeTask<Boolean> {
    public static final int LEN = 10_000;
    public static final int VALUE = 10_000;

    private int[] numbers;

    public static final String INFORMATION = """

        Description:
            Given an array of integers arr, return true if and only if it is a valid mountain array.

            Recall that arr is a mountain array if and only if:
                * arr.length >= 3
                * There exists some i with 0 < i < arr.length - 1 such that:
                    - arr[0] < arr[1] < ... < arr[i - 1] < arr[i]
                    - arr[i] > arr[i + 1] > ... > arr[arr.length - 1]

        Example:
            Input: arr = [0,3,2,1]
            Output: true""";

    public ValidMountainArray(int id, String description, TaskRevision revision) {
        super(id, description, revision);
        initialization();
    }

    private void initialization() {
        final var random = ThreadLocalRandom.current();

        this.numbers = random.ints(
            random.nextInt(1, LEN + 1),
            0, VALUE + 1
        ).toArray();

        log.info("Array: {}", Arrays.toString(numbers));
    }

    @Override
    protected String getInformation() {
        return INFORMATION;
    }

    // time = 497 ms
    @Override
    protected Boolean original() {
        var original = new Original(numbers);
        return original.process();
    }

    // time = 469 ms
    @Override
    protected Boolean practice() {
        var practice = new Practice(numbers);
        return practice.process();
    }

    // time = 468 ms
    @Override
    protected Boolean solution() {
        var solution = new Solution(numbers);
        return solution.process();
    }
}
