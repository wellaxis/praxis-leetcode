package com.witalis.praxis.leetcode.task.h24.p2369;

import com.witalis.praxis.leetcode.task.LeetCodeTask;
import com.witalis.praxis.leetcode.task.h24.p2369.option.*;
import com.witalis.praxis.leetcode.utils.LeetCode;
import com.witalis.praxis.leetcode.utils.TaskDifficulty;
import com.witalis.praxis.leetcode.utils.TaskRevision;

import lombok.extern.slf4j.Slf4j;
import java.util.Arrays;
import java.util.concurrent.ThreadLocalRandom;

import static com.witalis.praxis.leetcode.utils.TaskTag.*;

@Slf4j
@LeetCode(
    id = 2369,
    description = "Check if There is a Valid Partition For The Array",
    difficulty = TaskDifficulty.MEDIUM,
    tags = {ARRAY, DYNAMIC_PROGRAMMING}
)
public class CheckIfThereIsValidPartitionForArray extends LeetCodeTask<Boolean> {
    public static final int LEN = 100_000;
    public static final int VALUE = 1_000_000;

    private int[] numbers;

    public static final String INFORMATION = """

        Description:
            You are given a 0-indexed integer array nums. You have to partition the array into one or more contiguous subarrays.

            We call a partition of the array valid if each of the obtained subarrays satisfies one of the following conditions:
                * The subarray consists of exactly 2 equal elements. For example, the subarray [2,2] is good.
                * The subarray consists of exactly 3 equal elements. For example, the subarray [4,4,4] is good.
                * The subarray consists of exactly 3 consecutive increasing elements, that is, the difference between adjacent elements is 1.
                  For example, the subarray [3,4,5] is good, but the subarray [1,3,5] is not.

            Return true if the array has at least one valid partition. Otherwise, return false.

        Example:
            Input: nums = [4,4,4,5,6]
            Output: true
            Explanation: The array can be partitioned into the subarrays [4,4] and [4,5,6].
                This partition is valid, so we return true.""";

    public CheckIfThereIsValidPartitionForArray(int id, String description, TaskRevision revision) {
        super(id, description, revision);
        initialization();
    }

    private void initialization() {
        final var random = ThreadLocalRandom.current();

        this.numbers = random.ints(
            random.nextInt(2, LEN + 1),
            1,
            VALUE + 1
        ).toArray();

        log.info("Numbers: {}", Arrays.toString(numbers));
    }

    @Override
    protected String getInformation() {
        return INFORMATION;
    }

    // time = 525 ms
    @Override
    protected Boolean original() {
        var original = new Original(numbers);
        return original.process();
    }

    // time = 505 ms
    @Override
    protected Boolean practice() {
        var practice = new Practice(numbers);
        return practice.process();
    }

    // time = 5628 ms
    @Override
    protected Boolean solution() {
        var solution = new Solution(numbers);
        return solution.process();
    }
}
