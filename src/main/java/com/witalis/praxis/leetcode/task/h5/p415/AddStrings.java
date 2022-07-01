package com.witalis.praxis.leetcode.task.h5.p415;

import com.witalis.praxis.leetcode.task.LeetCodeTask;
import com.witalis.praxis.leetcode.task.h5.p415.option.*;
import com.witalis.praxis.leetcode.utils.LeetCode;
import com.witalis.praxis.leetcode.utils.TaskDifficulty;
import com.witalis.praxis.leetcode.utils.TaskRevision;

import lombok.extern.slf4j.Slf4j;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

import static com.witalis.praxis.leetcode.utils.TaskTag.*;

@Slf4j
@LeetCode(
    id = 415,
    description = "Add Strings",
    difficulty = TaskDifficulty.EASY,
    tags = {MATH, STRING, SIMULATION}
)
public class AddStrings extends LeetCodeTask<String> {
    public static final int LEN = 10_000;
    private String number1;
    private String number2;

    public static final String INFORMATION = """

        Given two non-negative integers, num1 and num2 represented as string,
            return the sum of num1 and num2 as a string.

        You must solve the problem without using any built-in library for handling large integers (such as BigInteger).
            You must also not convert the inputs to integers directly.

        Example:
            Input: num1 = "456", num2 = "77"
            Output: "533" """;

    public AddStrings(int id, String description, TaskRevision revision) {
        super(id, description, revision);
        initialization();
    }

    private void initialization() {
        this.number1 = generate();
        this.number2 = generate();

        log.info("Number N1 is {}", number1);
        log.info("Number N2 is {}", number2);
    }

    private static String generate() {
        final var random = ThreadLocalRandom.current();

        StringBuilder builder = new StringBuilder();
        int len = random.nextInt(1, LEN + 1);
        for (int i = 0; i < len; i++) {
            builder.append(random.nextInt(0, 10));
        }

        String number = builder.toString().replaceFirst ("^0*", "");
        return number.isEmpty() ? "0" : number;
    }

    @Override
    protected String getInformation() {
        return INFORMATION;
    }

    // time = 628 ms
    @Override
    protected String original() {
        var original = new Original(number1, number2);
        return original.process();
    }

    // time = 597 ms
    @Override
    protected String practice() {
        var practice = new Practice(number1, number2);
        return practice.process();
    }

    // time = 616 ms
    @Override
    protected String solution() {
        var solution = new Solution(number1, number2);
        return solution.process();
    }
}
