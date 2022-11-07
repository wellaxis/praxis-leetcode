package com.witalis.praxis.leetcode.task.h14.p1323;

import com.witalis.praxis.leetcode.task.LeetCodeTask;
import com.witalis.praxis.leetcode.task.h14.p1323.option.*;
import com.witalis.praxis.leetcode.utils.LeetCode;
import com.witalis.praxis.leetcode.utils.TaskDifficulty;
import com.witalis.praxis.leetcode.utils.TaskRevision;

import lombok.extern.slf4j.Slf4j;
import java.util.concurrent.ThreadLocalRandom;

import static com.witalis.praxis.leetcode.utils.TaskTag.*;

@Slf4j
@LeetCode(
    id = 1323,
    description = "Maximum 69 Number",
    difficulty = TaskDifficulty.EASY,
    tags = {MATH, GREEDY}
)
public class Maximum69Number extends LeetCodeTask<Integer> {
    public static final int LEN = 10_000;
    private int number;

    public static final String INFORMATION = """

        Description:
            You are given a positive integer num consisting only of digits 6 and 9.

            Return the maximum number you can get by changing at most one digit (6 becomes 9, and 9 becomes 6).

        Example:
            Input: num = 9669
            Output: 9969
            Explanation:
                Changing the first digit results in 6669.
                Changing the second digit results in 9969.
                Changing the third digit results in 9699.
                Changing the fourth digit results in 9666.
                The maximum number is 9969.""";

    public Maximum69Number(int id, String description, TaskRevision revision) {
        super(id, description, revision);
        initialization();
    }

    private void initialization() {
        final var random = ThreadLocalRandom.current();

        this.number = 0;
        while (number <= LEN) {
            number *= 10;
            number += random.nextBoolean() ? 6 : 9;
        }

        log.info("Number is {}", number);
    }

    @Override
    protected String getInformation() {
        return INFORMATION;
    }

    // time = 525 ms
    @Override
    protected Integer original() {
        var original = new Original(number);
        return original.process();
    }

    // time = 398 ms
    @Override
    protected Integer practice() {
        var practice = new Practice(number);
        return practice.process();
    }

    // time = 422 ms
    @Override
    protected Integer solution() {
        var solution = new Solution(number);
        return solution.process();
    }
}
