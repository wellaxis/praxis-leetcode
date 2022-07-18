package com.witalis.praxis.leetcode.task.h5.p482;

import com.witalis.praxis.leetcode.task.LeetCodeTask;
import com.witalis.praxis.leetcode.task.h5.p482.option.*;
import com.witalis.praxis.leetcode.utils.LeetCode;
import com.witalis.praxis.leetcode.utils.TaskDifficulty;
import com.witalis.praxis.leetcode.utils.TaskRevision;

import lombok.extern.slf4j.Slf4j;
import java.util.concurrent.ThreadLocalRandom;

import static com.witalis.praxis.leetcode.utils.TaskTag.*;

@Slf4j
@LeetCode(
    id = 482,
    description = "License Key Formatting",
    difficulty = TaskDifficulty.EASY,
    tags = {STRING}
)
public class LicenseKeyFormatting extends LeetCodeTask<String> {
    public static final int LEN = 100_000;
    public static final int SIZE = 10_000;
    private String string;
    private int key;

    public static final String INFORMATION = """

        You are given a license key represented as a string s
            that consists of only alphanumeric characters and dashes.
            The string is separated into n + 1 groups by n dashes. You are also given an integer k.

        We want to reformat the string s such that each group contains exactly k characters,
            except for the first group, which could be shorter than k but still must contain at least one character.
            Furthermore, there must be a dash inserted between two groups,
            and you should convert all lowercase letters to uppercase.

        Return the reformatted license key.

        Example:
            Input: s = "2-5g-3-J", k = 2
            Output: "2-5G-3J"
            Explanation: The string s has been split into three parts,
                each part has 2 characters except the first part as it could be shorter as mentioned above.""";

    public LicenseKeyFormatting(int id, String description, TaskRevision revision) {
        super(id, description, revision);
        initialization();
    }

    private void initialization() {
        var random = ThreadLocalRandom.current();
        int len = random.nextInt(1, LEN + 1);

        var builder = new StringBuilder();
        int group;
        while (builder.length() < len) {
            group = random.nextInt(1, len - builder.length() + 1);
            builder.append("-").append(generate(group));
        }

        this.string = builder.substring(1);
        this.key = random.nextInt(1, Math.min(SIZE, len));

        log.info("String is '{}'", string);
        log.info("Key is {}", key);
    }

    private String generate(int length) {
        final var random = ThreadLocalRandom.current();
        final var builder = new StringBuilder();

        for (int i = 0; i < length; i++) {
            if (random.nextBoolean()) {
                builder.append((char) random.nextInt('0', '9' + 1));
            } else {
                if (random.nextBoolean()) {
                    builder.append((char) random.nextInt('a', 'z' + 1));
                } else {
                    builder.append((char) random.nextInt('A', 'Z' + 1));
                }
            }
        }

        return builder.toString();
    }

    @Override
    protected String getInformation() {
        return INFORMATION;
    }

    // time = 2522 ms
    @Override
    protected String original() {
        var original = new Original(string, key);
        return original.process();
    }

    // time = 1874 ms
    @Override
    protected String practice() {
        var practice = new Practice(string, key);
        return practice.process();
    }

    // time = 1662 ms
    @Override
    protected String solution() {
        var solution = new Solution(string, key);
        return solution.process();
    }
}
