package com.witalis.praxis.leetcode.task.h20.p1930;

import com.witalis.praxis.leetcode.task.LeetCodeTask;
import com.witalis.praxis.leetcode.task.h20.p1930.option.*;
import com.witalis.praxis.leetcode.utils.LeetCode;
import com.witalis.praxis.leetcode.utils.TaskDifficulty;
import com.witalis.praxis.leetcode.utils.TaskRevision;

import lombok.extern.slf4j.Slf4j;
import java.util.concurrent.ThreadLocalRandom;

import static com.witalis.praxis.leetcode.utils.TaskTag.*;

@Slf4j
@LeetCode(
    id = 1930,
    description = "Unique Length-3 Palindromic Subsequences",
    difficulty = TaskDifficulty.MEDIUM,
    tags = {HASH_TABLE, STRING, PREFIX_SUM}
)
public class UniqueLength3PalindromicSubsequences extends LeetCodeTask<Integer> {
    public static final int LEN = 100_000;

    private String string;

    public static final String INFORMATION = """

        Description:
            Given a string s, return the number of unique palindromes of length three that are a subsequence of s.

            Note that even if there are multiple ways to obtain the same subsequence, it is still only counted once.

            A palindrome is a string that reads the same forwards and backwards.

            A subsequence of a string is a new string generated from the original string
                with some characters (can be none) deleted without changing the relative order of the remaining characters.

            * For example, "ace" is a subsequence of "abcde".

        Example:
            Input: s = "aabca"
            Output: 3
            Explanation: The 3 palindromic subsequences of length 3 are:
                - "aba" (subsequence of "aabca")
                - "aaa" (subsequence of "aabca")
                - "aca" (subsequence of "aabca")""";

    public UniqueLength3PalindromicSubsequences(int id, String description, TaskRevision revision) {
        super(id, description, revision);
        initialization();
    }

    private void initialization() {
        final var random = ThreadLocalRandom.current();

        var len = random.nextInt(3, LEN + 1);
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < len; i++) {
            builder.append((char) random.nextInt('a', 'z' + 1));
        }
        this.string = builder.toString();

        log.info("String 's': '{}'", string);
    }

    @Override
    protected String getInformation() {
        return INFORMATION;
    }

    // time = 10228 ms
    @Override
    protected Integer original() {
        var original = new Original(string);
        return original.process();
    }

    // time = 10034 ms
    @Override
    protected Integer practice() {
        var practice = new Practice(string);
        return practice.process();
    }

    // time = 1668 ms
    @Override
    protected Integer solution() {
        var solution = new Solution(string);
        return solution.process();
    }
}
