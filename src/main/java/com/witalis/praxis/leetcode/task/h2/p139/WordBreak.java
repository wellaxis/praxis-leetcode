package com.witalis.praxis.leetcode.task.h2.p139;

import com.witalis.praxis.leetcode.task.LeetCodeTask;
import com.witalis.praxis.leetcode.task.h2.p139.option.*;
import com.witalis.praxis.leetcode.utils.LeetCode;
import com.witalis.praxis.leetcode.utils.TaskDifficulty;
import com.witalis.praxis.leetcode.utils.TaskRevision;

import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

import static com.witalis.praxis.leetcode.utils.TaskTag.*;

@Slf4j
@LeetCode(
    id = 139,
    description = "Word Break",
    difficulty = TaskDifficulty.MEDIUM,
    tags = {HASH_TABLE, STRING, DYNAMIC_PROGRAMMING, TRIE, MEMOIZATION}
)
public class WordBreak extends LeetCodeTask<Boolean> {
    public static final int LEN = 300;
    public static final int DICT_LEN = 20;
    public static final int DICT_SIZE = 1_000;
    private String string;
    private List<String> wordDict;

    public static final String INFORMATION = """

        Given a string s and a dictionary of strings wordDict,
            return true if s can be segmented into a space-separated sequence of one or more dictionary words.

        Note that the same word in the dictionary may be reused multiple times in the segmentation.

        Example:
            Input: s = "applepenapple", wordDict = ["apple","pen"]
            Output: true
            Explanation: Return true because "applepenapple" can be segmented as "apple pen apple".
                Note that you are allowed to reuse a dictionary word.""";

    public WordBreak(int id, String description, TaskRevision revision) {
        super(id, description, revision);
        initialization();
    }

    private void initialization() {
        final var random = ThreadLocalRandom.current();

        var len = random.nextInt(1, LEN + 1);
        this.string = generate(len);

        var size = random.nextInt(1, DICT_SIZE + 1);
        this.wordDict = new ArrayList<>(size);
        for (int i = 0; i < size; i++) {
            len = random.nextInt(1, DICT_LEN + 1);
            wordDict.add(i, generate(len));
        }

        log.info("String is {}", string);
        log.info("Dictionary is {}", wordDict);
    }

    private static String generate(int length) {
        final var random = ThreadLocalRandom.current();

        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < length; i++) {
            builder.append((char) random.nextInt('a', 'z' + 1));
        }

        return builder.toString();
    }

    @Override
    protected String getInformation() {
        return INFORMATION;
    }

    // time = 803 ms
    @Override
    protected Boolean original() {
        var original = new Original(string, wordDict);
        return original.process();
    }

    // time = 539 ms
    @Override
    protected Boolean practice() {
        var practice = new Practice(string, wordDict);
        return practice.process();
    }

    // time = 523 ms
    @Override
    protected Boolean solution() {
        var solution = new Solution(string, wordDict);
        return solution.process();
    }
}
