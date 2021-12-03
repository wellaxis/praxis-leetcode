package com.witalis.praxis.leetcode.task.p29;

import com.witalis.praxis.leetcode.task.LeetCodeTask;
import com.witalis.praxis.leetcode.task.p29.option.*;
import com.witalis.praxis.leetcode.utils.LeetCode;
import com.witalis.praxis.leetcode.utils.TaskRevision;

import lombok.extern.slf4j.Slf4j;
import java.util.concurrent.ThreadLocalRandom;

@Slf4j
@LeetCode(id = 29, description = "Divide Two Integers")
public class DivideTwoIntegers extends LeetCodeTask<Integer> {
    private int dividend;
    private int divisor;

    public static final String INFORMATION = """

        Given two integers dividend and divisor, divide two integers
            without using multiplication, division, and mod operator.
                                                
        The integer division should truncate toward zero, which means
            losing its fractional part. For example, 8.345 would be truncated
            to 8, and -2.7335 would be truncated to -2.
        
        Return the quotient after dividing dividend by divisor.
        
        Note: Assume we are dealing with an environment that could only store
            integers within the 32-bit signed integer range: [−2^31, 2^31 − 1].
            For this problem,
                if the quotient is strictly greater than 2^31 - 1, then return 2^31 - 1,
                and if the quotient is strictly less than -2^31, then return -2^31.

        Example:
            Input: dividend = 10, divisor = 3
            Output: 3
            Explanation: 10/3 = 3.33333.. which is truncated to 3.""";

    public DivideTwoIntegers(int id, String description, TaskRevision revision) {
        super(id, description, revision);
        initialization();
    }

    private void initialization() {
        var random = ThreadLocalRandom.current();
        this.dividend = random.nextInt(Integer.MIN_VALUE, Integer.MAX_VALUE);
        this.divisor = random.nextInt(Integer.MIN_VALUE, Integer.MAX_VALUE);

        log.info("Dividend is {}, divisor is {}", dividend, divisor);
    }

    @Override
    protected String getInformation() {
        return INFORMATION;
    }

    // time = 2564 ms
    @Override
    protected Integer original() {
        var original = new Original(dividend, divisor);
        return original.process();
    }

    // time = 539 ms
    @Override
    protected Integer practice() {
        var practice = new Practice(dividend, divisor);
        return practice.process();
    }

    // time = 488 ms
    @Override
    protected Integer solution() {
        var solution = new Solution(dividend, divisor);
        return solution.process();
    }
}
