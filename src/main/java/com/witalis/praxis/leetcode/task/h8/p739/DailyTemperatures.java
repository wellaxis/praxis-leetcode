package com.witalis.praxis.leetcode.task.h8.p739;

import com.witalis.praxis.leetcode.task.LeetCodeTask;
import com.witalis.praxis.leetcode.task.h8.p739.option.*;
import com.witalis.praxis.leetcode.utils.LeetCode;
import com.witalis.praxis.leetcode.utils.TaskDifficulty;
import com.witalis.praxis.leetcode.utils.TaskRevision;

import lombok.extern.slf4j.Slf4j;
import java.util.Arrays;
import java.util.concurrent.ThreadLocalRandom;

import static com.witalis.praxis.leetcode.utils.TaskTag.*;

@Slf4j
@LeetCode(
    id = 739,
    description = "Daily Temperatures",
    difficulty = TaskDifficulty.MEDIUM,
    tags = {ARRAY, STACK, MONOTONIC_STACK}
)
public class DailyTemperatures extends LeetCodeTask<int[]> {
    public static final int LEN = 100_000;
    public static final int MIN_VALUE = 30;
    public static final int MAX_VALUE = 100;

    private int[] temperatures;

    public static final String INFORMATION = """

        Description:
            Given an array of integers temperatures represents the daily temperatures,
                return an array answer such that answer[i] is the number of days
                you have to wait after the ith day to get a warmer temperature.
                If there is no future day for which this is possible, keep answer[i] == 0 instead.

        Example:
            Input: temperatures = [73,74,75,71,69,72,76,73]
            Output: [1,1,4,2,1,1,0,0]""";

    public DailyTemperatures(int id, String description, TaskRevision revision) {
        super(id, description, revision);
        initialization();
    }

    private void initialization() {
        final var random = ThreadLocalRandom.current();

        this.temperatures = random.ints(
                random.nextInt(1, LEN + 1),
                MIN_VALUE, MAX_VALUE + 1
            )
            .toArray();

        log.info("Temperatures: {}", Arrays.toString(temperatures));
    }

    @Override
    protected String getInformation() {
        return INFORMATION;
    }

    // time = 119022 ms
    @Override
    protected int[] original() {
        var original = new Original(temperatures);
        return original.process();
    }

    // time = 11593 ms
    @Override
    protected int[] practice() {
        var practice = new Practice(temperatures);
        return practice.process();
    }

    // time = 2571 ms
    @Override
    protected int[] solution() {
        var solution = new Solution(temperatures);
        return solution.process();
    }
}
