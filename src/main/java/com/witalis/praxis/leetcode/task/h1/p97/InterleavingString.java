package com.witalis.praxis.leetcode.task.h1.p97;

import com.witalis.praxis.leetcode.task.LeetCodeTask;
import com.witalis.praxis.leetcode.task.h1.p97.option.*;
import com.witalis.praxis.leetcode.utils.LeetCode;
import com.witalis.praxis.leetcode.utils.TaskDifficulty;
import com.witalis.praxis.leetcode.utils.TaskRevision;

import lombok.extern.slf4j.Slf4j;

import static com.witalis.praxis.leetcode.utils.TaskTag.*;

@Slf4j
@LeetCode(
    id = 97,
    description = "Interleaving String",
    difficulty = TaskDifficulty.MEDIUM,
    tags = {STRING, DYNAMIC_PROGRAMMING}
)
public class InterleavingString extends LeetCodeTask<Boolean> {
    public static final int LEN = 16;
    private String string1;
    private String string2;
    private String string3;

    public static final String INFORMATION = """

        Given strings s1, s2, and s3, find whether s3 is formed
            by an interleaving of s1 and s2.

        An interleaving of two strings s and t is a configuration
            where they are divided into non-empty substrings such that:
            * s = s1 + s2 + ... + sn
            * t = t1 + t2 + ... + tm
            * |n - m| <= 1
            * The interleaving is s1 + t1 + s2 + t2 + s3 + t3 + ... or t1 + s1 + t2 + s2 + t3 + s3 + ...

        Note: a + b is the concatenation of strings a and b.

        Example:
            Input: s1 = "aabcc", s2 = "dbbca", s3 = "aadbbcbcac"
            Output: true""";

    public InterleavingString(int id, String description, TaskRevision revision) {
        super(id, description, revision);
        initialization();
    }

    private void initialization() {
        this.string1 = "aabcc";
        this.string2 = "dbbca";
        this.string3 = "aadbbcbcac";

        log.info("String-1 is {}", string1);
        log.info("String-2 is {}", string2);
        log.info("String-3 is {}", string3);
    }

    @Override
    protected String getInformation() {
        return INFORMATION;
    }

    // time = 769 ms
    @Override
    protected Boolean original() {
        var original = new Original(string1, string2, string3);
        return original.process();
    }

    // time = 619 ms
    @Override
    protected Boolean practice() {
        var practice = new Practice(string1, string2, string3);
        return practice.process();
    }

    // time = 450 ms
    @Override
    protected Boolean solution() {
        var solution = new Solution(string1, string2, string3);
        return solution.process();
    }
}
