package com.witalis.praxis.leetcode.task.h24.p2348;

import com.witalis.praxis.leetcode.task.LeetCodeTask;
import com.witalis.praxis.leetcode.task.h24.p2348.option.*;
import com.witalis.praxis.leetcode.utils.LeetCode;
import com.witalis.praxis.leetcode.utils.TaskDifficulty;
import com.witalis.praxis.leetcode.utils.TaskRevision;

import lombok.extern.slf4j.Slf4j;
import java.util.Arrays;
import java.util.concurrent.ThreadLocalRandom;

import static com.witalis.praxis.leetcode.utils.TaskTag.*;

@Slf4j
@LeetCode(
    id = 2348,
    description = "Number of Zero-Filled Subarrays",
    difficulty = TaskDifficulty.MEDIUM,
    tags = {ARRAY, MATH}
)
public class NumberOfZeroFilledSubarrays extends LeetCodeTask<Long> {
    public static final int LEN = 100_000;
    public static final int VALUE = 1_000_000_000;

    private int[] numbers;

    public static final String INFORMATION = """

        Description:
            Given an integer array nums, return the number of subarrays filled with 0.

            A subarray is a contiguous non-empty sequence of elements within an array.

        Example:
            Input: nums = [0,0,0,2,0,0]
            Output: 9
            Explanation:
                There are 5 occurrences of [0] as a subarray.
                There are 3 occurrences of [0,0] as a subarray.
                There is 1 occurrence of [0,0,0] as a subarray.
                There is no occurrence of a subarray with a size more than 3 filled with 0. Therefore, we return 9.""";

    public NumberOfZeroFilledSubarrays(int id, String description, TaskRevision revision) {
        super(id, description, revision);
        initialization();
    }

    private void initialization() {
        final var random = ThreadLocalRandom.current();

        int len = random.nextInt(1, LEN + 1);
        this.numbers = new int[len];
        for (int i = 0; i < len; i++) {
            if (random.nextBoolean()) {
                numbers[i] = 0;
            } else {
                numbers[i] = random.nextInt(-VALUE, VALUE + 1);
            }
        }

        log.info("Numbers: {}", Arrays.toString(numbers));
    }

    @Override
    protected String getInformation() {
        return INFORMATION;
    }

    // time = 2064 ms
    @Override
    protected Long original() {
        var original = new Original(numbers);
        return original.process();
    }

    // time = 1615 ms
    @Override
    protected Long practice() {
        var practice = new Practice(numbers);
        return practice.process();
    }

    // time = 1283 ms
    @Override
    protected Long solution() {
        var solution = new Solution(numbers);
        return solution.process();
    }
}
