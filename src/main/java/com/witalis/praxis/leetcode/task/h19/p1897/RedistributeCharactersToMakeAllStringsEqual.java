package com.witalis.praxis.leetcode.task.h19.p1897;

import com.witalis.praxis.leetcode.task.LeetCodeTask;
import com.witalis.praxis.leetcode.task.h19.p1897.option.*;
import com.witalis.praxis.leetcode.utils.LeetCode;
import com.witalis.praxis.leetcode.utils.TaskDifficulty;
import com.witalis.praxis.leetcode.utils.TaskRevision;

import lombok.extern.slf4j.Slf4j;
import java.util.Arrays;
import java.util.concurrent.ThreadLocalRandom;

import static com.witalis.praxis.leetcode.utils.TaskTag.*;

@Slf4j
@LeetCode(
    id = 1897,
    description = "Redistribute Characters to Make All Strings Equal",
    difficulty = TaskDifficulty.EASY,
    tags = {HASH_TABLE, STRING, COUNTING}
)
public class RedistributeCharactersToMakeAllStringsEqual extends LeetCodeTask<Boolean> {
    public static final int LEN = 100;

    private String[] words;

    public static final String INFORMATION = """

        Description:
            You are given an array of strings words (0-indexed).

            In one operation, pick two distinct indices i and j, where words[i] is a non-empty string,
                and move any character from words[i] to any position in words[j].

            Return true if you can make every string in words equal using any number of operations, and false otherwise.

        Examples:
            Input: words = ["abc","aabc","bc"]
            Output: true
            Explanation: Move the first 'a' in words[1] to the front of words[2], to make words[1] = "abc" and words[2] = "abc".
                All the strings are now equal to "abc", so return true.""";

    public RedistributeCharactersToMakeAllStringsEqual(int id, String description, TaskRevision revision) {
        super(id, description, revision);
        initialization();
    }

    private void initialization() {
        final var random = ThreadLocalRandom.current();

        int n = random.nextInt(1, LEN + 1);
        this.words = new String[n];
        for (int i = 0; i < n; i++) {
            var builder = new StringBuilder();
            int len = random.nextInt(1, LEN + 1);
            for (int j = 0; j < len; j++) {
                builder.append((char) random.nextInt('a', 'z' + 1));
            }
            words[i] = builder.toString();
        }

        log.info("Words: {}", Arrays.toString(words));
    }

    @Override
    protected String getInformation() {
        return INFORMATION;
    }

    // time = 574 ms
    @Override
    protected Boolean original() {
        var original = new Original(words.clone());
        return original.process();
    }

    // time = 532 ms
    @Override
    protected Boolean practice() {
        var practice = new Practice(words.clone());
        return practice.process();
    }

    // time = 449 ms
    @Override
    protected Boolean solution() {
        var solution = new Solution(words.clone());
        return solution.process();
    }
}
