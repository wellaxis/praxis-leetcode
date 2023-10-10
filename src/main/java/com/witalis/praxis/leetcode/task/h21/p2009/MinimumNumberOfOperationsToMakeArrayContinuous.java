package com.witalis.praxis.leetcode.task.h21.p2009;

import com.witalis.praxis.leetcode.task.LeetCodeTask;
import com.witalis.praxis.leetcode.task.h21.p2009.option.*;
import com.witalis.praxis.leetcode.utils.LeetCode;
import com.witalis.praxis.leetcode.utils.TaskDifficulty;
import com.witalis.praxis.leetcode.utils.TaskRevision;

import lombok.extern.slf4j.Slf4j;
import java.util.Arrays;
import java.util.concurrent.ThreadLocalRandom;

import static com.witalis.praxis.leetcode.utils.TaskTag.*;

@Slf4j
@LeetCode(
    id = 2009,
    description = "Minimum Number of Operations to Make Array Continuous",
    difficulty = TaskDifficulty.HARD,
    tags = {ARRAY, BINARY_SEARCH}
)
public class MinimumNumberOfOperationsToMakeArrayContinuous extends LeetCodeTask<Integer> {
    public static final int LEN = 100_000;
    public static final int VALUE = 1_000_000_000;

    private int[] numbers;

    public static final String INFORMATION = """

        Description:
            You are given an integer array nums. In one operation, you can replace any element in nums with any integer.

            nums is considered continuous if both of the following conditions are fulfilled:
                * All elements in nums are unique.
                * The difference between the maximum element and the minimum element in nums equals nums.length - 1.

            For example, nums = [4, 2, 5, 3] is continuous, but nums = [1, 2, 3, 5, 6] is not continuous.

            Return the minimum number of operations to make nums continuous.

        Example:
            Input: nums = [1,2,3,5,6]
            Output: 1
            Explanation: One possible solution is to change the last element to 4.
                The resulting array is [1,2,3,5,4], which is continuous.""";

    public MinimumNumberOfOperationsToMakeArrayContinuous(int id, String description, TaskRevision revision) {
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

    // time = 7287 ms
    @Override
    protected Integer original() {
        var original = new Original(numbers.clone());
        return original.process();
    }

    // time = 7160 ms
    @Override
    protected Integer practice() {
        var practice = new Practice(numbers.clone());
        return practice.process();
    }

    // time = 4459 ms
    @Override
    protected Integer solution() {
        var solution = new Solution(numbers.clone());
        return solution.process();
    }
}
