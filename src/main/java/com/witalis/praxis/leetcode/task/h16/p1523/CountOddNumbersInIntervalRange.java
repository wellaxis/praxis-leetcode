package com.witalis.praxis.leetcode.task.h16.p1523;

import com.witalis.praxis.leetcode.task.LeetCodeTask;
import com.witalis.praxis.leetcode.task.h16.p1523.option.*;
import com.witalis.praxis.leetcode.utils.LeetCode;
import com.witalis.praxis.leetcode.utils.TaskDifficulty;
import com.witalis.praxis.leetcode.utils.TaskRevision;

import lombok.extern.slf4j.Slf4j;
import java.util.Arrays;
import java.util.concurrent.ThreadLocalRandom;

import static com.witalis.praxis.leetcode.utils.TaskTag.*;

@Slf4j
@LeetCode(
    id = 1523,
    description = "Count Odd Numbers in an Interval Range",
    difficulty = TaskDifficulty.EASY,
    tags = {MATH}
)
public class CountOddNumbersInIntervalRange extends LeetCodeTask<Integer> {
    public static final int VALUE = (int) Math.pow(10, 9);

    private int low;
    private int high;

    public static final String INFORMATION = """

        Description:
            Given two non-negative integers low and high.
                Return the count of odd numbers between low and high (inclusive).

        Example:
            Input: low = 3, high = 7
            Output: 3
            Explanation: The odd numbers between 3 and 7 are [3,5,7].""";

    public CountOddNumbersInIntervalRange(int id, String description, TaskRevision revision) {
        super(id, description, revision);
        initialization();
    }

    private void initialization() {
        final var random = ThreadLocalRandom.current();

        this.low = random.nextInt(1, VALUE + 1);
        this.high = random.nextInt(1, VALUE + 1);
        if (low > high) {
            low = low + high - (high = low);
        }

        log.info("Low: {}", low);
        log.info("High: {}", high);
    }

    @Override
    protected String getInformation() {
        return INFORMATION;
    }

    // time = 448 ms
    @Override
    protected Integer original() {
        var original = new Original(low, high);
        return original.process();
    }

    // time = 441 ms
    @Override
    protected Integer practice() {
        var practice = new Practice(low, high);
        return practice.process();
    }

    // time = 447 ms
    @Override
    protected Integer solution() {
        var solution = new Solution(low, high);
        return solution.process();
    }
}
