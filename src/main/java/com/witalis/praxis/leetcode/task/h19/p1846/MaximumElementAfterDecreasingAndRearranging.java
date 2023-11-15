package com.witalis.praxis.leetcode.task.h19.p1846;

import com.witalis.praxis.leetcode.task.LeetCodeTask;
import com.witalis.praxis.leetcode.task.h19.p1846.option.*;
import com.witalis.praxis.leetcode.utils.LeetCode;
import com.witalis.praxis.leetcode.utils.TaskDifficulty;
import com.witalis.praxis.leetcode.utils.TaskRevision;

import lombok.extern.slf4j.Slf4j;
import java.util.Arrays;
import java.util.concurrent.ThreadLocalRandom;

import static com.witalis.praxis.leetcode.utils.TaskTag.*;

@Slf4j
@LeetCode(
    id = 1846,
    description = "Maximum Element After Decreasing and Rearranging",
    difficulty = TaskDifficulty.MEDIUM,
    tags = {ARRAY, GREEDY, SORTING}
)
public class MaximumElementAfterDecreasingAndRearranging extends LeetCodeTask<Integer> {
    public static final int LEN = 100_000;
    public static final int VALUE = 1_000_000_000;

    private int[] array;

    public static final String INFORMATION = """

        Description:
            You are given an array of positive integers arr. Perform some operations (possibly none) on arr so that it satisfies these conditions:
                * The value of the first element in arr must be 1.
                * The absolute difference between any 2 adjacent elements must be less than or equal to 1.
                  In other words, abs(arr[i] - arr[i - 1]) <= 1 for each i where 1 <= i < arr.length (0-indexed).
                  abs(x) is the absolute value of x.

            There are 2 types of operations that you can perform any number of times:
                * Decrease the value of any element of arr to a smaller positive integer.
                * Rearrange the elements of arr to be in any order.

            Return the maximum possible value of an element in arr after performing the operations to satisfy the conditions.

        Example:
            Input: arr = [100,1,1000]
            Output: 3
            Explanation:
                One possible way to satisfy the conditions is by doing the following:
                1. Rearrange arr so it becomes [1,100,1000].
                2. Decrease the value of the second element to 2.
                3. Decrease the value of the third element to 3.
                Now arr = [1,2,3], which satisfies the conditions.
                The largest element in arr is 3.""";

    public MaximumElementAfterDecreasingAndRearranging(int id, String description, TaskRevision revision) {
        super(id, description, revision);
        initialization();
    }

    private void initialization() {
        final var random = ThreadLocalRandom.current();

        this.array = random.ints(
            random.nextInt(1, LEN + 1),
            1, LEN + 1
        ).toArray();

        log.info("Array: {}", Arrays.toString(array));
    }

    @Override
    protected String getInformation() {
        return INFORMATION;
    }

    // time = 3484 ms
    @Override
    protected Integer original() {
        var original = new Original(array.clone());
        return original.process();
    }

    // time = 2922 ms
    @Override
    protected Integer practice() {
        var practice = new Practice(array.clone());
        return practice.process();
    }

    // time = 2150 ms
    @Override
    protected Integer solution() {
        var solution = new Solution(array.clone());
        return solution.process();
    }
}
