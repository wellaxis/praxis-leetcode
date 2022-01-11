package com.witalis.praxis.leetcode.task.h1.p10;

import com.witalis.praxis.leetcode.task.LeetCodeTask;
import com.witalis.praxis.leetcode.task.h1.p10.option.*;
import com.witalis.praxis.leetcode.utils.LeetCode;
import com.witalis.praxis.leetcode.utils.TaskDifficulty;
import com.witalis.praxis.leetcode.utils.TaskRevision;

import lombok.extern.slf4j.Slf4j;
import java.util.concurrent.ThreadLocalRandom;

import static com.witalis.praxis.leetcode.utils.TaskTag.*;

@Slf4j
@LeetCode(
    id = 10,
    description = "Regular Expression Matching",
    difficulty = TaskDifficulty.HARD,
    tags = {STRING, DYNAMIC_PROGRAMMING, RECURSION}
)
public class RegularExpressionMatching extends LeetCodeTask<Boolean> {
    public static final int STRING_LEN = 20;
    public static final int PATTERN_LEN = 30;

    private String string;
    private String pattern;

    public static final String INFORMATION = """

        Given an input string s and a pattern p,
            implement regular expression matching
            with support for '.' and '*' where:

        '.' Matches any single character.
        '*' Matches zero or more of the preceding element.

        The matching should cover the entire input string (not partial).

        Example:
            Input: s = "ab", p = ".*"
            Output: true
            Explanation: ".*" means "zero or more (*) of any character (.)" """;

    public RegularExpressionMatching(int id, String description, TaskRevision revision) {
        super(id, description, revision);
        initialization();
    }

    private void initialization() {
        this.string = generate(STRING_LEN, false);
        this.pattern = generate(PATTERN_LEN, true);

        log.info("String is {}, patter is {}", string, pattern);
    }

    private String generate(int len, boolean isPattern) {
        final int regexChance = 10; // '.' or '*'
        final int leftLower = 97; // letter 'a'
        final int rightLower = 122; // letter 'z'

        var random = ThreadLocalRandom.current();
        var length = random.nextInt(1, len + 1);
        var builder = new StringBuilder(length);
        for (int i = 0; i < length; i++) {
            if (isPattern && random.nextInt(0, regexChance + 1) == regexChance) {
                char regex = (i % 2 == 0) ? '.' : '*';
                builder.append(regex);
            } else {
                int randomLimitedInt = leftLower + (int)
                    (random.nextFloat() * (rightLower - leftLower + 1));
                builder.append((char) randomLimitedInt);
            }
        }
        return builder.toString();
    }

    @Override
    protected String getInformation() {
        return INFORMATION;
    }

    // time = 632 ms
    @Override
    protected Boolean original() {
        var original = new Original(string, pattern);
        return original.process();
    }

    // time = 600 ms
    @Override
    protected Boolean practice() {
        var practice = new Practice(string, pattern);
        return practice.process();
    }

    // time = 466 ms
    @Override
    protected Boolean solution() {
        var solution = new Solution(string, pattern);
        return solution.process();
    }
}
