package com.witalis.praxis.leetcode.task.p69;

import com.witalis.praxis.leetcode.task.LeetCodeTask;
import com.witalis.praxis.leetcode.task.p69.option.*;
import com.witalis.praxis.leetcode.utils.LeetCode;
import com.witalis.praxis.leetcode.utils.TaskRevision;

import lombok.extern.slf4j.Slf4j;
import java.util.concurrent.ThreadLocalRandom;

@Slf4j
@LeetCode(id = 69, description = "Sqrt(x)")
public class SqrtX extends LeetCodeTask<Integer> {
    private int number;

    public static final String INFORMATION = """

        Given a non-negative integer x,
            compute and return the square root of x.

        Since the return type is an integer,
            the decimal digits are truncated,
            and only the integer part of the result is returned.

        Note: You are not allowed to use any built-in exponent function
            or operator, such as pow(x, 0.5) or x ** 0.5.

        Example:
            Input: x = 8
            Output: 2
            Explanation: The square root of 8 is 2.82842...,
                and since the decimal part is truncated, 2 is returned.""";

    public SqrtX(int id, String description, TaskRevision revision) {
        super(id, description, revision);
        initialization();
    }

    private void initialization() {
        this.number = ThreadLocalRandom.current().nextInt(0, Integer.MAX_VALUE);

        log.info("Number is {}", number);
    }

    @Override
    protected String getInformation() {
        return INFORMATION;
    }

    // time = 940 ms
    @Override
    protected Integer original() {
        var original = new Original(number);
        return original.process();
    }

    // time = 448 ms
    @Override
    protected Integer practice() {
        var practice = new Practice(number);
        return practice.process();
    }

    // time = 606 ms
    @Override
    protected Integer solution() {
        var solution = new Solution(number);
        return solution.process();
    }
}
