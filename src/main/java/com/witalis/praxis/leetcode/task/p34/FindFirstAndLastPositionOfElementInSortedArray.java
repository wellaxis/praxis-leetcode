package com.witalis.praxis.leetcode.task.p34;

import com.witalis.praxis.leetcode.task.LeetCodeTask;
import com.witalis.praxis.leetcode.task.p34.option.*;
import com.witalis.praxis.leetcode.utils.LeetCode;
import com.witalis.praxis.leetcode.utils.TaskRevision;

import lombok.extern.slf4j.Slf4j;
import java.util.concurrent.ThreadLocalRandom;

@Slf4j
@LeetCode(id = 34, description = "Find First and Last Position of Element in Sorted Array")
public class FindFirstAndLastPositionOfElementInSortedArray extends LeetCodeTask<int[]> {
    public static final int LEN = (int) Math.pow(10, 5);
    public static final int VALUE = (int) Math.pow(10, 3);
    private int[] numbers;
    private int target;

    public static final String INFORMATION = """

        Given an array of integers nums sorted in non-decreasing order,
            find the starting and ending position of a given target value.

        If target is not found in the array, return [-1, -1].

        You must write an algorithm with O(log n) runtime complexity.

        Example:
            Input: nums = [5,7,7,8,8,10], target = 8
            Output: [3,4]""";

    public FindFirstAndLastPositionOfElementInSortedArray(int id, String description, TaskRevision revision) {
        super(id, description, revision);
        initialization();
    }

    private void initialization() {
        var random = ThreadLocalRandom.current();
        this.numbers = random.ints(
                random.nextInt(0, LEN + 1),
                -VALUE,
                VALUE + 1
            )
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

    // time = 618 ms
    @Override
    protected int[] original() {
        var original = new Original(numbers.clone(), target);
        return original.process();
    }

    // time = 517 ms
    @Override
    protected int[] practice() {
        var practice = new Practice(numbers.clone(), target);
        return practice.process();
    }

    // time = 560 ms
    @Override
    protected int[] solution() {
        var solution = new Solution(numbers.clone(), target);
        return solution.process();
    }
}
