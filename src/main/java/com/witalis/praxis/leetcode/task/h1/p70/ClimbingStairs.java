package com.witalis.praxis.leetcode.task.h1.p70;

import com.witalis.praxis.leetcode.task.LeetCodeTask;
import com.witalis.praxis.leetcode.task.h1.p70.option.*;
import com.witalis.praxis.leetcode.utils.LeetCode;
import com.witalis.praxis.leetcode.utils.TaskDifficulty;
import com.witalis.praxis.leetcode.utils.TaskRevision;

import lombok.extern.slf4j.Slf4j;
import java.util.concurrent.ThreadLocalRandom;

import static com.witalis.praxis.leetcode.utils.TaskTag.*;

@Slf4j
@LeetCode(
    id = 70,
    description = "Climbing Stairs",
    difficulty = TaskDifficulty.EASY,
    tags = {MATH, DYNAMIC_PROGRAMMING, MEMOIZATION}
)
public class ClimbingStairs extends LeetCodeTask<Integer> {
    public static final int STEPS = 45;
    private int number;

    public static final String INFORMATION = """

        You are climbing a staircase. It takes n steps to reach the top.

        Each time you can either climb 1 or 2 steps.
            In how many distinct ways can you climb to the top?

        Example:
            Input: n = 3
            Output: 3
            Explanation: There are three ways to climb to the top.
                1. 1 step + 1 step + 1 step
                2. 1 step + 2 steps
                3. 2 steps + 1 step""";

    public ClimbingStairs(int id, String description, TaskRevision revision) {
        super(id, description, revision);
        initialization();
    }

    private void initialization() {
        this.number = ThreadLocalRandom.current().nextInt(1, STEPS + 1);

        log.info("Number is '{}'", number);
    }

    @Override
    protected String getInformation() {
        return INFORMATION;
    }

    // time = 572 ms, memory limit exceeded
    @Override
    protected Integer original() {
        var original = new Original(number);
        return original.process();
    }

    // time = 475 ms
    @Override
    protected Integer practice() {
        var practice = new Practice(number);
        return practice.process();
    }

    // time = 463 ms
    @Override
    protected Integer solution() {
        var solution = new Solution(number);
        return solution.process();
    }
}
