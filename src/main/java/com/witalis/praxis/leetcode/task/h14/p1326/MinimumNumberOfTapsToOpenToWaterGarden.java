package com.witalis.praxis.leetcode.task.h14.p1326;

import com.witalis.praxis.leetcode.task.LeetCodeTask;
import com.witalis.praxis.leetcode.task.h14.p1326.option.*;
import com.witalis.praxis.leetcode.utils.LeetCode;
import com.witalis.praxis.leetcode.utils.TaskDifficulty;
import com.witalis.praxis.leetcode.utils.TaskRevision;

import lombok.extern.slf4j.Slf4j;
import java.util.Arrays;
import java.util.concurrent.ThreadLocalRandom;

import static com.witalis.praxis.leetcode.utils.TaskTag.*;

@Slf4j
@LeetCode(
    id = 1326,
    description = "Minimum Number of Taps to Open to Water a Garden",
    difficulty = TaskDifficulty.HARD,
    tags = {ARRAY, DYNAMIC_PROGRAMMING, GREEDY}
)
public class MinimumNumberOfTapsToOpenToWaterGarden extends LeetCodeTask<Integer> {
    public static final int LEN = 10_000;
    public static final int VALUE = 100;

    private int points;
    private int[] ranges;

    public static final String INFORMATION = """

        Description:
            There is a one-dimensional garden on the x-axis.
                The garden starts at the point 0 and ends at the point n. (i.e The length of the garden is n).

            There are n + 1 taps located at points [0, 1, ..., n] in the garden.

            Given an integer n and an integer array ranges of length n + 1 where
                ranges[i] (0-indexed) means the i-th tap can water the area [i - ranges[i], i + ranges[i]] if it was open.

            Return the minimum number of taps that should be open to water the whole garden,
                If the garden cannot be watered return -1.

        Example:
            Input: n = 5, ranges = [3,4,1,1,0,0]
            Output: 1
            Explanation:
                The tap at point 0 can cover the interval [-3,3]
                The tap at point 1 can cover the interval [-3,5]
                The tap at point 2 can cover the interval [1,3]
                The tap at point 3 can cover the interval [2,4]
                The tap at point 4 can cover the interval [4,4]
                The tap at point 5 can cover the interval [5,5]
                Opening Only the second tap will water the whole garden [0,5]""";

    public MinimumNumberOfTapsToOpenToWaterGarden(int id, String description, TaskRevision revision) {
        super(id, description, revision);
        initialization();
    }

    private void initialization() {
        final var random = ThreadLocalRandom.current();

        this.points = random.nextInt(1, LEN + 1);
        this.ranges = random.ints(
            points + 1L, 0, VALUE + 1
        ).toArray();

        log.info("Points n: {}", points);
        log.info("Ranges: {}", Arrays.toString(ranges));
    }

    @Override
    protected String getInformation() {
        return INFORMATION;
    }

    // time = 732 ms
    @Override
    protected Integer original() {
        var original = new Original(points, ranges);
        return original.process();
    }

    // time = 724 ms
    @Override
    protected Integer practice() {
        var practice = new Practice(points, ranges);
        return practice.process();
    }

    // time = 627 ms
    @Override
    protected Integer solution() {
        var solution = new Solution(points, ranges);
        return solution.process();
    }
}
