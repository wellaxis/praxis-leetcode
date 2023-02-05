package com.witalis.praxis.leetcode.task.h5.p438;

import com.witalis.praxis.leetcode.task.LeetCodeTask;
import com.witalis.praxis.leetcode.task.h5.p438.option.*;
import com.witalis.praxis.leetcode.utils.LeetCode;
import com.witalis.praxis.leetcode.utils.TaskDifficulty;
import com.witalis.praxis.leetcode.utils.TaskRevision;

import lombok.extern.slf4j.Slf4j;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

import static com.witalis.praxis.leetcode.utils.TaskTag.*;

@Slf4j
@LeetCode(
    id = 438,
    description = "Find All Anagrams in a String",
    difficulty = TaskDifficulty.MEDIUM,
    tags = {HASH_TABLE, STRING, SLIDING_WINDOW}
)
public class FindAllAnagramsInString extends LeetCodeTask<List<Integer>> {
    public static final int LEN = 30_000;

    private String source;
    private String pattern;

    public static final String INFORMATION = """

        Description:
            Given two strings s and p, return an array of all the start indices of p's anagrams in s.
                You may return the answer in any order.

            An Anagram is a word or phrase formed by rearranging the letters of a different word or phrase,
                typically using all the original letters exactly once.

        Example:
            Input: s = "cbaebabacd", p = "abc"
            Output: [0,6]
            Explanation:
                The substring with start index = 0 is "cba", which is an anagram of "abc".
                The substring with start index = 6 is "bac", which is an anagram of "abc".""";

    public FindAllAnagramsInString(int id, String description, TaskRevision revision) {
        super(id, description, revision);
        initialization();
    }

    private void initialization() {
        this.source = generate();
        this.pattern = generate();

        log.info("String #1: '{}'", source);
        log.info("String #2: '{}'", pattern);
    }

    private String generate() {
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

    // time = 823211 ms
    @Override
    protected List<Integer> original() {
        var original = new Original(source, pattern);
        return original.process();
    }

    // time = 9583 ms
    @Override
    protected List<Integer> practice() {
        var practice = new Practice(source, pattern);
        return practice.process();
    }

    // time = 5008 ms
    @Override
    protected List<Integer> solution() {
        var solution = new Solution(source, pattern);
        return solution.process();
    }
}
