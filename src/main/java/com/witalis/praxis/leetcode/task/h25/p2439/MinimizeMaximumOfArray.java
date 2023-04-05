package com.witalis.praxis.leetcode.task.h25.p2439;

import com.witalis.praxis.leetcode.task.LeetCodeTask;
import com.witalis.praxis.leetcode.task.h25.p2439.option.*;
import com.witalis.praxis.leetcode.utils.LeetCode;
import com.witalis.praxis.leetcode.utils.TaskDifficulty;
import com.witalis.praxis.leetcode.utils.TaskRevision;

import lombok.extern.slf4j.Slf4j;
import java.util.Arrays;
import java.util.concurrent.ThreadLocalRandom;

import static com.witalis.praxis.leetcode.utils.TaskTag.*;

@Slf4j
@LeetCode(
    id = 2439,
    description = "Minimize Maximum of Array",
    difficulty = TaskDifficulty.MEDIUM,
    tags = {ARRAY, BINARY_SEARCH, DYNAMIC_PROGRAMMING, GREEDY, PREFIX_SUM}
)
public class MinimizeMaximumOfArray extends LeetCodeTask<Integer> {
    public static final int LEN = 100_000;
    public static final int VALUE = 1_000_000_000;

    private int[] numbers;

    public static final String INFORMATION = """

        Description:
            You are given a 0-indexed array nums comprising of n non-negative integers.

            In one operation, you must:
                * Choose an integer i such that 1 <= i < n and nums[i] > 0.
                * Decrease nums[i] by 1.
                * Increase nums[i - 1] by 1.

            Return the minimum possible value of the maximum integer of nums after performing any number of operations.

        Example:
            Input: nums = [3,7,1,6]
            Output: 5
            Explanation:
                One set of optimal operations is as follows:
                1. Choose i = 1, and nums becomes [4,6,1,6].
                2. Choose i = 3, and nums becomes [4,6,2,5].
                3. Choose i = 1, and nums becomes [5,5,2,5].
                The maximum integer of nums is 5. It can be shown that the maximum number cannot be less than 5.
                Therefore, we return 5.""";

    public MinimizeMaximumOfArray(int id, String description, TaskRevision revision) {
        super(id, description, revision);
        initialization();
    }

    private void initialization() {
        final var random = ThreadLocalRandom.current();

        this.numbers = random.ints(
            random.nextInt(2, LEN + 1),
            0, VALUE + 1
        ).toArray();

        log.info("Numbers are {}", Arrays.toString(numbers));
    }

    @Override
    protected String getInformation() {
        return INFORMATION;
    }

    // time = 4129 ms
    @Override
    protected Integer original() {
        var original = new Original(numbers);
        return original.process();
    }

    // time = 3167 ms
    @Override
    protected Integer practice() {
        var practice = new Practice(numbers);
        return practice.process();
    }

    // time = 1476 ms
    @Override
    protected Integer solution() {
        var solution = new Solution(numbers);
        return solution.process();
    }
}
