package com.witalis.praxis.leetcode.task.h14.p1356;

import com.witalis.praxis.leetcode.task.LeetCodeTask;
import com.witalis.praxis.leetcode.task.h14.p1356.option.*;
import com.witalis.praxis.leetcode.utils.LeetCode;
import com.witalis.praxis.leetcode.utils.TaskDifficulty;
import com.witalis.praxis.leetcode.utils.TaskRevision;

import lombok.extern.slf4j.Slf4j;
import java.util.Arrays;
import java.util.concurrent.ThreadLocalRandom;

import static com.witalis.praxis.leetcode.utils.TaskTag.*;

@Slf4j
@LeetCode(
    id = 1356,
    description = "Sort Integers by The Number of 1 Bits",
    difficulty = TaskDifficulty.EASY,
    tags = {ARRAY, BIT_MANIPULATION, SORTING, COUNTING}
)
public class SortIntegersByNumberOf1Bits extends LeetCodeTask<int[]> {
    public static final int LEN = 500;
    public static final int VALUE = 10_000;

    private int[] numbers;

    public static final String INFORMATION = """

        Description:
            You are given an integer array arr. Sort the integers in the array in ascending order
                by the number of 1's in their binary representation and in case of two or more integers
                have the same number of 1's you have to sort them in ascending order.

            Return the array after sorting it.

        Example:
            Input: arr = [0,1,2,3,4,5,6,7,8]
            Output: [0,1,2,4,8,3,5,6,7]
            Explanation: [0] is the only integer with 0 bits.
                [1,2,4,8] all have 1 bit.
                [3,5,6] have 2 bits.
                [7] has 3 bits.
                The sorted array by bits is [0,1,2,4,8,3,5,6,7]""";

    public SortIntegersByNumberOf1Bits(int id, String description, TaskRevision revision) {
        super(id, description, revision);
        initialization();
    }

    private void initialization() {
        final var random = ThreadLocalRandom.current();

        this.numbers = random.ints(
            random.nextInt(1, LEN + 1),
            0,
            VALUE + 1
        ).toArray();

        log.info("Array: {}", Arrays.toString(numbers));
    }

    @Override
    protected String getInformation() {
        return INFORMATION;
    }

    // time = 1577 ms
    @Override
    protected int[] original() {
        var original = new Original(numbers.clone());
        return original.process();
    }

    // time = 1556 ms
    @Override
    protected int[] practice() {
        var practice = new Practice(numbers.clone());
        return practice.process();
    }

    // time = 1418 ms
    @Override
    protected int[] solution() {
        var solution = new Solution(numbers.clone());
        return solution.process();
    }
}
