package com.witalis.praxis.leetcode.task.h8.p796;

import com.witalis.praxis.leetcode.task.LeetCodeTask;
import com.witalis.praxis.leetcode.task.h8.p796.option.*;
import com.witalis.praxis.leetcode.utils.LeetCode;
import com.witalis.praxis.leetcode.utils.TaskDifficulty;
import com.witalis.praxis.leetcode.utils.TaskRevision;

import lombok.extern.slf4j.Slf4j;
import java.util.concurrent.ThreadLocalRandom;

import static com.witalis.praxis.leetcode.utils.TaskTag.*;

@Slf4j
@LeetCode(
    id = 796,
    description = "Rotate String",
    difficulty = TaskDifficulty.EASY,
    tags = {STRING, STRING_MATCHING}
)
public class RotateString extends LeetCodeTask<Boolean> {
    public static final int LEN = 100;

    private String source;
    private String target;

    public static final String INFORMATION = """

        Description:
            Given two strings s and goal,
                return true if and only if s can become goal after some number of shifts on s.

            A shift on s consists of moving the leftmost character of s to the rightmost position.
                * For example, if s = "abcde", then it will be "bcdea" after one shift.

        Example:
            Input: s = "abcde", goal = "cdeab"
            Output: true""";

    public RotateString(int id, String description, TaskRevision revision) {
        super(id, description, revision);
        initialization();
    }

    private void initialization() {
        final var random = ThreadLocalRandom.current();

        int len = random.nextInt(1, LEN + 1);
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < len; i++) {
            builder.append((char) random.nextInt('a', 'z' + 1));
        }
        this.source = builder.toString();

        if (random.nextBoolean()) {
            int index = random.nextInt(1, len);
            builder = new StringBuilder();
            for (int i = index; index < len; index++) {
                builder.append(source.charAt(i));
            }
            for (int i = 0; i < index; i++) {
                builder.append(source.charAt(i));
            }
            this.target = builder.toString();
        } else {
            len = random.nextInt(1, LEN + 1);
            builder = new StringBuilder();
            for (int i = 0; i < len; i++) {
                builder.append((char) random.nextInt('a', 'z' + 1));
            }
            this.target = builder.toString();
        }

        log.info("Source: '{}'", source);
        log.info("Target: '{}'", target);
    }

    @Override
    protected String getInformation() {
        return INFORMATION;
    }

    // time = 574 ms
    @Override
    protected Boolean original() {
        var original = new Original(source, target);
        return original.process();
    }

    // time = 530 ms
    @Override
    protected Boolean practice() {
        var practice = new Practice(source, target);
        return practice.process();
    }

    // time = 486 ms
    @Override
    protected Boolean solution() {
        var solution = new Solution(source, target);
        return solution.process();
    }
}
