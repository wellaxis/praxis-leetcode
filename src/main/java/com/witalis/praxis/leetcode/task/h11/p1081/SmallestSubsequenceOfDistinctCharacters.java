package com.witalis.praxis.leetcode.task.h11.p1081;

import com.witalis.praxis.leetcode.task.LeetCodeTask;
import com.witalis.praxis.leetcode.task.h11.p1081.option.*;
import com.witalis.praxis.leetcode.utils.LeetCode;
import com.witalis.praxis.leetcode.utils.TaskDifficulty;
import com.witalis.praxis.leetcode.utils.TaskRevision;

import lombok.extern.slf4j.Slf4j;
import java.util.concurrent.ThreadLocalRandom;

import static com.witalis.praxis.leetcode.utils.TaskTag.*;

@Slf4j
@LeetCode(
    id = 1081,
    description = "Smallest Subsequence of Distinct Characters",
    difficulty = TaskDifficulty.MEDIUM,
    tags = {STRING, STACK, GREEDY, MONOTONIC_STACK}
)
public class SmallestSubsequenceOfDistinctCharacters extends LeetCodeTask<String> {
    public static final int LEN = 1_000;
    private String string;

    public static final String INFORMATION = """

        Description:
            Given a string s, return the lexicographically smallest subsequence of s
                that contains all the distinct characters of s exactly once.

        Example:
            Input: s = "bcabc"
            Output: "abc" """;

    public SmallestSubsequenceOfDistinctCharacters(int id, String description, TaskRevision revision) {
        super(id, description, revision);
        initialization();
    }

    private void initialization() {
        final var random = ThreadLocalRandom.current();

        var len = random.nextInt(1, LEN + 1);
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < len; i++) {
            builder.append((char) random.nextInt('a', 'z' + 1));
        }
        this.string = builder.toString();

        log.info("String 's' is {}", string);
    }

    @Override
    protected String getInformation() {
        return INFORMATION;
    }

    // time = 2209 ms
    @Override
    protected String original() {
        var original = new Original(string);
        return original.process();
    }

    // time = 2154 ms
    @Override
    protected String practice() {
        var practice = new Practice(string);
        return practice.process();
    }

    // time = 2064 ms
    @Override
    protected String solution() {
        var solution = new Solution(string);
        return solution.process();
    }
}
