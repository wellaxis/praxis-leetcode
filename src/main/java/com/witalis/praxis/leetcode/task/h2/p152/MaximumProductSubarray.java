package com.witalis.praxis.leetcode.task.h2.p152;

import com.witalis.praxis.leetcode.task.LeetCodeTask;
import com.witalis.praxis.leetcode.task.h2.p152.option.*;
import com.witalis.praxis.leetcode.utils.LeetCode;
import com.witalis.praxis.leetcode.utils.TaskDifficulty;
import com.witalis.praxis.leetcode.utils.TaskRevision;

import lombok.extern.slf4j.Slf4j;
import java.util.concurrent.ThreadLocalRandom;

import static com.witalis.praxis.leetcode.utils.TaskTag.*;

@Slf4j
@LeetCode(
    id = 152,
    description = "Maximum Product Subarray",
    difficulty = TaskDifficulty.MEDIUM,
    tags = {ARRAY, DYNAMIC_PROGRAMMING}
)
public class MaximumProductSubarray extends LeetCodeTask<Integer> {
    public static final int LEN = 20_000;
    public static final int VALUE = 10;
    private int[] numbers;

    public static final String INFORMATION = """

        Given an integer array nums, find a contiguous non-empty subarray within the array
            that has the largest product, and return the product.

        The test cases are generated so that the answer will fit in a 32-bit integer.

        A subarray is a contiguous subsequence of the array.

        Example:
            Input: nums = [2,3,-2,4]
            Output: 6
            Explanation: [2,3] has the largest product 6.""";

    public MaximumProductSubarray(int id, String description, TaskRevision revision) {
        super(id, description, revision);
        initialization();
    }

    private void initialization() {
        var random = ThreadLocalRandom.current();
        int length = random.nextInt(1, LEN + 1);

        this.numbers = new int[length];
        long product = 1;
        for (int i = 0; i < length; i++) {
            int number = random.nextInt(-VALUE, VALUE + 1);
            product *= number;
            if (product > Integer.MAX_VALUE || product < Integer.MIN_VALUE) {
                number = 0;
                product = 1;
            }
            numbers[i] = number;
        }

        log.info("Numbers are {}", numbers);
    }

    @Override
    protected String getInformation() {
        return INFORMATION;
    }

    // time = 3334 ms
    @Override
    protected Integer original() {
        var original = new Original(numbers.clone());
        return original.process();
    }

    // time = 2515 ms
    @Override
    protected Integer practice() {
        var practice = new Practice(numbers.clone());
        return practice.process();
    }

    // time = 2544 ms
    @Override
    protected Integer solution() {
        var solution = new Solution(numbers.clone());
        return solution.process();
    }
}
