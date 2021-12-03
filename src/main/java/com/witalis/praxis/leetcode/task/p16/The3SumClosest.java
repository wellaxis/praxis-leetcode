package com.witalis.praxis.leetcode.task.p16;

import com.witalis.praxis.leetcode.task.LeetCodeTask;
import com.witalis.praxis.leetcode.task.p16.option.*;
import com.witalis.praxis.leetcode.utils.LeetCode;
import com.witalis.praxis.leetcode.utils.TaskRevision;

import lombok.extern.slf4j.Slf4j;

import java.util.Arrays;
import java.util.concurrent.ThreadLocalRandom;
import java.util.stream.IntStream;

@Slf4j
@LeetCode(id = 16, description = "3Sum Closest")
public class The3SumClosest extends LeetCodeTask<Integer> {
    public static final int MIN_SIZE = 3;
    public static final int MAX_SIZE = 1_000;
    public static final int MIN = -1_000;
    public static final int MAX = 1_000;
    private int[] numbers;
    private int target;

    public static final String INFORMATION = """

        Given an integer array nums of length n and an integer target,
            find three integers in nums such that the sum is closest to target.
                                                
        Return the sum of the three integers.
                                                
        You may assume that each input would have exactly one solution..
        
        Example:
            Input: nums = [-1,2,1,-4], target = 1
            Output: 2
            Explanation: The sum that is closest to the target is 2. (-1 + 2 + 1 = 2).""";

    public The3SumClosest(int id, String description, TaskRevision revision) {
        super(id, description, revision);
        initialization();
    }

    private void initialization() {
        var random = ThreadLocalRandom.current();
        this.numbers = IntStream.generate(
                () -> random.nextInt(MIN, MAX + 1)
            )
            .limit(random.nextInt(MIN_SIZE, MAX_SIZE + 1))
            .toArray();
        this.target = random.nextInt(-MAX_SIZE * 10, MAX_SIZE * 10 + 1);

        log.info("Numbers are {}, target is {}", Arrays.toString(numbers), target);
    }

    @Override
    protected String getInformation() {
        return INFORMATION;
    }

    // time = 6032 ms
    @Override
    protected Integer original() {
        var original = new Original(numbers.clone(), target);
        return original.process();
    }

    // time = 5437 ms
    @Override
    protected Integer practice() {
        var practice = new Practice(numbers.clone(), target);
        return practice.process();
    }

    // time = 7901 ms
    @Override
    protected Integer solution() {
        var solution = new Solution(numbers.clone(), target);
        return solution.process();
    }
}
