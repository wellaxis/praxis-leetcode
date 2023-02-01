package com.witalis.praxis.leetcode.task.h11.p1071;

import com.witalis.praxis.leetcode.task.LeetCodeTask;
import com.witalis.praxis.leetcode.task.h11.p1071.option.*;
import com.witalis.praxis.leetcode.utils.LeetCode;
import com.witalis.praxis.leetcode.utils.TaskDifficulty;
import com.witalis.praxis.leetcode.utils.TaskRevision;

import lombok.extern.slf4j.Slf4j;
import java.util.concurrent.ThreadLocalRandom;

import static com.witalis.praxis.leetcode.utils.TaskTag.*;

@Slf4j
@LeetCode(
    id = 1071,
    description = "Greatest Common Divisor of Strings",
    difficulty = TaskDifficulty.EASY,
    tags = {MATH, STRING}
)
public class GreatestCommonDivisorOfStrings extends LeetCodeTask<String> {
    public static final int LEN = 1_000;

    private String string1;
    private String string2;

    public static final String INFORMATION = """

        Description:
            For two strings s and t, we say "t divides s" if and only if s = t + ... + t
                (i.e., t is concatenated with itself one or more times).

            Given two strings str1 and str2, return the largest string x such that x divides both str1 and str2.

        Example:
            Input: str1 = "ABABAB", str2 = "ABAB"
            Output: "AB" """;

    public GreatestCommonDivisorOfStrings(int id, String description, TaskRevision revision) {
        super(id, description, revision);
        initialization();
    }

    private void initialization() {
        final var random = ThreadLocalRandom.current();

        var len = random.nextInt(1, LEN + 1);
        StringBuilder builder1 = new StringBuilder();
        StringBuilder builder2 = new StringBuilder();
        if (random.nextBoolean()) {
            // usual scenario
            for (int i = 0; i < len; i++) {
                builder1.append((char) random.nextInt('A', 'Z' + 1));
                builder2.append((char) random.nextInt('A', 'Z' + 1));
            }
        } else {
            // repeatable scenario
            int size = random.nextInt(1, 10);
            StringBuilder divisor = new StringBuilder();
            for (int i = 0; i < size; i++) {
                divisor.append((char) random.nextInt('A', 'Z' + 1));
            }
            int count;
            while (builder1.length() < len || builder2.length() < len) {
                if (builder1.length() < len) {
                    count = random.nextInt(1, 5);
                    while (count > 0) builder1.append(divisor);
                }
                if (builder2.length() < len) {
                    count = random.nextInt(1, 5);
                    while (count > 0) builder2.append(divisor);
                }
            }
        }
        this.string1 = builder1.toString();
        this.string2 = builder2.toString();

        log.info("String #1: '{}'", string1);
        log.info("String #2: '{}'", string1);
    }

    @Override
    protected String getInformation() {
        return INFORMATION;
    }

    // time = 2209 ms
    @Override
    protected String original() {
        var original = new Original(string1, string2);
        return original.process();
    }

    // time = 2154 ms
    @Override
    protected String practice() {
        var practice = new Practice(string1, string2);
        return practice.process();
    }

    // time = 2064 ms
    @Override
    protected String solution() {
        var solution = new Solution(string1, string2);
        return solution.process();
    }
}
