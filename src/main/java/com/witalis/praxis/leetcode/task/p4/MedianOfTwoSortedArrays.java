package com.witalis.praxis.leetcode.task.p4;

import com.witalis.praxis.leetcode.task.LeetCodeTask;
import com.witalis.praxis.leetcode.task.p4.option.*;
import com.witalis.praxis.leetcode.utils.LeetCode;
import com.witalis.praxis.leetcode.utils.TaskRevision;

import lombok.extern.slf4j.Slf4j;
import java.util.Arrays;
import java.util.concurrent.ThreadLocalRandom;

@Slf4j
@LeetCode(id = 4, description = "Median of Two Sorted Arrays")
public class MedianOfTwoSortedArrays extends LeetCodeTask<Double> {
    public static final int LENGTH = 1_001;
    private int[] numbers1;
    private int[] numbers2;

    public static final String INFORMATION = """

        Given two sorted arrays nums1 and nums2 of size m and n respectively,
            return the median of the two sorted arrays.
        The overall run time complexity should be O(log (m+n)).
        Example:
            Input: nums1 = [1,2], nums2 = [3,4]
            Output: 2.50000
            Explanation: merged array = [1,2,3,4] and median is (2 + 3) / 2 = 2.5.""";

    public MedianOfTwoSortedArrays(int id, String description, TaskRevision revision) {
        super(id, description, revision);
        initialization();
    }

    private void initialization() {
        var random = ThreadLocalRandom.current();

        this.numbers1 = random.ints(0, LENGTH)
            .limit(random.nextInt(0, LENGTH))
            .sorted()
            .toArray();
        log.info("Numbers[1] is {}", Arrays.toString(numbers1));

        this.numbers2 = random.ints(0, LENGTH)
            .limit(random.nextInt(0, LENGTH))
            .sorted()
            .toArray();
        log.info("Numbers[2] is {}", Arrays.toString(numbers2));
    }

    @Override
    protected String getInformation() {
        return INFORMATION;
    }

    // time = 1287 ms
    @Override
    protected Double original() {
        var original = new Original(numbers1.clone(), numbers2.clone());
        return original.process();
    }

    // time = 1163 ms
    @Override
    protected Double practice() {
        var practice = new Practice(numbers1.clone(), numbers2.clone());
        return practice.process();
    }

    // time = 1078 ms
    @Override
    protected Double solution() {
        var solution = new Solution(numbers1.clone(), numbers2.clone());
        return solution.process();
    }
}
