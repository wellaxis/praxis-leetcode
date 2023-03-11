package com.witalis.praxis.leetcode.task.h9.p804;

import com.witalis.praxis.leetcode.task.LeetCodeTask;
import com.witalis.praxis.leetcode.task.h9.p804.option.*;
import com.witalis.praxis.leetcode.utils.LeetCode;
import com.witalis.praxis.leetcode.utils.TaskDifficulty;
import com.witalis.praxis.leetcode.utils.TaskRevision;

import lombok.extern.slf4j.Slf4j;
import java.util.Arrays;
import java.util.concurrent.ThreadLocalRandom;

import static com.witalis.praxis.leetcode.utils.TaskTag.*;

@Slf4j
@LeetCode(
    id = 804,
    description = "Unique Morse Code Words",
    difficulty = TaskDifficulty.EASY,
    tags = {ARRAY, HASH_TABLE, STRING}
)
public class UniqueMorseCodeWords extends LeetCodeTask<Integer> {
    public static final int SIZE = 100;
    public static final int LEN = 12;

    private String[] words;

    public static final String INFORMATION = """

        Description:
            International Morse Code defines a standard encoding where each letter is mapped to a series of dots and dashes, as follows:
                * 'a' maps to ".-",
                * 'b' maps to "-...",
                * 'c' maps to "-.-.", and so on.

            For convenience, the full table for the 26 letters of the English alphabet is given below:
                [".-","-...","-.-.","-..",".","..-.","--.","....","..",".---","-.-",".-..","--",
                "-.","---",".--.","--.-",".-.","...","-","..-","...-",".--","-..-","-.--","--.."]

            Given an array of strings words where each word can be written as a concatenation of the Morse code of each letter.
                * For example, "cab" can be written as "-.-..--...", which is the concatenation of "-.-.", ".-", and "-...".
                We will call such a concatenation the transformation of a word.

            Return the number of different transformations among all words we have.

        Example:
            Input: words = ["gin","zen","gig","msg"]
            Output: 2
            Explanation: The transformation of each word is:
                "gin" -> "--...-."
                "zen" -> "--...-."
                "gig" -> "--...--."
                "msg" -> "--...--."
                There are 2 different transformations: "--...-." and "--...--.".""";

    public UniqueMorseCodeWords(int id, String description, TaskRevision revision) {
        super(id, description, revision);
        initialization();
    }

    private void initialization() {
        final var random = ThreadLocalRandom.current();

        var size = random.nextInt(1, SIZE + 1);
        this.words = new String[size];
        StringBuilder builder;
        for (int i = 0; i < size; i++) {
            builder = new StringBuilder();
            var len = random.nextInt(1, LEN + 1);
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

    // time = 1475 ms
    @Override
    protected Integer original() {
        var original = new Original(words);
        return original.process();
    }

    // time = 528 ms
    @Override
    protected Integer practice() {
        var practice = new Practice(words);
        return practice.process();
    }

    // time = 569 ms
    @Override
    protected Integer solution() {
        var solution = new Solution(words);
        return solution.process();
    }
}
