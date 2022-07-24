package com.witalis.praxis.leetcode.task.h5.p496;

import com.witalis.praxis.leetcode.task.LeetCodeTask;
import com.witalis.praxis.leetcode.task.h5.p496.option.*;
import com.witalis.praxis.leetcode.utils.LeetCode;
import com.witalis.praxis.leetcode.utils.TaskDifficulty;
import com.witalis.praxis.leetcode.utils.TaskRevision;

import lombok.extern.slf4j.Slf4j;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

import static com.witalis.praxis.leetcode.utils.TaskTag.*;

@Slf4j
@LeetCode(
    id = 496,
    description = "Next Greater Element I",
    difficulty = TaskDifficulty.EASY,
    tags = {ARRAY, HASH_TABLE, STACK, MONOTONIC_STACK}
)
public class NextGreaterElementI extends LeetCodeTask<int[]> {
    public static final int LEN = 1_000;
    public static final int VALUE = 10_000;
    private int[] numbers1;
    private int[] numbers2;

    public static final String INFORMATION = """

        The next greater element of some element x in an array is the first greater element
            that is to the right of x in the same array.

        You are given two distinct 0-indexed integer arrays nums1 and nums2,
            where nums1 is a subset of nums2.

        For each 0 <= i < nums1.length, find the index j such that nums1[i] == nums2[j]
            and determine the next greater element of nums2[j] in nums2.
            If there is no next greater element, then the answer for this query is -1.

        Return an array ans of length nums1.length such
            that ans[i] is the next greater element as described above.

        Example:
            Input: nums1 = [4,1,2], nums2 = [1,3,4,2]
            Output: [-1,3,-1]
            Explanation: The next greater element for each value of nums1 is as follows:
                - 4 is underlined in nums2 = [1,3,4,2]. There is no next greater element, so the answer is -1.
                - 1 is underlined in nums2 = [1,3,4,2]. The next greater element is 3.
                - 2 is underlined in nums2 = [1,3,4,2]. There is no next greater element, so the answer is -1.""";

    public NextGreaterElementI(int id, String description, TaskRevision revision) {
        super(id, description, revision);
        initialization();
    }

    private void initialization() {
        final var random = ThreadLocalRandom.current();

        this.numbers2 = random.ints(
            random.nextInt(1, LEN + 1),
            0,
            VALUE + 1
        ).distinct().toArray();

        this.numbers1 = Arrays.copyOfRange(
            numbers2,
            random.nextInt(0, (numbers2.length - 1) / 2),
            random.nextInt(numbers2.length - 1)
        );

        List<Integer> list = new ArrayList<>(Arrays.stream(numbers1).boxed().toList());
        Collections.shuffle(list);
        numbers1 = list.stream().mapToInt(Integer::intValue).toArray();

        log.info("Numbers N1 are {}", Arrays.toString(numbers1));
        log.info("Numbers N2 are {}", Arrays.toString(numbers2));
    }

    @Override
    protected String getInformation() {
        return INFORMATION;
    }

    // time = 1877 ms
    @Override
    protected int[] original() {
        var original = new Original(numbers1.clone(), numbers2.clone());
        return original.process();
    }

    // time = 1824 ms
    @Override
    protected int[] practice() {
        var practice = new Practice(numbers1.clone(), numbers2.clone());
        return practice.process();
    }

    // time = 1737 ms
    @Override
    protected int[] solution() {
        var solution = new Solution(numbers1.clone(), numbers2.clone());
        return solution.process();
    }
}
