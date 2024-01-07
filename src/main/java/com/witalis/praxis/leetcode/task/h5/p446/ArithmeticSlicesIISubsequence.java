package com.witalis.praxis.leetcode.task.h5.p446;

import com.witalis.praxis.leetcode.task.LeetCodeTask;
import com.witalis.praxis.leetcode.task.h5.p446.option.*;
import com.witalis.praxis.leetcode.utils.LeetCode;
import com.witalis.praxis.leetcode.utils.TaskDifficulty;
import com.witalis.praxis.leetcode.utils.TaskRevision;

import lombok.extern.slf4j.Slf4j;
import java.util.Arrays;
import java.util.concurrent.ThreadLocalRandom;

import static com.witalis.praxis.leetcode.utils.TaskTag.*;

@Slf4j
@LeetCode(
    id = 446,
    description = "Arithmetic Slices II - Subsequence",
    difficulty = TaskDifficulty.HARD,
    tags = {ARRAY, DYNAMIC_PROGRAMMING}
)
public class ArithmeticSlicesIISubsequence extends LeetCodeTask<Integer> {
    public static final int LEN = 1_000;

    private int[] numbers;

    public static final String INFORMATION = """

        Description:
            Given an integer array nums, return the number of all the arithmetic subsequences of nums.

            A sequence of numbers is called arithmetic if it consists of at least three elements
                and if the difference between any two consecutive elements is the same.

            * For example, [1, 3, 5, 7, 9], [7, 7, 7, 7], and [3, -1, -5, -9] are arithmetic sequences.
            * For example, [1, 1, 2, 5, 7] is not an arithmetic sequence.

            A subsequence of an array is a sequence that can be formed by removing some elements (possibly none) of the array.

            * For example, [2,5,10] is a subsequence of [1,2,1,2,4,1,5,10].

            The test cases are generated so that the answer fits in 32-bit integer.

        Example:
            Input: nums = [2,4,6,8,10]
            Output: 7
            Explanation: All arithmetic subsequence slices are:
                [2,4,6]
                [4,6,8]
                [6,8,10]
                [2,4,6,8]
                [4,6,8,10]
                [2,4,6,8,10]
                [2,6,10]""";

    public ArithmeticSlicesIISubsequence(int id, String description, TaskRevision revision) {
        super(id, description, revision);
        initialization();
    }

    private void initialization() {
        final var random = ThreadLocalRandom.current();
        final int len = random.nextInt(1, LEN + 1);

        this.numbers = random.ints(
            random.nextInt(1, LEN + 1),
            Integer.MIN_VALUE, Integer.MAX_VALUE
        ).toArray();

        log.info("Numbers: {}", Arrays.toString(numbers));
    }

    @Override
    protected String getInformation() {
        return INFORMATION;
    }

    // time = 35711 ms
    @Override
    protected Integer original() {
        var original = new Original(numbers.clone());
        return original.process();
    }

    // time = 34295 ms
    @Override
    protected Integer practice() {
        var practice = new Practice(numbers.clone());
        return practice.process();
    }

    // time = 11992 ms
    @Override
    protected Integer solution() {
        var solution = new Solution(numbers.clone());
        return solution.process();
    }
}
