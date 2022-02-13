package com.witalis.praxis.leetcode.task.h1.p42;

import com.witalis.praxis.leetcode.task.LeetCodeTask;
import com.witalis.praxis.leetcode.task.h1.p42.option.*;
import com.witalis.praxis.leetcode.utils.LeetCode;
import com.witalis.praxis.leetcode.utils.TaskDifficulty;
import com.witalis.praxis.leetcode.utils.TaskRevision;

import lombok.extern.slf4j.Slf4j;
import java.util.Arrays;
import java.util.concurrent.ThreadLocalRandom;

import static com.witalis.praxis.leetcode.utils.TaskTag.*;

@Slf4j
@LeetCode(
    id = 42,
    description = "Trapping Rain Water",
    difficulty = TaskDifficulty.HARD,
    tags = {ARRAY, TWO_POINTERS, DYNAMIC_PROGRAMMING, STACK, MONOTONIC_STACK}
)
public class TrappingRainWater extends LeetCodeTask<Integer> {
    public static final int LEN = 20_000;
    public static final int VALUE = 100_000;
    private int[] height;

    public static final String INFORMATION = """

        Given n non-negative integers representing an elevation map
            where the width of each bar is 1,
            compute how much water it can trap after raining.

        Example:
            Input: height = [0,1,0,2,1,0,1,3,2,1,2,1]
            Output: 6
            Explanation: The above elevation map (black section)
                is represented by array [0,1,0,2,1,0,1,3,2,1,2,1].
                In this case, 6 units of rain water (blue section) are being trapped.""";

    public TrappingRainWater(int id, String description, TaskRevision revision) {
        super(id, description, revision);
        initialization();
    }

    private void initialization() {
        var random = ThreadLocalRandom.current();
        this.height = random.ints(
            random.nextInt(1, LEN + 1),
            0,
            VALUE + 1
        ).toArray();

        log.info("Height is {}", Arrays.toString(height));
    }

    @Override
    protected String getInformation() {
        return INFORMATION;
    }

    // time = 3819358 ms, time limit exceeded
    @Override
    protected Integer original() {
        var original = new Original(height.clone());
        return original.process();
    }

    // time = 35838 ms
    @Override
    protected Integer practice() {
        var practice = new Practice(height.clone());
        return practice.process();
    }

    // time = 1610 ms
    @Override
    protected Integer solution() {
        var solution = new Solution(height.clone());
        return solution.process();
    }
}
