package com.witalis.praxis.leetcode.task.h23.p2279;

import com.witalis.praxis.leetcode.task.LeetCodeTask;
import com.witalis.praxis.leetcode.task.h23.p2279.option.*;
import com.witalis.praxis.leetcode.utils.LeetCode;
import com.witalis.praxis.leetcode.utils.TaskDifficulty;
import com.witalis.praxis.leetcode.utils.TaskRevision;

import lombok.extern.slf4j.Slf4j;
import java.util.Arrays;
import java.util.concurrent.ThreadLocalRandom;

import static com.witalis.praxis.leetcode.utils.TaskTag.*;

@Slf4j
@LeetCode(
    id = 2279,
    description = "Maximum Bags With Full Capacity of Rocks",
    difficulty = TaskDifficulty.MEDIUM,
    tags = {ARRAY, GREEDY, SORTING}
)
public class MaximumBagsWithFullCapacityOfRocks extends LeetCodeTask<Integer> {
    public static final int LEN = 50_000;
    public static final int VALUE = 1_000_000_000;
    private int[] capacity;
    private int[] rocks;
    private int additionalRocks;

    public static final String INFORMATION = """

        Description:
            You have n bags numbered from 0 to n - 1. You are given two 0-indexed integer arrays capacity and rocks.
                The ith bag can hold a maximum of capacity[i] rocks and currently contains rocks[i] rocks.
                You are also given an integer additionalRocks, the number of additional rocks you can place in any of the bags.

            Return the maximum number of bags that could have full capacity after placing the additional rocks in some bags.

        Example:
            Input: capacity = [2,3,4,5], rocks = [1,2,4,4], additionalRocks = 2
            Output: 3
            Explanation:
                Place 1 rock in bag 0 and 1 rock in bag 1.
                The number of rocks in each bag are now [2,3,4,4].
                Bags 0, 1, and 2 have full capacity.
                There are 3 bags at full capacity, so we return 3.
                It can be shown that it is not possible to have more than 3 bags at full capacity.
                Note that there may be other ways of placing the rocks that result in an answer of 3.""";

    public MaximumBagsWithFullCapacityOfRocks(int id, String description, TaskRevision revision) {
        super(id, description, revision);
        initialization();
    }

    private void initialization() {
        final var random = ThreadLocalRandom.current();

        int len = random.nextInt(1, LEN + 1);
        this.capacity = new int[len];
        this.rocks = new int[len];
        for (int i = 0; i < len; i++) {
            capacity[i] = random.nextInt(1, VALUE + 1);
            rocks[i] = random.nextInt(0, capacity[i] + 1);
        }
        this.additionalRocks = random.nextInt(1, VALUE + 1);

        log.info("Capacity: {}", Arrays.toString(capacity));
        log.info("Rocks: {}", Arrays.toString(rocks));
        log.info("Additional rocks: {}", additionalRocks);
    }

    @Override
    protected String getInformation() {
        return INFORMATION;
    }

    // time = 4193 ms
    @Override
    protected Integer original() {
        var original = new Original(capacity.clone(), rocks.clone(), additionalRocks);
        return original.process();
    }

    // time = 2890 ms
    @Override
    protected Integer practice() {
        var practice = new Practice(capacity.clone(), rocks.clone(), additionalRocks);
        return practice.process();
    }

    // time = 2637 ms
    @Override
    protected Integer solution() {
        var solution = new Solution(capacity.clone(), rocks.clone(), additionalRocks);
        return solution.process();
    }
}
