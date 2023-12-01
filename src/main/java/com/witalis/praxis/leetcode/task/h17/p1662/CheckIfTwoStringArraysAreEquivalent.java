package com.witalis.praxis.leetcode.task.h17.p1662;

import com.witalis.praxis.leetcode.task.LeetCodeTask;
import com.witalis.praxis.leetcode.task.h17.p1662.option.*;
import com.witalis.praxis.leetcode.utils.LeetCode;
import com.witalis.praxis.leetcode.utils.TaskDifficulty;
import com.witalis.praxis.leetcode.utils.TaskRevision;

import lombok.extern.slf4j.Slf4j;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

import static com.witalis.praxis.leetcode.utils.TaskTag.*;

@Slf4j
@LeetCode(
    id = 1662,
    description = "Check If Two String Arrays are Equivalent",
    difficulty = TaskDifficulty.EASY,
    tags = {ARRAY, STRING}
)
public class CheckIfTwoStringArraysAreEquivalent extends LeetCodeTask<Boolean> {
    public static final int LEN = 1_000;

    private String[] word1;
    private String[] word2;

    public static final String INFORMATION = """

        Description:
            Given two string arrays word1 and word2, return true if the two arrays represent the same string, and false otherwise.

            A string is represented by an array if the array elements concatenated in order forms the string.

        Example:
            Input: word1 = ["ab", "c"], word2 = ["a", "bc"]
            Output: true
            Explanation:
                word1 represents string "ab" + "c" -> "abc"
                word2 represents string "a" + "bc" -> "abc"
                The strings are the same, so return true.""";

    public CheckIfTwoStringArraysAreEquivalent(int id, String description, TaskRevision revision) {
        super(id, description, revision);
        initialization();
    }

    private void initialization() {
        final var random = ThreadLocalRandom.current();

        int len = random.nextInt(1, LEN + 1);

        this.word1 = generate(len);
        this.word2 = generate(len);

        log.info("Word #1: {}", Arrays.toString(word1));
        log.info("Word #2: {}", Arrays.toString(word2));
    }

    private static String[] generate(int len) {
        final var random = ThreadLocalRandom.current();

        List<String> words = new ArrayList<>();

        int size = 0;
        while (size < len) {
            int n = random.nextInt(1, len / 10);

            if (size + n > len) n = len - size;
            size += n;

            StringBuilder builder = new StringBuilder();
            while (n-- > 0) builder.append((char) random.nextInt('a', 'z' + 1));
            words.add(builder.toString());
        }

        return words.toArray(String[]::new);
    }

    @Override
    protected String getInformation() {
        return INFORMATION;
    }

    // time = 767 ms
    @Override
    protected Boolean original() {
        var original = new Original(word1, word2);
        return original.process();
    }

    // time = 804 ms
    @Override
    protected Boolean practice() {
        var practice = new Practice(word1, word2);
        return practice.process();
    }

    // time = 654 ms
    @Override
    protected Boolean solution() {
        var solution = new Solution(word1, word2);
        return solution.process();
    }
}
