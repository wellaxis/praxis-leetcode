package com.witalis.praxis.leetcode.task.h2.p191;

import com.witalis.praxis.leetcode.task.LeetCodeTask;
import com.witalis.praxis.leetcode.task.h2.p191.option.*;
import com.witalis.praxis.leetcode.utils.LeetCode;
import com.witalis.praxis.leetcode.utils.TaskDifficulty;
import com.witalis.praxis.leetcode.utils.TaskRevision;

import lombok.extern.slf4j.Slf4j;
import java.util.concurrent.ThreadLocalRandom;

import static com.witalis.praxis.leetcode.utils.TaskTag.*;

@Slf4j
@LeetCode(
    id = 191,
    description = "Number of 1 Bits",
    difficulty = TaskDifficulty.EASY,
    tags = {BIT_MANIPULATION}
)
public class NumberOf1Bits extends LeetCodeTask<Integer> {
    public static final int LEN = 32;
    private int number;

    public static final String INFORMATION = """

        Write a function that takes an unsigned integer and returns the number of '1' bits it has (also known as the Hamming weight).

        Note:
        * Note that in some languages, such as Java, there is no unsigned integer type.
            In this case, the input will be given as a signed integer type.
            It should not affect your implementation, as the integer's internal
            binary representation is the same, whether it is signed or unsigned.
        * In Java, the compiler represents the signed integers using 2's complement
            notation. Therefore, in Example 3, the input represents the signed integer. -3.

        Example:
            Input: n = 00000000000000000000000000001011
            Output: 3
            Explanation: The input binary string 00000000000000000000000000001011
                has a total of three '1' bits.""";

    public NumberOf1Bits(int id, String description, TaskRevision revision) {
        super(id, description, revision);
        initialization();
    }

    private void initialization() {
        var random = ThreadLocalRandom.current();
        this.number = random.nextInt(Integer.MIN_VALUE, Integer.MAX_VALUE);

        log.info("The 32 bits of integer {} is {}", number, Integer.toBinaryString(number));
    }

    @Override
    protected String getInformation() {
        return INFORMATION;
    }

    // time = 471 ms
    @Override
    protected Integer original() {
        var original = new Original(number);
        return original.process();
    }

    // time = 464 ms
    @Override
    protected Integer practice() {
        var practice = new Practice(number);
        return practice.process();
    }

    // time = 469 ms
    @Override
    protected Integer solution() {
        var solution = new Solution(number);
        return solution.process();
    }
}
