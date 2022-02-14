package com.witalis.praxis.leetcode.task.h1.p89;

import com.witalis.praxis.leetcode.task.LeetCodeTask;
import com.witalis.praxis.leetcode.task.h1.p89.option.*;
import com.witalis.praxis.leetcode.utils.LeetCode;
import com.witalis.praxis.leetcode.utils.TaskDifficulty;
import com.witalis.praxis.leetcode.utils.TaskRevision;

import lombok.extern.slf4j.Slf4j;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

import static com.witalis.praxis.leetcode.utils.TaskTag.*;

@Slf4j
@LeetCode(
    id = 89,
    description = "Gray Code",
    difficulty = TaskDifficulty.MEDIUM,
    tags = {MATH, BACKTRACKING, BIT_MANIPULATION}
)
public class GrayCode extends LeetCodeTask<List<Integer>> {
    public static final int LEN = 16;
    private int number;

    public static final String INFORMATION = """

        An n-bit gray code sequence is a sequence of 2n integers where:

        * Every integer is in the inclusive range [0, 2n - 1],
        * The first integer is 0,
        * An integer appears no more than once in the sequence,
        * The binary representation of every pair of adjacent integers differs by exactly one bit, and
        * The binary representation of the first and last integers differs by exactly one bit.

        Given an integer n, return any valid n-bit gray code sequence.

        Example:
            Input: n = 2
            Output: [0,1,3,2]
            Explanation:
            The binary representation of [0,1,3,2] is [00,01,11,10].
            - 00 and 01 differ by one bit
            - 01 and 11 differ by one bit
            - 11 and 10 differ by one bit
            - 10 and 00 differ by one bit
            [0,2,3,1] is also a valid gray code sequence, whose binary representation is [00,10,11,01].
            - 00 and 10 differ by one bit
            - 10 and 11 differ by one bit
            - 11 and 01 differ by one bit
            - 01 and 00 differ by one bit""";

    public GrayCode(int id, String description, TaskRevision revision) {
        super(id, description, revision);
        initialization();
    }

    private void initialization() {
        this.number = ThreadLocalRandom.current().nextInt(1, LEN + 1);

        log.info("Number is {}", number);
    }

    @Override
    protected String getInformation() {
        return INFORMATION;
    }

    // time = 2288 ms
    @Override
    protected List<Integer> original() {
        var original = new Original(number);
        return original.process();
    }

    // time = 2173 ms
    @Override
    protected List<Integer> practice() {
        var practice = new Practice(number);
        return practice.process();
    }

    // time = 2052 ms
    @Override
    protected List<Integer> solution() {
        var solution = new Solution(number);
        return solution.process();
    }
}
