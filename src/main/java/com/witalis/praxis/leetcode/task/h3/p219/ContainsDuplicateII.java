package com.witalis.praxis.leetcode.task.h3.p219;

import com.witalis.praxis.leetcode.task.LeetCodeTask;
import com.witalis.praxis.leetcode.task.h3.p219.option.*;
import com.witalis.praxis.leetcode.utils.LeetCode;
import com.witalis.praxis.leetcode.utils.TaskDifficulty;
import com.witalis.praxis.leetcode.utils.TaskRevision;

import lombok.extern.slf4j.Slf4j;
import java.util.concurrent.ThreadLocalRandom;

import static com.witalis.praxis.leetcode.utils.TaskTag.*;

@Slf4j
@LeetCode(
    id = 219,
    description = "Contains Duplicate II",
    difficulty = TaskDifficulty.EASY,
    tags = {ARRAY, HASH_TABLE, SLIDING_WINDOW}
)
public class ContainsDuplicateII extends LeetCodeTask<Boolean> {
    public static final int LEN = (int) Math.pow(10, 5);
    public static final int VALUE = (int) Math.pow(10, 9);
    private int[] numbers;
    private int distance;

    public static final String INFORMATION = """

        Given an integer array nums and an integer k,
            return true if there are two distinct indices i and j
            in the array such that nums[i] == nums[j] and abs(i - j) <= k.

        Example:
            Input: nums = [1,2,3,1], k = 3
            Output: true""";

    public ContainsDuplicateII(int id, String description, TaskRevision revision) {
        super(id, description, revision);
        initialization();
    }

    private void initialization() {
        var random = ThreadLocalRandom.current();

        this.numbers = random.ints(
                random.nextInt(1, LEN + 1),
                -VALUE,
                VALUE + 1
            )
            .toArray();
        this.distance = ThreadLocalRandom.current().nextInt(0, LEN + 1);

        log.info("Numbers are {}", numbers);
        log.info("Number K is {}", distance);
    }

    @Override
    protected String getInformation() {
        return INFORMATION;
    }

    // time = 3847407 ms, time limit exceeded
    @Override
    protected Boolean original() {
        var original = new Original(numbers.clone(), distance);
        return original.process();
    }

    // time = 7174 ms
    @Override
    protected Boolean practice() {
        var practice = new Practice(numbers.clone(), distance);
        return practice.process();
    }

    // time = 6466 ms
    @Override
    protected Boolean solution() {
        var solution = new Solution(numbers.clone(), distance);
        return solution.process();
    }
}
