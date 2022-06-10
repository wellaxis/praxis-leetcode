package com.witalis.praxis.leetcode.task.h4.p367;

import com.witalis.praxis.leetcode.task.LeetCodeTask;
import com.witalis.praxis.leetcode.task.h4.p367.option.*;
import com.witalis.praxis.leetcode.utils.LeetCode;
import com.witalis.praxis.leetcode.utils.TaskDifficulty;
import com.witalis.praxis.leetcode.utils.TaskRevision;

import lombok.extern.slf4j.Slf4j;
import java.util.concurrent.ThreadLocalRandom;

import static com.witalis.praxis.leetcode.utils.TaskTag.*;

@Slf4j
@LeetCode(
    id = 367,
    description = "Valid Perfect Square",
    difficulty = TaskDifficulty.EASY,
    tags = {MATH, BINARY_SEARCH}
)
public class ValidPerfectSquare extends LeetCodeTask<Boolean> {
    private int number;

    public static final String INFORMATION = """

        Given a positive integer num, write a function which returns True if num is a perfect square else False.

        Follow up: Do not use any built-in library function such as sqrt.

        Example:
            Input: num = 16
            Output: true""";

    public ValidPerfectSquare(int id, String description, TaskRevision revision) {
        super(id, description, revision);
        initialization();
    }

    private void initialization() {
        final var random = ThreadLocalRandom.current();

        this.number = random.nextInt(1, Integer.MAX_VALUE);

        log.info("Number is {}", number);
    }

    @Override
    protected String getInformation() {
        return INFORMATION;
    }

    // time = 742 ms
    @Override
    protected Boolean original() {
        var original = new Original(number);
        return original.process();
    }

    // time = 731 ms
    @Override
    protected Boolean practice() {
        var practice = new Practice(number);
        return practice.process();
    }

    // time = 621 ms
    @Override
    protected Boolean solution() {
        var solution = new Solution(number);
        return solution.process();
    }
}
