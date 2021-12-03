package com.witalis.praxis.leetcode.task.p31;

import com.witalis.praxis.leetcode.task.LeetCodeTask;
import com.witalis.praxis.leetcode.task.p31.option.*;
import com.witalis.praxis.leetcode.utils.LeetCode;
import com.witalis.praxis.leetcode.utils.TaskRevision;

import lombok.extern.slf4j.Slf4j;
import java.util.Arrays;
import java.util.concurrent.ThreadLocalRandom;

@Slf4j
@LeetCode(id = 31, description = "Next Permutation")
public class NextPermutation extends LeetCodeTask<int[]> {
    public static final int NUM = 100;
    private int[] numbers;

    public static final String INFORMATION = """

        Implement next permutation, which rearranges numbers
            into the lexicographically next greater permutation of numbers.
                                                                 
        If such an arrangement is not possible, it must rearrange it
            as the lowest possible order (i.e., sorted in ascending order).
                                                                 
        The replacement must be in place and use only constant extra memory.
        
        Examples:
            Input: nums = [1,2,3] Output: [1,3,2]
            Input: nums = [3,2,1] Output: [1,2,3]
            Input: nums = [1,1,5] Output: [1,5,1]""";

    public NextPermutation(int id, String description, TaskRevision revision) {
        super(id, description, revision);
        initialization();
    }

    private void initialization() {
        this.numbers = ThreadLocalRandom.current().ints(
            ThreadLocalRandom.current().nextInt(1, NUM + 1),
            0, NUM + 1
        ).toArray();

        log.info("Numbers are {}", Arrays.toString(numbers));
    }

    @Override
    protected String getInformation() {
        return INFORMATION;
    }

    // time = 506 ms
    @Override
    protected int[] original() {
        var original = new Original(numbers.clone());
        return original.process();
    }

    // time = 436 ms
    @Override
    protected int[] practice() {
        var practice = new Practice(numbers.clone());
        return practice.process();
    }

    // time = 429 ms
    @Override
    protected int[] solution() {
        var solution = new Solution(numbers.clone());
        return solution.process();
    }
}
