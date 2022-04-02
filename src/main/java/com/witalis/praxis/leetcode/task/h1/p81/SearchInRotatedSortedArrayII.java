package com.witalis.praxis.leetcode.task.h1.p81;

import com.witalis.praxis.leetcode.task.LeetCodeTask;
import com.witalis.praxis.leetcode.task.h1.p81.option.*;
import com.witalis.praxis.leetcode.utils.LeetCode;
import com.witalis.praxis.leetcode.utils.TaskDifficulty;
import com.witalis.praxis.leetcode.utils.TaskRevision;
import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;
import java.util.stream.IntStream;

import static com.witalis.praxis.leetcode.utils.TaskTag.ARRAY;
import static com.witalis.praxis.leetcode.utils.TaskTag.BINARY_SEARCH;

@Slf4j
@LeetCode(
    id = 81,
    description = "Search in Rotated Sorted Array",
    difficulty = TaskDifficulty.MEDIUM,
    tags = {ARRAY, BINARY_SEARCH}
)
public class SearchInRotatedSortedArrayII extends LeetCodeTask<Boolean> {
    public static final int LEN = 5_000;
    public static final int VALUE = 10_000;
    private int[] numbers;
    private int target;

    public static final String INFORMATION = """

        There is an integer array nums sorted in non-decreasing order
            (not necessarily with distinct values).

        Before being passed to your function, nums is rotated
            at an unknown pivot index k (0 <= k < nums.length)
            such that the resulting array is
            [nums[k], nums[k+1], ..., nums[n-1], nums[0], nums[1], ..., nums[k-1]] (0-indexed).
            For example, [0,1,2,4,4,4,5,6,6,7] might be rotated
            at pivot index 5 and become [4,5,6,6,7,0,1,2,4,4].

        Given the array nums after the rotation and an integer target,
            return true if target is in nums, or false if it is not in nums.

        You must decrease the overall operation steps as much as possible.

        Example:
            Input: nums = [2,5,6,0,0,1,2], target = 3
            Output: false""";

    public SearchInRotatedSortedArrayII(int id, String description, TaskRevision revision) {
        super(id, description, revision);
        initialization();
    }

    private void initialization() {
        var random = ThreadLocalRandom.current();
        List<Integer> integers = new ArrayList<>(
            IntStream.generate(
                    () -> random.nextInt(-VALUE, VALUE + 1)
                )
                .limit(random.nextInt(1, LEN + 1))
                .sorted()
                .boxed()
                .toList()
        );
        Collections.rotate(integers, random.nextInt(1, integers.size()));

        this.numbers = integers.stream().mapToInt(Integer::intValue).toArray();
        this.target = random.nextInt(-VALUE, VALUE + 1);

        log.info("Numbers are {}", numbers);
        log.info("Target is {}", target);
    }

    @Override
    protected String getInformation() {
        return INFORMATION;
    }

    // time = 769 ms
    @Override
    protected Boolean original() {
        var original = new Original(numbers.clone(), target);
        return original.process();
    }

    // time = 433 ms
    @Override
    protected Boolean practice() {
        var practice = new Practice(numbers.clone(), target);
        return practice.process();
    }

    // time = 542 ms
    @Override
    protected Boolean solution() {
        var solution = new Solution(numbers.clone(), target);
        return solution.process();
    }
}
