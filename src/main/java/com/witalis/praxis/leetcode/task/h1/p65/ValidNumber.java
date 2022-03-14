package com.witalis.praxis.leetcode.task.h1.p65;

import com.witalis.praxis.leetcode.task.LeetCodeTask;
import com.witalis.praxis.leetcode.task.h1.p65.option.*;
import com.witalis.praxis.leetcode.utils.LeetCode;
import com.witalis.praxis.leetcode.utils.TaskDifficulty;
import com.witalis.praxis.leetcode.utils.TaskRevision;

import lombok.extern.slf4j.Slf4j;
import java.util.concurrent.ThreadLocalRandom;

import static com.witalis.praxis.leetcode.utils.TaskTag.*;

@Slf4j
@LeetCode(
    id = 65,
    description = "Valid Number",
    difficulty = TaskDifficulty.HARD,
    tags = {STRING}
)
public class ValidNumber extends LeetCodeTask<Boolean> {
    public static final int LEN = 20;
    private String string;

    public static final String INFORMATION = """

            A valid number can be split up into these components (in order):
                1. A decimal number or an integer.
                2. (Optional) An 'e' or 'E', followed by an integer.

            A decimal number can be split up into these components (in order):
                1. (Optional) A sign character (either '+' or '-').
                2. One of the following formats:
                    1. One or more digits, followed by a dot '.'.
                    2. One or more digits, followed by a dot '.', followed by one or more digits.
                    3. A dot '.', followed by one or more digits.

            An integer can be split up into these components (in order):
                1. (Optional) A sign character (either '+' or '-').
                2. One or more digits.

            For example, all the following are valid numbers:
                ["2", "0089", "-0.1", "+3.14", "4.", "-.9", "2e10", "-90E3", "3e+7", "+6e-1", "53.5e93", "-123.456e789"],
                while the following are not valid numbers: ["abc", "1a", "1e", "e3", "99e2.5", "--6", "-+3", "95a54e53"].

            Given a string s, return true if s is a valid number.

            Example:
                Input: s = "0"
                Output: true""";

    public ValidNumber(int id, String description, TaskRevision revision) {
        super(id, description, revision);
        initialization();
    }

    private void initialization() {
        var random = ThreadLocalRandom.current();
        var builder = new StringBuilder();
        builder.append("-");
        var len = random.nextInt(1, 5);
        for (int i = 0; i < len; i++) builder.append(random.nextInt(0, 10));
        builder.append(".");
        len = random.nextInt(1, 5);
        for (int i = 0; i < len; i++) builder.append(random.nextInt(0, 10));
        builder.append("e");
        builder.append("-");
        len = random.nextInt(1, 5);
        for (int i = 0; i < len; i++) builder.append(random.nextInt(0, 10));

        this.string = builder.toString();

        log.info("String is {}", string);
    }

    @Override
    protected String getInformation() {
        return INFORMATION;
    }

    // time = 569 ms
    @Override
    protected Boolean original() {
        var original = new Original(string);
        return original.process();
    }

    // time = 519 ms
    @Override
    protected Boolean practice() {
        var practice = new Practice(string);
        return practice.process();
    }

    // time = 380 ms
    @Override
    protected Boolean solution() {
        var solution = new Solution(string);
        return solution.process();
    }
}
