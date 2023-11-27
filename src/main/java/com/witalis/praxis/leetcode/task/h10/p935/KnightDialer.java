package com.witalis.praxis.leetcode.task.h10.p935;

import com.witalis.praxis.leetcode.task.LeetCodeTask;
import com.witalis.praxis.leetcode.task.h10.p935.option.*;
import com.witalis.praxis.leetcode.utils.LeetCode;
import com.witalis.praxis.leetcode.utils.TaskDifficulty;
import com.witalis.praxis.leetcode.utils.TaskRevision;

import lombok.extern.slf4j.Slf4j;
import java.util.concurrent.ThreadLocalRandom;

import static com.witalis.praxis.leetcode.utils.TaskTag.*;

@Slf4j
@LeetCode(
    id = 935,
    description = "Knight Dialer",
    difficulty = TaskDifficulty.MEDIUM,
    tags = {DYNAMIC_PROGRAMMING}
)
public class KnightDialer extends LeetCodeTask<Integer> {
    public static final int LEN = 5_000;

    private int number;

    public static final String INFORMATION = """

        Description:
            The chess knight has a unique movement, it may move two squares vertically and one square horizontally,
                or two squares horizontally and one square vertically (with both forming the shape of an L).
                The possible movements of chess knight are shown in this diagram:

            A chess knight can move as indicated in the chess diagram below:

            We have a chess knight and a phone pad as shown below, the knight can only stand on a numeric cell (i.e. blue cell).

            Given an integer n, return how many distinct phone numbers of length n we can dial.

            You are allowed to place the knight on any numeric cell initially
                and then you should perform n - 1 jumps to dial a number of length n. All jumps should be valid knight jumps.

            As the answer may be very large, return the answer modulo 10^9 + 7.

        Example:
            Input: n = 2
            Output: 20
            Explanation: All the valid number we can dial are [04, 06, 16, 18, 27, 29, 34, 38, 40, 43, 49, 60, 61, 67, 72, 76, 81, 83, 92, 94]""";

    public KnightDialer(int id, String description, TaskRevision revision) {
        super(id, description, revision);
        initialization();
    }

    private void initialization() {
        final var random = ThreadLocalRandom.current();

        this.number = random.nextInt(1, LEN + 1);

        log.info("Number 'n': {}", number);
    }

    @Override
    protected String getInformation() {
        return INFORMATION;
    }

    // time = 6731 ms
    @Override
    protected Integer original() {
        var original = new Original(number);
        return original.process();
    }

    // time = 2371 ms
    @Override
    protected Integer practice() {
        var practice = new Practice(number);
        return practice.process();
    }

    // time = 656 ms
    @Override
    protected Integer solution() {
        var solution = new Solution(number);
        return solution.process();
    }
}
