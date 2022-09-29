package com.witalis.praxis.leetcode.task.h7.p628;

import com.witalis.praxis.leetcode.task.LeetCodeTask;
import com.witalis.praxis.leetcode.task.h7.p628.option.*;
import com.witalis.praxis.leetcode.utils.LeetCode;
import com.witalis.praxis.leetcode.utils.TaskDifficulty;
import com.witalis.praxis.leetcode.utils.TaskRevision;

import lombok.extern.slf4j.Slf4j;
import java.util.Arrays;
import java.util.concurrent.ThreadLocalRandom;

import static com.witalis.praxis.leetcode.utils.TaskTag.*;

@Slf4j
@LeetCode(
    id = 628,
    description = "Maximum Product of Three Numbers",
    difficulty = TaskDifficulty.EASY,
    tags = {ARRAY, MATH, SORTING}
)
public class MaximumProductOfThreeNumbers extends LeetCodeTask<Integer> {
    public static final int LEN = 10_000;
    public static final int VALUE = 1_000;
    private int[] numbers;

    public static final String INFORMATION = """

        Given an integer array nums, find three numbers
            whose product is maximum and return the maximum product.

        Example:
            Input: nums = [1,2,3,4]
            Output: 24""";

    public MaximumProductOfThreeNumbers(int id, String description, TaskRevision revision) {
        super(id, description, revision);
        initialization();
    }

    private void initialization() {
        final var random = ThreadLocalRandom.current();

        int len = random.nextInt(3, LEN + 1);
        this.numbers = random.ints(len, -VALUE, VALUE + 1).toArray();

        log.info("Numbers are {}", Arrays.toString(numbers));
    }

    @Override
    protected String getInformation() {
        return INFORMATION;
    }

    // time = 1530 ms
    @Override
    protected Integer original() {
        var original = new Original(numbers);
        return original.process();
    }

    // time = 1358 ms
    @Override
    protected Integer practice() {
        var practice = new Practice(numbers);
        return practice.process();
    }

    // time = 852 ms
    @Override
    protected Integer solution() {
        var solution = new Solution(numbers);
        return solution.process();
    }
}
