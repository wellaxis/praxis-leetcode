package com.witalis.praxis.leetcode.task.h8.p712;

import com.witalis.praxis.leetcode.task.LeetCodeTask;
import com.witalis.praxis.leetcode.task.h8.p712.option.*;
import com.witalis.praxis.leetcode.utils.LeetCode;
import com.witalis.praxis.leetcode.utils.TaskDifficulty;
import com.witalis.praxis.leetcode.utils.TaskRevision;

import lombok.extern.slf4j.Slf4j;
import java.util.concurrent.ThreadLocalRandom;

import static com.witalis.praxis.leetcode.utils.TaskTag.*;

@Slf4j
@LeetCode(
    id = 712,
    description = "Minimum ASCII Delete Sum for Two Strings",
    difficulty = TaskDifficulty.MEDIUM,
    tags = {STRING, DYNAMIC_PROGRAMMING}
)
public class MinimumASCIIDeleteSumForTwoStrings extends LeetCodeTask<Integer> {
    public static final int LEN = 1_000;

    private String string1;
    private String string2;

    public static final String INFORMATION = """

        Description:
            Given two strings s1 and s2, return the lowest ASCII sum of deleted characters to make two strings equal.

        Example:
            Input: s1 = "delete", s2 = "leet"
            Output: 403
            Explanation: Deleting "dee" from "delete" to turn the string into "let",
                adds 100[d] + 101[e] + 101[e] to the sum.
                Deleting "e" from "leet" adds 101[e] to the sum.
                At the end, both strings are equal to "let", and the answer is 100+101+101+101 = 403.
                If instead we turned both strings into "lee" or "eet", we would get answers of 433 or 417, which are higher.""";

    public MinimumASCIIDeleteSumForTwoStrings(int id, String description, TaskRevision revision) {
        super(id, description, revision);
        initialization();
    }

    private void initialization() {
        this.string1 = generate();
        this.string2 = generate();

        log.info("String s1: '{}'", string1);
        log.info("String s2: '{}'", string2);
    }

    private static String generate() {
        final var random = ThreadLocalRandom.current();

        var len = random.nextInt(1, LEN + 1);
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < len; i++) {
            builder.append((char) random.nextInt('a', 'z' + 1));
        }
        return builder.toString();
    }

    @Override
    protected String getInformation() {
        return INFORMATION;
    }

    // time = 316063 ms
    @Override
    protected Integer original() {
        var original = new Original(string1, string2);
        return original.process();
    }

    // time = 272417 ms
    @Override
    protected Integer practice() {
        var practice = new Practice(string1, string2);
        return practice.process();
    }

    // time = 13876 ms
    @Override
    protected Integer solution() {
        var solution = new Solution(string1, string2);
        return solution.process();
    }
}
