package com.witalis.praxis.leetcode.task.h2.p140;

import com.witalis.praxis.leetcode.task.LeetCodeTask;
import com.witalis.praxis.leetcode.task.h2.p140.option.*;
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
    id = 140,
    description = "Word Break II",
    difficulty = TaskDifficulty.HARD,
    tags = {ARRAY, HASH_TABLE, STRING, DYNAMIC_PROGRAMMING, BACKTRACKING, TRIE, MEMOIZATION}
)
public class WordBreakII extends LeetCodeTask<List<String>> {
    public static final int LEN = 20;
    public static final int DICT_LEN = 10;
    public static final int DICT_SIZE = 1_000;

    private String string;
    private List<String> wordDict;

    public static final String INFORMATION = """

        Description:
            Given a string s and a dictionary of strings wordDict, add spaces in s to construct a sentence
                where each word is a valid dictionary word. Return all such possible sentences in any order.

            Note that the same word in the dictionary may be reused multiple times in the segmentation.

        Example:
            Input: s = "pineapplepenapple", wordDict = ["apple","pen","applepen","pine","pineapple"]
            Output: ["pine apple pen apple","pineapple pen apple","pine applepen apple"]
            Explanation: Note that you are allowed to reuse a dictionary word.""";

    public WordBreakII(int id, String description, TaskRevision revision) {
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

        log.info("String 's': {}", string);
        log.info("Dictionary: {}", wordDict);
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

    // time = 2990 ms
    @Override
    protected List<String> original() {
        var original = new Original(string, wordDict);
        return original.process();
    }

    // time = 2837 ms
    @Override
    protected List<String> practice() {
        var practice = new Practice(string, wordDict);
        return practice.process();
    }

    // time = 1631 ms
    @Override
    protected List<String> solution() {
        var solution = new Solution(string, wordDict);
        return solution.process();
    }
}
