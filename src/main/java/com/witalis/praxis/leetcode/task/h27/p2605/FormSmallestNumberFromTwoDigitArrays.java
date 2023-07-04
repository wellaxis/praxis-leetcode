package com.witalis.praxis.leetcode.task.h27.p2605;

import com.witalis.praxis.leetcode.task.LeetCodeTask;
import com.witalis.praxis.leetcode.task.h27.p2605.option.*;
import com.witalis.praxis.leetcode.utils.LeetCode;
import com.witalis.praxis.leetcode.utils.TaskDifficulty;
import com.witalis.praxis.leetcode.utils.TaskRevision;

import lombok.extern.slf4j.Slf4j;
import java.util.Arrays;
import java.util.concurrent.ThreadLocalRandom;

import static com.witalis.praxis.leetcode.utils.TaskTag.*;

@Slf4j
@LeetCode(
    id = 2605,
    description = "Form Smallest Number From Two Digit Arrays",
    difficulty = TaskDifficulty.EASY,
    tags = {ARRAY, HASH_TABLE, ENUMERATION}
)
public class FormSmallestNumberFromTwoDigitArrays extends LeetCodeTask<Integer> {
    public static final int LEN = 9;
    public static final int VALUE = 9;

    private int[] numbers1;
    private int[] numbers2;

    public static final String INFORMATION = """

        Description:
            Given two arrays of unique digits nums1 and nums2,
                return the smallest number that contains at least one digit from each array.

        Example:
            Input: nums1 = [4,1,3], nums2 = [5,7]
            Output: 15
            Explanation: The number 15 contains the digit 1 from nums1 and the digit 5 from nums2.
                It can be proven that 15 is the smallest number we can have.""";

    public FormSmallestNumberFromTwoDigitArrays(int id, String description, TaskRevision revision) {
        super(id, description, revision);
        initialization();
    }

    private void initialization() {
        final var random = ThreadLocalRandom.current();

        this.numbers1 = random.ints(
            random.nextInt(1, LEN + 1), 1, VALUE + 1
        ).distinct().toArray();
        this.numbers2 = random.ints(
            random.nextInt(1, LEN + 1), 1, VALUE + 1
        ).distinct().toArray();

        log.info("Numbers #1: {}", Arrays.toString(numbers1));
        log.info("Numbers #2: {}", Arrays.toString(numbers2));
    }

    @Override
    protected String getInformation() {
        return INFORMATION;
    }

    // time = 482 ms
    @Override
    protected Integer original() {
        var original = new Original(numbers1, numbers2);
        return original.process();
    }

    // time = 456 ms
    @Override
    protected Integer practice() {
        var practice = new Practice(numbers1, numbers2);
        return practice.process();
    }

    // time = 473 ms
    @Override
    protected Integer solution() {
        var solution = new Solution(numbers1, numbers2);
        return solution.process();
    }
}
