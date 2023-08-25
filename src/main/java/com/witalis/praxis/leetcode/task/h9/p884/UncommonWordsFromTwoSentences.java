package com.witalis.praxis.leetcode.task.h9.p884;

import com.witalis.praxis.leetcode.task.LeetCodeTask;
import com.witalis.praxis.leetcode.task.h9.p884.option.*;
import com.witalis.praxis.leetcode.utils.LeetCode;
import com.witalis.praxis.leetcode.utils.TaskDifficulty;
import com.witalis.praxis.leetcode.utils.TaskRevision;

import lombok.extern.slf4j.Slf4j;
import java.util.concurrent.ThreadLocalRandom;

import static com.witalis.praxis.leetcode.utils.TaskTag.*;

@Slf4j
@LeetCode(
    id = 884,
    description = "Uncommon Words from Two Sentences",
    difficulty = TaskDifficulty.EASY,
    tags = {HASH_TABLE, STRING}
)
public class UncommonWordsFromTwoSentences extends LeetCodeTask<String[]> {
    public static final int LEN = 200;

    private String string1;
    private String string2;

    public static final String INFORMATION = """

        Description:
            A sentence is a string of single-space separated words where each word consists only of lowercase letters.

            A word is uncommon if it appears exactly once in one of the sentences, and does not appear in the other sentence.

            Given two sentences s1 and s2, return a list of all the uncommon words. You may return the answer in any order.

        Example:
            Input: s1 = "this apple is sweet", s2 = "this apple is sour"
            Output: ["sweet","sour"]""";

    public UncommonWordsFromTwoSentences(int id, String description, TaskRevision revision) {
        super(id, description, revision);
        initialization();
    }

    private void initialization() {
        this.string1 = generate();
        this.string2 = generate();

        log.info("String 's1': {}", string1);
        log.info("String 's2': {}", string2);
    }

    private static String generate() {
        final var random = ThreadLocalRandom.current();

        int len = random.nextInt(1, LEN + 1);
        var builder = new StringBuilder();
        for (int i = 0; i < len; i++) {
            if (random.nextInt(0, 7) == 0) {
                builder.append(' ');
            } else {
                builder.append((char) random.nextInt('a', 'z' + 1));
            }
        }
        return builder.toString().trim();
    }

    @Override
    protected String getInformation() {
        return INFORMATION;
    }

    // time = 1248 ms
    @Override
    protected String[] original() {
        var original = new Original(string1, string2);
        return original.process();
    }

    // time = 1113 ms
    @Override
    protected String[] practice() {
        var practice = new Practice(string1, string2);
        return practice.process();
    }

    // time = 552 ms
    @Override
    protected String[] solution() {
        var solution = new Solution(string1, string2);
        return solution.process();
    }
}
