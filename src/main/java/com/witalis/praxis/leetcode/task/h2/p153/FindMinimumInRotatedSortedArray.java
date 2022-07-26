package com.witalis.praxis.leetcode.task.h2.p153;

import com.witalis.praxis.leetcode.task.LeetCodeTask;
import com.witalis.praxis.leetcode.task.h2.p153.option.*;
import com.witalis.praxis.leetcode.utils.LeetCode;
import com.witalis.praxis.leetcode.utils.TaskDifficulty;
import com.witalis.praxis.leetcode.utils.TaskRevision;

import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;
import java.util.stream.IntStream;

import static com.witalis.praxis.leetcode.utils.TaskTag.*;

@Slf4j
@LeetCode(
    id = 153,
    description = "Find Minimum in Rotated Sorted Array",
    difficulty = TaskDifficulty.MEDIUM,
    tags = {ARRAY, BINARY_SEARCH}
)
public class FindMinimumInRotatedSortedArray extends LeetCodeTask<Integer> {
    public static final int LEN = 5_000;
    public static final int VALUE = 5_000;
    private int[] numbers;

    public static final String INFORMATION = """

        Suppose an array of length n sorted in ascending order is rotated between 1 and n times.
            For example, the array nums = [0,1,2,4,5,6,7] might become:
            * [4,5,6,7,0,1,2] if it was rotated 4 times.
            * [0,1,2,4,5,6,7] if it was rotated 7 times.

        Notice that rotating an array [a[0], a[1], a[2], ..., a[n-1]] 1 time
            results in the array [a[n-1], a[0], a[1], a[2], ..., a[n-2]].

        Given the sorted rotated array nums of unique elements, return the minimum element of this array.

        You must write an algorithm that runs in O(log n) time.

        Example:
            Input: nums = [4,5,6,7,0,1,2]
            Output: 0
            Explanation: The original array was [0,1,2,4,5,6,7] and it was rotated 4 times.""";

    public FindMinimumInRotatedSortedArray(int id, String description, TaskRevision revision) {
        super(id, description, revision);
        initialization();
    }

    private void initialization() {
        var random = ThreadLocalRandom.current();
        int length = random.nextInt(1, LEN + 1);

        List<Integer> nums = new ArrayList<>(IntStream.rangeClosed(1, length).boxed().toList());
        Collections.rotate(nums, random.nextInt(1, length));
        this.numbers = nums.stream().mapToInt(Integer::intValue).toArray();

        log.info("Numbers are {}", Arrays.toString(numbers));
    }

    @Override
    protected String getInformation() {
        return INFORMATION;
    }

    // time = 593 ms
    @Override
    protected Integer original() {
        var original = new Original(numbers.clone());
        return original.process();
    }

    // time = 564 ms
    @Override
    protected Integer practice() {
        var practice = new Practice(numbers.clone());
        return practice.process();
    }

    // time = 479 ms
    @Override
    protected Integer solution() {
        var solution = new Solution(numbers.clone());
        return solution.process();
    }
}
