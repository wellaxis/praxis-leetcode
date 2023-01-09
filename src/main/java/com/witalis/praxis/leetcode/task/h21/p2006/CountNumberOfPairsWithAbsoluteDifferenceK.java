package com.witalis.praxis.leetcode.task.h21.p2006;

import com.witalis.praxis.leetcode.task.LeetCodeTask;
import com.witalis.praxis.leetcode.task.h21.p2006.option.*;
import com.witalis.praxis.leetcode.utils.LeetCode;
import com.witalis.praxis.leetcode.utils.TaskDifficulty;
import com.witalis.praxis.leetcode.utils.TaskRevision;

import lombok.extern.slf4j.Slf4j;
import java.util.Arrays;
import java.util.concurrent.ThreadLocalRandom;

import static com.witalis.praxis.leetcode.utils.TaskTag.*;

@Slf4j
@LeetCode(
    id = 2006,
    description = "Count Number of Pairs With Absolute Difference K",
    difficulty = TaskDifficulty.EASY,
    tags = {ARRAY, HASH_TABLE, COUNTING}
)
public class CountNumberOfPairsWithAbsoluteDifferenceK extends LeetCodeTask<Integer> {
    public static final int LEN = 200;
    public static final int VALUE = 100;
    private int[] numbers;
    private int difference;

    public static final String INFORMATION = """

        Description:
            Given an integer array nums and an integer k,
                return the number of pairs (i, j) where i < j such that |nums[i] - nums[j]| == k.

            The value of |x| is defined as:
                * x if x >= 0.
                * -x if x < 0.

        Example:
            Input: nums = [3,2,1,5,4], k = 2
            Output: 3
            Explanation: The pairs with an absolute difference of 2 are:
                - ['3',2,'1',5,4]
                - ['3',2,1,'5',4]
                - [3,'2',1,5,'4']""";

    public CountNumberOfPairsWithAbsoluteDifferenceK(int id, String description, TaskRevision revision) {
        super(id, description, revision);
        initialization();
    }

    private void initialization() {
        final var random = ThreadLocalRandom.current();

        this.numbers = random.ints(
            random.nextInt(1, LEN + 1),
            1, VALUE + 1
        ).toArray();
        this.difference = random.nextInt(1, LEN);

        log.info("Numbers: {}", Arrays.toString(numbers));
        log.info("Difference 'k': {}", difference);
    }

    @Override
    protected String getInformation() {
        return INFORMATION;
    }

    // time = 666 ms
    @Override
    protected Integer original() {
        var original = new Original(numbers, difference);
        return original.process();
    }

    // time = 462 ms
    @Override
    protected Integer practice() {
        var practice = new Practice(numbers, difference);
        return practice.process();
    }

    // time = 476 ms
    @Override
    protected Integer solution() {
        var solution = new Solution(numbers, difference);
        return solution.process();
    }
}
