package com.witalis.praxis.leetcode.task.h4.p365;

import com.witalis.praxis.leetcode.task.LeetCodeTask;
import com.witalis.praxis.leetcode.task.h4.p365.option.*;
import com.witalis.praxis.leetcode.utils.LeetCode;
import com.witalis.praxis.leetcode.utils.TaskDifficulty;
import com.witalis.praxis.leetcode.utils.TaskRevision;

import lombok.extern.slf4j.Slf4j;
import java.util.concurrent.ThreadLocalRandom;

import static com.witalis.praxis.leetcode.utils.TaskTag.*;

@Slf4j
@LeetCode(
    id = 365,
    description = "Water and Jug Problem",
    difficulty = TaskDifficulty.MEDIUM,
    tags = {MATH, DEPTH_FIRST_SEARCH, BREADTH_FIRST_SEARCH}
)
public class WaterAndJugProblem extends LeetCodeTask<Boolean> {
    public static final int LEN = 1_000_000;

    private int capacity1;
    private int capacity2;
    private int capacity3;

    public static final String INFORMATION = """

        Description:
            You are given two jugs with capacities jug1Capacity and jug2Capacity liters.
                There is an infinite amount of water supply available.
                Determine whether it is possible to measure exactly targetCapacity liters using these two jugs.

            If targetCapacity liters of water are measurable, you must have targetCapacity liters of water
                contained within one or both buckets by the end.

            Operations allowed:
                * Fill any of the jugs with water.
                * Empty any of the jugs.
                * Pour water from one jug into another till the other jug is completely full, or the first jug itself is empty.

        Example:
            Input: jug1Capacity = 3, jug2Capacity = 5, targetCapacity = 4
            Output: true
            Explanation: The famous Die Hard example""";

    public WaterAndJugProblem(int id, String description, TaskRevision revision) {
        super(id, description, revision);
        initialization();
    }

    private void initialization() {
        final var random = ThreadLocalRandom.current();

        this.capacity1 = random.nextInt(1, LEN + 1);
        this.capacity2 = random.nextInt(1, LEN + 1);
        this.capacity3 = random.nextInt(1, LEN + 1);

        log.info("Capacity [Jag-1]: {}", capacity1);
        log.info("Capacity [Jag-2]: {}", capacity2);
        log.info("Capacity [Target]: {}", capacity3);
    }

    @Override
    protected String getInformation() {
        return INFORMATION;
    }

    // time = 722563 ms
    @Override
    protected Boolean original() {
        var original = new Original(capacity1, capacity2, capacity3);
        return original.process();
    }

    // time = 742190 ms
    @Override
    protected Boolean practice() {
        var practice = new Practice(capacity1, capacity2, capacity3);
        return practice.process();
    }

    // time = 124782 ms
    @Override
    protected Boolean solution() {
        var solution = new Solution(capacity1, capacity2, capacity3);
        return solution.process();
    }
}
