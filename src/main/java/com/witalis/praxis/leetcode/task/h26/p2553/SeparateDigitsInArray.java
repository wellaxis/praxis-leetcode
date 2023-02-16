package com.witalis.praxis.leetcode.task.h26.p2553;

import com.witalis.praxis.leetcode.task.LeetCodeTask;
import com.witalis.praxis.leetcode.task.h26.p2553.option.*;
import com.witalis.praxis.leetcode.utils.LeetCode;
import com.witalis.praxis.leetcode.utils.TaskDifficulty;
import com.witalis.praxis.leetcode.utils.TaskRevision;

import lombok.extern.slf4j.Slf4j;
import java.util.Arrays;
import java.util.concurrent.ThreadLocalRandom;

import static com.witalis.praxis.leetcode.utils.TaskTag.*;

@Slf4j
@LeetCode(
    id = 2553,
    description = "Separate the Digits in an Array",
    difficulty = TaskDifficulty.EASY,
    tags = {ARRAY, SIMULATION}
)
public class SeparateDigitsInArray extends LeetCodeTask<int[]> {
    public static final int LEN = 1_000;
    public static final int VALUE = 100_000;

    private int[] numbers;

    public static final String INFORMATION = """

        Description:
            Given an array of positive integers nums, return an array answer that consists of the digits
                of each integer in nums after separating them in the same order they appear in nums.

            To separate the digits of an integer is to get all the digits it has in the same order.
                * For example, for the integer 10921, the separation of its digits is [1,0,9,2,1].

        Example:
            Input: nums = [13,25,83,77]
            Output: [1,3,2,5,8,3,7,7]
            Explanation:
            - The separation of 13 is [1,3].
            - The separation of 25 is [2,5].
            - The separation of 83 is [8,3].
            - The separation of 77 is [7,7].
            answer = [1,3,2,5,8,3,7,7]. Note that answer contains the separations in the same order.""";

    public SeparateDigitsInArray(int id, String description, TaskRevision revision) {
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

    // time = 5689 ms
    @Override
    protected int[] original() {
        var original = new Original(numbers);
        return original.process();
    }

    // time = 1746 ms
    @Override
    protected int[] practice() {
        var practice = new Practice(numbers);
        return practice.process();
    }

    // time = 734 ms
    @Override
    protected int[] solution() {
        var solution = new Solution(numbers);
        return solution.process();
    }
}
