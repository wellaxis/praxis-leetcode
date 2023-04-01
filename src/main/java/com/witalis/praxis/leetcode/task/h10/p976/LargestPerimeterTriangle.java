package com.witalis.praxis.leetcode.task.h10.p976;

import com.witalis.praxis.leetcode.task.LeetCodeTask;
import com.witalis.praxis.leetcode.task.h10.p976.option.*;
import com.witalis.praxis.leetcode.utils.LeetCode;
import com.witalis.praxis.leetcode.utils.TaskDifficulty;
import com.witalis.praxis.leetcode.utils.TaskRevision;

import lombok.extern.slf4j.Slf4j;
import java.util.Arrays;
import java.util.concurrent.ThreadLocalRandom;

import static com.witalis.praxis.leetcode.utils.TaskTag.*;

@Slf4j
@LeetCode(
    id = 976,
    description = "Largest Perimeter Triangle",
    difficulty = TaskDifficulty.EASY,
    tags = {ARRAY, MATH, GREEDY, SORTING}
)
public class LargestPerimeterTriangle extends LeetCodeTask<Integer> {
    public static final int LEN = 10_000;
    public static final int VALUE = 1_000_000;

    private int[] numbers;

    public static final String INFORMATION = """

        Description:
            Given an integer array nums, return the largest perimeter of a triangle with a non-zero area,
                formed from three of these lengths. If it is impossible to form any triangle of a non-zero area, return 0.

        Example:
            Input: nums = [2,1,2]
            Output: 5
            Explanation: You can form a triangle with three side lengths: 1, 2, and 2.""";

    public LargestPerimeterTriangle(int id, String description, TaskRevision revision) {
        super(id, description, revision);
        initialization();
    }

    private void initialization() {
        final var random = ThreadLocalRandom.current();

        this.numbers = random.ints(
            random.nextInt(3, LEN + 1),
            1, VALUE + 1
        ).toArray();

        log.info("Numbers: {}", Arrays.toString(numbers));
    }

    @Override
    protected String getInformation() {
        return INFORMATION;
    }

    // time = 1119 ms
    @Override
    protected Integer original() {
        var original = new Original(numbers.clone());
        return original.process();
    }

    // time = 993 ms
    @Override
    protected Integer practice() {
        var practice = new Practice(numbers.clone());
        return practice.process();
    }

    // time = 883 ms
    @Override
    protected Integer solution() {
        var solution = new Solution(numbers.clone());
        return solution.process();
    }
}
