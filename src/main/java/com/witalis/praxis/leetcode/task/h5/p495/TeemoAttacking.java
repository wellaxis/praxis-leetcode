package com.witalis.praxis.leetcode.task.h5.p495;

import com.witalis.praxis.leetcode.task.LeetCodeTask;
import com.witalis.praxis.leetcode.task.h5.p495.option.*;
import com.witalis.praxis.leetcode.utils.LeetCode;
import com.witalis.praxis.leetcode.utils.TaskDifficulty;
import com.witalis.praxis.leetcode.utils.TaskRevision;

import lombok.extern.slf4j.Slf4j;
import java.util.Arrays;
import java.util.concurrent.ThreadLocalRandom;

import static com.witalis.praxis.leetcode.utils.TaskTag.*;

@Slf4j
@LeetCode(
    id = 495,
    description = "Teemo ttacking",
    difficulty = TaskDifficulty.EASY,
    tags = {ARRAY, SIMULATION}
)
public class TeemoAttacking extends LeetCodeTask<Integer> {
    public static final int LEN = 10_000;
    public static final int VALUE = 10_000_000;
    private int[] timeSeries;
    private int duration;

    public static final String INFORMATION = """

        Our hero Teemo is attacking an enemy Ashe with poison attacks!
            When Teemo attacks Ashe, Ashe gets poisoned for a exactly duration seconds.
            More formally, an attack at second t will mean Ashe is poisoned
            during the inclusive time interval [t, t + duration - 1].
            If Teemo attacks again before the poison effect ends, the timer for it is reset,
            and the poison effect will end duration seconds after the new attack.

        You are given a non-decreasing integer array timeSeries, where timeSeries[i] denotes
            that Teemo attacks Ashe at second timeSeries[i], and an integer duration.

        Return the total number of seconds that Ashe is poisoned.

        Example:
            Input: timeSeries = [1,4], duration = 2
            Output: 4
            Explanation: Teemo's attacks on Ashe go as follows:
                - At second 1, Teemo attacks, and Ashe is poisoned for seconds 1 and 2.
                - At second 4, Teemo attacks, and Ashe is poisoned for seconds 4 and 5.
                Ashe is poisoned for seconds 1, 2, 4, and 5, which is 4 seconds in total.""";

    public TeemoAttacking(int id, String description, TaskRevision revision) {
        super(id, description, revision);
        initialization();
    }

    private void initialization() {
        final var random = ThreadLocalRandom.current();

        this.timeSeries = random.ints(
            random.nextInt(1, LEN + 1),
            0,
            VALUE + 1
        ).sorted().toArray();
        this.duration = random.nextInt(0, VALUE + 1);

        log.info("Time series are {}", Arrays.toString(timeSeries));
        log.info("Duration is {}", duration);
    }

    @Override
    protected String getInformation() {
        return INFORMATION;
    }

    // time = 1877 ms
    @Override
    protected Integer original() {
        var original = new Original(timeSeries.clone(), duration);
        return original.process();
    }

    // time = 1824 ms
    @Override
    protected Integer practice() {
        var practice = new Practice(timeSeries.clone(), duration);
        return practice.process();
    }

    // time = 1737 ms
    @Override
    protected Integer solution() {
        var solution = new Solution(timeSeries.clone(), duration);
        return solution.process();
    }
}
