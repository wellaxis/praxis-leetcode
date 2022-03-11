package com.witalis.praxis.leetcode.task.h1.p44;

import com.witalis.praxis.leetcode.task.LeetCodeTask;
import com.witalis.praxis.leetcode.task.h1.p44.option.*;
import com.witalis.praxis.leetcode.utils.LeetCode;
import com.witalis.praxis.leetcode.utils.TaskDifficulty;
import com.witalis.praxis.leetcode.utils.TaskRevision;

import lombok.extern.slf4j.Slf4j;
import java.util.concurrent.ThreadLocalRandom;

import static com.witalis.praxis.leetcode.utils.TaskTag.*;

@Slf4j
@LeetCode(
    id = 44,
    description = "Wildcard Matching",
    difficulty = TaskDifficulty.HARD,
    tags = {STRING, DYNAMIC_PROGRAMMING, GREEDY, RECURSION}
)
public class WildcardMatching extends LeetCodeTask<Boolean> {
    public static final int LEN = 2_000;

    private String string;
    private String pattern;

    public static final String INFORMATION = """

        Given an input string (s) and a pattern (p),
            implement wildcard pattern matching with support for '?' and '*' where:

        '?' Matches any single character.
        '*' Matches any sequence of characters (including the empty sequence).

        The matching should cover the entire input string (not partial).

        Example:
            Input: s = "cb", p = "?a"
            Output: false
            Explanation: '?' matches 'c', but the second letter is 'a', which does not match 'b'.""";

    public WildcardMatching(int id, String description, TaskRevision revision) {
        super(id, description, revision);
        initialization();
    }

    private void initialization() {
        this.string = generate(false);
        this.pattern = generate(true);

        log.info("String is {}", string);
        log.info("Patter is {}", pattern);
    }

    private String generate(boolean isPattern) {
        final int regexChance = 10; // '?' or '*'
        final int leftLower = 97; // letter 'a'
        final int rightLower = 122; // letter 'z'

        var random = ThreadLocalRandom.current();
        var length = random.nextInt(1, LEN + 1);
        var builder = new StringBuilder(length);
        for (int i = 0; i < length; i++) {
            if (isPattern && random.nextInt(0, regexChance + 1) == regexChance) {
                char regex = (i % 4 == 0) ? '*' : '?';
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

    // time = 691 ms
    @Override
    protected Boolean original() {
        var original = new Original(string, pattern);
        return original.process();
    }

    // time = 535 ms
    @Override
    protected Boolean practice() {
        var practice = new Practice(string, pattern);
        return practice.process();
    }

    // time = 6245 ms
    @Override
    protected Boolean solution() {
        var solution = new Solution(string, pattern);
        return solution.process();
    }
}
