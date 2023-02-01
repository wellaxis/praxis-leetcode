package com.witalis.praxis.leetcode.task.h12.p1137;

import com.witalis.praxis.leetcode.task.LeetCodeTask;
import com.witalis.praxis.leetcode.task.h12.p1137.option.*;
import com.witalis.praxis.leetcode.utils.LeetCode;
import com.witalis.praxis.leetcode.utils.TaskDifficulty;
import com.witalis.praxis.leetcode.utils.TaskRevision;

import lombok.extern.slf4j.Slf4j;
import java.util.concurrent.ThreadLocalRandom;

import static com.witalis.praxis.leetcode.utils.TaskTag.*;

@Slf4j
@LeetCode(
    id = 1137,
    description = "N-th Tribonacci Number",
    difficulty = TaskDifficulty.EASY,
    tags = {MATH, DYNAMIC_PROGRAMMING, MEMOIZATION}
)
public class NthTribonacciNumber extends LeetCodeTask<Integer> {
    public static final int LEN = 37;
    private int number;

    public static final String INFORMATION = """

        Desciption:
            The Tribonacci sequence T[n] is defined as follows:
                T[0] = 0, T[1] = 1, T[2] = 1, and T[n+3] = T[n] + T[n+1] + T[n+2] for n >= 0.

            Given `n`, return _the value of T[n]_.

        Example:
            Input: n = 4
            Output: 4
            Explanation:
                T_3 = 0 + 1 + 1 = 2
                T_4 = 1 + 1 + 2 = 4""";

    public NthTribonacciNumber(int id, String description, TaskRevision revision) {
        super(id, description, revision);
        initialization();
    }

    private void initialization() {
        final var random = ThreadLocalRandom.current();

        this.number = random.nextInt(0, LEN + 1);

        log.info("Number: {}", number);
    }

    @Override
    protected String getInformation() {
        return INFORMATION;
    }

    // time = 3029 ms
    @Override
    protected Integer original() {
        var original = new Original(number);
        return original.process();
    }

    // time = 3606 ms
    @Override
    protected Integer practice() {
        var practice = new Practice(number);
        return practice.process();
    }

    // time = 2189 ms
    @Override
    protected Integer solution() {
        var solution = new Solution(number);
        return solution.process();
    }
}
