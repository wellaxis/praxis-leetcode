package com.witalis.praxis.leetcode.task.h3.p209;

import com.witalis.praxis.leetcode.task.LeetCodeTask;
import com.witalis.praxis.leetcode.task.h3.p209.option.*;
import com.witalis.praxis.leetcode.utils.LeetCode;
import com.witalis.praxis.leetcode.utils.TaskDifficulty;
import com.witalis.praxis.leetcode.utils.TaskRevision;

import lombok.extern.slf4j.Slf4j;
import java.util.Arrays;
import java.util.concurrent.ThreadLocalRandom;

import static com.witalis.praxis.leetcode.utils.TaskTag.*;

@Slf4j
@LeetCode(
    id = 209,
    description = "Minimum Size Subarray Sum",
    difficulty = TaskDifficulty.MEDIUM,
    tags = {ARRAY, BINARY_SEARCH, SLIDING_WINDOW, PREFIX_SUM}
)
public class MinimumSizeSubarraySum extends LeetCodeTask<Integer> {
    public static final int SUM = (int) Math.pow(10, 9);
    public static final int LEN = 100_000;
    public static final int VALUE = 100_000;
    private int[] numbers;
    private int target;

    public static final String INFORMATION = """

        Given an array of positive integers nums and a positive integer target,
            return the minimal length of a contiguous subarray [numsl, numsl+1, ..., numsr-1, numsr]
            of which the sum is greater than or equal to target.
            If there is no such subarray, return 0 instead.

        Example:
            Input: target = 7, nums = [2,3,1,2,4,3]
            Output: 2
            Explanation: The subarray [4,3] has the minimal length under the problem constraint.""";

    public MinimumSizeSubarraySum(int id, String description, TaskRevision revision) {
        super(id, description, revision);
        initialization();
    }

    private void initialization() {
        final var random = ThreadLocalRandom.current();

        this.numbers = random.ints(
            random.nextInt(1, LEN + 1),
            1,
            VALUE + 1
        ).toArray();
        log.info("Numbers are {}", Arrays.toString(numbers));

        this.target = random.nextInt(1, SUM + 1);
        log.info("Target is {}", target);
    }

    @Override
    protected String getInformation() {
        return INFORMATION;
    }

    // time = 2794 ms
    @Override
    protected Integer original() {
        var original = new Original(numbers.clone(), target);
        return original.process();
    }

    // time = 2699 ms
    @Override
    protected Integer practice() {
        var practice = new Practice(numbers.clone(), target);
        return practice.process();
    }

    // time = 2735 ms
    @Override
    protected Integer solution() {
        var solution = new Solution(numbers.clone(), target);
        return solution.process();
    }
}
