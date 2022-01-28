package com.witalis.praxis.leetcode.task.h1.p88;

import com.witalis.praxis.leetcode.task.LeetCodeTask;
import com.witalis.praxis.leetcode.task.h1.p88.option.*;
import com.witalis.praxis.leetcode.utils.LeetCode;
import com.witalis.praxis.leetcode.utils.TaskDifficulty;
import com.witalis.praxis.leetcode.utils.TaskRevision;

import lombok.extern.slf4j.Slf4j;
import java.util.Arrays;
import java.util.concurrent.ThreadLocalRandom;

import static com.witalis.praxis.leetcode.utils.TaskTag.*;

@Slf4j
@LeetCode(
    id = 88,
    description = "Merge Sorted Array",
    difficulty = TaskDifficulty.EASY,
    tags = {ARRAY, TWO_POINTERS, SORTING}
)
public class MergeSortedArray extends LeetCodeTask<int[]> {
    public static final int LEN = 100;
    private int[] nums1;
    private int m;
    private int[] nums2;
    private int n;

    public static final String INFORMATION = """

        You are given two integer arrays nums1 and nums2, sorted in non-decreasing order,
            and two integers m and n, representing the number of elements in nums1 and nums2 respectively.

        Merge nums1 and nums2 into a single array sorted in non-decreasing order.

        The final sorted array should not be returned by the function,
            but instead be stored inside the array nums1. To accommodate this,
            nums1 has a length of m + n, where the first m elements denote the elements
            that should be merged, and the last n elements are set to 0 and should be ignored.
            nums2 has a length of n.

        Example:
            Input: nums1 = [1,2,3,0,0,0], m = 3, nums2 = [2,5,6], n = 3
            Output: [1,2,2,3,5,6]
            Explanation: The arrays we are merging are [1,2,3] and [2,5,6].
                         The result of the merge is [1,2,2,3,5,6]
                         with the underlined elements coming from nums1.""";

    public MergeSortedArray(int id, String description, TaskRevision revision) {
        super(id, description, revision);
        initialization();
    }

    private void initialization() {
        var random = ThreadLocalRandom.current();
        m = random.nextInt(0, LEN + 1);
        n = random.nextInt(0, LEN + 1);

        this.nums1 = random
            .ints(Integer.MIN_VALUE, Integer.MAX_VALUE)
            .limit(m)
            .sorted()
            .toArray();
        this.nums2 = random
            .ints(Integer.MIN_VALUE, Integer.MAX_VALUE)
            .limit(n)
            .sorted()
            .toArray();

        int[] nums = new int[m + n];
        System.arraycopy(nums1, 0, nums, 0, nums1.length);
        this.nums1 = nums;

        log.info("Nums1 are {}, m is {}", Arrays.toString(nums1), m);
        log.info("Nums2 are {}, n is {}", Arrays.toString(nums2), n);
    }

    @Override
    protected String getInformation() {
        return INFORMATION;
    }

    // time = 1148 ms
    @Override
    protected int[] original() {
        var original = new Original(nums1.clone(), m, nums2.clone(), n);
        return original.process();
    }

    // time = 485 ms
    @Override
    protected int[] practice() {
        var practice = new Practice(nums1.clone(), m, nums2.clone(), n);
        return practice.process();
    }

    // time = 486 ms
    @Override
    protected int[] solution() {
        var solution = new Solution(nums1.clone(), m, nums2.clone(), n);
        return solution.process();
    }
}
