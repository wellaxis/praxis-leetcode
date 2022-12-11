package com.witalis.praxis.leetcode.task.h17.p1657;

import com.witalis.praxis.leetcode.task.LeetCodeTask;
import com.witalis.praxis.leetcode.task.h17.p1657.option.*;
import com.witalis.praxis.leetcode.utils.LeetCode;
import com.witalis.praxis.leetcode.utils.TaskDifficulty;
import com.witalis.praxis.leetcode.utils.TaskRevision;

import lombok.extern.slf4j.Slf4j;
import java.util.concurrent.ThreadLocalRandom;

import static com.witalis.praxis.leetcode.utils.TaskTag.*;

@Slf4j
@LeetCode(
    id = 1657,
    description = "Determine if Two Strings Are Close",
    difficulty = TaskDifficulty.MEDIUM,
    tags = {HASH_TABLE, STRING, SORTING}
)
public class DetermineIfTwoStringsAreClose extends LeetCodeTask<Boolean> {
    public static final int LEN = 100_000;
    private String word1;
    private String word2;

    public static final String INFORMATION = """

        Description:
            Two strings are considered close if you can attain one from the other using the following operations:
                * Operation 1: Swap any two existing characters.
                ** For example, abcde -> aecdb
                * Operation 2: Transform every occurrence of one existing character into another existing character,
                  and do the same with the other character.
                ** For example, aacabb -> bbcbaa (all a's turn into b's, and all b's turn into a's)

            You can use the operations on either string as many times as necessary.

            Given two strings, word1 and word2, return true if word1 and word2 are close, and false otherwise.

        Example:
            Input: word1 = "abc", word2 = "bca"
            Output: true
            Explanation: You can attain word2 from word1 in 2 operations.
                Apply Operation 1: "abc" -> "acb"
                Apply Operation 1: "acb" -> "bca" """;

    public DetermineIfTwoStringsAreClose(int id, String description, TaskRevision revision) {
        super(id, description, revision);
        initialization();
    }

    private void initialization() {
        this.word1 = generate();
        this.word2 = generate();

        log.info("Word #1 is {}", word1);
        log.info("Word #2 is {}", word2);
    }

    private static String generate() {
        final var random = ThreadLocalRandom.current();

        int len = random.nextInt(1, LEN + 1);
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

    // time = 1542 ms
    @Override
    protected Boolean original() {
        var original = new Original(word1, word2);
        return original.process();
    }

    // time = 1440 ms
    @Override
    protected Boolean practice() {
        var practice = new Practice(word1, word2);
        return practice.process();
    }

    // time = 1315 ms
    @Override
    protected Boolean solution() {
        var solution = new Solution(word1, word2);
        return solution.process();
    }
}
