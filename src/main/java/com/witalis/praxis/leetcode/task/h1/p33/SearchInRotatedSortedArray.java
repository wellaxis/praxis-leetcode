package com.witalis.praxis.leetcode.task.h1.p33;

import com.witalis.praxis.leetcode.task.LeetCodeTask;
import com.witalis.praxis.leetcode.task.h1.p33.option.*;
import com.witalis.praxis.leetcode.utils.LeetCode;
import com.witalis.praxis.leetcode.utils.TaskDifficulty;
import com.witalis.praxis.leetcode.utils.TaskRevision;

import lombok.extern.slf4j.Slf4j;
import java.util.concurrent.ThreadLocalRandom;

import static com.witalis.praxis.leetcode.utils.TaskTag.*;

@Slf4j
@LeetCode(
    id = 33,
    description = "Search in Rotated Sorted Array",
    difficulty = TaskDifficulty.MEDIUM,
    tags = {ARRAY, BINARY_SEARCH}
)
public class SearchInRotatedSortedArray extends LeetCodeTask<Integer> {
    public static final int LEN = 5_000;
    public static final int VALUE = 10_000;
    private int[] numbers;
    private int target;

    public static final String INFORMATION = """

        There is an integer array nums
            sorted in ascending order (with distinct values).

        Prior to being passed to your function, nums is possibly rotated
            at an unknown pivot index k (1 <= k < nums.length)
            such that the resulting array is [nums[k], nums[k+1], ..., nums[n-1],
            nums[0], nums[1], ..., nums[k-1]] (0-indexed).
            For example, [0,1,2,4,5,6,7] might be rotated
            at pivot index 3 and become [4,5,6,7,0,1,2].

        Given the array nums after the possible rotation and an integer target,
            return the index of target if it is in nums, or -1 if it is not in nums.

        You must write an algorithm with O(log n) runtime complexity.

        Example:
            Input: nums = [4,5,6,7,0,1,2], target = 0
            Output: 4""";

    public SearchInRotatedSortedArray(int id, String description, TaskRevision revision) {
        super(id, description, revision);
        initialization();
    }

    private void initialization() {
        var random = ThreadLocalRandom.current();
        this.numbers = random.ints(-VALUE, VALUE + 1)
            .distinct()
            .limit(LEN)
            .sorted()
            .toArray();

        this.target = random.nextInt(-VALUE, VALUE + 1);

        log.info("Numbers are {}", numbers);
        log.info("Target is {}", target);
    }

    @Override
    protected String getInformation() {
        return INFORMATION;
    }

    // time = 529 ms
    @Override
    protected Integer original() {
        var original = new Original(numbers.clone(), target);
        return original.process();
    }

    // time = 436 ms
    @Override
    protected Integer practice() {
        var practice = new Practice(numbers.clone(), target);
        return practice.process();
    }

    // time = 409 ms
    @Override
    protected Integer solution() {
        var solution = new Solution(numbers.clone(), target);
        return solution.process();
    }
}
