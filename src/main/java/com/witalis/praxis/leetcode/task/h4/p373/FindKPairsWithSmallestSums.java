package com.witalis.praxis.leetcode.task.h4.p373;

import com.witalis.praxis.leetcode.task.LeetCodeTask;
import com.witalis.praxis.leetcode.task.h4.p373.option.*;
import com.witalis.praxis.leetcode.utils.LeetCode;
import com.witalis.praxis.leetcode.utils.TaskDifficulty;
import com.witalis.praxis.leetcode.utils.TaskRevision;

import lombok.extern.slf4j.Slf4j;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

import static com.witalis.praxis.leetcode.utils.TaskTag.*;

@Slf4j
@LeetCode(
    id = 373,
    description = "Find K Pairs with Smallest Sums",
    difficulty = TaskDifficulty.MEDIUM,
    tags = {ARRAY, HEAP}
)
public class FindKPairsWithSmallestSums extends LeetCodeTask<List<List<Integer>>> {
    public static final int LEN = 10_000;
    public static final int VALUE = 1_000_000_000;
    public static final int SIZE = 10_000;

    private int[] numbers1;
    private int[] numbers2;
    private int pairs;

    public static final String INFORMATION = """

        Description:
            You are given two integer arrays nums1 and nums2 sorted in ascending order and an integer k.

            Define a pair (u, v) which consists of one element from the first array and one element from the second array.

            Return the k pairs (u1, v1), (u2, v2), ..., (uk, vk) with the smallest sums.

        Example:
            Input: nums1 = [1,7,11], nums2 = [2,4,6], k = 3
            Output: [[1,2],[1,4],[1,6]]
            Explanation: The first 3 pairs are returned from the sequence: [1,2],[1,4],[1,6],[7,2],[7,4],[11,2],[7,6],[11,4],[11,6]""";

    public FindKPairsWithSmallestSums(int id, String description, TaskRevision revision) {
        super(id, description, revision);
        initialization();
    }

    private void initialization() {
        final var random = ThreadLocalRandom.current();

        this.numbers1 = random.ints(
            random.nextInt(1, LEN + 1),
            -VALUE, VALUE + 1
        ).sorted().toArray();
        this.numbers2 = random.ints(
            random.nextInt(1, LEN + 1),
            -VALUE, VALUE + 1
        ).sorted().toArray();
        this.pairs = random.nextInt(1, SIZE + 1);

        log.info("Numbers #1: {}", Arrays.toString(numbers1));
        log.info("Numbers #2: {}", Arrays.toString(numbers2));
        log.info("Pairs K: {}", pairs);
    }

    @Override
    protected String getInformation() {
        return INFORMATION;
    }

    // time = 3717060 ms, memory limit exceeded
    @Override
    protected List<List<Integer>> original() {
        var original = new Original(numbers1, numbers2, pairs);
        return original.process();
    }

    // time = 9476 ms
    @Override
    protected List<List<Integer>> practice() {
        var practice = new Practice(numbers1, numbers2, pairs);
        return practice.process();
    }

    // time = 5999 ms
    @Override
    protected List<List<Integer>> solution() {
        var solution = new Solution(numbers1, numbers2, pairs);
        return solution.process();
    }
}
