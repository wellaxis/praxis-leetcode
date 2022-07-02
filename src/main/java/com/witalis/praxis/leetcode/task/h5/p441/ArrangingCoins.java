package com.witalis.praxis.leetcode.task.h5.p441;

import com.witalis.praxis.leetcode.task.LeetCodeTask;
import com.witalis.praxis.leetcode.task.h5.p441.option.*;
import com.witalis.praxis.leetcode.utils.LeetCode;
import com.witalis.praxis.leetcode.utils.TaskDifficulty;
import com.witalis.praxis.leetcode.utils.TaskRevision;

import lombok.extern.slf4j.Slf4j;
import java.util.concurrent.ThreadLocalRandom;

import static com.witalis.praxis.leetcode.utils.TaskTag.*;

@Slf4j
@LeetCode(
    id = 441,
    description = "Arranging Coins",
    difficulty = TaskDifficulty.EASY,
    tags = {MATH, BINARY_SEARCH}
)
public class ArrangingCoins extends LeetCodeTask<Integer> {
    private int number;

    public static final String INFORMATION = """

        You have n coins and you want to build a staircase with these coins.
            The staircase consists of k rows where the ith row has exactly i coins.
            The last row of the staircase may be incomplete.

        Given the integer n, return the number of complete rows of the staircase you will build.

        Example:
            Input: n = 8
            Output: 3
            Explanation: Because the 4th row is incomplete, we return 3.""";

    public ArrangingCoins(int id, String description, TaskRevision revision) {
        super(id, description, revision);
        initialization();
    }

    private void initialization() {
        final var random = ThreadLocalRandom.current();
        this.number = random.nextInt(1, Integer.MAX_VALUE);

        log.info("Number is '{}'", number);
    }

    @Override
    protected String getInformation() {
        return INFORMATION;
    }

    // time = 1402 ms
    @Override
    protected Integer original() {
        var original = new Original(number);
        return original.process();
    }

    // time = 469 ms
    @Override
    protected Integer practice() {
        var practice = new Practice(number);
        return practice.process();
    }

    // time = 415 ms
    @Override
    protected Integer solution() {
        var solution = new Solution(number);
        return solution.process();
    }
}
