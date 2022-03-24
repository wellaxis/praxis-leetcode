package com.witalis.praxis.leetcode.task.h3.p231;

import com.witalis.praxis.leetcode.task.LeetCodeTask;
import com.witalis.praxis.leetcode.task.h3.p231.option.*;
import com.witalis.praxis.leetcode.utils.LeetCode;
import com.witalis.praxis.leetcode.utils.TaskDifficulty;
import com.witalis.praxis.leetcode.utils.TaskRevision;

import lombok.extern.slf4j.Slf4j;
import java.util.concurrent.ThreadLocalRandom;

import static com.witalis.praxis.leetcode.utils.TaskTag.*;

@Slf4j
@LeetCode(
    id = 231,
    description = "Power of Two",
    difficulty = TaskDifficulty.EASY,
    tags = {MATH, BIT_MANIPULATION, RECURSION}
)
public class PowerOfTwo extends LeetCodeTask<Boolean> {
    private int number;

    public static final String INFORMATION = """

        Given an integer n, return true if it is a power of two.
            Otherwise, return false.

        An integer n is a power of two,
           if there exists an integer x such that n == 2^x.

        Example:
            Input: n = 16
            Output: true
            Explanation: 2^4 = 16""";

    public PowerOfTwo(int id, String description, TaskRevision revision) {
        super(id, description, revision);
        initialization();
    }

    private void initialization() {
        this.number = ThreadLocalRandom.current().nextInt(
            Integer.MIN_VALUE,
            Integer.MAX_VALUE
        );

        log.info("Number is {}", number);
    }

    @Override
    protected String getInformation() {
        return INFORMATION;
    }

    // time = 738 ms
    @Override
    protected Boolean original() {
        var original = new Original(number);
        return original.process();
    }

    // time = 651 ms
    @Override
    protected Boolean practice() {
        var practice = new Practice(number);
        return practice.process();
    }

    // time = 562 ms
    @Override
    protected Boolean solution() {
        var solution = new Solution(number);
        return solution.process();
    }
}
