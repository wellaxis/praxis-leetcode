package com.witalis.praxis.leetcode.task.h20.p1913;

import com.witalis.praxis.leetcode.task.LeetCodeTask;
import com.witalis.praxis.leetcode.task.h20.p1913.option.*;
import com.witalis.praxis.leetcode.utils.LeetCode;
import com.witalis.praxis.leetcode.utils.TaskDifficulty;
import com.witalis.praxis.leetcode.utils.TaskRevision;

import lombok.extern.slf4j.Slf4j;
import java.util.Arrays;
import java.util.concurrent.ThreadLocalRandom;

import static com.witalis.praxis.leetcode.utils.TaskTag.*;

@Slf4j
@LeetCode(
    id = 1913,
    description = "Maximum Product Difference Between Two Pairs",
    difficulty = TaskDifficulty.EASY,
    tags = {ARRAY, SORTING}
)
public class MaximumProductDifferenceBetweenTwoPairs extends LeetCodeTask<Integer> {
    public static final int LEN = 10_000;
    public static final int VALUE = 10_000;

    private int[] numbers;

    public static final String INFORMATION = """

        Description:
            The product difference between two pairs (a, b) and (c, d) is defined as (a * b) - (c * d).

            * For example, the product difference between (5, 6) and (2, 7) is (5 * 6) - (2 * 7) = 16.

            Given an integer array nums, choose four distinct indices w, x, y, and z such that
                the product difference between pairs (nums[w], nums[x]) and (nums[y], nums[z]) is maximized.

            Return the maximum such product difference.

        Example:
            Input: nums = [4,2,5,9,7,4,8]
            Output: 64
            Explanation: We can choose indices 3 and 6 for the first pair (9, 8) and indices 1 and 5 for the second pair (2, 4).
                The product difference is (9 * 8) - (2 * 4) = 64.""";

    public MaximumProductDifferenceBetweenTwoPairs(int id, String description, TaskRevision revision) {
        super(id, description, revision);
        initialization();
    }

    private void initialization() {
        final var random = ThreadLocalRandom.current();

        this.numbers = random.ints(
            random.nextInt(4, LEN + 1),
            1, VALUE + 1
        ).toArray();

        log.info("Numbers: {}", Arrays.toString(numbers));
    }

    @Override
    protected String getInformation() {
        return INFORMATION;
    }

    // time = 4368 ms
    @Override
    protected Integer original() {
        var original = new Original(numbers.clone());
        return original.process();
    }

    // time = 733 ms
    @Override
    protected Integer practice() {
        var practice = new Practice(numbers.clone());
        return practice.process();
    }

    // time = 667 ms
    @Override
    protected Integer solution() {
        var solution = new Solution(numbers.clone());
        return solution.process();
    }
}
