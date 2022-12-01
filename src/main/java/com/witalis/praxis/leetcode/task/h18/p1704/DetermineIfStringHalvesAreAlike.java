package com.witalis.praxis.leetcode.task.h18.p1704;

import com.witalis.praxis.leetcode.task.LeetCodeTask;
import com.witalis.praxis.leetcode.task.h18.p1704.option.*;
import com.witalis.praxis.leetcode.utils.LeetCode;
import com.witalis.praxis.leetcode.utils.TaskDifficulty;
import com.witalis.praxis.leetcode.utils.TaskRevision;

import lombok.extern.slf4j.Slf4j;
import java.util.concurrent.ThreadLocalRandom;

import static com.witalis.praxis.leetcode.utils.TaskTag.*;

@Slf4j
@LeetCode(
    id = 1704,
    description = "Determine if String Halves Are Alike",
    difficulty = TaskDifficulty.EASY,
    tags = {STRING, COUNTING}
)
public class DetermineIfStringHalvesAreAlike extends LeetCodeTask<Boolean> {
    public static final int LEN = 1_000;
    private String string;

    public static final String INFORMATION = """

        Description:
            You are given a string s of even length. Split this string into two halves of equal lengths,
                and let a be the first half and b be the second half.

            Two strings are alike if they have the same number of vowels
                ('a', 'e', 'i', 'o', 'u', 'A', 'E', 'I', 'O', 'U').
                Notice that s contains uppercase and lowercase letters.

            Return true if a and b are alike. Otherwise, return false.

        Example:
            Input: s = "book"
            Output: true
            Explanation: a = "bo" and b = "ok". a has 1 vowel and b has 1 vowel. Therefore, they are alike.""";

    public DetermineIfStringHalvesAreAlike(int id, String description, TaskRevision revision) {
        super(id, description, revision);
        initialization();
    }

    private void initialization() {
        final var random = ThreadLocalRandom.current();

        var len = 2 * random.nextInt(1, LEN / 2 + 1);
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < len; i++) {
            if (random.nextBoolean()) {
                builder.append((char) random.nextInt('A', 'Z' + 1));
            } else {
                builder.append((char) random.nextInt('a', 'z' + 1));
            }
        }
        this.string = builder.toString();

        log.info("String 's' is {}", string);
    }

    @Override
    protected String getInformation() {
        return INFORMATION;
    }

    // time = 1186 ms
    @Override
    protected Boolean original() {
        var original = new Original(string);
        return original.process();
    }

    // time = 520 ms
    @Override
    protected Boolean practice() {
        var practice = new Practice(string);
        return practice.process();
    }

    // time = 540 ms
    @Override
    protected Boolean solution() {
        var solution = new Solution(string);
        return solution.process();
    }
}
