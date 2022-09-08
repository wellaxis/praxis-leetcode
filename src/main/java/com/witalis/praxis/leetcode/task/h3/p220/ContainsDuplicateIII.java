package com.witalis.praxis.leetcode.task.h3.p220;

import com.witalis.praxis.leetcode.task.LeetCodeTask;
import com.witalis.praxis.leetcode.task.h3.p220.option.*;
import com.witalis.praxis.leetcode.utils.LeetCode;
import com.witalis.praxis.leetcode.utils.TaskDifficulty;
import com.witalis.praxis.leetcode.utils.TaskRevision;

import lombok.extern.slf4j.Slf4j;
import java.util.concurrent.ThreadLocalRandom;

import static com.witalis.praxis.leetcode.utils.TaskTag.*;

@Slf4j
@LeetCode(
    id = 220,
    description = "Contains Duplicate III",
    difficulty = TaskDifficulty.HARD,
    tags = {ARRAY, SLIDING_WINDOW, SORTING, BUCKET_SORT, ORDERED_SET}
)
public class ContainsDuplicateIII extends LeetCodeTask<Boolean> {
    public static final int LEN = 20_000;
    public static final int VALUE = 10_000;
    private int[] numbers;
    private int indexDiff;
    private int valueDiff;

    public static final String INFORMATION = """

        Given an integer array nums and two integers k and t,
            return true if there are two distinct indices i and j in the array
            such that abs(nums[i] - nums[j]) <= t and abs(i - j) <= k.

        Example:
            Input: nums = [1,2,3,1], k = 3, t = 0
            Output: true""";

    public ContainsDuplicateIII(int id, String description, TaskRevision revision) {
        super(id, description, revision);
        initialization();
    }

    private void initialization() {
        var random = ThreadLocalRandom.current();

        this.numbers = random.ints(random.nextInt(1, LEN + 1), Integer.MIN_VALUE, Integer.MAX_VALUE).toArray();
        this.indexDiff = random.nextInt(0, VALUE + 1);
        this.valueDiff = random.nextInt(0, Integer.MAX_VALUE);

        log.info("Numbers are {}", numbers);
        log.info("Number K is {}", indexDiff);
        log.info("Number T is {}", valueDiff);
    }

    @Override
    protected String getInformation() {
        return INFORMATION;
    }

    // time = 21540 ms
    @Override
    protected Boolean original() {
        var original = new Original(numbers.clone(), indexDiff, valueDiff);
        return original.process();
    }

    // time = 980 ms
    @Override
    protected Boolean practice() {
        var practice = new Practice(numbers.clone(), indexDiff, valueDiff);
        return practice.process();
    }

    // time = 510 ms
    @Override
    protected Boolean solution() {
        var solution = new Solution(numbers.clone(), indexDiff, valueDiff);
        return solution.process();
    }
}
