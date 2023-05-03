package com.witalis.praxis.leetcode.task.h23.p2215;

import com.witalis.praxis.leetcode.task.LeetCodeTask;
import com.witalis.praxis.leetcode.task.h23.p2215.option.*;
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
    id = 2215,
    description = "Find the Difference of Two Arrays",
    difficulty = TaskDifficulty.EASY,
    tags = {ARRAY, HASH_TABLE}
)
public class FindDifferenceOfTwoArrays extends LeetCodeTask<List<List<Integer>>> {
    public static final int LEN = 1_000;
    public static final int VALUE = 1_000;

    private int[] numbers1;
    private int[] numbers2;

    public static final String INFORMATION = """

        Description:
            Given two 0-indexed integer arrays nums1 and nums2, return a list answer of size 2 where:
                * answer[0] is a list of all distinct integers in nums1 which are not present in nums2.
                * answer[1] is a list of all distinct integers in nums2 which are not present in nums1.

            Note that the integers in the lists may be returned in any order.

        Example:
            Input: nums1 = [1,2,3], nums2 = [2,4,6]
            Output: [[1,3],[4,6]]
            Explanation:
                For nums1, nums1[1] = 2 is present at index 0 of nums2, whereas nums1[0] = 1 and nums1[2] = 3 are not present in nums2.
                    Therefore, answer[0] = [1,3].
                For nums2, nums2[0] = 2 is present at index 1 of nums1, whereas nums2[1] = 4 and nums2[2] = 6 are not present in nums2.
                    Therefore, answer[1] = [4,6].""";

    public FindDifferenceOfTwoArrays(int id, String description, TaskRevision revision) {
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

    // time = 2232 ms
    @Override
    protected List<List<Integer>> original() {
        var original = new Original(numbers1.clone(), numbers2.clone());
        return original.process();
    }

    // time = 2141 ms
    @Override
    protected List<List<Integer>> practice() {
        var practice = new Practice(numbers1.clone(), numbers2.clone());
        return practice.process();
    }

    // time = 1006 ms
    @Override
    protected List<List<Integer>> solution() {
        var solution = new Solution(numbers1.clone(), numbers2.clone());
        return solution.process();
    }
}
