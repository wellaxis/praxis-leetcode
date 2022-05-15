package com.witalis.praxis.leetcode.task.h3.p264;

import com.witalis.praxis.leetcode.task.LeetCodeTask;
import com.witalis.praxis.leetcode.task.h3.p264.option.*;
import com.witalis.praxis.leetcode.utils.LeetCode;
import com.witalis.praxis.leetcode.utils.TaskDifficulty;
import com.witalis.praxis.leetcode.utils.TaskRevision;

import lombok.extern.slf4j.Slf4j;
import java.util.concurrent.ThreadLocalRandom;

import static com.witalis.praxis.leetcode.utils.TaskTag.*;

@Slf4j
@LeetCode(
    id = 264,
    description = "Ugly Number II",
    difficulty = TaskDifficulty.MEDIUM,
    tags = {MATH, HASH_TABLE, DYNAMIC_PROGRAMMING, HEAP}
)
public class UglyNumberII extends LeetCodeTask<Integer> {
    public static final int LEN = 1690;
    private int number;

    public static final String INFORMATION = """

        Description:
            An ugly number is a positive integer
                whose prime factors are limited to 2, 3, and 5.

            Given an integer n, return the nth ugly number.

        Example:
            Input: n = 10
            Output: 12
            Explanation: [1, 2, 3, 4, 5, 6, 8, 9, 10, 12] is the sequence of the first 10 ugly numbers.""";

    public UglyNumberII(int id, String description, TaskRevision revision) {
        super(id, description, revision);
        initialization();
    }

    private void initialization() {
        this.number = ThreadLocalRandom.current().nextInt(1, LEN + 1);

        log.info("Number is '{}'", number);
    }

    @Override
    protected String getInformation() {
        return INFORMATION;
    }

    // time = 1260 ms
    @Override
    protected Integer original() {
        var original = new Original(number);
        return original.process();
    }

    // time = 875 ms
    @Override
    protected Integer practice() {
        var practice = new Practice(number);
        return practice.process();
    }

    // time = 729 ms
    @Override
    protected Integer solution() {
        var solution = new Solution(number);
        return solution.process();
    }
}
