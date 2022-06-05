package com.witalis.praxis.leetcode.task.h1.p76;

import com.witalis.praxis.leetcode.task.LeetCodeTask;
import com.witalis.praxis.leetcode.task.h1.p76.option.*;
import com.witalis.praxis.leetcode.utils.LeetCode;
import com.witalis.praxis.leetcode.utils.TaskDifficulty;
import com.witalis.praxis.leetcode.utils.TaskRevision;

import lombok.extern.slf4j.Slf4j;
import java.util.concurrent.ThreadLocalRandom;

import static com.witalis.praxis.leetcode.utils.TaskTag.*;

@Slf4j
@LeetCode(
    id = 76,
    description = "Minimum Window Substring",
    difficulty = TaskDifficulty.HARD,
    tags = {HASH_TABLE, STRING, SLIDING_WINDOW}
)
public class MinimumWindowSubstring extends LeetCodeTask<String> {
    public static final int LEN = 100_000;
    private String source;
    private String target;

    public static final String INFORMATION = """

        Given two strings s and t of lengths m and n respectively,
            return the minimum window substring of s such that every character in t
            (including duplicates) is included in the window.
            If there is no such substring, return the empty string "".

        The testcases will be generated such that the answer is unique.

        A substring is a contiguous sequence of characters within the string.

        Example:
            Input: s = "ADOBECODEBANC", t = "ABC"
            Output: "BANC"
            Explanation: The minimum window substring "BANC" includes 'A', 'B', and 'C' from string t.""";

    public MinimumWindowSubstring(int id, String description, TaskRevision revision) {
        super(id, description, revision);
        initialization();
    }

    private void initialization() {
        this.target = generateString(1, LEN + 1);
        this.source = generateString(target.length(), LEN + 1);

        log.info("Source is '{}'", source);
        log.info("Target is '{}'", target);
    }

    private String generateString(int minLength, int maxLength) {
        var random = ThreadLocalRandom.current();

        int len = random.nextInt(minLength, maxLength);
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < len; i++) {
            if (random.nextBoolean()) {
                builder.append((char) random.nextInt('A', 'Z' + 1));
            } else {
                builder.append((char) random.nextInt('a', 'z' + 1));
            }
        }

        return builder.toString();
    }

    @Override
    protected String getInformation() {
        return INFORMATION;
    }

    // time = 98184 ms
    @Override
    protected String original() {
        var original = new Original(source, target);
        return original.process();
    }

    // time = 5582 ms
    @Override
    protected String practice() {
        var practice = new Practice(source, target);
        return practice.process();
    }

    // time = 26713 ms
    @Override
    protected String solution() {
        var solution = new Solution(source, target);
        return solution.process();
    }
}
