package com.witalis.praxis.leetcode.task.h2.p172;

import com.witalis.praxis.leetcode.task.LeetCodeTask;
import com.witalis.praxis.leetcode.task.h2.p172.option.*;
import com.witalis.praxis.leetcode.utils.LeetCode;
import com.witalis.praxis.leetcode.utils.TaskDifficulty;
import com.witalis.praxis.leetcode.utils.TaskRevision;

import lombok.extern.slf4j.Slf4j;
import java.util.concurrent.ThreadLocalRandom;

import static com.witalis.praxis.leetcode.utils.TaskTag.*;

@Slf4j
@LeetCode(
    id = 172,
    description = "Factorial Trailing Zeroes",
    difficulty = TaskDifficulty.MEDIUM,
    tags = {MATH}
)
public class FactorialTrailingZeroes extends LeetCodeTask<Integer> {
    public static final int LEN = 10_000;
    private int number;

    public static final String INFORMATION = """

        Given an integer n, return the number of trailing zeroes in n!.

        Note that n! = n * (n - 1) * (n - 2) * ... * 3 * 2 * 1.

        Example:
            Input: n = 5
            Output: 1
            Explanation: 5! = 120, one trailing zero.""";

    public FactorialTrailingZeroes(int id, String description, TaskRevision revision) {
        super(id, description, revision);
        initialization();
    }

    private void initialization() {
        final var random = ThreadLocalRandom.current();

        this.number = random.nextInt(0, LEN + 1);

        log.info("Number is {}", number);
    }

    @Override
    protected String getInformation() {
        return INFORMATION;
    }

    // time = 660 ms
    @Override
    protected Integer original() {
        var original = new Original(number);
        return original.process();
    }

    // time = 349 ms
    @Override
    protected Integer practice() {
        var practice = new Practice(number);
        return practice.process();
    }

    // time = 344 ms
    @Override
    protected Integer solution() {
        var solution = new Solution(number);
        return solution.process();
    }
}
