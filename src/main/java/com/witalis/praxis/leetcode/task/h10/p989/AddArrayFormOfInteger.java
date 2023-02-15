package com.witalis.praxis.leetcode.task.h10.p989;

import com.witalis.praxis.leetcode.task.LeetCodeTask;
import com.witalis.praxis.leetcode.task.h10.p989.option.*;
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
    id = 989,
    description = "Add to Array-Form of Integer",
    difficulty = TaskDifficulty.EASY,
    tags = {ARRAY, MATH}
)
public class AddArrayFormOfInteger extends LeetCodeTask<List<Integer>> {
    public static final int LEN = 10_000;
    public static final int VALUE = 10_000;

    private int[] numbers;
    private int summand;

    public static final String INFORMATION = """

        Description:
            The array-form of an integer num is an array representing its digits in left to right order.
                * For example, for num = 1321, the array form is [1,3,2,1].

            Given num, the array-form of an integer, and an integer k,
                return the array-form of the integer num + k.

        Example:
            Input: num = [2,1,5], k = 806
            Output: [1,0,2,1]
            Explanation: 215 + 806 = 1021""";

    public AddArrayFormOfInteger(int id, String description, TaskRevision revision) {
        super(id, description, revision);
        initialization();
    }

    private void initialization() {
        final var random = ThreadLocalRandom.current();

        this.numbers = random.ints(
            random.nextInt(1, LEN + 1),
            0, 10
        ).toArray();
        this.summand = random.nextInt(1, VALUE + 1);

        log.info("Numbers: {}", Arrays.toString(numbers));
        log.info("Summand: {}", summand);
    }

    @Override
    protected String getInformation() {
        return INFORMATION;
    }

    // time = 120656 ms
    @Override
    protected List<Integer> original() {
        var original = new Original(numbers, summand);
        return original.process();
    }

    // time = 1584 ms
    @Override
    protected List<Integer> practice() {
        var practice = new Practice(numbers, summand);
        return practice.process();
    }

    // time = 1565 ms
    @Override
    protected List<Integer> solution() {
        var solution = new Solution(numbers, summand);
        return solution.process();
    }
}
