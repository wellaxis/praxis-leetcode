package com.witalis.praxis.leetcode.task.h30.p2903;

import com.witalis.praxis.leetcode.task.LeetCodeTask;
import com.witalis.praxis.leetcode.task.h30.p2903.option.*;
import com.witalis.praxis.leetcode.utils.LeetCode;
import com.witalis.praxis.leetcode.utils.TaskDifficulty;
import com.witalis.praxis.leetcode.utils.TaskRevision;

import lombok.extern.slf4j.Slf4j;
import java.util.Arrays;
import java.util.concurrent.ThreadLocalRandom;

import static com.witalis.praxis.leetcode.utils.TaskTag.*;

@Slf4j
@LeetCode(
    id = 2903,
    description = "Find Indices With Index and Value Difference I",
    difficulty = TaskDifficulty.EASY,
    tags = {ARRAY}
)
public class FindIndicesWithIndexAndValueDifferenceI extends LeetCodeTask<int[]> {
    public static final int LEN = 100;
    public static final int VALUE = 50;

    private int[] numbers;
    private int indexDifference;
    private int valueDifference;

    public static final String INFORMATION = """

        Description:
            You are given a 0-indexed integer array nums having length n, an integer indexDifference, and an integer valueDifference.

            Your task is to find two indices i and j, both in the range [0, n - 1], that satisfy the following conditions:
                * abs(i - j) >= indexDifference, and
                * abs(nums[i] - nums[j]) >= valueDifference

            Return an integer array answer, where answer = [i, j] if there are two such indices, and answer = [-1, -1] otherwise.
                If there are multiple choices for the two indices, return any of them.

            Note: i and j may be equal.

        Example:
            Input: nums = [5,1,4,1], indexDifference = 2, valueDifference = 4
            Output: [0,3]
            Explanation: In this example, i = 0 and j = 3 can be selected.
                abs(0 - 3) >= 2 and abs(nums[0] - nums[3]) >= 4.
                Hence, a valid answer is [0,3]. [3,0] is also a valid answer.""";

    public FindIndicesWithIndexAndValueDifferenceI(int id, String description, TaskRevision revision) {
        super(id, description, revision);
        initialization();
    }

    private void initialization() {
        final var random = ThreadLocalRandom.current();

        this.numbers = random.ints(
            random.nextInt(1, LEN + 1),
            0, VALUE + 1
        ).toArray();
        this.indexDifference = random.nextInt(0, LEN + 1);
        this.valueDifference = random.nextInt(0, VALUE + 1);

        log.info("Numbers: {}", Arrays.toString(numbers));
        log.info("Index Difference: {}", indexDifference);
        log.info("Value Difference: {}", valueDifference);
    }

    @Override
    protected String getInformation() {
        return INFORMATION;
    }

    // time = 608 ms
    @Override
    protected int[] original() {
        var original = new Original(numbers, indexDifference, valueDifference);
        return original.process();
    }

    // time = 603 ms
    @Override
    protected int[] practice() {
        var practice = new Practice(numbers, indexDifference, valueDifference);
        return practice.process();
    }

    // time = 495 ms
    @Override
    protected int[] solution() {
        var solution = new Solution(numbers, indexDifference, valueDifference);
        return solution.process();
    }
}
