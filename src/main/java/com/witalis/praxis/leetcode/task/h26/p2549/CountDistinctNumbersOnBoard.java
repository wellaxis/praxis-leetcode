package com.witalis.praxis.leetcode.task.h26.p2549;

import com.witalis.praxis.leetcode.task.LeetCodeTask;
import com.witalis.praxis.leetcode.task.h26.p2549.option.*;
import com.witalis.praxis.leetcode.utils.LeetCode;
import com.witalis.praxis.leetcode.utils.TaskDifficulty;
import com.witalis.praxis.leetcode.utils.TaskRevision;

import lombok.extern.slf4j.Slf4j;
import java.util.Arrays;
import java.util.concurrent.ThreadLocalRandom;

import static com.witalis.praxis.leetcode.utils.TaskTag.*;

@Slf4j
@LeetCode(
    id = 2549,
    description = "Count Distinct Numbers on Board",
    difficulty = TaskDifficulty.EASY,
    tags = {ARRAY, HASH_TABLE, MATH, SIMULATION}
)
public class CountDistinctNumbersOnBoard extends LeetCodeTask<Integer> {
    public static final int LEN = 100;

    private int number;

    public static final String INFORMATION = """

        Description:
            You are given a positive integer n, that is initially placed on a board.
                Every day, for 109 days, you perform the following procedure:
                * For each number x present on the board, find all numbers 1 <= i <= n such that x % i == 1.
                * Then, place those numbers on the board.

            Return the number of distinct integers present on the board after 109 days have elapsed.

            Note:
                * Once a number is placed on the board, it will remain on it until the end.
                * % stands for the modulo operation. For example, 14 % 3 is 2.

        Example:
            Input: n = 5
            Output: 4
            Explanation: Initially, 5 is present on the board.
                The next day, 2 and 4 will be added since 5 % 2 == 1 and 5 % 4 == 1.
                After that day, 3 will be added to the board because 4 % 3 == 1.
                At the end of a billion days, the distinct numbers on the board will be 2, 3, 4, and 5.""";

    public CountDistinctNumbersOnBoard(int id, String description, TaskRevision revision) {
        super(id, description, revision);
        initialization();
    }

    private void initialization() {
        final var random = ThreadLocalRandom.current();

        this.number = random.nextInt(1, LEN + 1);

        log.info("Number: {}", number);
    }

    @Override
    protected String getInformation() {
        return INFORMATION;
    }

    // time = 1556 ms
    @Override
    protected Integer original() {
        var original = new Original(number);
        return original.process();
    }

    // time = 1500 ms
    @Override
    protected Integer practice() {
        var practice = new Practice(number);
        return practice.process();
    }

    // time = 575 ms
    @Override
    protected Integer solution() {
        var solution = new Solution(number);
        return solution.process();
    }
}
