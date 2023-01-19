package com.witalis.praxis.leetcode.task.h10.p974;

import com.witalis.praxis.leetcode.task.LeetCodeTask;
import com.witalis.praxis.leetcode.task.h10.p974.option.*;
import com.witalis.praxis.leetcode.utils.LeetCode;
import com.witalis.praxis.leetcode.utils.TaskDifficulty;
import com.witalis.praxis.leetcode.utils.TaskRevision;

import lombok.extern.slf4j.Slf4j;
import java.util.Arrays;
import java.util.concurrent.ThreadLocalRandom;

import static com.witalis.praxis.leetcode.utils.TaskTag.*;

@Slf4j
@LeetCode(
    id = 974,
    description = "Subarray Sums Divisible by K",
    difficulty = TaskDifficulty.MEDIUM,
    tags = {ARRAY, HASH_TABLE, PREFIX_SUM}
)
public class SubarraySumsDivisibleByK extends LeetCodeTask<Integer> {
    public static final int LEN = 30_000;
    public static final int VALUE = 10_000;
    private int[] numbers;
    private int denominator;

    public static final String INFORMATION = """

        Description:
            Given an integer array nums and an integer k,
                return the number of non-empty subarrays that have a sum divisible by k.

            A subarray is a contiguous part of an array.

        Example:
            Input: nums = [4,5,0,-2,-3,1], k = 5
            Output: 7
            Explanation: There are 7 subarrays with a sum divisible by k = 5:
                [4, 5, 0, -2, -3, 1], [5], [5, 0], [5, 0, -2, -3], [0], [0, -2, -3], [-2, -3]""";

    public SubarraySumsDivisibleByK(int id, String description, TaskRevision revision) {
        super(id, description, revision);
        initialization();
    }

    private void initialization() {
        final var random = ThreadLocalRandom.current();

        this.numbers = random.ints(
            random.nextInt(1, LEN + 1),
            -VALUE, VALUE + 1
        ).distinct().toArray();
        this.denominator = random.nextInt(2, VALUE + 1);

        log.info("Numbers are {}", Arrays.toString(numbers));
        log.info("Denominator 'K' is {}", denominator);
    }

    @Override
    protected String getInformation() {
        return INFORMATION;
    }

    // time = 352626 ms, time limit exceeded
    @Override
    protected Integer original() {
        var original = new Original(numbers, denominator);
        return original.process();
    }

    // time = 2386 ms
    @Override
    protected Integer practice() {
        var practice = new Practice(numbers, denominator);
        return practice.process();
    }

    // time = 2024 ms
    @Override
    protected Integer solution() {
        var solution = new Solution(numbers, denominator);
        return solution.process();
    }
}
