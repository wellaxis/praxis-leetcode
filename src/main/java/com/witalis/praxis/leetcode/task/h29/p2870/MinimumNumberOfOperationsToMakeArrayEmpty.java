package com.witalis.praxis.leetcode.task.h29.p2870;

import com.witalis.praxis.leetcode.task.LeetCodeTask;
import com.witalis.praxis.leetcode.task.h29.p2870.option.*;
import com.witalis.praxis.leetcode.utils.LeetCode;
import com.witalis.praxis.leetcode.utils.TaskDifficulty;
import com.witalis.praxis.leetcode.utils.TaskRevision;

import lombok.extern.slf4j.Slf4j;
import java.util.Arrays;
import java.util.concurrent.ThreadLocalRandom;

import static com.witalis.praxis.leetcode.utils.TaskTag.*;

@Slf4j
@LeetCode(
    id = 2870,
    description = "Minimum Number of Operations to Make Array Empty",
    difficulty = TaskDifficulty.MEDIUM,
    tags = {ARRAY, HASH_TABLE, GREEDY, COUNTING}
)
public class MinimumNumberOfOperationsToMakeArrayEmpty extends LeetCodeTask<Integer> {
    public static final int LEN = 100_000;
    public static final int VALUE = 1_000_000;

    private int[] numbers;

    public static final String INFORMATION = """

        Description:
            You are given a 0-indexed array nums consisting of positive integers.

            There are two types of operations that you can apply on the array any number of times:
                * Choose two elements with equal values and delete them from the array.
                * Choose three elements with equal values and delete them from the array.

            Return the minimum number of operations required to make the array empty, or -1 if it is not possible.

        Example:
            Input: nums = [2,3,3,2,2,4,2,3,4]
            Output: 4
            Explanation: We can apply the following operations to make the array empty:
                - Apply the first operation on the elements at indices 0 and 3. The resulting array is nums = [3,3,2,4,2,3,4].
                - Apply the first operation on the elements at indices 2 and 4. The resulting array is nums = [3,3,4,3,4].
                - Apply the second operation on the elements at indices 0, 1, and 3. The resulting array is nums = [4,4].
                - Apply the first operation on the elements at indices 0 and 1. The resulting array is nums = [].
                It can be shown that we cannot make the array empty in less than 4 operations.""";

    public MinimumNumberOfOperationsToMakeArrayEmpty(int id, String description, TaskRevision revision) {
        super(id, description, revision);
        initialization();
    }

    private void initialization() {
        final var random = ThreadLocalRandom.current();

        this.numbers = random.ints(
            random.nextInt(2, LEN + 1),
            1, VALUE + 1
        ).toArray();

        log.info("Numbers: {}", Arrays.toString(numbers));
    }

    @Override
    protected String getInformation() {
        return INFORMATION;
    }

    // time = 20168 ms
    @Override
    protected Integer original() {
        var original = new Original(numbers.clone());
        return original.process();
    }

    // time = 17632 ms
    @Override
    protected Integer practice() {
        var practice = new Practice(numbers.clone());
        return practice.process();
    }

    // time = 10421 ms
    @Override
    protected Integer solution() {
        var solution = new Solution(numbers.clone());
        return solution.process();
    }
}
