package com.witalis.praxis.leetcode.task.h2.p131;

import com.witalis.praxis.leetcode.task.LeetCodeTask;
import com.witalis.praxis.leetcode.task.h2.p131.option.*;
import com.witalis.praxis.leetcode.utils.LeetCode;
import com.witalis.praxis.leetcode.utils.TaskDifficulty;
import com.witalis.praxis.leetcode.utils.TaskRevision;

import lombok.extern.slf4j.Slf4j;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

import static com.witalis.praxis.leetcode.utils.TaskTag.*;

@Slf4j
@LeetCode(
    id = 131,
    description = "Palindrome Partitioning",
    difficulty = TaskDifficulty.MEDIUM,
    tags = {STRING, DYNAMIC_PROGRAMMING, BACKTRACKING}
)
public class PalindromePartitioning extends LeetCodeTask<List<List<String>>> {
    public static final int LEN = 160;
    private String string;

    public static final String INFORMATION = """

        Given a string s, partition s such that every substring of the partition is a palindrome.
            Return all possible palindrome partitioning of s.

        A palindrome string is a string that reads the same backward as forward.

        Example:
            Input: s = "aab"
            Output: [["a","a","b"],["aa","b"]]""";

    public PalindromePartitioning(int id, String description, TaskRevision revision) {
        super(id, description, revision);
        initialization();
    }

    private void initialization() {
        final var random = ThreadLocalRandom.current();

        var len = random.nextInt(0, LEN + 1);
        var builder = new StringBuilder();

        for (int i = 0; i < len; i++) {
            builder.append((char) random.nextInt('a', 'z' + 1));
        }
        this.string = builder.toString();

        log.info("String is {}", string);
    }

    @Override
    protected String getInformation() {
        return INFORMATION;
    }

    // time = 925 ms
    @Override
    protected List<List<String>> original() {
        var original = new Original(string);
        return original.process();
    }

    // time = 964 ms
    @Override
    protected List<List<String>> practice() {
        var practice = new Practice(string);
        return practice.process();
    }

    // time = 901 ms
    @Override
    protected List<List<String>> solution() {
        var solution = new Solution(string);
        return solution.process();
    }
}
