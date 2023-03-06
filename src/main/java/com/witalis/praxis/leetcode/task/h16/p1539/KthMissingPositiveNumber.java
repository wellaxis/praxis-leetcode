package com.witalis.praxis.leetcode.task.h16.p1539;

import com.witalis.praxis.leetcode.task.LeetCodeTask;
import com.witalis.praxis.leetcode.task.h16.p1539.option.*;
import com.witalis.praxis.leetcode.utils.LeetCode;
import com.witalis.praxis.leetcode.utils.TaskDifficulty;
import com.witalis.praxis.leetcode.utils.TaskRevision;

import lombok.extern.slf4j.Slf4j;
import java.util.Arrays;
import java.util.concurrent.ThreadLocalRandom;

import static com.witalis.praxis.leetcode.utils.TaskTag.*;

@Slf4j
@LeetCode(
    id = 1539,
    description = "Kth Missing Positive Number",
    difficulty = TaskDifficulty.EASY,
    tags = {ARRAY, BINARY_SEARCH}
)
public class KthMissingPositiveNumber extends LeetCodeTask<Integer> {
    public static final int LEN = 1_000;
    public static final int VALUE = 1_000;

    private int[] numbers;
    private int index;

    public static final String INFORMATION = """

        Description:
            Given an array arr of positive integers sorted in a strictly increasing order, and an integer k.

            Return the kth positive integer that is missing from this array.

        Example:
            Input: arr = [2,3,4,7,11], k = 5
            Output: 9
            Explanation: The missing positive integers are [1,5,6,8,9,10,12,13,...]. The 5th missing positive integer is 9.""";

    public KthMissingPositiveNumber(int id, String description, TaskRevision revision) {
        super(id, description, revision);
        initialization();
    }

    private void initialization() {
        final var random = ThreadLocalRandom.current();

        this.numbers = random.ints(
            2 *random.nextInt(1, LEN + 1),
            1, VALUE + 1
        ).distinct().sorted().limit(LEN).toArray();
        this.index = random.nextInt(1, VALUE + 1);

        log.info("Array: {}", Arrays.toString(numbers));
        log.info("Index K: {}", index);
    }

    @Override
    protected String getInformation() {
        return INFORMATION;
    }

    // time = 525 ms
    @Override
    protected Integer original() {
        var original = new Original(numbers, index);
        return original.process();
    }

    // time = 481 ms
    @Override
    protected Integer practice() {
        var practice = new Practice(numbers, index);
        return practice.process();
    }

    // time = 472 ms
    @Override
    protected Integer solution() {
        var solution = new Solution(numbers, index);
        return solution.process();
    }
}
