package com.witalis.praxis.leetcode.task.h25.p2466;

import com.witalis.praxis.leetcode.task.LeetCodeTask;
import com.witalis.praxis.leetcode.task.h25.p2466.option.*;
import com.witalis.praxis.leetcode.utils.LeetCode;
import com.witalis.praxis.leetcode.utils.TaskDifficulty;
import com.witalis.praxis.leetcode.utils.TaskRevision;

import lombok.extern.slf4j.Slf4j;
import java.util.concurrent.ThreadLocalRandom;

import static com.witalis.praxis.leetcode.utils.TaskTag.*;

@Slf4j
@LeetCode(
    id = 2466,
    description = "Count Ways To Build Good Strings",
    difficulty = TaskDifficulty.MEDIUM,
    tags = {DYNAMIC_PROGRAMMING}
)
public class CountWaysToBuildGoodStrings extends LeetCodeTask<Integer> {
    public static final int VALUE = 100_000;

    private int zeroes;
    private int ones;
    private int minLen;
    private int maxLen;

    public static final String INFORMATION = """

        Description:
            Given the integers zero, one, low, and high, we can construct a string by starting with an empty string,
                and then at each step perform either of the following:
                * Append the character '0' zero times.
                * Append the character '1' one times.

            This can be performed any number of times.

            A good string is a string constructed by the above process having a length between low and high (inclusive).

            Return the number of different good strings that can be constructed satisfying these properties.
                Since the answer can be large, return it modulo 10^9 + 7.

        Example:
            Input: low = 2, high = 3, zero = 1, one = 2
            Output: 5
            Explanation: The good strings are "00", "11", "000", "110", and "011".""";

    public CountWaysToBuildGoodStrings(int id, String description, TaskRevision revision) {
        super(id, description, revision);
        initialization();
    }

    private void initialization() {
        final var random = ThreadLocalRandom.current();

        this.maxLen = random.nextInt(1, VALUE + 1);
        this.minLen = random.nextInt(1, maxLen + 1);
        this.zeroes = random.nextInt(1, minLen + 1);
        this.ones = random.nextInt(1, minLen + 1);

        log.info("Min Length: {}", minLen);
        log.info("Max Length: {}", maxLen);
        log.info("Zeroes: {}", zeroes);
        log.info("Ones: {}", ones);
    }

    @Override
    protected String getInformation() {
        return INFORMATION;
    }

    // time = 219500 ms, time limit exceeded
    @Override
    protected Integer original() {
        var original = new Original(zeroes, ones, minLen, maxLen);
        return original.process();
    }

    // time = 1039 ms
    @Override
    protected Integer practice() {
        var practice = new Practice(zeroes, ones, minLen, maxLen);
        return practice.process();
    }

    // time = 715 ms
    @Override
    protected Integer solution() {
        var solution = new Solution(zeroes, ones, minLen, maxLen);
        return solution.process();
    }
}
