package com.witalis.praxis.leetcode.task.h19.p1814;

import com.witalis.praxis.leetcode.task.LeetCodeTask;
import com.witalis.praxis.leetcode.task.h19.p1814.option.*;
import com.witalis.praxis.leetcode.utils.LeetCode;
import com.witalis.praxis.leetcode.utils.TaskDifficulty;
import com.witalis.praxis.leetcode.utils.TaskRevision;

import lombok.extern.slf4j.Slf4j;
import java.util.Arrays;
import java.util.concurrent.ThreadLocalRandom;

import static com.witalis.praxis.leetcode.utils.TaskTag.*;

@Slf4j
@LeetCode(
    id = 1814,
    description = "Count Nice Pairs in an Array",
    difficulty = TaskDifficulty.MEDIUM,
    tags = {ARRAY, HASH_TABLE, MATH, COUNTING}
)
public class CountNicePairsInArray extends LeetCodeTask<Integer> {
    public static final int LEN = 100_000;
    public static final int VALUE = 1_000_000_000;

    private int[] numbers;

    public static final String INFORMATION = """

        Description:
            You are given an array nums that consists of non-negative integers.
                Let us define rev(x) as the reverse of the non-negative integer x.
                For example, rev(123) = 321, and rev(120) = 21.
                A pair of indices (i, j) is nice if it satisfies all of the following conditions:
                * 0 <= i < j < nums.length
                * nums[i] + rev(nums[j]) == nums[j] + rev(nums[i])

            Return the number of nice pairs of indices.
                Since that number can be too large, return it modulo 109 + 7.

        Example:
            Input: nums = [42,11,1,97]
            Output: 2
            Explanation: The two pairs are:
                - (0,3) : 42 + rev(97) = 42 + 79 = 121, 97 + rev(42) = 97 + 24 = 121.
                - (1,2) : 11 + rev(1) = 11 + 1 = 12, 1 + rev(11) = 1 + 11 = 12.""";

    public CountNicePairsInArray(int id, String description, TaskRevision revision) {
        super(id, description, revision);
        initialization();
    }

    private void initialization() {
        final var random = ThreadLocalRandom.current();

        this.numbers = random.ints(
            random.nextInt(1, LEN + 1),
            0, VALUE + 1
        ).toArray();

        log.info("Numbers: {}", Arrays.toString(numbers));
    }

    @Override
    protected String getInformation() {
        return INFORMATION;
    }

    // time = 441 ms
    @Override
    protected Integer original() {
        var original = new Original(numbers);
        return original.process();
    }

    // time = 485 ms
    @Override
    protected Integer practice() {
        var practice = new Practice(numbers);
        return practice.process();
    }

    // time = 468 ms
    @Override
    protected Integer solution() {
        var solution = new Solution(numbers);
        return solution.process();
    }
}
