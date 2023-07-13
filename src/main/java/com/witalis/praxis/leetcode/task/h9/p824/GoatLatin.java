package com.witalis.praxis.leetcode.task.h9.p824;

import com.witalis.praxis.leetcode.task.LeetCodeTask;
import com.witalis.praxis.leetcode.task.h9.p824.option.*;
import com.witalis.praxis.leetcode.utils.LeetCode;
import com.witalis.praxis.leetcode.utils.TaskDifficulty;
import com.witalis.praxis.leetcode.utils.TaskRevision;

import lombok.extern.slf4j.Slf4j;
import java.util.concurrent.ThreadLocalRandom;

import static com.witalis.praxis.leetcode.utils.TaskTag.*;

@Slf4j
@LeetCode(
    id = 824,
    description = "Goat Latin",
    difficulty = TaskDifficulty.EASY,
    tags = {STRING}
)
public class GoatLatin extends LeetCodeTask<String> {
    public static final int LEN = 150;

    private String sentence;

    public static final String INFORMATION = """

        Description:
            You are given a string sentence that consist of words separated by spaces.
                Each word consists of lowercase and uppercase letters only.

            We would like to convert the sentence to "Goat Latin" (a made-up language similar to Pig Latin.)
                The rules of Goat Latin are as follows:
                * If a word begins with a vowel ('a', 'e', 'i', 'o', or 'u'), append "ma" to the end of the word.
                  * For example, the word "apple" becomes "applema".
                * If a word begins with a consonant (i.e., not a vowel), remove the first letter and append it to the end, then add "ma".
                  * For example, the word "goat" becomes "oatgma".
                * Add one letter 'a' to the end of each word per its word index in the sentence, starting with 1.
                  * For example, the first word gets "a" added to the end, the second word gets "aa" added to the end, and so on.

            Return the final sentence representing the conversion from sentence to Goat Latin.

        Example:
            Input: sentence = "The quick brown fox jumped over the lazy dog"
            Output: "heTmaa uickqmaaa rownbmaaaa oxfmaaaaa umpedjmaaaaaa overmaaaaaaa hetmaaaaaaaa azylmaaaaaaaaa ogdmaaaaaaaaaa""";

    public GoatLatin(int id, String description, TaskRevision revision) {
        super(id, description, revision);
        initialization();
    }

    private void initialization() {
        final var random = ThreadLocalRandom.current();

        final int len = random.nextInt(1, LEN + 1);
        final var builder = new StringBuilder();
        boolean space = false;
        while (builder.length() < len) {
            if (!space && random.nextInt(0, 5) == 0) {
                builder.append(' ');
                space = true;
            } else {
                if (random.nextBoolean()) {
                    builder.append((char) random.nextInt('A', 'Z' + 1));
                } else {
                    builder.append((char) random.nextInt('a', 'z' + 1));
                }
                space = false;
            }
        }
        this.sentence = builder.toString().trim();

        log.info("Sentence: '{}'", sentence);
    }

    @Override
    protected String getInformation() {
        return INFORMATION;
    }

    // time = 622 ms
    @Override
    protected String original() {
        var original = new Original(sentence);
        return original.process();
    }

    // time = 792 ms
    @Override
    protected String practice() {
        var practice = new Practice(sentence);
        return practice.process();
    }

    // time = 570 ms
    @Override
    protected String solution() {
        var solution = new Solution(sentence);
        return solution.process();
    }
}
