package com.witalis.praxis.leetcode.task.h11.p1013;

import com.witalis.praxis.leetcode.task.LeetCodeTask;
import com.witalis.praxis.leetcode.task.h11.p1013.option.*;
import com.witalis.praxis.leetcode.utils.LeetCode;
import com.witalis.praxis.leetcode.utils.TaskDifficulty;
import com.witalis.praxis.leetcode.utils.TaskRevision;

import lombok.extern.slf4j.Slf4j;
import java.util.Arrays;
import java.util.concurrent.ThreadLocalRandom;

import static com.witalis.praxis.leetcode.utils.TaskTag.*;

@Slf4j
@LeetCode(
    id = 1013,
    description = "Partition Array Into Three Parts With Equal Sum",
    difficulty = TaskDifficulty.EASY,
    tags = {ARRAY, GREEDY}
)
public class PartitionArrayIntoThreePartsWithEqualSum extends LeetCodeTask<Boolean> {
    public static final int LEN = 50_000;
    public static final int VALUE = 10_000;

    private int[] numbers;

    public static final String INFORMATION = """

        Description:
            Given an array of integers arr, return true if we can partition the array into three non-empty parts with equal sums.

            Formally, we can partition the array if we can find indexes i + 1 < j with
                (arr[0] + arr[1] + ... + arr[i] == arr[i + 1] + arr[i + 2] + ... + arr[j - 1] == arr[j] + arr[j + 1] + ... + arr[arr.length - 1])

        Example:
            Input: arr = [0,2,1,-6,6,-7,9,1,2,0,1]
            Output: true
            Explanation: 0 + 2 + 1 = -6 + 6 - 7 + 9 + 1 = 2 + 0 + 1""";

    public PartitionArrayIntoThreePartsWithEqualSum(int id, String description, TaskRevision revision) {
        super(id, description, revision);
        initialization();
    }

    private void initialization() {
        final var random = ThreadLocalRandom.current();

        this.numbers = random.ints(
            random.nextInt(3, LEN + 1),
            -VALUE, VALUE + 1
        ).toArray();

        log.info("Array: {}", Arrays.toString(numbers));
    }

    @Override
    protected String getInformation() {
        return INFORMATION;
    }

    // time = 1939 ms
    @Override
    protected Boolean original() {
        var original = new Original(numbers.clone());
        return original.process();
    }

    // time = 1215 ms
    @Override
    protected Boolean practice() {
        var practice = new Practice(numbers.clone());
        return practice.process();
    }

    // time = 1687 ms
    @Override
    protected Boolean solution() {
        var solution = new Solution(numbers.clone());
        return solution.process();
    }
}
