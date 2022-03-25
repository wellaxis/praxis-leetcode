package com.witalis.praxis.leetcode.task.h3.p290;

import com.witalis.praxis.leetcode.task.LeetCodeTask;
import com.witalis.praxis.leetcode.task.h3.p290.option.*;
import com.witalis.praxis.leetcode.utils.LeetCode;
import com.witalis.praxis.leetcode.utils.TaskDifficulty;
import com.witalis.praxis.leetcode.utils.TaskRevision;

import lombok.extern.slf4j.Slf4j;

import static com.witalis.praxis.leetcode.utils.TaskTag.*;

@Slf4j
@LeetCode(
    id = 290,
    description = "Word Pattern",
    difficulty = TaskDifficulty.EASY,
    tags = {STRING, HASH_TABLE}
)
public class WordPattern extends LeetCodeTask<Boolean> {
    public static final int PATTERN_LEN = 300;
    public static final int STRING_LEN = 3_000;
    private String pattern;
    private String string;

    public static final String INFORMATION = """

        Description:
            Given a pattern and a string s,
            find if s follows the same pattern.

            Here follow means a full match,
            such that there is a bijection between
            a letter in pattern and a non-empty word in s.

        Example:
            Input: pattern = "abba", s = "dog cat cat dog"
            Output: true""";

    public WordPattern(int id, String description, TaskRevision revision) {
        super(id, description, revision);
        initialization();
    }

    private void initialization() {
        this.pattern = "abba";
        this.string = "dog cat cat dog";

        log.info("Pattern is {}", pattern);
        log.info("String is {}", string);
    }

    @Override
    protected String getInformation() {
        return INFORMATION;
    }

    // time = 424 ms
    @Override
    protected Boolean original() {
        var original = new Original(pattern, string);
        return original.process();
    }

    // time = 415 ms
    @Override
    protected Boolean practice() {
        var practice = new Practice(pattern, string);
        return practice.process();
    }

    // time = 468 ms
    @Override
    protected Boolean solution() {
        var solution = new Solution(pattern, string);
        return solution.process();
    }
}
