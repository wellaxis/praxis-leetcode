package com.witalis.praxis.leetcode.task.h18.p1768;

import com.witalis.praxis.leetcode.task.LeetCodeTask;
import com.witalis.praxis.leetcode.task.h18.p1768.option.*;
import com.witalis.praxis.leetcode.utils.LeetCode;
import com.witalis.praxis.leetcode.utils.TaskDifficulty;
import com.witalis.praxis.leetcode.utils.TaskRevision;

import lombok.extern.slf4j.Slf4j;
import java.util.concurrent.ThreadLocalRandom;

import static com.witalis.praxis.leetcode.utils.TaskTag.*;

@Slf4j
@LeetCode(
    id = 1768,
    description = "Merge Strings Alternately",
    difficulty = TaskDifficulty.EASY,
    tags = {TWO_POINTERS, STRING}
)
public class MergeStringsAlternately extends LeetCodeTask<String> {
    public static final int LEN = 100;

    private String word1;
    private String word2;

    public static final String INFORMATION = """

        Description:
            You are given two strings word1 and word2. Merge the strings by adding letters in alternating order, starting with word1.
                If a string is longer than the other, append the additional letters onto the end of the merged string.

            Return the merged string.

        Example:
            Input: word1 = "abc", word2 = "pqr"
            Output: "apbqcr"
            Explanation: The merged string will be merged as so:
                word1:  a   b   c
                word2:    p   q   r
                merged: a p b q c r""";

    public MergeStringsAlternately(int id, String description, TaskRevision revision) {
        super(id, description, revision);
        initialization();
    }

    private void initialization() {
        this.word1 = generate();
        this.word2 = generate();

        log.info("Word #1: '{}'", word1);
        log.info("Word #2: '{}'", word2);
    }

    private static String generate() {
        final var random = ThreadLocalRandom.current();

        var len = random.nextInt(1, LEN + 1);
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

    // time = 608 ms
    @Override
    protected String original() {
        var original = new Original(word1, word2);
        return original.process();
    }

    // time = 545 ms
    @Override
    protected String practice() {
        var practice = new Practice(word1, word2);
        return practice.process();
    }

    // time = 504 ms
    @Override
    protected String solution() {
        var solution = new Solution(word1, word2);
        return solution.process();
    }
}
