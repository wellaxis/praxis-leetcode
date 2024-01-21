package com.witalis.praxis.leetcode.task.h10.p907;

import com.witalis.praxis.leetcode.task.LeetCodeTask;
import com.witalis.praxis.leetcode.task.h10.p907.option.*;
import com.witalis.praxis.leetcode.utils.LeetCode;
import com.witalis.praxis.leetcode.utils.TaskDifficulty;
import com.witalis.praxis.leetcode.utils.TaskRevision;

import lombok.extern.slf4j.Slf4j;
import java.util.Arrays;
import java.util.concurrent.ThreadLocalRandom;

import static com.witalis.praxis.leetcode.utils.TaskTag.*;

@Slf4j
@LeetCode(
    id = 907,
    description = "Sum of Subarray Minimums",
    difficulty = TaskDifficulty.MEDIUM,
    tags = {ARRAY, DYNAMIC_PROGRAMMING, STACK, MONOTONIC_STACK}
)
public class SumOfSubarrayMinimums extends LeetCodeTask<Integer> {
    public static final int LEN = 30_000;
    public static final int VALUE = 30_000;

    private int[] array;

    public static final String INFORMATION = """

        Description:
            Given an array of integers arr, find the sum of min(b),
                where b ranges over every (contiguous) subarray of arr.
                Since the answer may be large, return the answer modulo 10^9 + 7.

        Example:
            Input: arr = [3,1,2,4]
            Output: 17
            Explanation:
                Subarrays are [3], [1], [2], [4], [3,1], [1,2], [2,4], [3,1,2], [1,2,4], [3,1,2,4].
                Minimums are 3, 1, 2, 4, 1, 1, 2, 1, 1, 1.
                Sum is 17.""";

    public SumOfSubarrayMinimums(int id, String description, TaskRevision revision) {
        super(id, description, revision);
        initialization();
    }

    private void initialization() {
        final var random = ThreadLocalRandom.current();

        this.array = random.ints(
            random.nextInt(1, LEN + 1),
            1, VALUE + 1)
            .toArray();

        log.info("Array: {}", Arrays.toString(array));
    }

    @Override
    protected String getInformation() {
        return INFORMATION;
    }

    // time = 6640 ms
    @Override
    protected Integer original() {
        var original = new Original(array.clone());
        return original.process();
    }

    // time = 6558 ms
    @Override
    protected Integer practice() {
        var practice = new Practice(array.clone());
        return practice.process();
    }

    // time = 2044 ms
    @Override
    protected Integer solution() {
        var solution = new Solution(array.clone());
        return solution.process();
    }
}
