package com.witalis.praxis.leetcode.task.h12.p1160;

import com.witalis.praxis.leetcode.task.LeetCodeTask;
import com.witalis.praxis.leetcode.task.h12.p1160.option.*;
import com.witalis.praxis.leetcode.utils.LeetCode;
import com.witalis.praxis.leetcode.utils.TaskDifficulty;
import com.witalis.praxis.leetcode.utils.TaskRevision;

import lombok.extern.slf4j.Slf4j;
import java.util.Arrays;
import java.util.concurrent.ThreadLocalRandom;

import static com.witalis.praxis.leetcode.utils.TaskTag.*;

@Slf4j
@LeetCode(
    id = 1160,
    description = "Find Words That Can Be Formed by Characters",
    difficulty = TaskDifficulty.EASY,
    tags = {ARRAY, HASH_TABLE, STRING}
)
public class FindWordsThatCanBeFormedByCharacters extends LeetCodeTask<Integer> {
    public static final int LEN = 1_000;
    public static final int SIZE = 100;

    private String[] words;
    private String chars;

    public static final String INFORMATION = """

        Description:
            You are given an array of strings words and a string chars.

            A string is good if it can be formed by characters from chars (each character can only be used once).

            Return the sum of lengths of all good strings in words.

        Example:
            Input: words = ["cat","bt","hat","tree"], chars = "atach"
            Output: 6
            Explanation: The strings that can be formed are "cat" and "hat" so the answer is 3 + 3 = 6.""";

    public FindWordsThatCanBeFormedByCharacters(int id, String description, TaskRevision revision) {
        super(id, description, revision);
        initialization();
    }

    private void initialization() {
        final var random = ThreadLocalRandom.current();

        int len = random.nextInt(1, LEN + 1);
        this.words = new String[len];

        int size;
        StringBuilder builder;
        for (int i = 0; i < len; i++) {
            size = random.nextInt(1, SIZE + 1);
            builder = new StringBuilder();
            for (int j = 0; j < size; j++)
                builder.append((char) random.nextInt('a', 'z' + 1));
            words[i] = builder.toString();
        }
        size = random.nextInt(1, SIZE + 1);
        builder = new StringBuilder();
        for (int j = 0; j < size; j++)
            builder.append((char) random.nextInt('a', 'z' + 1));
        this.chars = builder.toString();

        log.info("Words: {}", Arrays.toString(words));
        log.info("Chars: {}", chars);
    }

    @Override
    protected String getInformation() {
        return INFORMATION;
    }

    // time = 2864 ms
    @Override
    protected Integer original() {
        var original = new Original(words, chars);
        return original.process();
    }

    // time = 1173 ms
    @Override
    protected Integer practice() {
        var practice = new Practice(words, chars);
        return practice.process();
    }

    // time = 1129 ms
    @Override
    protected Integer solution() {
        var solution = new Solution(words, chars);
        return solution.process();
    }
}
