package com.witalis.praxis.leetcode.task.p233;

import com.witalis.praxis.leetcode.task.LeetCodeTask;
import com.witalis.praxis.leetcode.task.p233.option.*;
import com.witalis.praxis.leetcode.utils.LeetCode;
import com.witalis.praxis.leetcode.utils.TaskRevision;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@LeetCode(id = 233, description = "Number of Digit One")
public class NumberOfDigitOne extends LeetCodeTask<Integer> {
    public static final int DEFAULT_NUMBER = 1_000_000;
    private int number;

    public static final String INFORMATION = """

            Description:
            Given: An integer n (0 <= n <= 10^9), count the total number of digit 1
                   appearing in all non-negative integers less than or equal to n.
            Example: Input: n = 13, Output: 6""";

    public NumberOfDigitOne(int id, String description, TaskRevision revision) {
        super(id, description, revision);
        initialization();
    }

    private void initialization() {
        this.number = DEFAULT_NUMBER;
    }

    @Override
    protected String getInformation() {
        return INFORMATION;
    }

    // time = 434793 ms
    @Override
    protected Integer original() {
        var original = new Original(number);
        return original.process();
    }

    // time = 251502 ms
    @Override
    protected Integer practice() {
        var practice = new Practice(number);
        return practice.process();
    }

    // time = 880 ms
    @Override
    protected Integer solution() {
        var solution = new Solution(number);
        return solution.process();
    }
}
