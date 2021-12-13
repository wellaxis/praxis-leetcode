package com.witalis.praxis.leetcode.task.p53;

import com.witalis.praxis.leetcode.task.LeetCodeTask;
import com.witalis.praxis.leetcode.task.p53.option.*;
import com.witalis.praxis.leetcode.utils.LeetCode;
import com.witalis.praxis.leetcode.utils.TaskRevision;

import lombok.extern.slf4j.Slf4j;
import java.util.concurrent.ThreadLocalRandom;

@Slf4j
@LeetCode(id = 53, description = "Maximum Subarray")
public class MaximumSubarray extends LeetCodeTask<Integer> {
    public static final int LEN = (int) Math.pow(10, 5);
    public static final int VALUE = (int) Math.pow(10, 4);

    private int[] numbers;

    public static final String INFORMATION = """

        Given an integer array nums, find the contiguous subarray
            (containing at least one number) which has
            the largest sum and return its sum.

        A subarray is a contiguous part of an array.

        Example:
            Input: nums = [-2,1,-3,4,-1,2,1,-5,4]
            Output: 6
            Explanation: [4,-1,2,1] has the largest sum = 6.""";

    public MaximumSubarray(int id, String description, TaskRevision revision) {
        super(id, description, revision);
        initialization();
    }

    private void initialization() {
        var random = ThreadLocalRandom.current();
        this.numbers = random.ints(
            random.nextInt(1, LEN + 1),
            -VALUE,
            VALUE + 1
        ).toArray();

        log.info("Numbers are {}", numbers);
    }

    @Override
    protected String getInformation() {
        return INFORMATION;
    }

    // time = 1306 ms
    @Override
    protected Integer original() {
        var original = new Original(numbers.clone());
        return original.process();
    }

    // time = 1348 ms
    @Override
    protected Integer practice() {
        var practice = new Practice(numbers.clone());
        return practice.process();
    }

    // time = 1364 ms
    @Override
    protected Integer solution() {
        var solution = new Solution(numbers.clone());
        return solution.process();
    }
}
