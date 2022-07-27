package com.witalis.praxis.leetcode.task.h2.p162;

import com.witalis.praxis.leetcode.task.LeetCodeTask;
import com.witalis.praxis.leetcode.task.h2.p162.option.*;
import com.witalis.praxis.leetcode.utils.LeetCode;
import com.witalis.praxis.leetcode.utils.TaskDifficulty;
import com.witalis.praxis.leetcode.utils.TaskRevision;

import lombok.extern.slf4j.Slf4j;
import java.util.Arrays;
import java.util.concurrent.ThreadLocalRandom;

import static com.witalis.praxis.leetcode.utils.TaskTag.*;

@Slf4j
@LeetCode(
    id = 162,
    description = "Find Peak Element",
    difficulty = TaskDifficulty.MEDIUM,
    tags = {ARRAY, BINARY_SEARCH}
)
public class FindPeakElement extends LeetCodeTask<Integer> {
    public static final int LEN = 1_000;
    private int[] numbers;

    public static final String INFORMATION = """

        A peak element is an element that is strictly greater than its neighbors.

        Given a 0-indexed integer array nums, find a peak element, and return its index.
            If the array contains multiple peaks, return the index to any of the peaks.

        You may imagine that nums[-1] = nums[n] = -∞. In other words, an element is always
            considered to be strictly greater than a neighbor that is outside the array.

        You must write an algorithm that runs in O(log n) time.

        Example:
            Input: nums = [1,2,1,3,5,6,4]
            Output: 5
            Explanation: Your function can return either index number 1 where the peak element is 2,
                or index number 5 where the peak element is 6.""";

    public FindPeakElement(int id, String description, TaskRevision revision) {
        super(id, description, revision);
        initialization();
    }

    private void initialization() {
        var random = ThreadLocalRandom.current();
        int length = random.nextInt(1, LEN + 1);

        this.numbers = new int[length];

        int number = 0;
        int previous = 0;
        for (int i = 0; i < length; i++) {
            while (number == previous) number = random.nextInt(Integer.MIN_VALUE, Integer.MAX_VALUE);
            previous = number;
            numbers[i] = number;
        }

        log.info("Numbers are {}", Arrays.toString(numbers));
    }

    @Override
    protected String getInformation() {
        return INFORMATION;
    }

    // time = 537 ms
    @Override
    protected Integer original() {
        var original = new Original(numbers.clone());
        return original.process();
    }

    // time = 515 ms
    @Override
    protected Integer practice() {
        var practice = new Practice(numbers.clone());
        return practice.process();
    }

    // time = 615 ms
    @Override
    protected Integer solution() {
        var solution = new Solution(numbers.clone());
        return solution.process();
    }
}
