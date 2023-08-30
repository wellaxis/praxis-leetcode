package com.witalis.praxis.leetcode.task.h24.p2366;

import com.witalis.praxis.leetcode.task.LeetCodeTask;
import com.witalis.praxis.leetcode.task.h24.p2366.option.*;
import com.witalis.praxis.leetcode.utils.LeetCode;
import com.witalis.praxis.leetcode.utils.TaskDifficulty;
import com.witalis.praxis.leetcode.utils.TaskRevision;

import lombok.extern.slf4j.Slf4j;
import java.util.Arrays;
import java.util.concurrent.ThreadLocalRandom;

import static com.witalis.praxis.leetcode.utils.TaskTag.*;

@Slf4j
@LeetCode(
    id = 2366,
    description = "Minimum Replacements to Sort the Array",
    difficulty = TaskDifficulty.MEDIUM,
    tags = {ARRAY, MATH, GREEDY}
)
public class MinimumReplacementsToSortArray extends LeetCodeTask<Long> {
    public static final int LEN = 100_000;
    public static final int VALUE = 1_000_000_000;

    private int[] numbers;

    public static final String INFORMATION = """

        Description:
            You are given a 0-indexed integer array nums.
                In one operation you can replace any element of the array with any two elements that sum to it.

            * For example, consider nums = [5,6,7].
              In one operation, we can replace nums[1] with 2 and 4 and convert nums to [5,2,4,7].

            Return the minimum number of operations to make an array that is sorted in non-decreasing order.

        Example:
            Input: nums = [3,9,3]
            Output: 2
            Explanation: Here are the steps to sort the array in non-decreasing order:
                - From [3,9,3], replace the 9 with 3 and 6 so the array becomes [3,3,6,3]
                - From [3,3,6,3], replace the 6 with 3 and 3 so the array becomes [3,3,3,3,3]
                There are 2 steps to sort the array in non-decreasing order. Therefore, we return 2.""";

    public MinimumReplacementsToSortArray(int id, String description, TaskRevision revision) {
        super(id, description, revision);
        initialization();
    }

    private void initialization() {
        final var random = ThreadLocalRandom.current();

        this.numbers = random.ints(
            random.nextInt(1, LEN + 1),
            1,
            VALUE + 1
        ).toArray();

        log.info("Numbers: {}", Arrays.toString(numbers));
    }

    @Override
    protected String getInformation() {
        return INFORMATION;
    }

    // time = 1329 ms
    @Override
    protected Long original() {
        var original = new Original(numbers);
        return original.process();
    }

    // time = 1215 ms
    @Override
    protected Long practice() {
        var practice = new Practice(numbers);
        return practice.process();
    }

    // time = 1111 ms
    @Override
    protected Long solution() {
        var solution = new Solution(numbers);
        return solution.process();
    }
}
