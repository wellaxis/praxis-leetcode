package com.witalis.praxis.leetcode.task.h3.p202;

import com.witalis.praxis.leetcode.task.LeetCodeTask;
import com.witalis.praxis.leetcode.task.h3.p202.option.*;
import com.witalis.praxis.leetcode.utils.LeetCode;
import com.witalis.praxis.leetcode.utils.TaskDifficulty;
import com.witalis.praxis.leetcode.utils.TaskRevision;

import lombok.extern.slf4j.Slf4j;
import java.util.concurrent.ThreadLocalRandom;

import static com.witalis.praxis.leetcode.utils.TaskTag.*;

@Slf4j
@LeetCode(
    id = 202,
    description = "Happy Number",
    difficulty = TaskDifficulty.EASY,
    tags = {HASH_TABLE, MATH, TWO_POINTERS}
)
public class HappyNumber extends LeetCodeTask<Boolean> {
    private int number;

    public static final String INFORMATION = """

        Write an algorithm to determine if a number n is happy.

        A happy number is a number defined by the following process:
        * Starting with any positive integer,
            replace the number by the sum of the squares of its digits.
        * Repeat the process until the number equals 1 (where it will stay),
            or it loops endlessly in a cycle which does not include 1.
        * Those numbers for which this process ends in 1 are happy.

        Return true if n is a happy number, and false if not.

        Example:
            Input: n = 19
            Output: true
            Explanation:
                1^2 + 9^2 = 82
                8^2 + 2^2 = 68
                6^2 + 8^2 = 100
                1^2 + 0^2 + 0^2 = 1""";

    public HappyNumber(int id, String description, TaskRevision revision) {
        super(id, description, revision);
        initialization();
    }

    private void initialization() {
        this.number = generate();

        log.info("Number is {}", number);
    }

    private int generate() {
        return ThreadLocalRandom.current().nextInt(1, Integer.MAX_VALUE);
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
