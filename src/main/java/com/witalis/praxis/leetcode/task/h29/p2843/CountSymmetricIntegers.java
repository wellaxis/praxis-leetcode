package com.witalis.praxis.leetcode.task.h29.p2843;

import com.witalis.praxis.leetcode.task.LeetCodeTask;
import com.witalis.praxis.leetcode.task.h29.p2843.option.*;
import com.witalis.praxis.leetcode.utils.LeetCode;
import com.witalis.praxis.leetcode.utils.TaskDifficulty;
import com.witalis.praxis.leetcode.utils.TaskRevision;

import lombok.extern.slf4j.Slf4j;
import java.util.concurrent.ThreadLocalRandom;

import static com.witalis.praxis.leetcode.utils.TaskTag.*;

@Slf4j
@LeetCode(
    id = 2843,
    description = "Count Symmetric Integers",
    difficulty = TaskDifficulty.EASY,
    tags = {MATH, ENUMERATION}
)
public class CountSymmetricIntegers extends LeetCodeTask<Integer> {
    public static final int VALUE = 10_000;

    private int low;
    private int high;

    public static final String INFORMATION = """

        Description:
            You are given two positive integers low and high.

            An integer x consisting of 2 * n digits is symmetric if the sum of the first n digits of x is equal
                to the sum of the last n digits of x. Numbers with an odd number of digits are never symmetric.

            Return the number of symmetric integers in the range [low, high].

        Example:
            Input: low = 1200, high = 1230
            Output: 4
            Explanation: There are 4 symmetric integers between 1200 and 1230: 1203, 1212, 1221, and 1230.""";

    public CountSymmetricIntegers(int id, String description, TaskRevision revision) {
        super(id, description, revision);
        initialization();
    }

    private void initialization() {
        final var random = ThreadLocalRandom.current();

        this.low = random.nextInt(1, VALUE + 1);
        this.high = random.nextInt(low, VALUE + 1);

        log.info("Low: {}", low);
        log.info("High: {}", high);
    }

    @Override
    protected String getInformation() {
        return INFORMATION;
    }

    // time = 2383 ms
    @Override
    protected Integer original() {
        var original = new Original(low, high);
        return original.process();
    }

    // time = 1297 ms
    @Override
    protected Integer practice() {
        var practice = new Practice(low, high);
        return practice.process();
    }

    // time = 1098 ms
    @Override
    protected Integer solution() {
        var solution = new Solution(low, high);
        return solution.process();
    }
}
