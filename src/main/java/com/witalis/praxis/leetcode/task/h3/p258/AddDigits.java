package com.witalis.praxis.leetcode.task.h3.p258;

import com.witalis.praxis.leetcode.task.LeetCodeTask;
import com.witalis.praxis.leetcode.task.h3.p258.option.*;
import com.witalis.praxis.leetcode.utils.LeetCode;
import com.witalis.praxis.leetcode.utils.TaskDifficulty;
import com.witalis.praxis.leetcode.utils.TaskRevision;

import lombok.extern.slf4j.Slf4j;
import java.util.concurrent.ThreadLocalRandom;

import static com.witalis.praxis.leetcode.utils.TaskTag.*;

@Slf4j
@LeetCode(
    id = 258,
    description = "Add Digits",
    difficulty = TaskDifficulty.EASY,
    tags = {MATH, SIMULATION, NUMBER_THEORY}
)
public class AddDigits extends LeetCodeTask<Integer> {
    private int number;

    public static final String INFORMATION = """

        Description:
            Given an integer num, repeatedly add all its digits
                until the result has only one digit, and return it.

        Example:
            Input: num = 38
            Output: 2
            Explanation:
                The process is
                38 --> 3 + 8 --> 11
                11 --> 1 + 1 --> 2
                Since 2 has only one digit, return it.""";

    public AddDigits(int id, String description, TaskRevision revision) {
        super(id, description, revision);
        initialization();
    }

    private void initialization() {
        this.number = ThreadLocalRandom.current().nextInt(0, Integer.MAX_VALUE);

        log.info("Number is {}", number);
    }

    @Override
    protected String getInformation() {
        return INFORMATION;
    }

    // time = 533 ms
    @Override
    protected Integer original() {
        var original = new Original(number);
        return original.process();
    }

    // time = 481 ms
    @Override
    protected Integer practice() {
        var practice = new Practice(number);
        return practice.process();
    }

    // time = 424 ms
    @Override
    protected Integer solution() {
        var solution = new Solution(number);
        return solution.process();
    }
}
