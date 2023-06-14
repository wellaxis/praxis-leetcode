package com.witalis.praxis.leetcode.task.h11.p1005;

import com.witalis.praxis.leetcode.task.LeetCodeTask;
import com.witalis.praxis.leetcode.task.h11.p1005.option.*;
import com.witalis.praxis.leetcode.utils.LeetCode;
import com.witalis.praxis.leetcode.utils.TaskDifficulty;
import com.witalis.praxis.leetcode.utils.TaskRevision;

import lombok.extern.slf4j.Slf4j;
import java.util.Arrays;
import java.util.concurrent.ThreadLocalRandom;

import static com.witalis.praxis.leetcode.utils.TaskTag.*;

@Slf4j
@LeetCode(
    id = 1005,
    description = "Maximize Sum Of Array After K Negations",
    difficulty = TaskDifficulty.EASY,
    tags = {ARRAY, GREEDY, SORTING}
)
public class MaximizeSumOfArrayAfterKNegations extends LeetCodeTask<Integer> {
    public static final int LEN = 10_000;
    public static final int VALUE = 100;

    private int[] numbers;
    private int negations;

    public static final String INFORMATION = """

        Description:
            Given an integer array nums and an integer k, modify the array in the following way:
                * choose an index i and replace nums[i] with -nums[i].

            You should apply this process exactly k times. You may choose the same index i multiple times.

            Return the largest possible sum of the array after modifying it in this way.

        Example:
            Input: nums = [2,-3,-1,5,-4], k = 2
            Output: 13
            Explanation: Choose indices (1, 4) and nums becomes [2,3,-1,5,4].""";

    public MaximizeSumOfArrayAfterKNegations(int id, String description, TaskRevision revision) {
        super(id, description, revision);
        initialization();
    }

    private void initialization() {
        final var random = ThreadLocalRandom.current();

        this.numbers = random.ints(
            random.nextInt(1, LEN + 1),
            -VALUE, VALUE + 1
        ).toArray();
        this.negations = random.nextInt(1, LEN + 1);

        log.info("Numbers: {}", Arrays.toString(numbers));
        log.info("Negations K: {}", negations);
    }

    @Override
    protected String getInformation() {
        return INFORMATION;
    }

    // time = 8541 ms
    @Override
    protected Integer original() {
        var original = new Original(numbers.clone(), negations);
        return original.process();
    }

    // time = 5254 ms
    @Override
    protected Integer practice() {
        var practice = new Practice(numbers.clone(), negations);
        return practice.process();
    }

    // time = 3760 ms
    @Override
    protected Integer solution() {
        var solution = new Solution(numbers.clone(), negations);
        return solution.process();
    }
}
