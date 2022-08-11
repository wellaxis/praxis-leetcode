package com.witalis.praxis.leetcode.task.h2.p179;

import com.witalis.praxis.leetcode.task.LeetCodeTask;
import com.witalis.praxis.leetcode.task.h2.p179.option.*;
import com.witalis.praxis.leetcode.utils.LeetCode;
import com.witalis.praxis.leetcode.utils.TaskDifficulty;
import com.witalis.praxis.leetcode.utils.TaskRevision;

import lombok.extern.slf4j.Slf4j;
import java.util.Arrays;
import java.util.concurrent.ThreadLocalRandom;

import static com.witalis.praxis.leetcode.utils.TaskTag.*;

@Slf4j
@LeetCode(
    id = 179,
    description = "Largest Number",
    difficulty = TaskDifficulty.MEDIUM,
    tags = {STRING, GREEDY, SORTING}
)
public class LargestNumber extends LeetCodeTask<String> {
    public static final int LEN = 100;
    public static final int VALUE = (int) Math.pow(10, 9);
    private int[] numbers;

    public static final String INFORMATION = """

        Given a list of non-negative integers nums,
            arrange them such that they form the largest number and return it.

        Since the result may be very large, so you need to return a string instead of an integer.

        Example:
            Input: nums = [3,30,34,5,9]
            Output: "9534330" """;

    public LargestNumber(int id, String description, TaskRevision revision) {
        super(id, description, revision);
        initialization();
    }

    private void initialization() {
        var random = ThreadLocalRandom.current();

        this.numbers = random.ints(
            random.nextInt(1, LEN + 1),
            0,
            VALUE + 1
        ).toArray();

        log.info("Numbers are {}", Arrays.toString(numbers));
    }

    @Override
    protected String getInformation() {
        return INFORMATION;
    }

    // time = 2345 ms
    @Override
    protected String original() {
        var original = new Original(numbers.clone());
        return original.process();
    }

    // time = 1075 ms
    @Override
    protected String practice() {
        var practice = new Practice(numbers.clone());
        return practice.process();
    }

    // time = 547 ms
    @Override
    protected String solution() {
        var solution = new Solution(numbers.clone());
        return solution.process();
    }
}
