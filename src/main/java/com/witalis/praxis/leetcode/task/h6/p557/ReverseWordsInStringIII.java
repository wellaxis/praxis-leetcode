package com.witalis.praxis.leetcode.task.h6.p557;

import com.witalis.praxis.leetcode.task.LeetCodeTask;
import com.witalis.praxis.leetcode.task.h6.p557.option.*;
import com.witalis.praxis.leetcode.utils.LeetCode;
import com.witalis.praxis.leetcode.utils.TaskDifficulty;
import com.witalis.praxis.leetcode.utils.TaskRevision;

import lombok.extern.slf4j.Slf4j;
import java.util.concurrent.ThreadLocalRandom;

import static com.witalis.praxis.leetcode.utils.TaskTag.*;

@Slf4j
@LeetCode(
    id = 557,
    description = "Reverse Words in a String III",
    difficulty = TaskDifficulty.EASY,
    tags = {TWO_POINTERS, STRING}
)
public class ReverseWordsInStringIII extends LeetCodeTask<String> {
    public static final int LEN = 50_000;
    private String string;

    public static final String INFORMATION = """

        Given a string s, reverse the order of characters in each word within a sentence
            while still preserving whitespace and initial word order.

        Example:
            Input: s = "Let's take LeetCode contest"
            Output: "s'teL ekat edoCteeL tsetnoc" """;

    public ReverseWordsInStringIII(int id, String description, TaskRevision revision) {
        super(id, description, revision);
        initialization();
    }

    private void initialization() {
        final var random = ThreadLocalRandom.current();

        var size = random.nextInt(1, LEN + 1);
        StringBuilder builder = new StringBuilder();

        while (builder.length() < size) {
            var len = random.nextInt(1, 21);
            for (int i = 0; i < len; i++) {
                if (random.nextBoolean()) {
                    builder.append((char) random.nextInt('A', 'Z' + 1));
                } else {
                    builder.append((char) random.nextInt('a', 'z' + 1));
                }
            }
            builder.append(" ");
        }
        this.string = builder.toString();

        log.info("String is '{}'", string);
    }

    @Override
    protected String getInformation() {
        return INFORMATION;
    }

    // time = 3569 ms
    @Override
    protected String original() {
        var original = new Original(string);
        return original.process();
    }

    // time = 2684 ms
    @Override
    protected String practice() {
        var practice = new Practice(string);
        return practice.process();
    }

    // time = 1104 ms
    @Override
    protected String solution() {
        var solution = new Solution(string);
        return solution.process();
    }
}
