package com.witalis.praxis.leetcode.task.h10.p905;

import com.witalis.praxis.leetcode.task.LeetCodeTask;
import com.witalis.praxis.leetcode.task.h10.p905.option.*;
import com.witalis.praxis.leetcode.utils.LeetCode;
import com.witalis.praxis.leetcode.utils.TaskDifficulty;
import com.witalis.praxis.leetcode.utils.TaskRevision;

import lombok.extern.slf4j.Slf4j;
import java.util.Arrays;
import java.util.concurrent.ThreadLocalRandom;

import static com.witalis.praxis.leetcode.utils.TaskTag.*;

@Slf4j
@LeetCode(
    id = 905,
    description = "Sort Array By Parity",
    difficulty = TaskDifficulty.EASY,
    tags = {ARRAY, TWO_POINTERS, SORTING}
)
public class SortArrayByParity extends LeetCodeTask<int[]> {
    public static final int LEN = 5_000;
    public static final int VALUE = 5_000;

    private int[] numbers;

    public static final String INFORMATION = """

        Description:
            Given an integer array nums, move all the even integers at the beginning of the array followed by all the odd integers.

            Return any array that satisfies this condition.

        Example:
            Input: nums = [3,1,2,4]
            Output: [2,4,3,1]
            Explanation: The outputs [4,2,3,1], [2,4,1,3], and [4,2,1,3] would also be accepted.""";

    public SortArrayByParity(int id, String description, TaskRevision revision) {
        super(id, description, revision);
        initialization();
    }

    private void initialization() {
        final var random = ThreadLocalRandom.current();

        this.numbers = random.ints(
            random.nextInt(1, LEN + 1),
            0, VALUE + 1)
            .toArray();

        log.info("Numbers: {}", Arrays.toString(numbers));
    }

    @Override
    protected String getInformation() {
        return INFORMATION;
    }

    // time = 665 ms
    @Override
    protected int[] original() {
        var original = new Original(numbers.clone());
        return original.process();
    }

    // time = 620 ms
    @Override
    protected int[] practice() {
        var practice = new Practice(numbers.clone());
        return practice.process();
    }

    // time = 633 ms
    @Override
    protected int[] solution() {
        var solution = new Solution(numbers.clone());
        return solution.process();
    }
}
