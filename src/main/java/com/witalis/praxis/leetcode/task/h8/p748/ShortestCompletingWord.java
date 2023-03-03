package com.witalis.praxis.leetcode.task.h8.p748;

import com.witalis.praxis.leetcode.task.LeetCodeTask;
import com.witalis.praxis.leetcode.task.h8.p748.option.*;
import com.witalis.praxis.leetcode.utils.LeetCode;
import com.witalis.praxis.leetcode.utils.TaskDifficulty;
import com.witalis.praxis.leetcode.utils.TaskRevision;

import lombok.extern.slf4j.Slf4j;
import java.util.Arrays;
import java.util.concurrent.ThreadLocalRandom;

import static com.witalis.praxis.leetcode.utils.TaskTag.*;

@Slf4j
@LeetCode(
    id = 748,
    description = "Shortest Completing Word",
    difficulty = TaskDifficulty.EASY,
    tags = {ARRAY, HASH_TABLE, STRING}
)
public class ShortestCompletingWord extends LeetCodeTask<String> {
    public static final int LEN_1 = 7;
    public static final int LEN_2 = 15;
    public static final int SIZE = 1_000;

    private String licensePlate;
    private String[] words;

    public static final String INFORMATION = """

        Description:
            Given a string licensePlate and an array of strings words, find the shortest completing word in words.

            A completing word is a word that contains all the letters in licensePlate.
                Ignore numbers and spaces in licensePlate, and treat letters as case insensitive.
                If a letter appears more than once in licensePlate, then it must appear in the word the same number of times or more.

            For example, if licensePlate = "aBc 12c", then it contains letters 'a', 'b' (ignoring case), and 'c' twice.
                Possible completing words are "abccdef", "caaacab", and "cbca".

            Return the shortest completing word in words. It is guaranteed an answer exists.
                If there are multiple shortest completing words, return the first one that occurs in words.

        Example:
            Input: licensePlate = "1s3 PSt", words = ["step","steps","stripe","stepple"]
            Output: "steps"
            Explanation: licensePlate contains letters 's', 'p', 's' (ignoring case), and 't'.
                "step" contains 't' and 'p', but only contains 1 's'.
                "steps" contains 't', 'p', and both 's' characters.
                "stripe" is missing an 's'.
                "stepple" is missing an 's'.
                Since "steps" is the only word containing all the letters, that is the answer.""";

    public ShortestCompletingWord(int id, String description, TaskRevision revision) {
        super(id, description, revision);
        initialization();
    }

    private void initialization() {
        final var random = ThreadLocalRandom.current();

        int len = random.nextInt(1, LEN_1 + 1);
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < len; i++) {
            int mode = random.nextInt(1, 5);
            char symbol = switch (mode) {
                case 1 -> ' ';
                case 2 -> (char) random.nextInt('0', '9' + 1);
                case 3 -> (char) random.nextInt('A', 'Z' + 1);
                case 4 -> (char) random.nextInt('a', 'z' + 1);
                default -> throw new IllegalStateException("Unexpected value: " + mode);
            };
            builder.append(symbol);
        }
        this.licensePlate = builder.toString();

        int size = random.nextInt(1, SIZE + 1);
        this.words = new String[size];
        for (int w = 0; w < size; w++) {
            builder = new StringBuilder();
            len = random.nextInt(1, LEN_2 + 1);
            for (int i = 0; i < len; i++) {
                builder.append((char) random.nextInt('a', 'z' + 1));
            }
            words[w] = builder.toString();
        }

        log.info("License Plate: {}", licensePlate);
        log.info("Words: {}", Arrays.toString(words));
    }

    @Override
    protected String getInformation() {
        return INFORMATION;
    }

    // time = 798 ms
    @Override
    protected String original() {
        var original = new Original(licensePlate, words);
        return original.process();
    }

    // time = 739 ms
    @Override
    protected String practice() {
        var practice = new Practice(licensePlate, words);
        return practice.process();
    }

    // time = 606 ms
    @Override
    protected String solution() {
        var solution = new Solution(licensePlate, words);
        return solution.process();
    }
}
