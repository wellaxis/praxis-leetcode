package com.witalis.praxis.leetcode.task.p75;

import com.witalis.praxis.leetcode.task.LeetCodeTask;
import com.witalis.praxis.leetcode.task.p75.option.*;
import com.witalis.praxis.leetcode.utils.LeetCode;
import com.witalis.praxis.leetcode.utils.TaskRevision;

import lombok.extern.slf4j.Slf4j;
import java.util.concurrent.ThreadLocalRandom;

@Slf4j
@LeetCode(id = 75, description = "Sort Colors")
public class SortColors extends LeetCodeTask<int[]> {
    public static final int LEN = 300;
    private int[] numbers;

    public static final String INFORMATION = """

        Given an array nums with n objects colored red, white, or blue,
            sort them in-place so that objects of the same color are adjacent,
            with the colors in the order red, white, and blue.

        We will use the integers 0, 1, and 2 to represent
            the color red, white, and blue, respectively.

        You must solve this problem without using the library's sort function.

        Example:
            Input: nums = [2,0,2,1,1,0]
            Output: [0,0,1,1,2,2]""";

    public SortColors(int id, String description, TaskRevision revision) {
        super(id, description, revision);
        initialization();
    }

    private void initialization() {
        var random = ThreadLocalRandom.current();
        this.numbers = random.ints(
            random.nextInt(1, LEN + 1),
            0, 3
        ).toArray();

        log.info("Numbers are '{}'", numbers);
    }

    @Override
    protected String getInformation() {
        return INFORMATION;
    }

    // time = 569 ms
    @Override
    protected int[] original() {
        var original = new Original(numbers.clone());
        return original.process();
    }

    // time = 435 ms
    @Override
    protected int[] practice() {
        var practice = new Practice(numbers.clone());
        return practice.process();
    }

    // time = 883 ms
    @Override
    protected int[] solution() {
        var solution = new Solution(numbers.clone());
        return solution.process();
    }
}
