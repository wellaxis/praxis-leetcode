package com.witalis.praxis.leetcode.task.h5.p448;

import com.witalis.praxis.leetcode.task.LeetCodeTask;
import com.witalis.praxis.leetcode.task.h5.p448.option.*;
import com.witalis.praxis.leetcode.utils.LeetCode;
import com.witalis.praxis.leetcode.utils.TaskDifficulty;
import com.witalis.praxis.leetcode.utils.TaskRevision;

import lombok.extern.slf4j.Slf4j;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

import static com.witalis.praxis.leetcode.utils.TaskTag.*;

@Slf4j
@LeetCode(
    id = 448,
    description = "Find All Numbers Disappeared in an Array",
    difficulty = TaskDifficulty.EASY,
    tags = {ARRAY, HASH_TABLE}
)
public class FindAllNumbersDisappearedInArray extends LeetCodeTask<List<Integer>> {
    public static final int LEN = 100_000;
    private int[] numbers;

    public static final String INFORMATION = """

        Given an array nums of n integers where nums[i] is in the range [1, n],
            return an array of all the integers in the range [1, n] that do not appear in nums.

        Example:
            Input: nums = [4,3,2,7,8,2,3,1]
            Output: [5,6]""";

    public FindAllNumbersDisappearedInArray(int id, String description, TaskRevision revision) {
        super(id, description, revision);
        initialization();
    }

    private void initialization() {
        final var random = ThreadLocalRandom.current();
        int len = random.nextInt(1, LEN + 1);

        this.numbers = new int[len];
        for (int i = 0; i < len; i++) {
            numbers[i] = random.nextInt(1, len + 1);
        }

        log.info("Numbers are {}", numbers);
    }

    @Override
    protected String getInformation() {
        return INFORMATION;
    }

    // time = 10378368 ms, time limit exceeded
    @Override
    protected List<Integer> original() {
        var original = new Original(numbers.clone());
        return original.process();
    }

    // time = 4431 ms
    @Override
    protected List<Integer> practice() {
        var practice = new Practice(numbers.clone());
        return practice.process();
    }

    // time = 4460 ms
    @Override
    protected List<Integer> solution() {
        var solution = new Solution(numbers.clone());
        return solution.process();
    }
}
