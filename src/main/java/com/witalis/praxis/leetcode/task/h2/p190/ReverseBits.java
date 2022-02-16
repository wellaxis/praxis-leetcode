package com.witalis.praxis.leetcode.task.h2.p190;

import com.witalis.praxis.leetcode.task.LeetCodeTask;
import com.witalis.praxis.leetcode.task.h2.p190.option.*;
import com.witalis.praxis.leetcode.utils.LeetCode;
import com.witalis.praxis.leetcode.utils.TaskDifficulty;
import com.witalis.praxis.leetcode.utils.TaskRevision;
import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.ThreadLocalRandom;

import static com.witalis.praxis.leetcode.utils.TaskTag.*;

@Slf4j
@LeetCode(
    id = 190,
    description = "Reverse Bits",
    difficulty = TaskDifficulty.EASY,
    tags = {DIVIDE_AND_CONQUER, BIT_MANIPULATION}
)
public class ReverseBits extends LeetCodeTask<Integer> {
    public static final int LEN = 32;
    private String bits;

    public static final String INFORMATION = """

        Reverse bits of a given 32 bits unsigned integer.

        Note:
        * Note that in some languages, such as Java, there is no unsigned integer type.
            In this case, both input and output will be given as a signed integer type.
            They should not affect your implementation, as the integer's internal
            binary representation is the same, whether it is signed or unsigned.
        * In Java, the compiler represents the signed integers using 2's complement
            notation. Therefore, in Example 2 above, the input represents the signed
            integer -3 and the output represents the signed integer -1073741825.

        Example:
            Input: n = 00000010100101000001111010011100
            Output:    964176192 (00111001011110000010100101000000)
            Explanation: The input binary string
                00000010100101000001111010011100 represents the unsigned integer 43261596,
                so return 964176192 which its binary representation is 00111001011110000010100101000000.
            
            Input: n = 11111111111111111111111111111101
            Output:   3221225471 (10111111111111111111111111111111)
            Explanation: The input binary string
                11111111111111111111111111111101 represents the unsigned integer 4294967293,
                so return 3221225471 which its binary representation is 10111111111111111111111111111111.""";

    public ReverseBits(int id, String description, TaskRevision revision) {
        super(id, description, revision);
        initialization();
    }

    private void initialization() {
        var random = ThreadLocalRandom.current();
        var builder = new StringBuilder(32);
        for (int i = 0; i < LEN; i++) {
            builder.append(random.nextBoolean() ? 1 : 0);
        }
        this.bits = builder.toString();

        log.info("The 32 bits of integer is {}", bits);
    }

    @Override
    protected String getInformation() {
        return INFORMATION;
    }

    // time = 430 ms
    @Override
    protected Integer original() {
        var original = new Original(bits);
        return original.process();
    }

    // time = 454 ms
    @Override
    protected Integer practice() {
        var practice = new Practice(bits);
        return practice.process();
    }

    // time = 492 ms
    @Override
    protected Integer solution() {
        var solution = new Solution(bits);
        return solution.process();
    }
}
