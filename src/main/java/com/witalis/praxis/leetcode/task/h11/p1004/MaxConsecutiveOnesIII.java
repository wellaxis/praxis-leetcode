package com.witalis.praxis.leetcode.task.h11.p1004;

import com.witalis.praxis.leetcode.task.LeetCodeTask;
import com.witalis.praxis.leetcode.task.h11.p1004.option.*;
import com.witalis.praxis.leetcode.utils.LeetCode;
import com.witalis.praxis.leetcode.utils.TaskDifficulty;
import com.witalis.praxis.leetcode.utils.TaskRevision;

import lombok.extern.slf4j.Slf4j;
import java.util.Arrays;
import java.util.concurrent.ThreadLocalRandom;

import static com.witalis.praxis.leetcode.utils.TaskTag.*;

@Slf4j
@LeetCode(
    id = 1004,
    description = "Max Consecutive Ones III",
    difficulty = TaskDifficulty.MEDIUM,
    tags = {ARRAY, BINARY_SEARCH, SLIDING_WINDOW, PREFIX_SUM}
)
public class MaxConsecutiveOnesIII extends LeetCodeTask<Integer> {
    public static final int LEN = 100_000;

    private int[] numbers;
    private int flips;

    public static final String INFORMATION = """

        Description:
            Given a binary array nums and an integer k,
                return the maximum number of consecutive 1's in the array if you can flip at most k 0's.

        Example:
            Input: nums = [0,0,1,1,0,0,1,1,1,0,1,1,0,0,0,1,1,1,1], k = 3
            Output: 10
            Explanation: [0,0,1,1,1,1,1,1,1,1,1,1,0,0,0,1,1,1,1]
                              -------------------
                Bolded numbers were flipped from 0 to 1. The longest subarray is underlined.""";

    public MaxConsecutiveOnesIII(int id, String description, TaskRevision revision) {
        super(id, description, revision);
        initialization();
    }

    private void initialization() {
        final var random = ThreadLocalRandom.current();

        this.numbers = random.ints(
            random.nextInt(1, LEN + 1),
            0,
            2
        ).toArray();
        this.flips = random.nextInt(0, numbers.length + 1);

        log.info("Numbers: {}", Arrays.toString(numbers));
        log.info("Flips 'k': {}", flips);
    }

    @Override
    protected String getInformation() {
        return INFORMATION;
    }

    // time = 4531 ms
    @Override
    protected Integer original() {
        var original = new Original(numbers, flips);
        return original.process();
    }

    // time = 3672 ms
    @Override
    protected Integer practice() {
        var practice = new Practice(numbers, flips);
        return practice.process();
    }

    // time = 1543 ms
    @Override
    protected Integer solution() {
        var solution = new Solution(numbers, flips);
        return solution.process();
    }
}
