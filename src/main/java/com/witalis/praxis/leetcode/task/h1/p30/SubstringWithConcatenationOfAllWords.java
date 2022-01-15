package com.witalis.praxis.leetcode.task.h1.p30;

import com.witalis.praxis.leetcode.task.LeetCodeTask;
import com.witalis.praxis.leetcode.task.h1.p30.option.*;
import com.witalis.praxis.leetcode.utils.LeetCode;
import com.witalis.praxis.leetcode.utils.TaskDifficulty;
import com.witalis.praxis.leetcode.utils.TaskRevision;

import lombok.extern.slf4j.Slf4j;
import java.util.Arrays;
import java.util.List;

import static com.witalis.praxis.leetcode.utils.TaskTag.*;

@Slf4j
@LeetCode(
    id = 30,
    description = "Substring with Concatenation of All Words",
    difficulty = TaskDifficulty.HARD,
    tags = {HASH_TABLE, STRING, SLIDING_WINDOW}
)
public class SubstringWithConcatenationOfAllWords extends LeetCodeTask<List<Integer>> {
    public static final int STRING_LEN = 10_000;
    public static final int WORD_LEN = 30;
    public static final int WORDS = 5_000;

    private String string;
    private String[] words;

    public static final String INFORMATION = """

        You are given a string s and an array of strings words
            of the same length. Return all starting indices of substring(s)
            in s that is a concatenation of each word in words exactly once,
            in any order, and without any intervening characters.

        You can return the answer in any order.

        Examples:
            Input: s = "barfoothefoobarman", words = ["foo","bar"]
            Output: [0,9]
            Explanation: Substrings starting at index 0 and 9
                         are "barfoo" and "foobar" respectively.
                         The output order does not matter, returning [9,0] is fine too.""";

    public SubstringWithConcatenationOfAllWords(int id, String description, TaskRevision revision) {
        super(id, description, revision);
        initialization();
    }

    private void initialization() {
        this.string = "wordgoodbestwordgoodwordgoodbestwordwordluck";
        this.words = new String[] {"word","good","best","word"};

        log.info("String is {}", string);
        log.info("Words are {}", Arrays.toString(words));
    }

    @Override
    protected String getInformation() {
        return INFORMATION;
    }

    // time = 883 ms
    @Override
    protected List<Integer> original() {
        var original = new Original(string, words.clone());
        return original.process();
    }

    // time = 749 ms
    @Override
    protected List<Integer> practice() {
        var practice = new Practice(string, words.clone());
        return practice.process();
    }

    // time = 622 ms
    @Override
    protected List<Integer> solution() {
        var solution = new Solution(string, words.clone());
        return solution.process();
    }
}
