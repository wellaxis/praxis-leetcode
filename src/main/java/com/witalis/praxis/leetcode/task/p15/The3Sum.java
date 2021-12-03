package com.witalis.praxis.leetcode.task.p15;

import com.witalis.praxis.leetcode.task.LeetCodeTask;
import com.witalis.praxis.leetcode.task.p15.option.*;
import com.witalis.praxis.leetcode.utils.LeetCode;
import com.witalis.praxis.leetcode.utils.TaskRevision;

import lombok.extern.slf4j.Slf4j;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;
import java.util.stream.IntStream;

@Slf4j
@LeetCode(id = 15, description = "3Sum")
public class The3Sum extends LeetCodeTask<List<List<Integer>>> {
    public static final int SIZE = 3_000;
    public static final int MIN = -100_000;
    public static final int MAX = 100_000;
    private int[] numbers;

    public static final String INFORMATION = """

        Given an integer array nums,
            return all the triplets [nums[i], nums[j], nums[k]]
            such that i != j, i != k, and j != k,
            and nums[i] + nums[j] + nums[k] == 0.
                                                                        
        Notice that the solution set must not contain duplicate triplets.
        
        Example:
            Input: nums = [-1,0,1,2,-1,-4]
            Output: [[-1,-1,2],[-1,0,1]]""";

    public The3Sum(int id, String description, TaskRevision revision) {
        super(id, description, revision);
        initialization();
    }

    private void initialization() {
        var random = ThreadLocalRandom.current();
        this.numbers = IntStream.generate(
                () -> random.nextInt(MIN, MAX + 1)
            )
            .limit(random.nextInt(0, SIZE + 1))
            .toArray();

        log.info("Numbers are {}", Arrays.toString(numbers));
    }

    @Override
    protected String getInformation() {
        return INFORMATION;
    }

    // time = 13550814 ms, limit exceeded
    @Override
    protected List<List<Integer>> original() {
        var original = new Original(numbers.clone());
        return original.process();
    }

    // time = 455464 ms
    @Override
    protected List<List<Integer>> practice() {
        var practice = new Practice(numbers.clone());
        return practice.process();
    }

    // time = 24861 ms
    @Override
    protected List<List<Integer>> solution() {
        var solution = new Solution(numbers.clone());
        return solution.process();
    }
}
