package com.witalis.praxis.leetcode.task.h4.p392;

import com.witalis.praxis.leetcode.task.LeetCodeTask;
import com.witalis.praxis.leetcode.task.h4.p392.option.*;
import com.witalis.praxis.leetcode.utils.LeetCode;
import com.witalis.praxis.leetcode.utils.TaskDifficulty;
import com.witalis.praxis.leetcode.utils.TaskRevision;

import lombok.extern.slf4j.Slf4j;
import java.util.concurrent.ThreadLocalRandom;

import static com.witalis.praxis.leetcode.utils.TaskTag.*;

@Slf4j
@LeetCode(
    id = 392,
    description = "Is Subsequence",
    difficulty = TaskDifficulty.EASY,
    tags = {TWO_POINTERS, STRING, DYNAMIC_PROGRAMMING}
)
public class IsSubsequence extends LeetCodeTask<Boolean> {
    public static final int LEN_S = 100;
    public static final int LEN_T = 10_000;
    private String s;
    private String t;

    public static final String INFORMATION = """

        Given two strings s and t, return true if s is a subsequence of t, or false otherwise.

        A subsequence of a string is a new string that is formed from the original string
            by deleting some (can be none) of the characters without disturbing
            the relative positions of the remaining characters.
            (i.e., "ace" is a subsequence of "abcde" while "aec" is not).

        Example:
            Input: s = "abc", t = "ahbgdc"
            Output: true""";

    public IsSubsequence(int id, String description, TaskRevision revision) {
        super(id, description, revision);
        initialization();
    }

    private void initialization() {
        var random = ThreadLocalRandom.current();
        int sLength = random.nextInt(0, LEN_S + 1);
        int tLength = random.nextInt(0, LEN_T + 1);

        var sBuilder = new StringBuilder();
        var tBuilder = new StringBuilder();

        for (int s = 0; s < sLength; s++) {
            char sc = (char) random.nextInt('a', 'z' + 1);
            sBuilder.append(sc);
            int len = random.nextInt(0, 100);
            for (int t = 0; t < len; t++) {
                char tc = (char) random.nextInt('a', 'z' + 1);
                tBuilder.append(tc);
            }
            tBuilder.append(sc);
        }

        this.s = sBuilder.toString();
        this.t = tBuilder.toString();

        log.info("String 's' is {}", s);
        log.info("String 't' is {}", t);
    }

    @Override
    protected String getInformation() {
        return INFORMATION;
    }

    // time = 501 ms
    @Override
    protected Boolean original() {
        var original = new Original(s, t);
        return original.process();
    }

    // time = 431 ms
    @Override
    protected Boolean practice() {
        var practice = new Practice(s, t);
        return practice.process();
    }

    // time = 398 ms
    @Override
    protected Boolean solution() {
        var solution = new Solution(s, t);
        return solution.process();
    }
}
