package com.witalis.praxis.leetcode.task.h17.p1611;

import com.witalis.praxis.leetcode.task.LeetCodeTask;
import com.witalis.praxis.leetcode.task.h17.p1611.option.*;
import com.witalis.praxis.leetcode.utils.LeetCode;
import com.witalis.praxis.leetcode.utils.TaskDifficulty;
import com.witalis.praxis.leetcode.utils.TaskRevision;

import lombok.extern.slf4j.Slf4j;
import java.util.concurrent.ThreadLocalRandom;

import static com.witalis.praxis.leetcode.utils.TaskTag.*;

@Slf4j
@LeetCode(
    id = 1611,
    description = "Minimum One Bit Operations to Make Integers Zero",
    difficulty = TaskDifficulty.HARD,
    tags = {DYNAMIC_PROGRAMMING, BIT_MANIPULATION, MEMOIZATION}
)
public class MinimumOneBitOperationsToMakeIntegersZero extends LeetCodeTask<Integer> {
    public static final int VALUE = 1_000_000_000;

    private int number;

    public static final String INFORMATION = """

        Description:
            Given an integer n, you must transform it into 0 using the following operations any number of times:
                * Change the rightmost (0th) bit in the binary representation of n.
                * Change the ith bit in the binary representation of n if the (i-1)th bit is set to 1
                  and the (i-2)th through 0th bits are set to 0.

            Return the minimum number of operations to transform n into 0.

        Example:
            Input: n = 6
            Output: 4
            Explanation: The binary representation of 6 is "110".
                "110" -> "010" with the 2nd operation since the 1st bit is 1 and 0th through 0th bits are 0.
                "010" -> "011" with the 1st operation.
                "011" -> "001" with the 2nd operation since the 0th bit is 1.
                "001" -> "000" with the 1st operation.""";

    public MinimumOneBitOperationsToMakeIntegersZero(int id, String description, TaskRevision revision) {
        super(id, description, revision);
        initialization();
    }

    private void initialization() {
        final var random = ThreadLocalRandom.current();

        this.number = random.nextInt(0, VALUE + 1);

        log.info("Number 'n': {}", number);
    }

    @Override
    protected String getInformation() {
        return INFORMATION;
    }

    // time = 594 ms
    @Override
    protected Integer original() {
        var original = new Original(number);
        return original.process();
    }

    // time = 574 ms
    @Override
    protected Integer practice() {
        var practice = new Practice(number);
        return practice.process();
    }

    // time = 441 ms
    @Override
    protected Integer solution() {
        var solution = new Solution(number);
        return solution.process();
    }
}
