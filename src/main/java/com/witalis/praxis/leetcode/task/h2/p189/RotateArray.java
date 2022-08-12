package com.witalis.praxis.leetcode.task.h2.p189;

import com.witalis.praxis.leetcode.task.LeetCodeTask;
import com.witalis.praxis.leetcode.task.h2.p189.option.*;
import com.witalis.praxis.leetcode.utils.LeetCode;
import com.witalis.praxis.leetcode.utils.TaskDifficulty;
import com.witalis.praxis.leetcode.utils.TaskRevision;

import lombok.extern.slf4j.Slf4j;
import java.util.Arrays;
import java.util.concurrent.ThreadLocalRandom;

import static com.witalis.praxis.leetcode.utils.TaskTag.*;

@Slf4j
@LeetCode(
    id = 189,
    description = "Rotate Array",
    difficulty = TaskDifficulty.MEDIUM,
    tags = {ARRAY, MATH, TWO_POINTERS}
)
public class RotateArray extends LeetCodeTask<int[]> {
    public static final int LEN = 100_000;
    private int[] numbers;
    private int steps;

    public static final String INFORMATION = """

        Given an array, rotate the array to the right by k steps, where k is non-negative.

        Example:
            Input: nums = [1,2,3,4,5,6,7], k = 3
            Output: [5,6,7,1,2,3,4]
            Explanation:
                rotate 1 steps to the right: [7,1,2,3,4,5,6]
                rotate 2 steps to the right: [6,7,1,2,3,4,5]
                rotate 3 steps to the right: [5,6,7,1,2,3,4]""";

    public RotateArray(int id, String description, TaskRevision revision) {
        super(id, description, revision);
        initialization();
    }

    private void initialization() {
        var random = ThreadLocalRandom.current();

        this.numbers = random.ints(
            random.nextInt(1, LEN + 1),
            Integer.MIN_VALUE,
            Integer.MAX_VALUE
        ).toArray();

        this.steps = random.nextInt(1, LEN + 1);

        log.info("Numbers are {}", Arrays.toString(numbers));
        log.info("Steps are {}", steps);
    }

    @Override
    protected String getInformation() {
        return INFORMATION;
    }

    // time = 1305 ms
    @Override
    protected int[] original() {
        var original = new Original(numbers.clone(), steps);
        return original.process();
    }

    // time = 1260 ms
    @Override
    protected int[] practice() {
        var practice = new Practice(numbers.clone(), steps);
        return practice.process();
    }

    // time = 1181 ms
    @Override
    protected int[] solution() {
        var solution = new Solution(numbers.clone(), steps);
        return solution.process();
    }
}
