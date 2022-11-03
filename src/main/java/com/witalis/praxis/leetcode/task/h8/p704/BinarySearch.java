package com.witalis.praxis.leetcode.task.h8.p704;

import com.witalis.praxis.leetcode.task.LeetCodeTask;
import com.witalis.praxis.leetcode.task.h8.p704.option.*;
import com.witalis.praxis.leetcode.utils.LeetCode;
import com.witalis.praxis.leetcode.utils.TaskDifficulty;
import com.witalis.praxis.leetcode.utils.TaskRevision;

import lombok.extern.slf4j.Slf4j;
import java.util.Arrays;
import java.util.concurrent.ThreadLocalRandom;

import static com.witalis.praxis.leetcode.utils.TaskTag.*;

@Slf4j
@LeetCode(
    id = 704,
    description = "Binary Search",
    difficulty = TaskDifficulty.EASY,
    tags = {ARRAY, BINARY_SEARCH}
)
public class BinarySearch extends LeetCodeTask<Integer> {
    public static final int LEN = 10_000;
    public static final int VALUE = 10_000;
    private int[] numbers;
    private int target;

    public static final String INFORMATION = """

        Description:
            Given an array of integers nums which is sorted in ascending order, and an integer target,
                write a function to search target in nums. If target exists, then return its index. Otherwise, return -1.

            You must write an algorithm with O(log n) runtime complexity.

        Example:
            Input: nums = [-1,0,3,5,9,12], target = 9
            Output: 4
            Explanation: 9 exists in nums and its index is 4""";

    public BinarySearch(int id, String description, TaskRevision revision) {
        super(id, description, revision);
        initialization();
    }

    private void initialization() {
        var random = ThreadLocalRandom.current();
        this.numbers = random.ints(
            random.nextInt(1, LEN + 1),
            -VALUE,
            VALUE + 1
        ).distinct().sorted().toArray();
        this.target = random.nextInt(-VALUE, VALUE + 1);

        log.info("Numbers are {}", Arrays.toString(numbers));
        log.info("Target is {}", target);
    }

    @Override
    protected String getInformation() {
        return INFORMATION;
    }

    // time = 1346 ms
    @Override
    protected Integer original() {
        var original = new Original(numbers, target);
        return original.process();
    }

    // time = 963 ms
    @Override
    protected Integer practice() {
        var practice = new Practice(numbers, target);
        return practice.process();
    }

    // time = 810 ms
    @Override
    protected Integer solution() {
        var solution = new Solution(numbers, target);
        return solution.process();
    }
}
