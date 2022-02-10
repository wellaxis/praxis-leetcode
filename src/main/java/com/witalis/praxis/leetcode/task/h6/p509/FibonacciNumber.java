package com.witalis.praxis.leetcode.task.h6.p509;

import com.witalis.praxis.leetcode.task.LeetCodeTask;
import com.witalis.praxis.leetcode.task.h6.p509.option.*;
import com.witalis.praxis.leetcode.utils.LeetCode;
import com.witalis.praxis.leetcode.utils.TaskDifficulty;
import com.witalis.praxis.leetcode.utils.TaskRevision;

import lombok.extern.slf4j.Slf4j;
import java.util.concurrent.ThreadLocalRandom;

import static com.witalis.praxis.leetcode.utils.TaskTag.*;

@Slf4j
@LeetCode(
    id = 509,
    description = "Fibonacci Number",
    difficulty = TaskDifficulty.EASY,
    tags = {MATH, DYNAMIC_PROGRAMMING, RECURSION, MEMOIZATION}
)
public class FibonacciNumber extends LeetCodeTask<Integer> {
    public static final int LEN = 30;
    private int number;

    public static final String INFORMATION = """

        The Fibonacci numbers, commonly denoted F(n) form a sequence,
            called the Fibonacci sequence, such that each number
            is the sum of the two preceding ones, starting from 0 and 1.

        That is,
            F(0) = 0, F(1) = 1
            F(n) = F(n - 1) + F(n - 2), for n > 1.

        Given n, calculate F(n).

        Example:
            Input: n = 4
            Output: 3
            Explanation: F(4) = F(3) + F(2) = 2 + 1 = 3.""";

    public FibonacciNumber(int id, String description, TaskRevision revision) {
        super(id, description, revision);
        initialization();
    }

    private void initialization() {
        this.number = ThreadLocalRandom.current().nextInt(0, LEN + 1);

        log.info("Number: {}", number);
    }

    @Override
    protected String getInformation() {
        return INFORMATION;
    }

    // time = 991 ms
    @Override
    protected Integer original() {
        var original = new Original(number);
        return original.process();
    }

    // time = 2231 ms
    @Override
    protected Integer practice() {
        var practice = new Practice(number);
        return practice.process();
    }

    // time = 599 ms
    @Override
    protected Integer solution() {
        var solution = new Solution(number);
        return solution.process();
    }
}
