package com.witalis.praxis.leetcode.task.h4.p349;

import com.witalis.praxis.leetcode.task.LeetCodeTask;
import com.witalis.praxis.leetcode.task.h4.p349.option.*;
import com.witalis.praxis.leetcode.utils.LeetCode;
import com.witalis.praxis.leetcode.utils.TaskDifficulty;
import com.witalis.praxis.leetcode.utils.TaskRevision;

import lombok.extern.slf4j.Slf4j;
import java.util.Arrays;
import java.util.concurrent.ThreadLocalRandom;

import static com.witalis.praxis.leetcode.utils.TaskTag.*;

@Slf4j
@LeetCode(
    id = 349,
    description = "Intersection of Two Arrays",
    difficulty = TaskDifficulty.EASY,
    tags = {ARRAY, HASH_TABLE, TWO_POINTERS, BINARY_SEARCH, SORTING}
)
public class IntersectionOfTwoArrays extends LeetCodeTask<int[]> {
    public static final int LEN = 1_000;
    public static final int VALUE = 1_000;
    private int[] numbers1;
    private int[] numbers2;

    public static final String INFORMATION = """

        Given two integer arrays nums1 and nums2, return an array of their intersection.
            Each element in the result must be unique and you may return the result in any order.

        Example:
            Input: nums1 = [4,9,5], nums2 = [9,4,9,8,4]
            Output: [9,4]
            Explanation: [4,9] is also accepted.""";

    public IntersectionOfTwoArrays(int id, String description, TaskRevision revision) {
        super(id, description, revision);
        initialization();
    }

    private void initialization() {
        final var random = ThreadLocalRandom.current();

        this.numbers1 = random.ints(
            random.nextInt(1, LEN + 1),
            0, VALUE + 1
        ).toArray();

        log.info("Numbers[1] are {}", Arrays.toString(numbers1));

        this.numbers2 = random.ints(
            random.nextInt(1, LEN + 1),
            0, VALUE + 1
        ).toArray();

        log.info("Numbers[2] are {}", Arrays.toString(numbers2));
    }

    @Override
    protected String getInformation() {
        return INFORMATION;
    }

    // time = 2843 ms
    @Override
    protected int[] original() {
        var original = new Original(numbers1.clone(), numbers2.clone());
        return original.process();
    }

    // time = 1950 ms
    @Override
    protected int[] practice() {
        var practice = new Practice(numbers1.clone(), numbers2.clone());
        return practice.process();
    }

    // time = 1201 ms
    @Override
    protected int[] solution() {
        var solution = new Solution(numbers1.clone(), numbers2.clone());
        return solution.process();
    }
}
