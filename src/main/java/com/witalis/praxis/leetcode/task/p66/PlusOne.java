package com.witalis.praxis.leetcode.task.p66;

import com.witalis.praxis.leetcode.task.LeetCodeTask;
import com.witalis.praxis.leetcode.task.p66.option.*;
import com.witalis.praxis.leetcode.utils.LeetCode;
import com.witalis.praxis.leetcode.utils.TaskRevision;

import lombok.extern.slf4j.Slf4j;
import java.util.Arrays;
import java.util.concurrent.ThreadLocalRandom;

@Slf4j
@LeetCode(id = 66, description = "Plus One")
public class PlusOne extends LeetCodeTask<int[]> {
    public static final int LEN = 100;
    private int[] digits;

    public static final String INFORMATION = """

        You are given a large integer represented as an integer array digits,
            where each digits[i] is the ith digit of the integer.
        The digits are ordered from most significant to least significant
            in left-to-right order.
        The large integer does not contain any leading 0's.

        Increment the large integer by one and return the resulting array of digits.

        Example:
            Input: digits = [1,2,3]
            Output: [1,2,4]
            Explanation: The array represents the integer 123.
                         Incrementing by one gives 123 + 1 = 124.
                         Thus, the result should be [1,2,4].""";

    public PlusOne(int id, String description, TaskRevision revision) {
        super(id, description, revision);
        initialization();
    }

    private void initialization() {
        this.digits = ThreadLocalRandom.current()
            .ints(0, 10)
            .limit(LEN)
            .toArray();

        log.info("Digits are {}", Arrays.toString(digits));
    }

    @Override
    protected String getInformation() {
        return INFORMATION;
    }

    // time = 496 ms
    @Override
    protected int[] original() {
        var original = new Original(digits.clone());
        return original.process();
    }

    // time = 466 ms
    @Override
    protected int[] practice() {
        var practice = new Practice(digits.clone());
        return practice.process();
    }

    // time = 404 ms
    @Override
    protected int[] solution() {
        var solution = new Solution(digits.clone());
        return solution.process();
    }
}
