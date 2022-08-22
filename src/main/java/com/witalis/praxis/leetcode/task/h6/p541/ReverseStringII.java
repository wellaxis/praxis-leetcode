package com.witalis.praxis.leetcode.task.h6.p541;

import com.witalis.praxis.leetcode.task.LeetCodeTask;
import com.witalis.praxis.leetcode.task.h6.p541.option.*;
import com.witalis.praxis.leetcode.utils.LeetCode;
import com.witalis.praxis.leetcode.utils.TaskDifficulty;
import com.witalis.praxis.leetcode.utils.TaskRevision;

import lombok.extern.slf4j.Slf4j;
import java.util.concurrent.ThreadLocalRandom;

import static com.witalis.praxis.leetcode.utils.TaskTag.*;

@Slf4j
@LeetCode(
    id = 541,
    description = "Reverse String II",
    difficulty = TaskDifficulty.EASY,
    tags = {TWO_POINTERS, STRING}
)
public class ReverseStringII extends LeetCodeTask<String> {
    public static final int LEN = 10_000;
    private String string;
    private int index;

    public static final String INFORMATION = """

        Given a string s and an integer k, reverse the first k characters
            for every 2k characters counting from the start of the string.

        If there are fewer than k characters left, reverse all of them.
            If there are less than 2k but greater than or equal to k characters,
            then reverse the first k characters and leave the other as original.

        Example:
            Input: s = "abcdefg", k = 2
            Output: "bacdfeg" """;

    public ReverseStringII(int id, String description, TaskRevision revision) {
        super(id, description, revision);
        initialization();
    }

    private void initialization() {
        final var random = ThreadLocalRandom.current();

        var len = random.nextInt(1, LEN + 1);
        StringBuilder builder = new StringBuilder();

        for (int i = 0; i < len; i++) {
            builder.append((char) random.nextInt('a', 'z' + 1));
        }
        this.string = builder.toString();
        this.index = random.nextInt(1, LEN + 1);

        log.info("String is '{}'", string);
        log.info("Index k is {}", index);
    }

    @Override
    protected String getInformation() {
        return INFORMATION;
    }

    // time = 2283 ms
    @Override
    protected String original() {
        var original = new Original(string, index);
        return original.process();
    }

    // time = 548 ms
    @Override
    protected String practice() {
        var practice = new Practice(string, index);
        return practice.process();
    }

    // time = 609 ms
    @Override
    protected String solution() {
        var solution = new Solution(string, index);
        return solution.process();
    }
}
