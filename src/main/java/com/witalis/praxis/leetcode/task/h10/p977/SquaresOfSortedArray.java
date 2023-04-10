package com.witalis.praxis.leetcode.task.h10.p977;

import com.witalis.praxis.leetcode.task.LeetCodeTask;
import com.witalis.praxis.leetcode.task.h10.p977.option.*;
import com.witalis.praxis.leetcode.utils.LeetCode;
import com.witalis.praxis.leetcode.utils.TaskDifficulty;
import com.witalis.praxis.leetcode.utils.TaskRevision;

import lombok.extern.slf4j.Slf4j;
import java.util.Arrays;
import java.util.concurrent.ThreadLocalRandom;

import static com.witalis.praxis.leetcode.utils.TaskTag.*;

@Slf4j
@LeetCode(
    id = 977,
    description = "Squares of a Sorted Array",
    difficulty = TaskDifficulty.EASY,
    tags = {ARRAY, TWO_POINTERS, SORTING}
)
public class SquaresOfSortedArray extends LeetCodeTask<int[]> {
    public static final int LEN = 10_000;
    public static final int VALUE = 10_000;

    private int[] numbers;

    public static final String INFORMATION = """

        Description:
            Given an integer array nums sorted in non-decreasing order,
                return an array of the squares of each number sorted in non-decreasing order.

        Example:
            Input: nums = [-4,-1,0,3,10]
            Output: [0,1,9,16,100]
            Explanation: After squaring, the array becomes [16,1,0,9,100].
                After sorting, it becomes [0,1,9,16,100].""";

    public SquaresOfSortedArray(int id, String description, TaskRevision revision) {
        super(id, description, revision);
        initialization();
    }

    private void initialization() {
        final var random = ThreadLocalRandom.current();

        this.numbers = random.ints(
            random.nextInt(1, LEN + 1),
            -VALUE, VALUE + 1
        ).sorted().toArray();

        log.info("Numbers: {}", Arrays.toString(numbers));
    }

    @Override
    protected String getInformation() {
        return INFORMATION;
    }

    // time = 665 ms
    @Override
    protected int[] original() {
        var original = new Original(numbers.clone());
        return original.process();
    }

    // time = 532 ms
    @Override
    protected int[] practice() {
        var practice = new Practice(numbers.clone());
        return practice.process();
    }

    // time = 487 ms
    @Override
    protected int[] solution() {
        var solution = new Solution(numbers.clone());
        return solution.process();
    }
}
