package com.witalis.praxis.leetcode.task.h6.p500;

import com.witalis.praxis.leetcode.task.LeetCodeTask;
import com.witalis.praxis.leetcode.task.h6.p500.option.*;
import com.witalis.praxis.leetcode.utils.LeetCode;
import com.witalis.praxis.leetcode.utils.TaskDifficulty;
import com.witalis.praxis.leetcode.utils.TaskRevision;

import lombok.extern.slf4j.Slf4j;

import java.util.Arrays;
import java.util.concurrent.ThreadLocalRandom;

import static com.witalis.praxis.leetcode.utils.TaskTag.*;

@Slf4j
@LeetCode(
    id = 500,
    description = "Keyboard Row",
    difficulty = TaskDifficulty.EASY,
    tags = {ARRAY, HASH_TABLE, STRING}
)
public class KeyboardRow extends LeetCodeTask<String[]> {
    public static final int SIZE = 20;
    public static final int LEN = 100;
    private String[] words;

    public static final String INFORMATION = """

        Given an array of strings words, return the words that can be typed
            using letters of the alphabet on only one row of American keyboard like the image below.

        In the American keyboard:
            * the first row consists of the characters "qwertyuiop",
            * the second row consists of the characters "asdfghjkl", and
            * the third row consists of the characters "zxcvbnm".

        Example:
            Input: words = ["Hello","Alaska","Dad","Peace"]
            Output: ["Alaska","Dad"]""";

    public KeyboardRow(int id, String description, TaskRevision revision) {
        super(id, description, revision);
        initialization();
    }

    private void initialization() {
        var random = ThreadLocalRandom.current();
        int size = random.nextInt(1, SIZE + 1);

        var builder = new StringBuilder();

        this.words = new String[size];
        for (int i = 0; i < size; i++) {
            builder.setLength(0);
            int length = random.nextInt(1, LEN + 1);
            for (int j = 0; j < length; j++) {
                if (random.nextBoolean()) {
                    builder.append((char) random.nextInt('a', 'z' + 1));
                } else {
                    builder.append((char) random.nextInt('A', 'Z' + 1));
                }
            }
            words[i] = builder.toString();
        }

        log.info("Words are {}", Arrays.toString(words));
    }

    @Override
    protected String getInformation() {
        return INFORMATION;
    }

    // time = 5381 ms
    @Override
    protected String[] original() {
        var original = new Original(words);
        return original.process();
    }

    // time = 2148 ms
    @Override
    protected String[] practice() {
        var practice = new Practice(words);
        return practice.process();
    }

    // time = 1518 ms
    @Override
    protected String[] solution() {
        var solution = new Solution(words);
        return solution.process();
    }
}
