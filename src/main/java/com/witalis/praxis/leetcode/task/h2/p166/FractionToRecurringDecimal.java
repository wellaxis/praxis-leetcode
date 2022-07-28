package com.witalis.praxis.leetcode.task.h2.p166;

import com.witalis.praxis.leetcode.task.LeetCodeTask;
import com.witalis.praxis.leetcode.task.h2.p166.option.*;
import com.witalis.praxis.leetcode.utils.LeetCode;
import com.witalis.praxis.leetcode.utils.TaskDifficulty;
import com.witalis.praxis.leetcode.utils.TaskRevision;

import lombok.extern.slf4j.Slf4j;
import java.util.concurrent.ThreadLocalRandom;

import static com.witalis.praxis.leetcode.utils.TaskTag.*;

@Slf4j
@LeetCode(
    id = 166,
    description = "Fraction to Recurring Decimal",
    difficulty = TaskDifficulty.MEDIUM,
    tags = {HASH_TABLE, MATH, STRING}
)
public class FractionToRecurringDecimal extends LeetCodeTask<String> {
    private int numerator;
    private int denominator;

    public static final String INFORMATION = """

        Given two integers representing the numerator and denominator of a fraction,
            return the fraction in string format.

        If the fractional part is repeating, enclose the repeating part in parentheses.

        If multiple answers are possible, return any of them.

        It is guaranteed that the length of the answer string is less than 104 for all the given inputs.

        Example:
            Input: numerator = 4, denominator = 333
            Output: "0.(012)" """;

    public FractionToRecurringDecimal(int id, String description, TaskRevision revision) {
        super(id, description, revision);
        initialization();
    }

    private void initialization() {
        var random = ThreadLocalRandom.current();

        this.numerator = random.nextInt(Integer.MIN_VALUE, Integer.MAX_VALUE);
        this.denominator = random.nextInt(Integer.MIN_VALUE, Integer.MAX_VALUE);
        if (denominator == 0) denominator = 1;

        log.info("Numerator is {}", numerator);
        log.info("Denominator is '{}'", denominator);
    }

    @Override
    protected String getInformation() {
        return INFORMATION;
    }

    // time = 4346 ms
    @Override
    protected String original() {
        var original = new Original(numerator, denominator);
        return original.process();
    }

    // time = 4008 ms
    @Override
    protected String practice() {
        var practice = new Practice(numerator, denominator);
        return practice.process();
    }

    // time = 3696 ms
    @Override
    protected String solution() {
        var solution = new Solution(numerator, denominator);
        return solution.process();
    }
}
