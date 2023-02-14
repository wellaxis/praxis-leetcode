package com.witalis.praxis.leetcode.task.h26.p2562;

import com.witalis.praxis.leetcode.task.LeetCodeTask;
import com.witalis.praxis.leetcode.task.h26.p2562.option.*;
import com.witalis.praxis.leetcode.utils.LeetCode;
import com.witalis.praxis.leetcode.utils.TaskDifficulty;
import com.witalis.praxis.leetcode.utils.TaskRevision;

import lombok.extern.slf4j.Slf4j;
import java.util.Arrays;
import java.util.concurrent.ThreadLocalRandom;

import static com.witalis.praxis.leetcode.utils.TaskTag.*;

@Slf4j
@LeetCode(
    id = 2562,
    description = "Find the Array Concatenation Value",
    difficulty = TaskDifficulty.EASY,
    tags = {ARRAY, MATH}
)
public class FindArrayConcatenationValue extends LeetCodeTask<Long> {
    public static final int LEN = 1_000;
    public static final int VALUE = 10_000;

    private int[] numbers;

    public static final String INFORMATION = """

        Description:
            You are given a 0-indexed integer array nums.

            The concatenation of two numbers is the number formed by concatenating their numerals.
                * For example, the concatenation of 15, 49 is 1549.

            The concatenation value of nums is initially equal to 0.
                Perform this operation until nums becomes empty:
                * If there exists more than one number in nums, pick the first element and last element in nums respectively
                  and add the value of their concatenation to the concatenation value of nums,
                  then delete the first and last element from nums.
                * If one element exists, add its value to the concatenation value of nums, then delete it.

            Return the concatenation value of the nums.

        Example:
            Input: nums = [5,14,13,8,12]
            Output: 673
            Explanation: Before performing any operation, nums is [5,14,13,8,12] and concatenation value is 0.
                 - In the first operation:
                We pick the first element, 5, and the last element, 12.
                Their concatenation is 512, and we add it to the concatenation value, so it becomes equal to 512.
                Then we delete them from the nums, so nums becomes equal to [14,13,8].
                 - In the second operation:
                We pick the first element, 14, and the last element, 8.
                Their concatenation is 148, and we add it to the concatenation value, so it becomes equal to 660.
                Then we delete them from the nums, so nums becomes equal to [13].
                 - In the third operation:
                nums has only one element, so we pick 13 and add it to the concatenation value, so it becomes equal to 673.
                Then we delete it from nums, so nums become empty.
                Since the concatenation value is 673 so the answer is 673.""";

    public FindArrayConcatenationValue(int id, String description, TaskRevision revision) {
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

    // time = 700 ms
    @Override
    protected Long original() {
        var original = new Original(numbers);
        return original.process();
    }

    // time = 494 ms
    @Override
    protected Long practice() {
        var practice = new Practice(numbers);
        return practice.process();
    }

    // time = 466 ms
    @Override
    protected Long solution() {
        var solution = new Solution(numbers);
        return solution.process();
    }
}
