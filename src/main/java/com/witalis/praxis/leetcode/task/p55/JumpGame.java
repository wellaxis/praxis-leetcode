package com.witalis.praxis.leetcode.task.p55;

import com.witalis.praxis.leetcode.task.LeetCodeTask;
import com.witalis.praxis.leetcode.task.p55.option.*;
import com.witalis.praxis.leetcode.utils.LeetCode;
import com.witalis.praxis.leetcode.utils.TaskRevision;

import lombok.extern.slf4j.Slf4j;
import java.util.Arrays;
import java.util.concurrent.ThreadLocalRandom;

@Slf4j
@LeetCode(id = 55, description = "Jump Game")
public class JumpGame extends LeetCodeTask<Boolean> {
    public static final int LEN = 1_000;
    public static final int VALUE = 10;
    private int[] numbers;

    public static final String INFORMATION = """

        You are given an integer array nums.
            You are initially positioned at the array's first index,
            and each element in the array represents your
            maximum jump length at that position.
                                                
        Return true if you can reach the last index, or false otherwise.

        Example:
            Input: nums = [2,3,1,1,4]
            Output: true
            Explanation: Jump 1 step from index 0 to 1,
                         then 3 steps to the last index.""";

    public JumpGame(int id, String description, TaskRevision revision) {
        super(id, description, revision);
        initialization();
    }

    private void initialization() {
        var random = ThreadLocalRandom.current();
        this.numbers = random.ints(
            random.nextInt(1, LEN + 1),
            0,
            VALUE + 1
        ).toArray();

        log.info("Numbers are {}", Arrays.toString(numbers));
    }

    @Override
    protected String getInformation() {
        return INFORMATION;
    }

    // time = 581 ms, time limit exceeded
    @Override
    protected Boolean original() {
        var original = new Original(numbers.clone());
        return original.process();
    }

    // time = 445 ms
    @Override
    protected Boolean practice() {
        var practice = new Practice(numbers.clone());
        return practice.process();
    }

    // time = 410 ms
    @Override
    protected Boolean solution() {
        var solution = new Solution(numbers.clone());
        return solution.process();
    }
}
