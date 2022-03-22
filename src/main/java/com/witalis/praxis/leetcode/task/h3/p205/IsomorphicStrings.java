package com.witalis.praxis.leetcode.task.h3.p205;

import com.witalis.praxis.leetcode.task.LeetCodeTask;
import com.witalis.praxis.leetcode.task.h3.p205.option.*;
import com.witalis.praxis.leetcode.utils.LeetCode;
import com.witalis.praxis.leetcode.utils.TaskDifficulty;
import com.witalis.praxis.leetcode.utils.TaskRevision;

import lombok.extern.slf4j.Slf4j;

import static com.witalis.praxis.leetcode.utils.TaskTag.*;

@Slf4j
@LeetCode(
    id = 205,
    description = "Isomorphic Strings",
    difficulty = TaskDifficulty.EASY,
    tags = {STRING, HASH_TABLE}
)
public class IsomorphicStrings extends LeetCodeTask<Boolean> {
    public static final int LEN = 50_000;
    private String source;
    private String target;

    public static final String INFORMATION = """

        Given two strings s and t, determine if they are isomorphic.

        Two strings s and t are isomorphic
            if the characters in s can be replaced to get t.

        All occurrences of a character must be replaced
            with another character while preserving the order of characters.
            No two characters may map to the same character,
            but a character may map to itself.

        Example:
            Input: s = "paper", t = "title"
            Output: true""";

    public IsomorphicStrings(int id, String description, TaskRevision revision) {
        super(id, description, revision);
        initialization();
    }

    private void initialization() {
        this.source = "paper";
        this.target = "title";

        log.info("Source is '{}'", source);
        log.info("Target is '{}'", target);
    }

    @Override
    protected String getInformation() {
        return INFORMATION;
    }

    // time = 436 ms
    @Override
    protected Boolean original() {
        var original = new Original(source, target);
        return original.process();
    }

    // time = 424 ms
    @Override
    protected Boolean practice() {
        var practice = new Practice(source, target);
        return practice.process();
    }

    // time = 413 ms
    @Override
    protected Boolean solution() {
        var solution = new Solution(source, target);
        return solution.process();
    }
}
