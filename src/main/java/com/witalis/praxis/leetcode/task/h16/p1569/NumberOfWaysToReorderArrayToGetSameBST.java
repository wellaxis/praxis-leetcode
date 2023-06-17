package com.witalis.praxis.leetcode.task.h16.p1569;

import com.witalis.praxis.leetcode.task.LeetCodeTask;
import com.witalis.praxis.leetcode.task.h16.p1569.option.*;
import com.witalis.praxis.leetcode.utils.LeetCode;
import com.witalis.praxis.leetcode.utils.TaskDifficulty;
import com.witalis.praxis.leetcode.utils.TaskRevision;

import lombok.extern.slf4j.Slf4j;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.concurrent.ThreadLocalRandom;
import java.util.stream.IntStream;

import static com.witalis.praxis.leetcode.utils.TaskTag.*;

@Slf4j
@LeetCode(
    id = 1569,
    description = "Number of Ways to Reorder Array to Get Same BST",
    difficulty = TaskDifficulty.HARD,
    tags = {ARRAY, MATH, DIVIDE_AND_CONQUER, DYNAMIC_PROGRAMMING, TREE, UNION_FIND, BINARY_SEARCH_TREE, MEMOIZATION, COMBINATORICS, BINARY_TREE}
)
public class NumberOfWaysToReorderArrayToGetSameBST extends LeetCodeTask<Integer> {
    public static final int LEN = 1_000;

    private int[] numbers;

    public static final String INFORMATION = """

        Description:
            Given an array nums that represents a permutation of integers from 1 to n.
                We are going to construct a binary search tree (BST) by inserting
                the elements of nums in order into an initially empty BST.
                Find the number of different ways to reorder nums so that
                the constructed BST is identical to that formed from the original array nums.

            * For example, given nums = [2,1,3], we will have 2 as the root, 1 as a left child, and 3 as a right child.
              The array [2,3,1] also yields the same BST but [3,2,1] yields a different BST.

            Return the number of ways to reorder nums such that
                the BST formed is identical to the original BST formed from nums.

            Since the answer may be very large, return it modulo 109 + 7.

        Example:
            Input: nums = [3,4,5,1,2]
            Output: 5
            Explanation: The following 5 arrays will yield the same BST:
                [3,1,2,4,5]
                [3,1,4,2,5]
                [3,1,4,5,2]
                [3,4,1,2,5]
                [3,4,1,5,2]""";

    public NumberOfWaysToReorderArrayToGetSameBST(int id, String description, TaskRevision revision) {
        super(id, description, revision);
        initialization();
    }

    private void initialization() {
        final var random = ThreadLocalRandom.current();

        final int len = random.nextInt(1, LEN + 1);
        var values = new ArrayList<>(IntStream.rangeClosed(1, len).boxed().toList());
        Collections.shuffle(values);
        this.numbers = values.stream().mapToInt(Integer::intValue).toArray();

        log.info("Numbers: {}", Arrays.toString(numbers));
    }

    @Override
    protected String getInformation() {
        return INFORMATION;
    }

    // time = 30915 ms
    @Override
    protected Integer original() {
        var original = new Original(numbers.clone());
        return original.process();
    }

    // time = 29546 ms
    @Override
    protected Integer practice() {
        var practice = new Practice(numbers.clone());
        return practice.process();
    }

    // time = 14087 ms
    @Override
    protected Integer solution() {
        var solution = new Solution(numbers.clone());
        return solution.process();
    }
}
