package com.witalis.praxis.leetcode.task.h17.p1685;

import com.witalis.praxis.leetcode.task.LeetCodeTask;
import com.witalis.praxis.leetcode.task.h17.p1685.option.*;
import com.witalis.praxis.leetcode.utils.LeetCode;
import com.witalis.praxis.leetcode.utils.TaskDifficulty;
import com.witalis.praxis.leetcode.utils.TaskRevision;

import lombok.extern.slf4j.Slf4j;
import java.util.Arrays;
import java.util.concurrent.ThreadLocalRandom;

import static com.witalis.praxis.leetcode.utils.TaskTag.*;

@Slf4j
@LeetCode(
    id = 1685,
    description = "Sum of Absolute Differences in a Sorted Array",
    difficulty = TaskDifficulty.MEDIUM,
    tags = {ARRAY, MATH, PREFIX_SUM}
)
public class SumOfAbsoluteDifferencesInSortedArray extends LeetCodeTask<int[]> {
    public static final int LEN = 100_000;
    public static final int VALUE = 10_000;

    private int[] numbers;

    public static final String INFORMATION = """

        Description:
            You are given an integer array nums sorted in non-decreasing order.

            Build and return an integer array result with the same length as nums such that result[i] is equal
                to the summation of absolute differences between nums[i] and all the other elements in the array.

            In other words, result[i] is equal to sum(|nums[i]-nums[j]|) where 0 <= j < nums.length and j != i (0-indexed).

        Example:
            Input: nums = [2,3,5]
            Output: [4,3,5]
            Explanation: Assuming the arrays are 0-indexed, then
                result[0] = |2-2| + |2-3| + |2-5| = 0 + 1 + 3 = 4,
                result[1] = |3-2| + |3-3| + |3-5| = 1 + 0 + 2 = 3,
                result[2] = |5-2| + |5-3| + |5-5| = 3 + 2 + 0 = 5.""";

    public SumOfAbsoluteDifferencesInSortedArray(int id, String description, TaskRevision revision) {
        super(id, description, revision);
        initialization();
    }

    private void initialization() {
        final var random = ThreadLocalRandom.current();

        this.numbers = random.ints(
            random.nextInt(2, LEN + 1),
            1, VALUE + 1
        ).sorted().toArray();

        log.info("Numbers: {}", Arrays.toString(numbers));
    }

    @Override
    protected String getInformation() {
        return INFORMATION;
    }

    // time = 3320 ms
    @Override
    protected int[] original() {
        var original = new Original(numbers);
        return original.process();
    }

    // time = 3084 ms
    @Override
    protected int[] practice() {
        var practice = new Practice(numbers);
        return practice.process();
    }

    // time = 2082 ms
    @Override
    protected int[] solution() {
        var solution = new Solution(numbers);
        return solution.process();
    }
}
