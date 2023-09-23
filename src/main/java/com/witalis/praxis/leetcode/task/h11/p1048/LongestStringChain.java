package com.witalis.praxis.leetcode.task.h11.p1048;

import com.witalis.praxis.leetcode.task.LeetCodeTask;
import com.witalis.praxis.leetcode.task.h11.p1048.option.*;
import com.witalis.praxis.leetcode.utils.LeetCode;
import com.witalis.praxis.leetcode.utils.TaskDifficulty;
import com.witalis.praxis.leetcode.utils.TaskRevision;

import lombok.extern.slf4j.Slf4j;
import java.util.Arrays;
import java.util.concurrent.ThreadLocalRandom;

import static com.witalis.praxis.leetcode.utils.TaskTag.*;

@Slf4j
@LeetCode(
    id = 1048,
    description = "Longest String Chain",
    difficulty = TaskDifficulty.MEDIUM,
    tags = {ARRAY, HASH_TABLE, TWO_POINTERS, STRING, DYNAMIC_PROGRAMMING}
)
public class LongestStringChain extends LeetCodeTask<Integer> {
    public static final int SIZE = 10_000;
    public static final int LEN = 8;

    private String[] words;

    public static final String INFORMATION = """

        Description:
            You are given an array of words where each word consists of lowercase English letters.

            wordA is a predecessor of wordB if and only if we can insert exactly one letter
                anywhere in wordA without changing the order of the other characters to make it equal to wordB.

            * For example, "abc" is a predecessor of "abac", while "cba" is not a predecessor of "bcad".

            A word chain is a sequence of words [word1, word2, ..., wordk] with k >= 1,
                where word1 is a predecessor of word2, word2 is a predecessor of word3, and so on.
                A single word is trivially a word chain with k == 1.

            Return the length of the longest possible word chain with words chosen from the given list of words.

        Example:
            Input: words = ["xbc","pcxbcf","xb","cxbc","pcxbc"]
            Output: 5
            Explanation: All the words can be put in a word chain ["xb", "xbc", "cxbc", "pcxbc", "pcxbcf"].""";

    public LongestStringChain(int id, String description, TaskRevision revision) {
        super(id, description, revision);
        initialization();
    }

    private void initialization() {
        final var random = ThreadLocalRandom.current();

        var size = random.nextInt(1, SIZE + 1);
        this.words = new String[size];
        for (int i = 0; i < size; i++)
            words[i] = generate();

        log.info("Words: {}", Arrays.toString(words));
    }

    private String generate() {
        final var random = ThreadLocalRandom.current();

        var len = random.nextInt(1, LEN + 1);
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < len; i++)
            builder.append((char) random.nextInt('a', 'z' + 1));

        return builder.toString();
    }

    @Override
    protected String getInformation() {
        return INFORMATION;
    }

    // time = 336583 ms
    @Override
    protected Integer original() {
        var original = new Original(words.clone());
        return original.process();
    }

    // time = 314253 ms
    @Override
    protected Integer practice() {
        var practice = new Practice(words.clone());
        return practice.process();
    }

    // time = 18040 ms
    @Override
    protected Integer solution() {
        var solution = new Solution(words.clone());
        return solution.process();
    }
}
