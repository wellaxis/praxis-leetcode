package com.witalis.praxis.leetcode.task.p1;

import com.witalis.praxis.leetcode.task.LeetCodeTask;
import com.witalis.praxis.leetcode.task.p1.option.*;
import com.witalis.praxis.leetcode.utils.LeetCode;
import com.witalis.praxis.leetcode.utils.TaskRevision;

import lombok.extern.slf4j.Slf4j;
import java.util.Arrays;
import java.util.concurrent.ThreadLocalRandom;

@Slf4j
@LeetCode(id = 1, description = "Two Sum")
public class TwoSum extends LeetCodeTask<int[]> {
    private static final int SIZE = 20;
    private int[] nums;
    private int target;

    public static final String INFORMATION = """

        Given: an array of integers nums and an integer target,
               return indices of the two numbers such that they add up to target.
               You may assume that each input would have exactly one solution,
               and you may not use the same element twice.
               You can return the answer in any order.""";

    public TwoSum(int id, String description, TaskRevision revision) {
        super(id, description, revision);
        initialization();
    }

    private void initialization() {
        var origin = 0;
        var bound = 100;
        ThreadLocalRandom random = ThreadLocalRandom.current();
        this.nums = random.ints(SIZE, origin, bound)
            .toArray();
        this.target = nums[random.nextInt(0, SIZE)] +
            nums[random.nextInt(0, SIZE)];
        log.info("INIT: nums {}, target {}", Arrays.toString(nums), target);
    }

    @Override
    protected String getInformation() {
        return INFORMATION;
    }

    // time = 1073 ms
    @Override
    protected int[] original() {
        var original = new Original(nums.clone(), target);
        return original.process();
    }

    // time = 1204 ms
    @Override
    protected int[] practice() {
        var practice = new Practice(nums.clone(), target);
        return practice.process();
    }

    // time = 1142 ms
    @Override
    protected int[] solution() {
        var solution = new Solution(nums.clone(), target);
        return solution.process();
    }
}
