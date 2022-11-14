package com.witalis.praxis.leetcode.task.h8.p709;

import com.witalis.praxis.leetcode.task.LeetCodeTask;
import com.witalis.praxis.leetcode.task.h8.p709.option.*;
import com.witalis.praxis.leetcode.utils.LeetCode;
import com.witalis.praxis.leetcode.utils.TaskDifficulty;
import com.witalis.praxis.leetcode.utils.TaskRevision;

import lombok.extern.slf4j.Slf4j;
import java.util.concurrent.ThreadLocalRandom;

import static com.witalis.praxis.leetcode.utils.TaskTag.*;

@Slf4j
@LeetCode(
    id = 709,
    description = "To Lower Case",
    difficulty = TaskDifficulty.EASY,
    tags = {STRING}
)
public class ToLowerCase extends LeetCodeTask<String> {
    public static final int LEN = 100;
    private String string;

    public static final String INFORMATION = """

        Description:
            Given a string s, return the string after replacing every uppercase letter with the same lowercase letter.

        Example:
            Input: s = "Hello"
            Output: "hello" """;

    public ToLowerCase(int id, String description, TaskRevision revision) {
        super(id, description, revision);
        initialization();
    }

    private void initialization() {
        final var random = ThreadLocalRandom.current();

        var len = random.nextInt(1, LEN + 1);
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

    // time = 2184 ms
    @Override
    protected String original() {
        var original = new Original(string);
        return original.process();
    }

    // time = 590 ms
    @Override
    protected String practice() {
        var practice = new Practice(string);
        return practice.process();
    }

    // time = 818 ms
    @Override
    protected String solution() {
        var solution = new Solution(string);
        return solution.process();
    }
}
