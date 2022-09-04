package com.witalis.praxis.leetcode.task.h3.p215;

import com.witalis.praxis.leetcode.task.LeetCodeTask;
import com.witalis.praxis.leetcode.task.h3.p215.option.*;
import com.witalis.praxis.leetcode.utils.LeetCode;
import com.witalis.praxis.leetcode.utils.TaskDifficulty;
import com.witalis.praxis.leetcode.utils.TaskRevision;

import lombok.extern.slf4j.Slf4j;
import java.util.Arrays;
import java.util.concurrent.ThreadLocalRandom;

import static com.witalis.praxis.leetcode.utils.TaskTag.*;

@Slf4j
@LeetCode(
    id = 215,
    description = "Kth Largest Element in an Array",
    difficulty = TaskDifficulty.MEDIUM,
    tags = {ARRAY, DIVIDE_AND_CONQUER, SORTING, HEAP, QUICK_SELECT}
)
public class KthLargestElementInArray extends LeetCodeTask<Integer> {
    public static final int LEN = 100_000;
    public static final int VALUE = 10_000;
    private int[] numbers;
    private int index;

    public static final String INFORMATION = """

        Given an integer array nums and an integer k, return the k^th largest element in the array.

        Note that it is the k^th largest element in the sorted order, not the k^th distinct element.

        You must solve it in O(n) time complexity.

        Example:
            Input: nums = [3,2,3,1,2,4,5,5,6], k = 4
            Output: 4""";

    public KthLargestElementInArray(int id, String description, TaskRevision revision) {
        super(id, description, revision);
        initialization();
    }

    private void initialization() {
        var random = ThreadLocalRandom.current();

        int len = random.nextInt(1, LEN + 1);
        this.numbers = random.ints(len, -VALUE,VALUE + 1).toArray();
        this.index = random.nextInt(1, len + 1);

        log.info("Numbers are {}", Arrays.toString(numbers));
        log.info("Index k is {}", index);
    }

    @Override
    protected String getInformation() {
        return INFORMATION;
    }

    // time = 4891 ms
    @Override
    protected Integer original() {
        var original = new Original(numbers, index);
        return original.process();
    }

    // time = 6146 ms
    @Override
    protected Integer practice() {
        var practice = new Practice(numbers, index);
        return practice.process();
    }

    // time = 787 ms
    @Override
    protected Integer solution() {
        var solution = new Solution(numbers, index);
        return solution.process();
    }
}
