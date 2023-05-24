package com.witalis.praxis.leetcode.task.h26.p2542;

import com.witalis.praxis.leetcode.task.LeetCodeTask;
import com.witalis.praxis.leetcode.task.h26.p2542.option.*;
import com.witalis.praxis.leetcode.utils.LeetCode;
import com.witalis.praxis.leetcode.utils.TaskDifficulty;
import com.witalis.praxis.leetcode.utils.TaskRevision;

import lombok.extern.slf4j.Slf4j;
import java.util.Arrays;
import java.util.concurrent.ThreadLocalRandom;

import static com.witalis.praxis.leetcode.utils.TaskTag.*;

@Slf4j
@LeetCode(
    id = 2542,
    description = "Maximum Subsequence Score",
    difficulty = TaskDifficulty.MEDIUM,
    tags = {ARRAY, GREEDY, SORTING, HEAP}
)
public class MaximumSubsequenceScore extends LeetCodeTask<Long> {
    public static final int LEN = 100_000;
    public static final int VALUE = 100_000;

    private int[] numbers1;
    private int[] numbers2;
    private int quantity;

    public static final String INFORMATION = """

        Description:
            You are given two 0-indexed integer arrays nums1 and nums2 of equal length n and a positive integer k.
                You must choose a subsequence of indices from nums1 of length k.

            For chosen indices i0, i1, ..., ik - 1, your score is defined as:
                * The sum of the selected elements from nums1 multiplied with the minimum of the selected elements from nums2.
                * It can defined simply as: (nums1[i0] + nums1[i1] +...+ nums1[ik - 1]) * min(nums2[i0] , nums2[i1], ... ,nums2[ik - 1]).

            Return the maximum possible score.

            A subsequence of indices of an array is a set that can be derived from the set {0, 1, ..., n-1} by deleting some or no elements.

        Example:
            Input: nums1 = [1,3,3,2], nums2 = [2,1,3,4], k = 3
            Output: 12
            Explanation:
            The four possible subsequence scores are:
            - We choose the indices 0, 1, and 2 with score = (1+3+3) * min(2,1,3) = 7.
            - We choose the indices 0, 1, and 3 with score = (1+3+2) * min(2,1,4) = 6.
            - We choose the indices 0, 2, and 3 with score = (1+3+2) * min(2,3,4) = 12.
            - We choose the indices 1, 2, and 3 with score = (3+3+2) * min(1,3,4) = 8.
            Therefore, we return the max score, which is 12.""";

    public MaximumSubsequenceScore(int id, String description, TaskRevision revision) {
        super(id, description, revision);
        initialization();
    }

    private void initialization() {
        final var random = ThreadLocalRandom.current();

        final int len = random.nextInt(1, LEN + 1);
        this.numbers1 = random.ints(len, 0, VALUE + 1).toArray();
        this.numbers2 = random.ints(len, 0, VALUE + 1).toArray();
        this.quantity = random.nextInt(1, len + 1);

        log.info("Numbers #1: {}", Arrays.toString(numbers1));
        log.info("Numbers #2: {}", Arrays.toString(numbers2));
        log.info("Quantity k: {}", quantity);
    }

    @Override
    protected String getInformation() {
        return INFORMATION;
    }

    // time = 168569 ms
    @Override
    protected Long original() {
        var original = new Original(numbers1, numbers2, quantity);
        return original.process();
    }

    // time = 125796 ms
    @Override
    protected Long practice() {
        var practice = new Practice(numbers1, numbers2, quantity);
        return practice.process();
    }

    // time = 50723 ms
    @Override
    protected Long solution() {
        var solution = new Solution(numbers1, numbers2, quantity);
        return solution.process();
    }
}
