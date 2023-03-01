package com.witalis.praxis.leetcode.task.h10.p912;

import com.witalis.praxis.leetcode.task.LeetCodeTask;
import com.witalis.praxis.leetcode.task.h10.p912.option.*;
import com.witalis.praxis.leetcode.utils.LeetCode;
import com.witalis.praxis.leetcode.utils.TaskDifficulty;
import com.witalis.praxis.leetcode.utils.TaskRevision;

import lombok.extern.slf4j.Slf4j;
import java.util.Arrays;
import java.util.concurrent.ThreadLocalRandom;

import static com.witalis.praxis.leetcode.utils.TaskTag.*;

@Slf4j
@LeetCode(
    id = 912,
    description = "Sort an Array",
    difficulty = TaskDifficulty.MEDIUM,
    tags = {ARRAY, DIVIDE_AND_CONQUER, SORTING, HEAP, MERGE_SORT, BUCKET_SORT, RADIX_SORT, COUNTING_SORT}
)
public class SortArray extends LeetCodeTask<int[]> {
    public static final int LEN = 50_000;
    public static final int VALUE = 50_000;

    private int[] numbers;

    public static final String INFORMATION = """

        Description:
            Given an array of integers nums, sort the array in ascending order and return it.

            You must solve the problem without using any built-in functions in O(nlog(n)) time complexity
                and with the smallest space complexity possible.

        Example:
            Input: nums = [5,1,1,2,0,0]
            Output: [0,0,1,1,2,5]
            Explanation: Note that the values of nums are not necessary unique.""";

    public SortArray(int id, String description, TaskRevision revision) {
        super(id, description, revision);
        initialization();
    }

    private void initialization() {
        final var random = ThreadLocalRandom.current();

        this.numbers = random.ints(
            random.nextInt(1, LEN + 1),
            -VALUE, VALUE + 1
        ).distinct().toArray();

        log.info("Numbers: {}", Arrays.toString(numbers));
    }

    @Override
    protected String getInformation() {
        return INFORMATION;
    }

    // time = 13605 ms
    @Override
    protected int[] original() {
        var original = new Original(numbers.clone());
        return original.process();
    }

    // time = 13344 ms
    @Override
    protected int[] practice() {
        var practice = new Practice(numbers.clone());
        return practice.process();
    }

    // time = 6109 ms
    @Override
    protected int[] solution() {
        var solution = new Solution(numbers.clone());
        return solution.process();
    }
}
