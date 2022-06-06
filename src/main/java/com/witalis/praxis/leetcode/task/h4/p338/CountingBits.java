package com.witalis.praxis.leetcode.task.h4.p338;

import com.witalis.praxis.leetcode.task.LeetCodeTask;
import com.witalis.praxis.leetcode.task.h4.p338.option.*;
import com.witalis.praxis.leetcode.utils.LeetCode;
import com.witalis.praxis.leetcode.utils.TaskDifficulty;
import com.witalis.praxis.leetcode.utils.TaskRevision;

import lombok.extern.slf4j.Slf4j;
import java.util.concurrent.ThreadLocalRandom;

import static com.witalis.praxis.leetcode.utils.TaskTag.*;

@Slf4j
@LeetCode(
    id = 338,
    description = "Counting Bits",
    difficulty = TaskDifficulty.EASY,
    tags = {DYNAMIC_PROGRAMMING, BIT_MANIPULATION}
)
public class CountingBits extends LeetCodeTask<int[]> {
    public static final int VALUE = 100_000;
    private int number;

    public static final String INFORMATION = """

        Given an integer n, return an array ans of length n + 1 such that for each i (0 <= i <= n),
            ans[i] is the number of 1's in the binary representation of i.

        Example:
            Input: n = 5
            Output: [0,1,1,2,1,2]
            Explanation:
                0 --> 0
                1 --> 1
                2 --> 10
                3 --> 11
                4 --> 100
                5 --> 101""";

    public CountingBits(int id, String description, TaskRevision revision) {
        super(id, description, revision);
        initialization();
    }

    private void initialization() {
        this.number = generate();

        log.info("Number is {}", number);
    }

    private int generate() {
        return ThreadLocalRandom.current().nextInt(0, VALUE + 1);
    }

    @Override
    protected String getInformation() {
        return INFORMATION;
    }

    // time = 20920 ms
    @Override
    protected int[] original() {
        var original = new Original(number);
        return original.process();
    }

    // time = 2301 ms
    @Override
    protected int[] practice() {
        var practice = new Practice(number);
        return practice.process();
    }

    // time = 2082 ms
    @Override
    protected int[] solution() {
        var solution = new Solution(number);
        return solution.process();
    }
}
