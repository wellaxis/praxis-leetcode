package com.witalis.praxis.leetcode.task.p43;

import com.witalis.praxis.leetcode.task.LeetCodeTask;
import com.witalis.praxis.leetcode.task.p43.option.*;
import com.witalis.praxis.leetcode.utils.LeetCode;
import com.witalis.praxis.leetcode.utils.TaskRevision;

import lombok.extern.slf4j.Slf4j;
import java.util.concurrent.ThreadLocalRandom;

@Slf4j
@LeetCode(id = 43, description = "Multiply Strings")
public class MultiplyStrings extends LeetCodeTask<String> {
    public static final int LEN = 200;
    private String number1;
    private String number2;

    public static final String INFORMATION = """

        Given two non-negative integers num1 and num2 represented as strings,
            return the product of num1 and num2, also represented as a string.

        Note: You must not use any built-in BigInteger library
            or convert the inputs to integer directly.

        Example:
            Input: num1 = "123", num2 = "456"
            Output: "56088" """;

    public MultiplyStrings(int id, String description, TaskRevision revision) {
        super(id, description, revision);
        initialization();
    }

    private void initialization() {
        this.number1 = generate();
        this.number2 = generate();

        log.info("Number1 is {}, number2 is {}", number1, number2);
    }

    private String generate() {
        final int origin = 0;
        final int bound = 10;

        return ThreadLocalRandom.current()
            .ints(
                ThreadLocalRandom.current()
                    .nextInt(1, LEN + 1),
                origin,
                bound
            )
            .collect(
                StringBuilder::new,
                StringBuilder::append,
                StringBuilder::append
            ).toString();
    }

    @Override
    protected String getInformation() {
        return INFORMATION;
    }

    // time = 7148 ms
    @Override
    protected String original() {
        var original = new Original(number1, number2);
        return original.process();
    }

    // time = 7366 ms
    @Override
    protected String practice() {
        var practice = new Practice(number1, number2);
        return practice.process();
    }

    // time = 19566 ms
    @Override
    protected String solution() {
        var solution = new Solution(number1, number2);
        return solution.process();
    }
}
