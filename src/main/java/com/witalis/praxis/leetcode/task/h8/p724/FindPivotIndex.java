package com.witalis.praxis.leetcode.task.h8.p724;

import com.witalis.praxis.leetcode.task.LeetCodeTask;
import com.witalis.praxis.leetcode.task.h8.p724.option.*;
import com.witalis.praxis.leetcode.utils.LeetCode;
import com.witalis.praxis.leetcode.utils.TaskDifficulty;
import com.witalis.praxis.leetcode.utils.TaskRevision;

import lombok.extern.slf4j.Slf4j;
import java.util.Arrays;
import java.util.concurrent.ThreadLocalRandom;

import static com.witalis.praxis.leetcode.utils.TaskTag.*;

@Slf4j
@LeetCode(
    id = 724,
    description = "Find Pivot Index",
    difficulty = TaskDifficulty.EASY,
    tags = {ARRAY, PREFIX_SUM}
)
public class FindPivotIndex extends LeetCodeTask<Integer> {
    public static final int LEN = 10_000;
    public static final int VALUE = 1_000;
    private int[] numbers;

    public static final String INFORMATION = """

        Description:
            Given an array of integers nums, calculate the pivot index of this array.

            The pivot index is the index where the sum of all the numbers strictly
                to the left of the index is equal to the sum of all the numbers strictly to the index's right.

            If the index is on the left edge of the array, then the left sum is 0 because
                there are no elements to the left. This also applies to the right edge of the array.

            Return the leftmost pivot index. If no such index exists, return -1.

        Example:
            Input: nums = [1,7,3,6,5,6]
            Output: 3
            Explanation:
                The pivot index is 3.
                Left sum = nums[0] + nums[1] + nums[2] = 1 + 7 + 3 = 11
                Right sum = nums[4] + nums[5] = 5 + 6 = 11""";

    public FindPivotIndex(int id, String description, TaskRevision revision) {
        super(id, description, revision);
        initialization();
    }

    private void initialization() {
        final var random = ThreadLocalRandom.current();

        this.numbers = random.ints(
            random.nextInt(1, LEN + 1),
            -VALUE, VALUE + 1
        ).toArray();

        log.info("Numbers is {}", Arrays.toString(numbers));
    }

    @Override
    protected String getInformation() {
        return INFORMATION;
    }

    // time = 2220 ms
    @Override
    protected Integer original() {
        var original = new Original(numbers);
        return original.process();
    }

    // time = 2178 ms
    @Override
    protected Integer practice() {
        var practice = new Practice(numbers);
        return practice.process();
    }

    // time = 1506 ms
    @Override
    protected Integer solution() {
        var solution = new Solution(numbers);
        return solution.process();
    }
}
