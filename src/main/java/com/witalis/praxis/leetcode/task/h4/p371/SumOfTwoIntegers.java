package com.witalis.praxis.leetcode.task.h4.p371;

import com.witalis.praxis.leetcode.task.LeetCodeTask;
import com.witalis.praxis.leetcode.task.h4.p371.option.*;
import com.witalis.praxis.leetcode.utils.LeetCode;
import com.witalis.praxis.leetcode.utils.TaskDifficulty;
import com.witalis.praxis.leetcode.utils.TaskRevision;

import lombok.extern.slf4j.Slf4j;
import java.util.concurrent.ThreadLocalRandom;

import static com.witalis.praxis.leetcode.utils.TaskTag.*;

@Slf4j
@LeetCode(
    id = 371,
    description = "Sum of Two Integers",
    difficulty = TaskDifficulty.MEDIUM,
    tags = {MATH, BIT_MANIPULATION}
)
public class SumOfTwoIntegers extends LeetCodeTask<Integer> {
    public static final int VALUE = 1_000;

    private int number1;
    private int number2;

    public static final String INFORMATION = """

        Description:
            Given two integers a and b, return the sum of the two integers without using the operators + and -.

        Example:
            Input: a = 2, b = 3
            Output: 5""";

    public SumOfTwoIntegers(int id, String description, TaskRevision revision) {
        super(id, description, revision);
        initialization();
    }

    private void initialization() {
        final var random = ThreadLocalRandom.current();

        this.number1 = random.nextInt(-VALUE, VALUE + 1);
        this.number2 = random.nextInt(-VALUE, VALUE + 1);

        log.info("Number #1: {}", number1);
        log.info("Number #2: {}", number2);
    }

    @Override
    protected String getInformation() {
        return INFORMATION;
    }

    // time = 429 ms
    @Override
    protected Integer original() {
        var original = new Original(number1, number2);
        return original.process();
    }

    // time = 426 ms
    @Override
    protected Integer practice() {
        var practice = new Practice(number1, number2);
        return practice.process();
    }

    // time = 440 ms
    @Override
    protected Integer solution() {
        var solution = new Solution(number1, number2);
        return solution.process();
    }
}
