package com.witalis.praxis.leetcode.task.h5.p405;

import com.witalis.praxis.leetcode.task.LeetCodeTask;
import com.witalis.praxis.leetcode.task.h5.p405.option.*;
import com.witalis.praxis.leetcode.utils.LeetCode;
import com.witalis.praxis.leetcode.utils.TaskDifficulty;
import com.witalis.praxis.leetcode.utils.TaskRevision;

import lombok.extern.slf4j.Slf4j;
import java.util.concurrent.ThreadLocalRandom;

import static com.witalis.praxis.leetcode.utils.TaskTag.*;

@Slf4j
@LeetCode(
    id = 405,
    description = "Convert a Number to Hexadecimal",
    difficulty = TaskDifficulty.EASY,
    tags = {MATH, BIT_MANIPULATION}
)
public class ConvertNumberToHexadecimal extends LeetCodeTask<String> {
    private int number;

    public static final String INFORMATION = """

        Given an integer num, return a string representing its hexadecimal representation.
            For negative integers, two’s complement method is used.

        All the letters in the answer string should be lowercase characters,
            and there should not be any leading zeros in the answer except for the zero itself.

        Note: You are not allowed to use any built-in library method to directly solve this problem.

        Example:
            Input: num = 26
            Output: "1a" """;

    public ConvertNumberToHexadecimal(int id, String description, TaskRevision revision) {
        super(id, description, revision);
        initialization();
    }

    private void initialization() {
        final var random = ThreadLocalRandom.current();

        this.number = random.nextInt(Integer.MIN_VALUE, Integer.MAX_VALUE);
        log.info("Number is {}", number);
    }

    @Override
    protected String getInformation() {
        return INFORMATION;
    }

    // time = 607 ms
    @Override
    protected String original() {
        var original = new Original(number);
        return original.process();
    }

    // time = 501 ms
    @Override
    protected String practice() {
        var practice = new Practice(number);
        return practice.process();
    }

    // time = 390 ms
    @Override
    protected String solution() {
        var solution = new Solution(number);
        return solution.process();
    }
}
