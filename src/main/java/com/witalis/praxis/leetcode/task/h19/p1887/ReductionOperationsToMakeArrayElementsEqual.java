package com.witalis.praxis.leetcode.task.h19.p1887;

import com.witalis.praxis.leetcode.task.LeetCodeTask;
import com.witalis.praxis.leetcode.task.h19.p1887.option.*;
import com.witalis.praxis.leetcode.utils.LeetCode;
import com.witalis.praxis.leetcode.utils.TaskDifficulty;
import com.witalis.praxis.leetcode.utils.TaskRevision;

import lombok.extern.slf4j.Slf4j;
import java.util.Arrays;
import java.util.concurrent.ThreadLocalRandom;

import static com.witalis.praxis.leetcode.utils.TaskTag.*;

@Slf4j
@LeetCode(
    id = 1887,
    description = "Reduction Operations to Make the Array Elements Equal",
    difficulty = TaskDifficulty.MEDIUM,
    tags = {ARRAY, SORTING}
)
public class ReductionOperationsToMakeArrayElementsEqual extends LeetCodeTask<Integer> {
    public static final int LEN = 100_000;
    public static final int VALUE = 100_000;

    private int[] numbers;

    public static final String INFORMATION = """

        Description:
            Given an integer array nums, your goal is to make all elements in nums equal.
                To complete one operation, follow these steps:

            1. Find the largest value in nums. Let its index be i (0-indexed) and its value be largest.
               If there are multiple elements with the largest value, pick the smallest i.
            2. Find the next largest value in nums strictly smaller than largest. Let its value be nextLargest.
            3. Reduce nums[i] to nextLargest.

            Return the number of operations to make all elements in nums equal.

        Example:
            Input: nums = [5,1,3]
            Output: 3
            Explanation: It takes 3 operations to make all elements in nums equal:
                1. largest = 5 at index 0. nextLargest = 3. Reduce nums[0] to 3. nums = [3,1,3].
                2. largest = 3 at index 0. nextLargest = 1. Reduce nums[0] to 1. nums = [1,1,3].
                3. largest = 3 at index 2. nextLargest = 1. Reduce nums[2] to 1. nums = [1,1,1].""";

    public ReductionOperationsToMakeArrayElementsEqual(int id, String description, TaskRevision revision) {
        super(id, description, revision);
        initialization();
    }

    private void initialization() {
        final var random = ThreadLocalRandom.current();

        this.numbers = random.ints(
            random.nextInt(2, 2 * (LEN / 2)),
            1, VALUE + 1
        ).toArray();

        log.info("Numbers: {}", Arrays.toString(numbers));
    }

    @Override
    protected String getInformation() {
        return INFORMATION;
    }

    // time = 3902 ms
    @Override
    protected Integer original() {
        var original = new Original(numbers.clone());
        return original.process();
    }

    // time = 3836 ms
    @Override
    protected Integer practice() {
        var practice = new Practice(numbers.clone());
        return practice.process();
    }

    // time = 3687 ms
    @Override
    protected Integer solution() {
        var solution = new Solution(numbers.clone());
        return solution.process();
    }
}
