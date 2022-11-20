package com.witalis.praxis.leetcode.task.h4.p334;

import com.witalis.praxis.leetcode.task.LeetCodeTask;
import com.witalis.praxis.leetcode.task.h4.p334.option.*;
import com.witalis.praxis.leetcode.utils.LeetCode;
import com.witalis.praxis.leetcode.utils.TaskDifficulty;
import com.witalis.praxis.leetcode.utils.TaskRevision;

import lombok.extern.slf4j.Slf4j;
import java.util.Arrays;
import java.util.concurrent.ThreadLocalRandom;

import static com.witalis.praxis.leetcode.utils.TaskTag.*;

@Slf4j
@LeetCode(
    id = 334,
    description = "Increasing Triplet Subsequence",
    difficulty = TaskDifficulty.MEDIUM,
    tags = {ARRAY, GREEDY}
)
public class IncreasingTripletSubsequence extends LeetCodeTask<Boolean> {
    public static final int LEN = 500_000;
    private int[] numbers;

    public static final String INFORMATION = """

        Description:
            Given an integer array nums, return true if there exists a triple of indices (i, j, k)
                such that i < j < k and nums[i] < nums[j] < nums[k]. If no such indices exists, return false.

        Example:
            Input: nums = [2,1,5,0,4,6]
            Output: true
            Explanation: The triplet (3, 4, 5) is valid because nums[3] == 0 < nums[4] == 4 < nums[5] == 6.""";

    public IncreasingTripletSubsequence(int id, String description, TaskRevision revision) {
        super(id, description, revision);
        initialization();
    }

    private void initialization() {
        final var random = ThreadLocalRandom.current();

        this.numbers = random.ints(
            random.nextInt(1, LEN + 1),
            Integer.MIN_VALUE, Integer.MAX_VALUE
        ).toArray();

        log.info("Numbers are {}", Arrays.toString(numbers));
    }

    @Override
    protected String getInformation() {
        return INFORMATION;
    }

    // time = 8043 ms
    @Override
    protected Boolean original() {
        var original = new Original(numbers);
        return original.process();
    }

    // time = 7792 ms
    @Override
    protected Boolean practice() {
        var practice = new Practice(numbers);
        return practice.process();
    }

    // time = 1938 ms
    @Override
    protected Boolean solution() {
        var solution = new Solution(numbers);
        return solution.process();
    }
}
