package com.witalis.praxis.leetcode.task.h19.p1802;

import com.witalis.praxis.leetcode.task.LeetCodeTask;
import com.witalis.praxis.leetcode.task.h19.p1802.option.*;
import com.witalis.praxis.leetcode.utils.LeetCode;
import com.witalis.praxis.leetcode.utils.TaskDifficulty;
import com.witalis.praxis.leetcode.utils.TaskRevision;
import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.ThreadLocalRandom;

import static com.witalis.praxis.leetcode.utils.TaskTag.*;

@Slf4j
@LeetCode(
    id = 1802,
    description = "Maximum Value at a Given Index in a Bounded Array\n",
    difficulty = TaskDifficulty.MEDIUM,
    tags = {BINARY_SEARCH, GREEDY}
)
public class MaximumValueAtGivenIndexInBoundedArray extends LeetCodeTask<Integer> {
    public static final int LEN = 1_000_000_000;

    private int numbers;
    private int index;
    private int maxSum;

    public static final String INFORMATION = """

        Description:
            You are given three positive integers: n, index, and maxSum.
                You want to construct an array nums (0-indexed) that satisfies the following conditions:
                * nums.length == n
                * nums[i] is a positive integer where 0 <= i < n.
                * abs(nums[i] - nums[i+1]) <= 1 where 0 <= i < n-1.
                * The sum of all the elements of nums does not exceed maxSum.
                * nums[index] is maximized.

            Return nums[index] of the constructed array.

            Note that abs(x) equals x if x >= 0, and -x otherwise.

        Example:
            Input: n = 4, index = 2,  maxSum = 6
            Output: 2
            Explanation: nums = [1,2,2,1] is one array that satisfies all the conditions.
                There are no arrays that satisfy all the conditions and have nums[2] == 3, so 2 is the maximum nums[2].""";

    public MaximumValueAtGivenIndexInBoundedArray(int id, String description, TaskRevision revision) {
        super(id, description, revision);
        initialization();
    }

    private void initialization() {
        final var random = ThreadLocalRandom.current();

        this.numbers = random.nextInt(1, LEN + 1);
        this.maxSum = random.nextInt(1, numbers + 1);
        this.index = random.nextInt(0, numbers + 1);

        log.info("Numbers: {}", numbers);
        log.info("Index: {}", index);
        log.info("Max sum: {}", maxSum);
    }

    @Override
    protected String getInformation() {
        return INFORMATION;
    }

    // time = 762 ms
    @Override
    protected Integer original() {
        var original = new Original(numbers, index, maxSum);
        return original.process();
    }

    // time = 746 ms
    @Override
    protected Integer practice() {
        var practice = new Practice(numbers, index, maxSum);
        return practice.process();
    }

    // time = 718 ms
    @Override
    protected Integer solution() {
        var solution = new Solution(numbers, index, maxSum);
        return solution.process();
    }
}
