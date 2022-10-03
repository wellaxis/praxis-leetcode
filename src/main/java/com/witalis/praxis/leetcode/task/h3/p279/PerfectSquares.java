package com.witalis.praxis.leetcode.task.h3.p279;

import com.witalis.praxis.leetcode.task.LeetCodeTask;
import com.witalis.praxis.leetcode.task.h3.p279.option.*;
import com.witalis.praxis.leetcode.utils.LeetCode;
import com.witalis.praxis.leetcode.utils.TaskDifficulty;
import com.witalis.praxis.leetcode.utils.TaskRevision;

import lombok.extern.slf4j.Slf4j;
import java.util.concurrent.ThreadLocalRandom;

import static com.witalis.praxis.leetcode.utils.TaskTag.*;

@Slf4j
@LeetCode(
    id = 279,
    description = "Perfect Squares",
    difficulty = TaskDifficulty.MEDIUM,
    tags = {MATH, DYNAMIC_PROGRAMMING, BREADTH_FIRST_SEARCH}
)
public class PerfectSquares extends LeetCodeTask<Integer> {
    public static final int LEN = 10_000;
    private int number;

    public static final String INFORMATION = """

        Given an integer n, return the least number of perfect square numbers that sum to n.

        A perfect square is an integer that is the square of an integer;
            in other words, it is the product of some integer with itself.
            For example, 1, 4, 9, and 16 are perfect squares while 3 and 11 are not.

        Example:
            Input: n = 13
            Output: 2
            Explanation: 13 = 4 + 9.""";

    public PerfectSquares(int id, String description, TaskRevision revision) {
        super(id, description, revision);
        initialization();
    }

    private void initialization() {
        this.number = ThreadLocalRandom.current().nextInt(1, LEN + 1);

        log.info("Number is {}", number);
    }

    @Override
    protected String getInformation() {
        return INFORMATION;
    }

    // time = 1457 ms
    @Override
    protected Integer original() {
        var original = new Original(number);
        return original.process();
    }

    // time = 1251 ms
    @Override
    protected Integer practice() {
        var practice = new Practice(number);
        return practice.process();
    }

    // time = 412 ms
    @Override
    protected Integer solution() {
        var solution = new Solution(number);
        return solution.process();
    }
}
