package com.witalis.praxis.leetcode.task.h1.p67;

import com.witalis.praxis.leetcode.task.LeetCodeTask;
import com.witalis.praxis.leetcode.task.h1.p67.option.*;
import com.witalis.praxis.leetcode.utils.LeetCode;
import com.witalis.praxis.leetcode.utils.TaskDifficulty;
import com.witalis.praxis.leetcode.utils.TaskRevision;

import lombok.extern.slf4j.Slf4j;
import java.util.concurrent.ThreadLocalRandom;

import static com.witalis.praxis.leetcode.utils.TaskTag.*;

@Slf4j
@LeetCode(
    id = 67,
    description = "Add Binary",
    difficulty = TaskDifficulty.EASY,
    tags = {MATH, STRING, BIT_MANIPULATION, SIMULATION}
)
public class AddBinary extends LeetCodeTask<String> {
    public static final int LEN = 10_000;
    private String binary1;
    private String binary2;

    public static final String INFORMATION = """

        Given two binary strings a and b,
            return their sum as a binary string.

        Example:
            Input: a = "1010", b = "1011"
            Output: "10101" """;

    public AddBinary(int id, String description, TaskRevision revision) {
        super(id, description, revision);
        initialization();
    }

    private void initialization() {
        this.binary1 = generate();
        this.binary2 = generate();

        log.info("Binary1 is {}", binary1);
        log.info("Binary2 is {}", binary2);
    }

    private String generate() {
        final int origin = 0;
        final int bound = 2;

        var random = ThreadLocalRandom.current();
        int[] digits = random
            .ints(
                random.nextInt(1, LEN + 1),
                origin,
                bound
            ).toArray();

        var builder = new StringBuilder();
        for (int digit: digits) builder.append(digit);

        var binary = builder.toString();
        binary = binary.substring(binary.indexOf('1'));
        return binary.isEmpty() ? "0" : binary;
    }

    @Override
    protected String getInformation() {
        return INFORMATION;
    }

    // time = 2127 ms
    @Override
    protected String original() {
        var original = new Original(binary1, binary2);
        return original.process();
    }

    // time = 801 ms
    @Override
    protected String practice() {
        var practice = new Practice(binary1, binary2);
        return practice.process();
    }

    // time = 1621 ms
    @Override
    protected String solution() {
        var solution = new Solution(binary1, binary2);
        return solution.process();
    }
}
