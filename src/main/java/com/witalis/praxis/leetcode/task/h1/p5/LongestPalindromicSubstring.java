package com.witalis.praxis.leetcode.task.h1.p5;

import com.witalis.praxis.leetcode.task.LeetCodeTask;
import com.witalis.praxis.leetcode.task.h1.p5.option.*;
import com.witalis.praxis.leetcode.utils.LeetCode;
import com.witalis.praxis.leetcode.utils.TaskDifficulty;
import com.witalis.praxis.leetcode.utils.TaskRevision;

import lombok.extern.slf4j.Slf4j;

import static com.witalis.praxis.leetcode.utils.TaskTag.*;

@Slf4j
@LeetCode(
    id = 5,
    description = "Longest Palindromic Substring",
    difficulty = TaskDifficulty.MEDIUM,
    tags = {STRING, DYNAMIC_PROGRAMMING}
)
public class LongestPalindromicSubstring extends LeetCodeTask<String> {
    private String string;

    public static final String INFORMATION = """

            Given a string s, return the longest palindromic substring in s.
            Example:
                Input: s = "cbbd"
                Output: "bb\"""";

    public LongestPalindromicSubstring(int id, String description, TaskRevision revision) {
        super(id, description, revision);
        initialization();
    }

    private void initialization() {
        this.string = """
            Java is a high-level, class-based, object-oriented programming language
                that is designed to have as few implementation dependencies as possible.
                It is a general-purpose programming language intended to let programmers
                write once, run anywhere (WORA), meaning that compiled Java code
                can run on all platforms that support Java without the need for recompilation.
            """;
        log.info("String is {}", string);
    }

    @Override
    protected String getInformation() {
        return INFORMATION;
    }

    // time = 50497 ms
    @Override
    protected String original() {
        var original = new Original(string);
        return original.process();
    }

    // time = 1325 ms
    @Override
    protected String practice() {
        var practice = new Practice(string);
        return practice.process();
    }

    // time = 1511 ms
    @Override
    protected String solution() {
        var solution = new Solution(string);
        return solution.process();
    }
}
