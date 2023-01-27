package com.witalis.praxis.leetcode.task.h5.p472;

import com.witalis.praxis.leetcode.task.LeetCodeTask;
import com.witalis.praxis.leetcode.task.h5.p472.option.*;
import com.witalis.praxis.leetcode.utils.LeetCode;
import com.witalis.praxis.leetcode.utils.TaskDifficulty;
import com.witalis.praxis.leetcode.utils.TaskRevision;

import lombok.extern.slf4j.Slf4j;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

import static com.witalis.praxis.leetcode.utils.TaskTag.*;

@Slf4j
@LeetCode(
    id = 472,
    description = "Concatenated Words",
    difficulty = TaskDifficulty.HARD,
    tags = {ARRAY, STRING, DYNAMIC_PROGRAMMING, DEPTH_FIRST_SEARCH, TRIE}
)
public class ConcatenatedWords extends LeetCodeTask<List<String>> {
    public static final int SIZE = 10_000;
    public static final int LEN = 30;
    private String[] words;

    public static final String INFORMATION = """

        Description:
            Given an array of strings words (without duplicates),
                return all the concatenated words in the given list of words.

            A concatenated word is defined as a string that is comprised entirely
                of at least two shorter words in the given array.

        Example:
            Input: words = ["cat","cats","catsdogcats","dog","dogcatsdog","hippopotamuses","rat","ratcatdogcat"]
            Output: ["catsdogcats","dogcatsdog","ratcatdogcat"]
            Explanation:
                "catsdogcats" can be concatenated by "cats", "dog" and "cats";
                "dogcatsdog" can be concatenated by "dog", "cats" and "dog";
                "ratcatdogcat" can be concatenated by "rat", "cat", "dog" and "cat".""";

    public ConcatenatedWords(int id, String description, TaskRevision revision) {
        super(id, description, revision);
        initialization();
    }

    private void initialization() {
        final var random = ThreadLocalRandom.current();

        int size = random.nextInt(1, SIZE + 1);
        this.words = new String[size];

        StringBuilder builder;
        for (int i = 0; i < size; i++) {
            builder = new StringBuilder();
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

    // time = 36327 ms
    @Override
    protected List<String> original() {
        var original = new Original(words.clone());
        return original.process();
    }

    // time = 7923 ms
    @Override
    protected List<String> practice() {
        var practice = new Practice(words.clone());
        return practice.process();
    }

    // time = 26558 ms
    @Override
    protected List<String> solution() {
        var solution = new Solution(words.clone());
        return solution.process();
    }
}
