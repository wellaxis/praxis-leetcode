package com.witalis.praxis.leetcode.task.h9.p819;

import com.witalis.praxis.leetcode.task.LeetCodeTask;
import com.witalis.praxis.leetcode.task.h9.p819.option.*;
import com.witalis.praxis.leetcode.utils.LeetCode;
import com.witalis.praxis.leetcode.utils.TaskDifficulty;
import com.witalis.praxis.leetcode.utils.TaskRevision;

import lombok.extern.slf4j.Slf4j;

import java.util.*;
import java.util.concurrent.ThreadLocalRandom;

import static com.witalis.praxis.leetcode.utils.TaskTag.*;

@Slf4j
@LeetCode(
    id = 819,
    description = "Most Common Word",
    difficulty = TaskDifficulty.EASY,
    tags = {HASH_TABLE, STRING, COUNTING}
)
public class MostCommonWord extends LeetCodeTask<String> {
    public static final int LEN = 1_000;
    public static final int SIZE = 10;

    private String paragraph;
    private String[] banned;

    public static final String INFORMATION = """

        Description:
            Given a string paragraph and a string array of the banned words banned,
                return the most frequent word that is not banned.
                It is guaranteed there is at least one word that is not banned, and that the answer is unique.

            The words in paragraph are case-insensitive and the answer should be returned in lowercase.

        Example:
            Input: paragraph = "Bob hit a ball, the hit BALL flew far after it was hit.", banned = ["hit"]
            Output: "ball"
            Explanation:
                "hit" occurs 3 times, but it is a banned word.
                "ball" occurs twice (and no other word does), so it is the most frequent non-banned word in the paragraph.
                Note that words in the paragraph are not case sensitive,
                that punctuation is ignored (even if adjacent to words, such as "ball,"),
                and that "hit" isn't the answer even though it occurs more because it is banned.""";

    public MostCommonWord(int id, String description, TaskRevision revision) {
        super(id, description, revision);
        initialization();
    }

    private void initialization() {
        final var random = ThreadLocalRandom.current();

        String specialLetters = "!?',;.";
        List<String> words = new ArrayList<>();
        List<String> bannedWords = new ArrayList<>();

        var len = random.nextInt(1, LEN + 1);
        for (int i = 0; i < len; i++) {
            String word = generate();
            for (int j = 0; j <= i; j++) {
                words.add(transform(word));
            }
            if (random.nextInt(0, 6) == 0) {
                bannedWords.add(word.toLowerCase());
            }
        }
        Collections.shuffle(words);

        StringBuilder builder = new StringBuilder();
        for (String word : words) {
            builder.append(' ');
            builder.append(word);
            if (random.nextInt(0, 4) == 0) {
                builder.append(specialLetters.charAt(random.nextInt(0, specialLetters.length())));
            }
        }

        this.paragraph = builder.toString();
        this.banned = bannedWords.toArray(String[]::new);

        log.info("Paragraph: {}", paragraph);
        log.info("Banned: {}", Arrays.toString(banned));
    }

    private static String generate() {
        final var random = ThreadLocalRandom.current();

        var size = random.nextInt(1, SIZE + 1);
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < size; i++) {
            if (random.nextBoolean()) {
                builder.append((char) random.nextInt('A', 'Z' + 1));
            } else {
                builder.append((char) random.nextInt('a', 'z' + 1));
            }
        }

        return builder.toString();
    }

    private static String transform(String word) {
        final var random = ThreadLocalRandom.current();

        StringBuilder builder = new StringBuilder();
        for (char letter : word.toCharArray()) {
            if (random.nextBoolean()) {
                builder.append(Character.toUpperCase(letter));
            } else {
                builder.append(Character.toLowerCase(letter));
            }
        }

        return builder.toString();
    }

    @Override
    protected String getInformation() {
        return INFORMATION;
    }

    // time = 5528 ms
    @Override
    protected String original() {
        var original = new Original(paragraph, banned);
        return original.process();
    }

    // time = 4134 ms
    @Override
    protected String practice() {
        var practice = new Practice(paragraph, banned);
        return practice.process();
    }

    // time = 3634 ms
    @Override
    protected String solution() {
        var solution = new Solution(paragraph, banned);
        return solution.process();
    }
}
