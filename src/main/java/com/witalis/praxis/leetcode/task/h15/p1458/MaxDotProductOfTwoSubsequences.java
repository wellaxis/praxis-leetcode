package com.witalis.praxis.leetcode.task.h15.p1458;

import com.witalis.praxis.leetcode.task.LeetCodeTask;
import com.witalis.praxis.leetcode.task.h15.p1458.option.*;
import com.witalis.praxis.leetcode.utils.LeetCode;
import com.witalis.praxis.leetcode.utils.TaskDifficulty;
import com.witalis.praxis.leetcode.utils.TaskRevision;

import lombok.extern.slf4j.Slf4j;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

import static com.witalis.praxis.leetcode.utils.TaskTag.*;

@Slf4j
@LeetCode(
    id = 1458,
    description = "Max Dot Product of Two Subsequences",
    difficulty = TaskDifficulty.HARD,
    tags = {ARRAY, DYNAMIC_PROGRAMMING}
)
public class MaxDotProductOfTwoSubsequences extends LeetCodeTask<Integer> {
    public static final int LEN = 500;
    public static final int VALUE = 1_000;

    private int[] numbers1;
    private int[] numbers2;

    public static final String INFORMATION = """

        Description:
            Given two arrays nums1 and nums2.

            Return the maximum dot product between non-empty subsequences of nums1 and nums2 with the same length.

            A subsequence of a array is a new array which is formed from the original array by deleting some (can be none)
                of the characters without disturbing the relative positions of the remaining characters.
                (ie, [2,3,5] is a subsequence of [1,2,3,4,5] while [1,5,3] is not).

        Example:
            Input: nums1 = [2,1,-2,5], nums2 = [3,0,-6]
            Output: 18
            Explanation: Take subsequence [2,-2] from nums1 and subsequence [3,-6] from nums2.
                Their dot product is (2*3 + (-2)*(-6)) = 18.""";

    public MaxDotProductOfTwoSubsequences(int id, String description, TaskRevision revision) {
        super(id, description, revision);
        initialization();
    }

    private void initialization() {
        final var random = ThreadLocalRandom.current();

        this.numbers1 = random.ints(
            random.nextInt(1, LEN + 1),
            -VALUE, VALUE + 1
        ).toArray();
        this.numbers2 = random.ints(
            random.nextInt(1, LEN + 1),
            -VALUE, VALUE + 1
        ).toArray();

        log.info("Numbers #1: {}", Arrays.toString(numbers1));
        log.info("Numbers #2: {}", Arrays.toString(numbers2));
    }

    @Override
    protected String getInformation() {
        return INFORMATION;
    }

    // time = 14653 ms
    @Override
    protected Integer original() {
        var original = new Original(numbers1, numbers2);
        return original.process();
    }

    // time = 12752 ms
    @Override
    protected Integer practice() {
        var practice = new Practice(numbers1, numbers2);
        return practice.process();
    }

    // time = 4879 ms
    @Override
    protected Integer solution() {
        var solution = new Solution(numbers1, numbers2);
        return solution.process();
    }
}
