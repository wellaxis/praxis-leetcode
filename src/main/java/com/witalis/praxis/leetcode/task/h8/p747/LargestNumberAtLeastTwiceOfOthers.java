package com.witalis.praxis.leetcode.task.h8.p747;

import com.witalis.praxis.leetcode.task.LeetCodeTask;
import com.witalis.praxis.leetcode.task.h8.p747.option.*;
import com.witalis.praxis.leetcode.utils.LeetCode;
import com.witalis.praxis.leetcode.utils.TaskDifficulty;
import com.witalis.praxis.leetcode.utils.TaskRevision;

import lombok.extern.slf4j.Slf4j;
import java.util.Arrays;
import java.util.concurrent.ThreadLocalRandom;

import static com.witalis.praxis.leetcode.utils.TaskTag.*;

@Slf4j
@LeetCode(
    id = 747,
    description = "Largest Number At Least Twice of Others",
    difficulty = TaskDifficulty.EASY,
    tags = {ARRAY, SORTING}
)
public class LargestNumberAtLeastTwiceOfOthers extends LeetCodeTask<Integer> {
    public static final int LEN = 50;
    public static final int VALUE = 100;

    private int[] numbers;

    public static final String INFORMATION = """

        Description:
            You are given an integer array nums where the largest integer is unique.

            Determine whether the largest element in the array is at least twice as much as every other number in the array.
                If it is, return the index of the largest element, or return -1 otherwise.

        Example:
            Input: nums = [3,6,1,0]
            Output: 1
            Explanation: 6 is the largest integer.
                For every other number in the array x, 6 is at least twice as big as x.
                The index of value 6 is 1, so we return 1.""";

    public LargestNumberAtLeastTwiceOfOthers(int id, String description, TaskRevision revision) {
        super(id, description, revision);
        initialization();
    }

    private void initialization() {
        final var random = ThreadLocalRandom.current();

        this.numbers = random.ints(
            random.nextInt(2, LEN + 1),
            0,
            VALUE + 1
        ).toArray();

        log.info("Numbers: {}", Arrays.toString(numbers));
    }

    @Override
    protected String getInformation() {
        return INFORMATION;
    }

    // time = 1149 ms
    @Override
    protected Integer original() {
        var original = new Original(numbers.clone());
        return original.process();
    }

    // time = 449 ms
    @Override
    protected Integer practice() {
        var practice = new Practice(numbers.clone());
        return practice.process();
    }

    // time = 474 ms
    @Override
    protected Integer solution() {
        var solution = new Solution(numbers.clone());
        return solution.process();
    }
}
