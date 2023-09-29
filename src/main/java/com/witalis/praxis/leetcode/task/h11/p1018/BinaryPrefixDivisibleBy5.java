package com.witalis.praxis.leetcode.task.h11.p1018;

import com.witalis.praxis.leetcode.task.LeetCodeTask;
import com.witalis.praxis.leetcode.task.h11.p1018.option.*;
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
    id = 1018,
    description = "Binary Prefix Divisible By 5",
    difficulty = TaskDifficulty.EASY,
    tags = {ARRAY}
)
public class BinaryPrefixDivisibleBy5 extends LeetCodeTask<List<Boolean>> {
    public static final int LEN = 100_000;

    private int[] numbers;

    public static final String INFORMATION = """

        Description:
            You are given a binary array nums (0-indexed).

            We define xi as the number whose binary representation is the subarray nums[0..i]
                (from most-significant-bit to least-significant-bit).

            * For example, if nums = [1,0,1], then x0 = 1, x1 = 2, and x2 = 5.

            Return an array of booleans answer where answer[i] is true if xi is divisible by 5.

        Example:
            Input: nums = [0,1,1]
            Output: [true,false,false]
            Explanation: The input numbers in binary are 0, 01, 011; which are 0, 1, and 3 in base-10.
                Only the first number is divisible by 5, so answer[0] is true.""";

    public BinaryPrefixDivisibleBy5(int id, String description, TaskRevision revision) {
        super(id, description, revision);
        initialization();
    }

    private void initialization() {
        final var random = ThreadLocalRandom.current();

        this.numbers = random.ints(
            random.nextInt(1, LEN + 1),
            0, 1 + 1
        ).toArray();

        log.info("Numbers: {}", Arrays.toString(numbers));
    }

    @Override
    protected String getInformation() {
        return INFORMATION;
    }

    // time = 5199 ms
    @Override
    protected List<Boolean> original() {
        var original = new Original(numbers.clone());
        return original.process();
    }

    // time = 5936 ms
    @Override
    protected List<Boolean> practice() {
        var practice = new Practice(numbers.clone());
        return practice.process();
    }

    // time = 6060 ms
    @Override
    protected List<Boolean> solution() {
        var solution = new Solution(numbers.clone());
        return solution.process();
    }
}
