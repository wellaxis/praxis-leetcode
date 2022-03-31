package com.witalis.praxis.leetcode.task.h3.p242;

import com.witalis.praxis.leetcode.task.LeetCodeTask;
import com.witalis.praxis.leetcode.task.h3.p242.option.*;
import com.witalis.praxis.leetcode.utils.LeetCode;
import com.witalis.praxis.leetcode.utils.TaskDifficulty;
import com.witalis.praxis.leetcode.utils.TaskRevision;

import lombok.extern.slf4j.Slf4j;

import static com.witalis.praxis.leetcode.utils.TaskTag.*;

@Slf4j
@LeetCode(
    id = 242,
    description = "Valid Anagram",
    difficulty = TaskDifficulty.EASY,
    tags = {HASH_TABLE, STRING, SORTING}
)
public class ValidAnagram extends LeetCodeTask<Boolean> {
    public static final int LEN = 50_000;
    private String source;
    private String target;

    public static final String INFORMATION = """

        Description:
            Given two strings s and t,
                return true if t is an anagram of s, and false otherwise.

            An Anagram is a word or phrase formed by rearranging
                the letters of a different word or phrase,
                typically using all the original letters exactly once.

        Example:
            Input: s = "anagram", t = "nagaram"
            Output: true""";

    public ValidAnagram(int id, String description, TaskRevision revision) {
        super(id, description, revision);
        initialization();
    }

    private void initialization() {
        this.source = "anagram";
        this.target = "nagaram";

        log.info("Source is '{}'", source);
        log.info("Target is '{}'", target);
    }

    @Override
    protected String getInformation() {
        return INFORMATION;
    }

    // time = 3560 ms
    @Override
    protected Boolean original() {
        var original = new Original(source, target);
        return original.process();
    }

    // time = 393 ms
    @Override
    protected Boolean practice() {
        var practice = new Practice(source, target);
        return practice.process();
    }

    // time = 541 ms
    @Override
    protected Boolean solution() {
        var solution = new Solution(source, target);
        return solution.process();
    }
}
