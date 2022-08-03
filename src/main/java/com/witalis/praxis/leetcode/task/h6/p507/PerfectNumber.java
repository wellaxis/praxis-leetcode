package com.witalis.praxis.leetcode.task.h6.p507;

import com.witalis.praxis.leetcode.task.LeetCodeTask;
import com.witalis.praxis.leetcode.task.h6.p507.option.*;
import com.witalis.praxis.leetcode.utils.LeetCode;
import com.witalis.praxis.leetcode.utils.TaskDifficulty;
import com.witalis.praxis.leetcode.utils.TaskRevision;

import lombok.extern.slf4j.Slf4j;
import java.util.concurrent.ThreadLocalRandom;

import static com.witalis.praxis.leetcode.utils.TaskTag.*;

@Slf4j
@LeetCode(
    id = 507,
    description = "Perfect Number",
    difficulty = TaskDifficulty.EASY,
    tags = {MATH}
)
public class PerfectNumber extends LeetCodeTask<Boolean> {
    public static final int LEN = (int) Math.pow(10, 8);
    private int number;

    public static final String INFORMATION = """

        A perfect number is a positive integer that is equal to the sum of its positive divisors,
            excluding the number itself. A divisor of an integer x is an integer that can divide x evenly.

        Given an integer n, return true if n is a perfect number, otherwise return false.

        Example:
            Input: num = 28
            Output: true
            Explanation: 28 = 1 + 2 + 4 + 7 + 14
                1, 2, 4, 7, and 14 are all divisors of 28.""";

    public PerfectNumber(int id, String description, TaskRevision revision) {
        super(id, description, revision);
        initialization();
    }

    private void initialization() {
        this.number = ThreadLocalRandom.current().nextInt(1, LEN + 1);

        log.info("Number: {}", number);
    }

    @Override
    protected String getInformation() {
        return INFORMATION;
    }

    // time = 5943 ms
    @Override
    protected Boolean original() {
        var original = new Original(number);
        return original.process();
    }

    // time = 5412 ms
    @Override
    protected Boolean practice() {
        var practice = new Practice(number);
        return practice.process();
    }

    // time = 563 ms
    @Override
    protected Boolean solution() {
        var solution = new Solution(number);
        return solution.process();
    }
}
