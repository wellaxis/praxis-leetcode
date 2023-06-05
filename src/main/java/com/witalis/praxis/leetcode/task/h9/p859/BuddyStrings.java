package com.witalis.praxis.leetcode.task.h9.p859;

import com.witalis.praxis.leetcode.task.LeetCodeTask;
import com.witalis.praxis.leetcode.task.h9.p859.option.*;
import com.witalis.praxis.leetcode.utils.LeetCode;
import com.witalis.praxis.leetcode.utils.TaskDifficulty;
import com.witalis.praxis.leetcode.utils.TaskRevision;

import lombok.extern.slf4j.Slf4j;
import java.util.concurrent.ThreadLocalRandom;

import static com.witalis.praxis.leetcode.utils.TaskTag.*;

@Slf4j
@LeetCode(
    id = 859,
    description = "Buddy Strings",
    difficulty = TaskDifficulty.EASY,
    tags = {HASH_TABLE, STRING}
)
public class BuddyStrings extends LeetCodeTask<Boolean> {
    public static final int LEN = 20_000;

    private String source;
    private String target;

    public static final String INFORMATION = """

        Description:
            Given two strings s and goal, return true if you can swap two letters in s so the result is equal to goal, otherwise, return false.

            Swapping letters is defined as taking two indices i and j (0-indexed) such that i != j and swapping the characters at s[i] and s[j].

            * For example, swapping at indices 0 and 2 in "abcd" results in "cbad".

        Example:
            Input: s = "ab", goal = "ba"
            Output: true
            Explanation: You can swap s[0] = 'a' and s[1] = 'b' to get "ba", which is equal to goal.""";

    public BuddyStrings(int id, String description, TaskRevision revision) {
        super(id, description, revision);
        initialization();
    }

    private void initialization() {
        this.source = generate();
        this.target = generate(source);

        log.info("String 's': {}", source);
        log.info("String 't': {}", target);
    }

    private static String generate() {
        return generate(null);
    }

    private static String generate(String template) {
        final var random = ThreadLocalRandom.current();

        if (template == null) {
            int len = random.nextInt(1, LEN + 1);
            var builder = new StringBuilder();
            for (int i = 0; i < len; i++) {
                builder.append((char) random.nextInt('a', 'z' + 1));
            }
            return builder.toString();
        } else {
            if (random.nextBoolean()) {
                char[] letters = template.toCharArray();
                int i = random.nextInt(0, letters.length);
                int j = random.nextInt(0, letters.length);
                char letter = letters[i];
                letters[i] = letters[j];
                letters[j] = letter;
                return new String(letters);
            } else {
                int len = random.nextInt(1, template.length() + 1);
                var builder = new StringBuilder();
                for (int i = 0; i < len; i++) {
                    builder.append((char) random.nextInt('a', 'z' + 1));
                }
                return builder.toString();
            }
        }
    }

    @Override
    protected String getInformation() {
        return INFORMATION;
    }

    // time = 2566 ms
    @Override
    protected Boolean original() {
        var original = new Original(source, target);
        return original.process();
    }

    // time = 1017 ms
    @Override
    protected Boolean practice() {
        var practice = new Practice(source, target);
        return practice.process();
    }

    // time = 1499 ms
    @Override
    protected Boolean solution() {
        var solution = new Solution(source, target);
        return solution.process();
    }
}
