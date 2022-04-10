package com.witalis.praxis.leetcode.task.h3.p263;

import com.witalis.praxis.leetcode.task.LeetCodeTask;
import com.witalis.praxis.leetcode.task.h3.p263.option.*;
import com.witalis.praxis.leetcode.utils.LeetCode;
import com.witalis.praxis.leetcode.utils.TaskDifficulty;
import com.witalis.praxis.leetcode.utils.TaskRevision;

import lombok.extern.slf4j.Slf4j;
import java.util.concurrent.ThreadLocalRandom;

import static com.witalis.praxis.leetcode.utils.TaskTag.*;

@Slf4j
@LeetCode(
    id = 263,
    description = "Ugly Number",
    difficulty = TaskDifficulty.EASY,
    tags = {MATH}
)
public class UglyNumber extends LeetCodeTask<Boolean> {
    private int number;

    public static final String INFORMATION = """

        Description:
            An ugly number is a positive integer whose
                prime factors are limited to 2, 3, and 5.

            Given an integer n, return true if n is an ugly number.

        Example:
            Input: n = 6
            Output: true
            Explanation: 6 = 2 × 3""";

    public UglyNumber(int id, String description, TaskRevision revision) {
        super(id, description, revision);
        initialization();
    }

    private void initialization() {
        this.number = ThreadLocalRandom.current().nextInt(
            Integer.MIN_VALUE, Integer.MAX_VALUE
        );

        log.info("Number is '{}'", number);
    }

    @Override
    protected String getInformation() {
        return INFORMATION;
    }

    // time = 3560 ms
    @Override
    protected Boolean original() {
        var original = new Original(number);
        return original.process();
    }

    // time = 393 ms
    @Override
    protected Boolean practice() {
        var practice = new Practice(number);
        return practice.process();
    }

    // time = 541 ms
    @Override
    protected Boolean solution() {
        var solution = new Solution(number);
        return solution.process();
    }
}
