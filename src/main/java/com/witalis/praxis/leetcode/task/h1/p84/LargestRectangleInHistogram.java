package com.witalis.praxis.leetcode.task.h1.p84;

import com.witalis.praxis.leetcode.task.LeetCodeTask;
import com.witalis.praxis.leetcode.task.h1.p84.option.*;
import com.witalis.praxis.leetcode.utils.LeetCode;
import com.witalis.praxis.leetcode.utils.TaskDifficulty;
import com.witalis.praxis.leetcode.utils.TaskRevision;

import lombok.extern.slf4j.Slf4j;
import java.util.Arrays;
import java.util.concurrent.ThreadLocalRandom;

import static com.witalis.praxis.leetcode.utils.TaskTag.*;

@Slf4j
@LeetCode(
    id = 84,
    description = "Largest Rectangle in Histogram",
    difficulty = TaskDifficulty.HARD,
    tags = {ARRAY, STACK, MONOTONIC_STACK}
)
public class LargestRectangleInHistogram extends LeetCodeTask<Integer> {
    public static final int LEN = 100_000;
    public static final int VALUE = 10_000;
    private int[] heights;

    public static final String INFORMATION = """

        Given an array of integers heights representing the histogram's bar height
            where the width of each bar is 1,
            return the area of the largest rectangle in the histogram.

        Example:
            Input: heights = [2,1,5,6,2,3]
            Output: 10
            Explanation: The above is a histogram where width of each bar is 1.
                The largest rectangle is shown in the red area, which has an area = 10 units.""";

    public LargestRectangleInHistogram(int id, String description, TaskRevision revision) {
        super(id, description, revision);
        initialization();
    }

    private void initialization() {
        var random = ThreadLocalRandom.current();

        this.heights = random.ints(
            random.nextInt(1, LEN + 1),
            0,
            VALUE + 1
        ).toArray();

        log.info("Heights are {}", Arrays.toString(heights));
    }

    @Override
    protected String getInformation() {
        return INFORMATION;
    }

    // time = 16441 ms, time limit exceeded
    @Override
    protected Integer original() {
        var original = new Original(heights.clone());
        return original.process();
    }

    // time = 8287 ms
    @Override
    protected Integer practice() {
        var practice = new Practice(heights.clone());
        return practice.process();
    }

    // time = 8646 ms
    @Override
    protected Integer solution() {
        var solution = new Solution(heights.clone());
        return solution.process();
    }
}
