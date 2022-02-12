package com.witalis.praxis.leetcode.task.h1.p41;

import com.witalis.praxis.leetcode.task.LeetCodeTask;
import com.witalis.praxis.leetcode.task.h1.p41.option.*;
import com.witalis.praxis.leetcode.utils.LeetCode;
import com.witalis.praxis.leetcode.utils.TaskDifficulty;
import com.witalis.praxis.leetcode.utils.TaskRevision;

import lombok.extern.slf4j.Slf4j;
import java.util.Arrays;
import java.util.concurrent.ThreadLocalRandom;

import static com.witalis.praxis.leetcode.utils.TaskTag.*;

@Slf4j
@LeetCode(
    id = 41,
    description = "First Missing Positive",
    difficulty = TaskDifficulty.HARD,
    tags = {ARRAY, HASH_TABLE}
)
public class FirstMissingPositive extends LeetCodeTask<Integer> {
    public static final int LEN = 500_000;
    public static final int VALUE = 100_000;
    private int[] numbers;

    public static final String INFORMATION = """

        Given an unsorted integer array nums,
            return the smallest missing positive integer.

        You must implement an algorithm that runs in O(n) time
            and uses constant extra space.

        Example:
            Input: nums = [3,4,-1,1]
            Output: 2""";

    public FirstMissingPositive(int id, String description, TaskRevision revision) {
        super(id, description, revision);
        initialization();
    }

    private void initialization() {
        var random = ThreadLocalRandom.current();
        this.numbers = random.ints(
            LEN, -VALUE, VALUE + 1
        ).toArray();

        log.info("Numbers are {}", Arrays.toString(numbers));
    }

    @Override
    protected String getInformation() {
        return INFORMATION;
    }

    // time = 8706 ms
    @Override
    protected Integer original() {
        var original = new Original(numbers.clone());
        return original.process();
    }

    // time = 8317 ms
    @Override
    protected Integer practice() {
        var practice = new Practice(numbers.clone());
        return practice.process();
    }

    // time = 7907 ms
    @Override
    protected Integer solution() {
        var solution = new Solution(numbers.clone());
        return solution.process();
    }
}
