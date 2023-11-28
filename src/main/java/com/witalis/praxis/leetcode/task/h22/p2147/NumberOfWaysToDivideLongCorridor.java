package com.witalis.praxis.leetcode.task.h22.p2147;

import com.witalis.praxis.leetcode.task.LeetCodeTask;
import com.witalis.praxis.leetcode.task.h22.p2147.option.*;
import com.witalis.praxis.leetcode.utils.LeetCode;
import com.witalis.praxis.leetcode.utils.TaskDifficulty;
import com.witalis.praxis.leetcode.utils.TaskRevision;

import lombok.extern.slf4j.Slf4j;
import java.util.concurrent.ThreadLocalRandom;

import static com.witalis.praxis.leetcode.utils.TaskTag.*;

@Slf4j
@LeetCode(
    id = 2147,
    description = "Number of Ways to Divide a Long Corridor",
    difficulty = TaskDifficulty.HARD,
    tags = {MATH, STRING, DYNAMIC_PROGRAMMING}
)
public class NumberOfWaysToDivideLongCorridor extends LeetCodeTask<Integer> {
    public static final int LEN = 100_000;

    private String corridor;

    public static final String INFORMATION = """

        Description:
            Along a long library corridor, there is a line of seats and decorative plants.
                You are given a 0-indexed string corridor of length n consisting of letters 'S' and 'P'
                where each 'S' represents a seat and each 'P' represents a plant.

            One room divider has already been installed to the left of index 0, and another to the right of index n - 1.
                Additional room dividers can be installed.
                For each position between indices i - 1 and i (1 <= i <= n - 1), at most one divider can be installed.

            Divide the corridor into non-overlapping sections, where each section has exactly two seats
                with any number of plants. There may be multiple ways to perform the division.
                Two ways are different if there is a position with a room divider
                installed in the first way but not in the second way.

            Return the number of ways to divide the corridor.
                Since the answer may be very large, return it modulo 109 + 7. If there is no way, return 0.

        Example:
            Input: corridor = "SSPPSPS"
            Output: 3
            Explanation: There are 3 different ways to divide the corridor.
                The black bars in the above image indicate the two room dividers already installed.
                Note that in each of the ways, each section has exactly two seats.""";

    public NumberOfWaysToDivideLongCorridor(int id, String description, TaskRevision revision) {
        super(id, description, revision);
        initialization();
    }

    private void initialization() {
        final var random = ThreadLocalRandom.current();

        int len = random.nextInt(1, LEN + 1);
        var builder = new StringBuilder();
        for (int i = 0; i < len; i++) {
            if (random.nextBoolean()) {
                builder.append('S');
            } else {
                builder.append('P');
            }
        }
        this.corridor = builder.toString();

        log.info("Corridor: {}", corridor);
    }

    @Override
    protected String getInformation() {
        return INFORMATION;
    }

    // time = 3535 ms
    @Override
    protected Integer original() {
        var original = new Original(corridor);
        return original.process();
    }

    // time = 3029 ms
    @Override
    protected Integer practice() {
        var practice = new Practice(corridor);
        return practice.process();
    }

    // time = 4025 ms
    @Override
    protected Integer solution() {
        var solution = new Solution(corridor);
        return solution.process();
    }
}
