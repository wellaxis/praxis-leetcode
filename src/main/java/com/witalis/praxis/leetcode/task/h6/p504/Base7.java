package com.witalis.praxis.leetcode.task.h6.p504;

import com.witalis.praxis.leetcode.task.LeetCodeTask;
import com.witalis.praxis.leetcode.task.h6.p504.option.*;
import com.witalis.praxis.leetcode.utils.LeetCode;
import com.witalis.praxis.leetcode.utils.TaskDifficulty;
import com.witalis.praxis.leetcode.utils.TaskRevision;
import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.ThreadLocalRandom;

import static com.witalis.praxis.leetcode.utils.TaskTag.*;

@Slf4j
@LeetCode(
    id = 504,
    description = "Base 7",
    difficulty = TaskDifficulty.EASY,
    tags = {MATH}
)
public class Base7 extends LeetCodeTask<String> {
    public static final int VALUE = (int) Math.pow(10, 7);
    private int number;

    public static final String INFORMATION = """

        Given an integer num, return a string of its base 7 representation.

        Example:
            Input: num = 100
            Output: "202" """;

    public Base7(int id, String description, TaskRevision revision) {
        super(id, description, revision);
        initialization();
    }

    private void initialization() {
        this.number = ThreadLocalRandom.current().nextInt(-VALUE, VALUE + 1);

        log.info("Number: {}", number);
    }

    @Override
    protected String getInformation() {
        return INFORMATION;
    }

    // time = 601 ms
    @Override
    protected String original() {
        var original = new Original(number);
        return original.process();
    }

    // time = 491 ms
    @Override
    protected String practice() {
        var practice = new Practice(number);
        return practice.process();
    }

    // time = 2400 ms
    @Override
    protected String solution() {
        var solution = new Solution(number);
        return solution.process();
    }
}
