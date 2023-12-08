package com.witalis.praxis.leetcode.task.h25.p2413;

import com.witalis.praxis.leetcode.task.LeetCodeTask;
import com.witalis.praxis.leetcode.task.h25.p2413.option.*;
import com.witalis.praxis.leetcode.utils.LeetCode;
import com.witalis.praxis.leetcode.utils.TaskDifficulty;
import com.witalis.praxis.leetcode.utils.TaskRevision;

import lombok.extern.slf4j.Slf4j;
import java.util.concurrent.ThreadLocalRandom;

import static com.witalis.praxis.leetcode.utils.TaskTag.*;

@Slf4j
@LeetCode(
    id = 2413,
    description = "Smallest Even Multiple",
    difficulty = TaskDifficulty.EASY,
    tags = {MATH, NUMBER_THEORY}
)
public class SmallestEvenMultiple extends LeetCodeTask<Integer> {
    public static final int VALUE = 150;

    private int number;

    public static final String INFORMATION = """

        Description:
            Given a positive integer n, return the smallest positive integer that is a multiple of both 2 and n.

        Example:
            Input: n = 5
            Output: 10
            Explanation: The smallest multiple of both 5 and 2 is 10.""";

    public SmallestEvenMultiple(int id, String description, TaskRevision revision) {
        super(id, description, revision);
        initialization();
    }

    private void initialization() {
        final var random = ThreadLocalRandom.current();

        this.number = random.nextInt(1, VALUE + 1);

        log.info("Number 'n': {}", number);
    }

    @Override
    protected String getInformation() {
        return INFORMATION;
    }

    // time = 536 ms
    @Override
    protected Integer original() {
        var original = new Original(number);
        return original.process();
    }

    // time = 486 ms
    @Override
    protected Integer practice() {
        var practice = new Practice(number);
        return practice.process();
    }

    // time = 482 ms
    @Override
    protected Integer solution() {
        var solution = new Solution(number);
        return solution.process();
    }
}
