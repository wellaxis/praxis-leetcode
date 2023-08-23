package com.witalis.praxis.leetcode.task.h8.p767;

import com.witalis.praxis.leetcode.task.LeetCodeTask;
import com.witalis.praxis.leetcode.task.h8.p767.option.*;
import com.witalis.praxis.leetcode.utils.LeetCode;
import com.witalis.praxis.leetcode.utils.TaskDifficulty;
import com.witalis.praxis.leetcode.utils.TaskRevision;

import lombok.extern.slf4j.Slf4j;
import java.util.concurrent.ThreadLocalRandom;

import static com.witalis.praxis.leetcode.utils.TaskTag.*;

@Slf4j
@LeetCode(
    id = 767,
    description = "Reorganize String",
    difficulty = TaskDifficulty.MEDIUM,
    tags = {STRING, HASH_TABLE, GREEDY, SORTING, HEAP, COUNTING}
)
public class ReorganizeString extends LeetCodeTask<String> {
    public static final int LEN = 500;

    private String string;

    public static final String INFORMATION = """

        Description:
            Given a string s, rearrange the characters of s so that any two adjacent characters are not the same.

            Return any possible rearrangement of s or return "" if not possible.

        Example:
            Input: s = "aab"
            Output: "aba" """;

    public ReorganizeString(int id, String description, TaskRevision revision) {
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
        this.string = builder.toString();

        log.info("String s: '{}'", string);
    }

    @Override
    protected String getInformation() {
        return INFORMATION;
    }

    // time = 1748 ms
    @Override
    protected String original() {
        var original = new Original(string);
        return original.process();
    }

    // time = 569 ms
    @Override
    protected String practice() {
        var practice = new Practice(string);
        return practice.process();
    }

    // time = 421 ms
    @Override
    protected String solution() {
        var solution = new Solution(string);
        return solution.process();
    }
}
