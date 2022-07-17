package com.witalis.praxis.leetcode.task.h2.p151;

import com.witalis.praxis.leetcode.task.LeetCodeTask;
import com.witalis.praxis.leetcode.task.h2.p151.option.*;
import com.witalis.praxis.leetcode.utils.LeetCode;
import com.witalis.praxis.leetcode.utils.TaskDifficulty;
import com.witalis.praxis.leetcode.utils.TaskRevision;

import lombok.extern.slf4j.Slf4j;
import java.util.concurrent.ThreadLocalRandom;

import static com.witalis.praxis.leetcode.utils.TaskTag.*;

@Slf4j
@LeetCode(
    id = 151,
    description = "Reverse Words in a String",
    difficulty = TaskDifficulty.MEDIUM,
    tags = {TWO_POINTERS, STRING}
)
public class ReverseWordsInString extends LeetCodeTask<String> {
    public static final int LEN = 10_000;
    private String string;

    public static final String INFORMATION = """

        Given an input string s, reverse the order of the words.

        A word is defined as a sequence of non-space characters.
            The words in s will be separated by at least one space.

        Return a string of the words in reverse order concatenated by a single space.

        Note that s may contain leading or trailing spaces or multiple spaces between two words.
            The returned string should only have a single space separating the words.
            Do not include any extra spaces.

        Example:
            Input: s = "a good   example"
            Output: "example good a"
            Explanation: You need to reduce multiple spaces between two words to a single space in the reversed string.""";

    public ReverseWordsInString(int id, String description, TaskRevision revision) {
        super(id, description, revision);
        initialization();
    }

    private void initialization() {
        this.string = generate();

        log.info("String is '{}'", string);
    }

    private static String generate() {
        final var random = ThreadLocalRandom.current();

        var length = random.nextInt(1, LEN + 1);
        StringBuilder builder = new StringBuilder();
        while (builder.length() < length) {
            int len = random.nextInt(1, 10);
            if (random.nextBoolean()) {
                builder.append(" ".repeat(len));
            } else {
                for (int i = 0; i < len; i++) {
                    int let = random.nextInt(0, 3);
                    char letter = switch (let) {
                        case 0 -> (char) random.nextInt('a', 'z' + 1);
                        case 1 -> (char) random.nextInt('A', 'Z' + 1);
                        case 2 -> (char) random.nextInt('0', '9' + 1);
                        default -> throw new IllegalStateException("Unexpected value: " + let);
                    };
                    builder.append(letter);
                }
            }
        }

        return builder.toString();
    }

    @Override
    protected String getInformation() {
        return INFORMATION;
    }

    // time = 2704 ms
    @Override
    protected String original() {
        var original = new Original(string);
        return original.process();
    }

    // time = 1980 ms
    @Override
    protected String practice() {
        var practice = new Practice(string);
        return practice.process();
    }

    // time = 1634 ms
    @Override
    protected String solution() {
        var solution = new Solution(string);
        return solution.process();
    }
}
