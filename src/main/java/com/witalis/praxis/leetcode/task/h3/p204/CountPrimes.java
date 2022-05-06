package com.witalis.praxis.leetcode.task.h3.p204;

import com.witalis.praxis.leetcode.task.LeetCodeTask;
import com.witalis.praxis.leetcode.task.h3.p204.option.*;
import com.witalis.praxis.leetcode.utils.LeetCode;
import com.witalis.praxis.leetcode.utils.TaskDifficulty;
import com.witalis.praxis.leetcode.utils.TaskRevision;

import lombok.extern.slf4j.Slf4j;
import java.util.concurrent.ThreadLocalRandom;

import static com.witalis.praxis.leetcode.utils.TaskTag.*;

@Slf4j
@LeetCode(
    id = 204,
    description = "Count Primes",
    difficulty = TaskDifficulty.EASY,
    tags = {ARRAY, MATH, ENUMERATION, NUMBER_THEORY}
)
public class CountPrimes extends LeetCodeTask<Integer> {
    public static final int LEN = 5 * (int) Math.pow(10, 6);
    private int number;

    public static final String INFORMATION = """

        Given an integer n, return the number of prime numbers that are strictly less than n.

        Example:
            Input: n = 10
            Output: 4
            Explanation: There are 4 prime numbers less than 10, they are 2, 3, 5, 7.""";

    public CountPrimes(int id, String description, TaskRevision revision) {
        super(id, description, revision);
        initialization();
    }

    private void initialization() {
        this.number = generate();

        log.info("Number is {}", number);
    }

    private int generate() {
        return ThreadLocalRandom.current().nextInt(0, LEN + 1);
    }

    @Override
    protected String getInformation() {
        return INFORMATION;
    }

    // time = 31369 ms, time limit exceeded
    @Override
    protected Integer original() {
        var original = new Original(number);
        return original.process();
    }

    // time = 5141 ms
    @Override
    protected Integer practice() {
        var practice = new Practice(number);
        return practice.process();
    }

    // time = 3650 ms
    @Override
    protected Integer solution() {
        var solution = new Solution(number);
        return solution.process();
    }
}
