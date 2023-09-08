package com.witalis.praxis.leetcode.task.h26.p2506;

import com.witalis.praxis.leetcode.task.LeetCodeTask;
import com.witalis.praxis.leetcode.task.h26.p2506.option.*;
import com.witalis.praxis.leetcode.utils.LeetCode;
import com.witalis.praxis.leetcode.utils.TaskDifficulty;
import com.witalis.praxis.leetcode.utils.TaskRevision;

import lombok.extern.slf4j.Slf4j;
import java.util.Arrays;
import java.util.concurrent.ThreadLocalRandom;

import static com.witalis.praxis.leetcode.utils.TaskTag.*;

@Slf4j
@LeetCode(
    id = 2506,
    description = "Count Pairs Of Similar Strings",
    difficulty = TaskDifficulty.EASY,
    tags = {ARRAY, HASH_TABLE, STRING}
)
public class CountPairsOfSimilarStrings extends LeetCodeTask<Integer> {
    public static final int LEN = 100;
    public static final int SIZE = 100;

    private String[] words;

    public static final String INFORMATION = """

        Description:
            You are given a 0-indexed string array words.

            Two strings are similar if they consist of the same characters.
                * For example, "abca" and "cba" are similar since both consist of characters 'a', 'b', and 'c'.
                * However, "abacba" and "bcfd" are not similar since they do not consist of the same characters.

            Return the number of pairs (i, j) such that 0 <= i < j <= word.length - 1
                and the two strings words[i] and words[j] are similar.

        Example:
            Input: words = ["aba","aabb","abcd","bac","aabc"]
            Output: 2
            Explanation: There are 2 pairs that satisfy the conditions:
                - i = 0 and j = 1 : both words[0] and words[1] only consist of characters 'a' and 'b'.
                - i = 3 and j = 4 : both words[3] and words[4] only consist of characters 'a', 'b', and 'c'.""";

    public CountPairsOfSimilarStrings(int id, String description, TaskRevision revision) {
        super(id, description, revision);
        initialization();
    }

    private void initialization() {
        final var random = ThreadLocalRandom.current();

        int size = random.nextInt(1, SIZE + 1);
        this.words = new String[size];
        for (int i = 0; i < size; i++) {
            words[i] = generate();
        }

        log.info("Words: {}", Arrays.toString(words));
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

    // time = 2503 ms
    @Override
    protected Integer original() {
        var original = new Original(words);
        return original.process();
    }

    // time = 1672 ms
    @Override
    protected Integer practice() {
        var practice = new Practice(words);
        return practice.process();
    }

    // time = 602 ms
    @Override
    protected Integer solution() {
        var solution = new Solution(words);
        return solution.process();
    }
}
