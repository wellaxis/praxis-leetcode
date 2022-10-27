package com.witalis.praxis.leetcode.task.h7.p697;

import com.witalis.praxis.leetcode.task.LeetCodeTask;
import com.witalis.praxis.leetcode.task.h7.p697.option.*;
import com.witalis.praxis.leetcode.utils.LeetCode;
import com.witalis.praxis.leetcode.utils.TaskDifficulty;
import com.witalis.praxis.leetcode.utils.TaskRevision;

import lombok.extern.slf4j.Slf4j;
import java.util.Arrays;
import java.util.concurrent.ThreadLocalRandom;

import static com.witalis.praxis.leetcode.utils.TaskTag.*;

@Slf4j
@LeetCode(
    id = 697,
    description = "Degree of an Array",
    difficulty = TaskDifficulty.EASY,
    tags = {ARRAY, HASH_TABLE}
)
public class DegreeOfArray extends LeetCodeTask<Integer> {
    public static final int LEN = 50_000;
    public static final int VALUE = 50_000;
    private int[] numbers;

    public static final String INFORMATION = """

        Description:
            Given a non-empty array of non-negative integers nums,
                the degree of this array is defined as the maximum frequency of any one of its elements.

            Your task is to find the smallest possible length of a (contiguous) subarray of nums,
                that has the same degree as nums.

        Example:
            Input: nums = [1,2,2,3,1]
            Output: 2
            Explanation:
                The input array has a degree of 2 because both elements 1 and 2 appear twice.
                Of the sub-arrays that have the same degree:
                [1, 2, 2, 3, 1], [1, 2, 2, 3], [2, 2, 3, 1], [1, 2, 2], [2, 2, 3], [2, 2]
                The shortest length is 2. So return 2.""";

    public DegreeOfArray(int id, String description, TaskRevision revision) {
        super(id, description, revision);
        initialization();
    }

    private void initialization() {
        final var random = ThreadLocalRandom.current();

        this.numbers = random.ints(
            random.nextInt(1, LEN + 1),
            0, VALUE
        ).toArray();

        log.info("Numbers are {}", Arrays.toString(numbers));
    }

    @Override
    protected String getInformation() {
        return INFORMATION;
    }

    // time = 16705 ms
    @Override
    protected Integer original() {
        var original = new Original(numbers.clone());
        return original.process();
    }

    // time = 13813 ms
    @Override
    protected Integer practice() {
        var practice = new Practice(numbers.clone());
        return practice.process();
    }

    // time = 4174 ms
    @Override
    protected Integer solution() {
        var solution = new Solution(numbers.clone());
        return solution.process();
    }
}
