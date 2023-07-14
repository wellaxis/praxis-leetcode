package com.witalis.praxis.leetcode.task.h13.p1218;

import com.witalis.praxis.leetcode.task.LeetCodeTask;
import com.witalis.praxis.leetcode.task.h13.p1218.option.*;
import com.witalis.praxis.leetcode.utils.LeetCode;
import com.witalis.praxis.leetcode.utils.TaskDifficulty;
import com.witalis.praxis.leetcode.utils.TaskRevision;

import lombok.extern.slf4j.Slf4j;
import java.util.Arrays;
import java.util.concurrent.ThreadLocalRandom;

import static com.witalis.praxis.leetcode.utils.TaskTag.*;

@Slf4j
@LeetCode(
    id = 1218,
    description = "Longest Arithmetic Subsequence of Given Difference",
    difficulty = TaskDifficulty.MEDIUM,
    tags = {ARRAY, HASH_TABLE, DYNAMIC_PROGRAMMING}
)
public class LongestArithmeticSubsequenceOfGivenDifference extends LeetCodeTask<Integer> {
    public static final int LEN = 100_000;
    public static final int VALUE = 10_000;

    private int[] numbers;
    private int difference;

    public static final String INFORMATION = """

        Description:
            Given an integer array arr and an integer difference,
                return the length of the longest subsequence in arr which is an arithmetic sequence such
                that the difference between adjacent elements in the subsequence equals difference.

            A subsequence is a sequence that can be derived from arr by deleting some
                or no elements without changing the order of the remaining elements.

        Example:
            Input: arr = [1,5,7,8,5,3,4,2,1], difference = -2
            Output: 4
            Explanation: The longest arithmetic subsequence is [7,5,3,1].""";

    public LongestArithmeticSubsequenceOfGivenDifference(int id, String description, TaskRevision revision) {
        super(id, description, revision);
        initialization();
    }

    private void initialization() {
        final var random = ThreadLocalRandom.current();

        this.numbers = random.ints(
            random.nextInt(1, LEN + 1),
            -VALUE, VALUE + 1
        ).toArray();
        this.difference = random.nextInt(-VALUE, VALUE + 1);

        log.info("Numbers: {}", Arrays.toString(numbers));
        log.info("Difference: {}", difference);
    }

    @Override
    protected String getInformation() {
        return INFORMATION;
    }

    // time = 2120987 ms, time limit exceeded
    @Override
    protected Integer original() {
        var original = new Original(numbers, difference);
        return original.process();
    }

    // time = 17160 ms
    @Override
    protected Integer practice() {
        var practice = new Practice(numbers, difference);
        return practice.process();
    }

    // time = 4193 ms
    @Override
    protected Integer solution() {
        var solution = new Solution(numbers, difference);
        return solution.process();
    }
}
