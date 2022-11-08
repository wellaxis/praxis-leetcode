package com.witalis.praxis.leetcode.task.h16.p1544;

import com.witalis.praxis.leetcode.task.LeetCodeTask;
import com.witalis.praxis.leetcode.task.h16.p1544.option.*;
import com.witalis.praxis.leetcode.utils.LeetCode;
import com.witalis.praxis.leetcode.utils.TaskDifficulty;
import com.witalis.praxis.leetcode.utils.TaskRevision;

import lombok.extern.slf4j.Slf4j;
import java.util.concurrent.ThreadLocalRandom;

import static com.witalis.praxis.leetcode.utils.TaskTag.*;

@Slf4j
@LeetCode(
    id = 1544,
    description = "Make The String Great",
    difficulty = TaskDifficulty.EASY,
    tags = {STRING, STACK}
)
public class MakeTheStringGreat extends LeetCodeTask<String> {
    public static final int LEN = 100;
    private String string;

    public static final String INFORMATION = """

        Description:
            Given a string s of lower and upper case English letters.

            A good string is a string which doesn't have two adjacent characters s[i] and s[i + 1] where:
                * 0 <= i <= s.length - 2
                * s[i] is a lower-case letter and s[i + 1] is the same letter but in upper-case or vice-versa.

            To make the string good, you can choose two adjacent characters that make the string bad and remove them.
                You can keep doing this until the string becomes good.

            Return the string after making it good. The answer is guaranteed to be unique under the given constraints.

            Notice that an empty string is also good.

        Example:
            Input: s = "abBAcC"
            Output: ""
            Explanation: We have many possible scenarios, and all lead to the same answer. For example:
                "abBAcC" --> "aAcC" --> "cC" --> ""
                "abBAcC" --> "abBA" --> "aA" --> "" """;

    public MakeTheStringGreat(int id, String description, TaskRevision revision) {
        super(id, description, revision);
        initialization();
    }

    private void initialization() {
        final var random = ThreadLocalRandom.current();

        var len = random.nextInt(1, LEN + 1);
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < len; i++) {
            if (random.nextBoolean()) {
                builder.append((char) random.nextInt('a', 'z' + 1));
            } else {
                builder.append((char) random.nextInt('A', 'Z' + 1));
            }
        }
        this.string = builder.toString();

        log.info("String 's' is {}", string);
    }

    @Override
    protected String getInformation() {
        return INFORMATION;
    }

    // time = 987 ms
    @Override
    protected String original() {
        var original = new Original(string);
        return original.process();
    }

    // time = 813 ms
    @Override
    protected String practice() {
        var practice = new Practice(string);
        return practice.process();
    }

    // time = 788 ms
    @Override
    protected String solution() {
        var solution = new Solution(string);
        return solution.process();
    }
}
