package com.witalis.praxis.leetcode.task.h10.p918;

import com.witalis.praxis.leetcode.task.LeetCodeTask;
import com.witalis.praxis.leetcode.task.h10.p918.option.*;
import com.witalis.praxis.leetcode.utils.LeetCode;
import com.witalis.praxis.leetcode.utils.TaskDifficulty;
import com.witalis.praxis.leetcode.utils.TaskRevision;

import lombok.extern.slf4j.Slf4j;
import java.util.Arrays;
import java.util.concurrent.ThreadLocalRandom;

import static com.witalis.praxis.leetcode.utils.TaskTag.*;

@Slf4j
@LeetCode(
    id = 918,
    description = "Maximum Sum Circular Subarray",
    difficulty = TaskDifficulty.MEDIUM,
    tags = {ARRAY, DIVIDE_AND_CONQUER, DYNAMIC_PROGRAMMING, QUEUE, MONOTONIC_QUEUE}
)
public class MaximumSumCircularSubarray extends LeetCodeTask<Integer> {
    public static final int LEN = 30_000;
    public static final int VALUE = 30_000;
    private int[] numbers;

    public static final String INFORMATION = """

        Description:
            Given a circular integer array nums of length n,
                return the maximum possible sum of a non-empty subarray of nums.

            A circular array means the end of the array connects to the beginning of the array.
                Formally, the next element of nums[i] is nums[(i + 1) % n]
                and the previous element of nums[i] is nums[(i - 1 + n) % n].

            A subarray may only include each element of the fixed buffer nums at most once.
                Formally, for a subarray nums[i], nums[i + 1], ..., nums[j],
                there does not exist i <= k1, k2 <= j with k1 % n == k2 % n.

        Example:
            Input: nums = [5,-3,5]
            Output: 10
            Explanation: Subarray [5,5] has maximum sum 5 + 5 = 10.""";

    public MaximumSumCircularSubarray(int id, String description, TaskRevision revision) {
        super(id, description, revision);
        initialization();
    }

    private void initialization() {
        final var random = ThreadLocalRandom.current();

        this.numbers = random.ints(
            random.nextInt(1, LEN + 1),
            -VALUE, VALUE + 1
        ).distinct().toArray();

        log.info("Numbers are {}", Arrays.toString(numbers));
    }

    @Override
    protected String getInformation() {
        return INFORMATION;
    }

    // time = 26376 ms
    @Override
    protected Integer original() {
        var original = new Original(numbers);
        return original.process();
    }

    // time = 22729 ms
    @Override
    protected Integer practice() {
        var practice = new Practice(numbers);
        return practice.process();
    }

    // time = 18720 ms
    @Override
    protected Integer solution() {
        var solution = new Solution(numbers);
        return solution.process();
    }
}
