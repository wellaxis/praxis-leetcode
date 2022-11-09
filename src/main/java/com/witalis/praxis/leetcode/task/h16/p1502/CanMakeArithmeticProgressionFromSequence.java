package com.witalis.praxis.leetcode.task.h16.p1502;

import com.witalis.praxis.leetcode.task.LeetCodeTask;
import com.witalis.praxis.leetcode.task.h16.p1502.option.*;
import com.witalis.praxis.leetcode.utils.LeetCode;
import com.witalis.praxis.leetcode.utils.TaskDifficulty;
import com.witalis.praxis.leetcode.utils.TaskRevision;

import lombok.extern.slf4j.Slf4j;
import java.util.Arrays;
import java.util.concurrent.ThreadLocalRandom;

import static com.witalis.praxis.leetcode.utils.TaskTag.*;

@Slf4j
@LeetCode(
    id = 1502,
    description = "Can Make Arithmetic Progression From Sequence",
    difficulty = TaskDifficulty.EASY,
    tags = {ARRAY, SORTING}
)
public class CanMakeArithmeticProgressionFromSequence extends LeetCodeTask<Boolean> {
    public static final int LEN = 1_000;
    public static final int VALUE = 1_000_000;
    private int[] numbers;

    public static final String INFORMATION = """

        Description:
            A sequence of numbers is called an arithmetic progression
                if the difference between any two consecutive elements is the same.

            Given an array of numbers arr, return true if the array can be rearranged
                to form an arithmetic progression. Otherwise, return false.

        Example:
            Input: arr = [3,5,1]
            Output: true
            Explanation: We can reorder the elements as [1,3,5] or [5,3,1]
                with differences 2 and -2 respectively, between each consecutive elements.""";

    public CanMakeArithmeticProgressionFromSequence(int id, String description, TaskRevision revision) {
        super(id, description, revision);
        initialization();
    }

    private void initialization() {
        final var random = ThreadLocalRandom.current();

        this.numbers = random.ints(
            random.nextInt(2, LEN + 1),
            -VALUE, VALUE + 1
        ).toArray();

        log.info("Numbers are {}", Arrays.toString(numbers));
    }

    @Override
    protected String getInformation() {
        return INFORMATION;
    }

    // time = 1455 ms
    @Override
    protected Boolean original() {
        var original = new Original(numbers.clone());
        return original.process();
    }

    // time = 1258 ms
    @Override
    protected Boolean practice() {
        var practice = new Practice(numbers.clone());
        return practice.process();
    }

    // time = 1218 ms
    @Override
    protected Boolean solution() {
        var solution = new Solution(numbers.clone());
        return solution.process();
    }
}
