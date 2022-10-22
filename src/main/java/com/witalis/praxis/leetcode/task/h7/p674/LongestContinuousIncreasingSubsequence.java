package com.witalis.praxis.leetcode.task.h7.p674;

import com.witalis.praxis.leetcode.task.LeetCodeTask;
import com.witalis.praxis.leetcode.task.h7.p674.option.*;
import com.witalis.praxis.leetcode.utils.LeetCode;
import com.witalis.praxis.leetcode.utils.TaskDifficulty;
import com.witalis.praxis.leetcode.utils.TaskRevision;

import lombok.extern.slf4j.Slf4j;
import java.util.Arrays;
import java.util.concurrent.ThreadLocalRandom;

import static com.witalis.praxis.leetcode.utils.TaskTag.*;

@Slf4j
@LeetCode(
    id = 674,
    description = "Longest Continuous Increasing Subsequence",
    difficulty = TaskDifficulty.EASY,
    tags = {ARRAY}
)
public class LongestContinuousIncreasingSubsequence extends LeetCodeTask<Integer> {
    public static final int LEN = 10_000;
    public static final int VALUE = (int) Math.pow(10, 9);
    private int[] numbers;

    public static final String INFORMATION = """

        Description:
            Given an unsorted array of integers nums,
                return the length of the longest continuous increasing subsequence (i.e. subarray).
                The subsequence must be strictly increasing.

            A continuous increasing subsequence is defined by two indices l and r (l < r) such that
                it is [nums[l], nums[l + 1], ..., nums[r - 1], nums[r]]
                and for each l <= i < r, nums[i] < nums[i + 1].

        Example:
            Input: nums = [1,3,5,4,7]
            Output: 3
            Explanation: The longest continuous increasing subsequence is [1,3,5] with length 3.
                Even though [1,3,5,7] is an increasing subsequence,
                it is not continuous as elements 5 and 7 are separated by element 4.""";

    public LongestContinuousIncreasingSubsequence(int id, String description, TaskRevision revision) {
        super(id, description, revision);
        initialization();
    }

    private void initialization() {
        final var random = ThreadLocalRandom.current();

        this.numbers = random.ints(
            random.nextInt(1, LEN + 1),
            -VALUE, VALUE + 1
        ).toArray();

        log.info("Numbers are {}", Arrays.toString(numbers));
    }

    @Override
    protected String getInformation() {
        return INFORMATION;
    }

    // time = 857 ms
    @Override
    protected Integer original() {
        var original = new Original(numbers.clone());
        return original.process();
    }

    // time = 580 ms
    @Override
    protected Integer practice() {
        var practice = new Practice(numbers.clone());
        return practice.process();
    }

    // time = 560 ms
    @Override
    protected Integer solution() {
        var solution = new Solution(numbers.clone());
        return solution.process();
    }
}
