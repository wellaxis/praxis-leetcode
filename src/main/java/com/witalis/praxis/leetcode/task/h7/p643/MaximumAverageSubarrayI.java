package com.witalis.praxis.leetcode.task.h7.p643;

import com.witalis.praxis.leetcode.task.LeetCodeTask;
import com.witalis.praxis.leetcode.task.h7.p643.option.*;
import com.witalis.praxis.leetcode.utils.LeetCode;
import com.witalis.praxis.leetcode.utils.TaskDifficulty;
import com.witalis.praxis.leetcode.utils.TaskRevision;

import lombok.extern.slf4j.Slf4j;
import java.util.Arrays;
import java.util.concurrent.ThreadLocalRandom;

import static com.witalis.praxis.leetcode.utils.TaskTag.*;

@Slf4j
@LeetCode(
    id = 643,
    description = "Maximum Average Subarray I",
    difficulty = TaskDifficulty.EASY,
    tags = {ARRAY, SLIDING_WINDOW}
)
public class MaximumAverageSubarrayI extends LeetCodeTask<Double> {
    public static final int LEN = 100_000;
    public static final int VALUE = 10_000;
    private int[] numbers;
    private int length;

    public static final String INFORMATION = """

        You are given an integer array nums consisting of n elements, and an integer k.

        Find a contiguous subarray whose length is equal to k that has the maximum average value
            and return this value. Any answer with a calculation error less than 10-5 will be accepted.

        Example:
            Input: nums = [1,12,-5,-6,50,3], k = 4
            Output: 12.75000
            Explanation: Maximum average is (12 - 5 - 6 + 50) / 4 = 51 / 4 = 12.75""";

    public MaximumAverageSubarrayI(int id, String description, TaskRevision revision) {
        super(id, description, revision);
        initialization();
    }

    private void initialization() {
        final var random = ThreadLocalRandom.current();

        int len = random.nextInt(1, LEN + 1);
        this.numbers = random.ints(len, -VALUE, VALUE + 1).toArray();
        this.length = random.nextInt(1, len + 1);

        log.info("Numbers are {}", Arrays.toString(numbers));
        log.info("Length K is {}", length);
    }

    @Override
    protected String getInformation() {
        return INFORMATION;
    }

    // time = 1732 ms
    @Override
    protected Double original() {
        var original = new Original(numbers, length);
        return original.process();
    }

    // time = 1306 ms
    @Override
    protected Double practice() {
        var practice = new Practice(numbers, length);
        return practice.process();
    }

    // time = 1301 ms
    @Override
    protected Double solution() {
        var solution = new Solution(numbers, length);
        return solution.process();
    }
}
