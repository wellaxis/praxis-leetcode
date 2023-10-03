package com.witalis.praxis.leetcode.task.h16.p1512;

import com.witalis.praxis.leetcode.task.LeetCodeTask;
import com.witalis.praxis.leetcode.task.h16.p1512.option.*;
import com.witalis.praxis.leetcode.utils.LeetCode;
import com.witalis.praxis.leetcode.utils.TaskDifficulty;
import com.witalis.praxis.leetcode.utils.TaskRevision;

import lombok.extern.slf4j.Slf4j;
import java.util.Arrays;
import java.util.concurrent.ThreadLocalRandom;

import static com.witalis.praxis.leetcode.utils.TaskTag.*;

@Slf4j
@LeetCode(
    id = 1512,
    description = "Number of Good Pairs",
    difficulty = TaskDifficulty.EASY,
    tags = {ARRAY, HASH_TABLE, MATH, COUNTING}
)
public class NumberOfGoodPairs extends LeetCodeTask<Integer> {
    public static final int LEN = 100;
    public static final int VALUE = 100;

    private int[] numbers;

    public static final String INFORMATION = """

        Description:
            Given an array of integers nums, return the number of good pairs.

            A pair (i, j) is called good if nums[i] == nums[j] and i < j.

        Example:
            Input: nums = [1,2,3,1,1,3]
            Output: 4
            Explanation: There are 4 good pairs (0,3), (0,4), (3,4), (2,5) 0-indexed.""";

    public NumberOfGoodPairs(int id, String description, TaskRevision revision) {
        super(id, description, revision);
        initialization();
    }

    private void initialization() {
        final var random = ThreadLocalRandom.current();

        this.numbers = random.ints(
            random.nextInt(1, LEN + 1),
            1, VALUE + 1
        ).toArray();

        log.info("Numbers: {}", Arrays.toString(numbers));
    }

    @Override
    protected String getInformation() {
        return INFORMATION;
    }

    // time = 4042 ms
    @Override
    protected Integer original() {
        var original = new Original(numbers);
        return original.process();
    }

    // time = 496 ms
    @Override
    protected Integer practice() {
        var practice = new Practice(numbers);
        return practice.process();
    }

    // time = 520 ms
    @Override
    protected Integer solution() {
        var solution = new Solution(numbers);
        return solution.process();
    }
}
