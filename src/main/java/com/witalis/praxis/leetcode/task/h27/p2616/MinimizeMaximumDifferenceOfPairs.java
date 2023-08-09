package com.witalis.praxis.leetcode.task.h27.p2616;

import com.witalis.praxis.leetcode.task.LeetCodeTask;
import com.witalis.praxis.leetcode.task.h27.p2616.option.*;
import com.witalis.praxis.leetcode.utils.LeetCode;
import com.witalis.praxis.leetcode.utils.TaskDifficulty;
import com.witalis.praxis.leetcode.utils.TaskRevision;

import lombok.extern.slf4j.Slf4j;
import java.util.Arrays;
import java.util.concurrent.ThreadLocalRandom;

import static com.witalis.praxis.leetcode.utils.TaskTag.*;

@Slf4j
@LeetCode(
    id = 2616,
    description = "Minimize the Maximum Difference of Pairs",
    difficulty = TaskDifficulty.MEDIUM,
    tags = {ARRAY, BINARY_SEARCH, GREEDY}
)
public class MinimizeMaximumDifferenceOfPairs extends LeetCodeTask<Integer> {
    public static final int LEN = 100_000;
    public static final int VALUE = 1_000_000_000;

    private int[] numbers;
    private int pairs;

    public static final String INFORMATION = """

        Description:
            You are given a 0-indexed integer array nums and an integer p.
                Find p pairs of indices of nums such that the maximum difference amongst all the pairs is minimized.
                Also, ensure no index appears more than once amongst the p pairs.

            Note that for a pair of elements at the index i and j,
                the difference of this pair is |nums[i] - nums[j]|,
                where |x| represents the absolute value of x.

            Return the minimum maximum difference among all p pairs.
                We define the maximum of an empty set to be zero.

        Example:
            Input: nums = [10,1,2,7,1,3], p = 2
            Output: 1
            Explanation: The first pair is formed from the indices 1 and 4, and the second pair is formed from the indices 2 and 5.
                The maximum difference is max(|nums[1] - nums[4]|, |nums[2] - nums[5]|) = max(0, 1) = 1. Therefore, we return 1.""";

    public MinimizeMaximumDifferenceOfPairs(int id, String description, TaskRevision revision) {
        super(id, description, revision);
        initialization();
    }

    private void initialization() {
        final var random = ThreadLocalRandom.current();

        int len = random.nextInt(1, LEN + 1);

        this.numbers = random.ints(len, 0, VALUE + 1).toArray();
        this.pairs = random.nextInt(0, len / 2);

        log.info("Numbers: {}", Arrays.toString(numbers));
        log.info("Pairs p: {}", pairs);
    }

    @Override
    protected String getInformation() {
        return INFORMATION;
    }

    // time = 7907 ms
    @Override
    protected Integer original() {
        var original = new Original(numbers.clone(), pairs);
        return original.process();
    }

    // time = 7442 ms
    @Override
    protected Integer practice() {
        var practice = new Practice(numbers.clone(), pairs);
        return practice.process();
    }

    // time = 6735 ms
    @Override
    protected Integer solution() {
        var solution = new Solution(numbers.clone(), pairs);
        return solution.process();
    }
}
