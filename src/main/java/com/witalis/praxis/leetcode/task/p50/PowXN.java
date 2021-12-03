package com.witalis.praxis.leetcode.task.p50;

import com.witalis.praxis.leetcode.task.LeetCodeTask;
import com.witalis.praxis.leetcode.task.p50.option.*;
import com.witalis.praxis.leetcode.utils.LeetCode;
import com.witalis.praxis.leetcode.utils.TaskRevision;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.ThreadLocalRandom;

@Slf4j
@LeetCode(id = 50, description = "Pow(x, n)")
public class PowXN extends LeetCodeTask<Double> {
    private double x;
    private int n;

    public static final String INFORMATION = """

        Implement pow(x, n), which calculates x raised to the power n (i.e., xn).
                                                
        Example:
            Input: x = 2.10000, n = 3
            Output: 9.26100

            Input: x = 2.00000, n = -2
            Output: 0.25000
            Explanation: 2-2 = 1/22 = 1/4 = 0.25""";

    public PowXN(int id, String description, TaskRevision revision) {
        super(id, description, revision);
        initialization();
    }

    private void initialization() {
        var random = ThreadLocalRandom.current();
        this.x = random.nextInt(-100 + 1, 100 + 1);
        this.n = random.nextInt(Integer.MIN_VALUE/100000000, Integer.MAX_VALUE/100000000);

        log.info("x is {}, n is {}", x, n);
    }

    @Override
    protected String getInformation() {
        return INFORMATION;
    }

    // time = 481 ms
    @Override
    protected Double original() {
        var original = new Original(x, n);
        return original.process();
    }

    // time = 462 ms
    @Override
    protected Double practice() {
        var practice = new Practice(x, n);
        return practice.process();
    }

    // time = 429 ms
    @Override
    protected Double solution() {
        var solution = new Solution(x, n);
        return solution.process();
    }
}
