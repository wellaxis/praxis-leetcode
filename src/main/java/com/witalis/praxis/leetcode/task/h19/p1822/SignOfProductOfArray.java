package com.witalis.praxis.leetcode.task.h19.p1822;

import com.witalis.praxis.leetcode.task.LeetCodeTask;
import com.witalis.praxis.leetcode.task.h19.p1822.option.*;
import com.witalis.praxis.leetcode.utils.LeetCode;
import com.witalis.praxis.leetcode.utils.TaskDifficulty;
import com.witalis.praxis.leetcode.utils.TaskRevision;

import lombok.extern.slf4j.Slf4j;
import java.util.Arrays;
import java.util.concurrent.ThreadLocalRandom;

import static com.witalis.praxis.leetcode.utils.TaskTag.*;

@Slf4j
@LeetCode(
    id = 1822,
    description = "Sign of the Product of an Array",
    difficulty = TaskDifficulty.EASY,
    tags = {ARRAY, MATH}
)
public class SignOfProductOfArray extends LeetCodeTask<Integer> {
    public static final int LEN = 1_000;
    public static final int VALUE = 100;

    private int[] numbers;

    public static final String INFORMATION = """

        Description:
            There is a function signFunc(x) that returns:
                * 1 if x is positive.
                * -1 if x is negative.
                * 0 if x is equal to 0.

            You are given an integer array nums.
                Let product be the product of all values in the array nums.

            Return signFunc(product).

        Example:
            Input: nums = [-1,-2,-3,-4,3,2,1]
            Output: 1
            Explanation: The product of all values in the array is 144, and signFunc(144) = 1""";

    public SignOfProductOfArray(int id, String description, TaskRevision revision) {
        super(id, description, revision);
        initialization();
    }

    private void initialization() {
        final var random = ThreadLocalRandom.current();

        this.numbers = random.ints(
            random.nextInt(1, LEN + 1),
            -VALUE, VALUE + 1
        ).toArray();

        log.info("Numbers: {}", Arrays.toString(numbers));
    }

    @Override
    protected String getInformation() {
        return INFORMATION;
    }

    // time = 441 ms
    @Override
    protected Integer original() {
        var original = new Original(numbers);
        return original.process();
    }

    // time = 485 ms
    @Override
    protected Integer practice() {
        var practice = new Practice(numbers);
        return practice.process();
    }

    // time = 468 ms
    @Override
    protected Integer solution() {
        var solution = new Solution(numbers);
        return solution.process();
    }
}
