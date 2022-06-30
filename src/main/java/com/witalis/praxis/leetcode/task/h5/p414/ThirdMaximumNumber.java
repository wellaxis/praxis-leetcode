package com.witalis.praxis.leetcode.task.h5.p414;

import com.witalis.praxis.leetcode.task.LeetCodeTask;
import com.witalis.praxis.leetcode.task.h5.p414.option.*;
import com.witalis.praxis.leetcode.utils.LeetCode;
import com.witalis.praxis.leetcode.utils.TaskDifficulty;
import com.witalis.praxis.leetcode.utils.TaskRevision;

import lombok.extern.slf4j.Slf4j;
import java.util.Arrays;
import java.util.concurrent.ThreadLocalRandom;

import static com.witalis.praxis.leetcode.utils.TaskTag.*;

@Slf4j
@LeetCode(
    id = 414,
    description = "Third Maximum Number",
    difficulty = TaskDifficulty.EASY,
    tags = {ARRAY, SORTING}
)
public class ThirdMaximumNumber extends LeetCodeTask<Integer> {
    public static final int LEN = 10_000;
    private int[] numbers;

    public static final String INFORMATION = """

        Given an integer array nums, return the third distinct maximum number in this array.
            If the third maximum does not exist, return the maximum number.

        Example:
            Input: nums = [3,2,1]
            Output: 1
            Explanation:
                The first distinct maximum is 3.
                The second distinct maximum is 2.
                The third distinct maximum is 1.""";

    public ThirdMaximumNumber(int id, String description, TaskRevision revision) {
        super(id, description, revision);
        initialization();
    }

    private void initialization() {
        final var random = ThreadLocalRandom.current();

        this.numbers = random.ints(
            random.nextInt(1, LEN + 1),
            Integer.MIN_VALUE,
            Integer.MAX_VALUE
        ).toArray();

        log.info("Numbers are {}", Arrays.toString(numbers));
    }

    @Override
    protected String getInformation() {
        return INFORMATION;
    }

    // time = 16352 ms
    @Override
    protected Integer original() {
        var original = new Original(numbers.clone());
        return original.process();
    }

    // time = 1750 ms
    @Override
    protected Integer practice() {
        var practice = new Practice(numbers.clone());
        return practice.process();
    }

    // time = 1217 ms
    @Override
    protected Integer solution() {
        var solution = new Solution(numbers.clone());
        return solution.process();
    }
}
