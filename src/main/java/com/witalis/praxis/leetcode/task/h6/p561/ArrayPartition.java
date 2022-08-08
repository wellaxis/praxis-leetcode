package com.witalis.praxis.leetcode.task.h6.p561;

import com.witalis.praxis.leetcode.task.LeetCodeTask;
import com.witalis.praxis.leetcode.task.h6.p561.option.*;
import com.witalis.praxis.leetcode.utils.LeetCode;
import com.witalis.praxis.leetcode.utils.TaskDifficulty;
import com.witalis.praxis.leetcode.utils.TaskRevision;

import lombok.extern.slf4j.Slf4j;
import java.util.Arrays;
import java.util.concurrent.ThreadLocalRandom;

import static com.witalis.praxis.leetcode.utils.TaskTag.*;

@Slf4j
@LeetCode(
    id = 561,
    description = "Array Partition",
    difficulty = TaskDifficulty.EASY,
    tags = {ARRAY, GREEDY, SORTING, COUNTING_SORT}
)
public class ArrayPartition extends LeetCodeTask<Integer> {
    public static final int LEN = 10_000;
    public static final int VALUE = 10_000;
    private int[] numbers;

    public static final String INFORMATION = """

        Given an integer array nums of 2n integers,
            group these integers into n pairs (a1, b1), (a2, b2), ..., (an, bn)
            such that the sum of min(ai, bi) for all i is maximized.
            Return the maximized sum.

        Example:
            Input: nums = [6,2,6,5,1,2]
            Output: 9
            Explanation: The optimal pairing is (2, 1), (2, 5), (6, 6). min(2, 1) + min(2, 5) + min(6, 6) = 1 + 2 + 6 = 9.""";

    public ArrayPartition(int id, String description, TaskRevision revision) {
        super(id, description, revision);
        initialization();
    }

    private void initialization() {
        final var random = ThreadLocalRandom.current();

        this.numbers = random.ints(
            2L * random.nextInt(1, LEN + 1),
            -VALUE,
            VALUE + 1
        ).toArray();

        log.info("Numbers are {}", Arrays.toString(numbers));
    }

    @Override
    protected String getInformation() {
        return INFORMATION;
    }

    // time = 3399 ms
    @Override
    protected Integer original() {
        var original = new Original(numbers.clone());
        return original.process();
    }

    // time = 1641 ms
    @Override
    protected Integer practice() {
        var practice = new Practice(numbers.clone());
        return practice.process();
    }

    // time = 1426 ms
    @Override
    protected Integer solution() {
        var solution = new Solution(numbers.clone());
        return solution.process();
    }
}
