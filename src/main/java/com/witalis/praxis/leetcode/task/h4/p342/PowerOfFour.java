package com.witalis.praxis.leetcode.task.h4.p342;

import com.witalis.praxis.leetcode.task.LeetCodeTask;
import com.witalis.praxis.leetcode.task.h4.p342.option.*;
import com.witalis.praxis.leetcode.utils.LeetCode;
import com.witalis.praxis.leetcode.utils.TaskDifficulty;
import com.witalis.praxis.leetcode.utils.TaskRevision;

import lombok.extern.slf4j.Slf4j;
import java.util.concurrent.ThreadLocalRandom;

import static com.witalis.praxis.leetcode.utils.TaskTag.*;

@Slf4j
@LeetCode(
    id = 342,
    description = "Power of Four",
    difficulty = TaskDifficulty.EASY,
    tags = {MATH, BIT_MANIPULATION, RECURSION}
)
public class PowerOfFour extends LeetCodeTask<Boolean> {
    private int number;

    public static final String INFORMATION = """

        Given an integer n, return true if it is a power of four.
            Otherwise, return false.

        An integer n is a power of four,
            if there exists an integer x such that n == 4^x.

        Example:
            Input: n = 16
            Output: true""";

    public PowerOfFour(int id, String description, TaskRevision revision) {
        super(id, description, revision);
        initialization();
    }

    private void initialization() {
        this.number = generate();

        log.info("Number is {}", number);
    }

    private int generate() {
        return ThreadLocalRandom.current().nextInt(Integer.MIN_VALUE, Integer.MAX_VALUE);
    }

    @Override
    protected String getInformation() {
        return INFORMATION;
    }

    // time = 482 ms
    @Override
    protected Boolean original() {
        var original = new Original(number);
        return original.process();
    }

    // time = 473 ms
    @Override
    protected Boolean practice() {
        var practice = new Practice(number);
        return practice.process();
    }

    // time = 396 ms
    @Override
    protected Boolean solution() {
        var solution = new Solution(number);
        return solution.process();
    }
}
