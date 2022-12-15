package com.witalis.praxis.leetcode.task.h12.p1143;

import com.witalis.praxis.leetcode.task.LeetCodeTask;
import com.witalis.praxis.leetcode.task.h12.p1143.option.*;
import com.witalis.praxis.leetcode.utils.LeetCode;
import com.witalis.praxis.leetcode.utils.TaskDifficulty;
import com.witalis.praxis.leetcode.utils.TaskRevision;

import lombok.extern.slf4j.Slf4j;
import java.util.concurrent.ThreadLocalRandom;

import static com.witalis.praxis.leetcode.utils.TaskTag.*;

@Slf4j
@LeetCode(
    id = 1143,
    description = "Longest Common Subsequence",
    difficulty = TaskDifficulty.MEDIUM,
    tags = {STRING, DYNAMIC_PROGRAMMING}
)
public class LongestCommonSubsequence extends LeetCodeTask<Integer> {
    public static final int LEN = 1_000;
    private String text1;
    private String text2;

    public static final String INFORMATION = """

        Description:
            Given two strings text1 and text2, return the length of their longest common subsequence.
                If there is no common subsequence, return 0.

            A subsequence of a string is a new string generated from the original string with some characters
                (can be none) deleted without changing the relative order of the remaining characters.
                * For example, "ace" is a subsequence of "abcde".

            A common subsequence of two strings is a subsequence that is common to both strings.

        Example:
            Input: text1 = "abcde", text2 = "ace"
            Output: 3
            Explanation: The longest common subsequence is "ace" and its length is 3.""";

    public LongestCommonSubsequence(int id, String description, TaskRevision revision) {
        super(id, description, revision);
        initialization();
    }

    private void initialization() {
        this.text1 = generate();
        this.text2 = generate();

        log.info("Text #1: '{}'", text1);
        log.info("Text #2: '{}'", text1);
    }

    private static String generate() {
        final var random = ThreadLocalRandom.current();

        int len = random.nextInt(1, LEN + 1);
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < len; i++) {
            builder.append((char) random.nextInt('a', 'z' + 1));
        }

        return builder.toString();
    }

    @Override
    protected String getInformation() {
        return INFORMATION;
    }

    // time = 9078 ms
    @Override
    protected Integer original() {
        var original = new Original(text1, text2);
        return original.process();
    }

    // time = 7405 ms
    @Override
    protected Integer practice() {
        var practice = new Practice(text1, text2);
        return practice.process();
    }

    // time = 8764 ms
    @Override
    protected Integer solution() {
        var solution = new Solution(text1, text2);
        return solution.process();
    }
}
