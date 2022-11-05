package com.witalis.praxis.leetcode.task.h4.p318;

import com.witalis.praxis.leetcode.task.LeetCodeTask;
import com.witalis.praxis.leetcode.task.h4.p318.option.*;
import com.witalis.praxis.leetcode.utils.LeetCode;
import com.witalis.praxis.leetcode.utils.TaskDifficulty;
import com.witalis.praxis.leetcode.utils.TaskRevision;

import lombok.extern.slf4j.Slf4j;
import java.util.Arrays;
import java.util.concurrent.ThreadLocalRandom;

import static com.witalis.praxis.leetcode.utils.TaskTag.*;

@Slf4j
@LeetCode(
    id = 318,
    description = "Maximum Product of Word Lengths",
    difficulty = TaskDifficulty.MEDIUM,
    tags = {ARRAY, STRING, BIT_MANIPULATION}
)
public class MaximumProductOfWordLengths extends LeetCodeTask<Integer> {
    public static final int SIZE = 1_000;
    public static final int LEN = 10;
    private String[] words;

    public static final String INFORMATION = """

        Description:
            Given a string array words, return the maximum value of length(word[i]) * length(word[j])
                where the two words do not share common letters. If no such two words exist, return 0.

        Example:
            Input: words = ["abcw","baz","foo","bar","xtfn","abcdef"]
            Output: 16
            Explanation: The two words can be "abcw", "xtfn".""";

    public MaximumProductOfWordLengths(int id, String description, TaskRevision revision) {
        super(id, description, revision);
        initialization();
    }

    private void initialization() {
        final var random = ThreadLocalRandom.current();

        var size = random.nextInt(2, SIZE + 1);
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

        log.info("Words are {}", Arrays.toString(words));
    }

    @Override
    protected String getInformation() {
        return INFORMATION;
    }

    // time = 275175 ms, time limit exceeded
    @Override
    protected Integer original() {
        var original = new Original(words);
        return original.process();
    }

    // time = 5647 ms
    @Override
    protected Integer practice() {
        var practice = new Practice(words);
        return practice.process();
    }

    // time = 5180 ms
    @Override
    protected Integer solution() {
        var solution = new Solution(words);
        return solution.process();
    }
}
