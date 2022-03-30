package com.witalis.praxis.leetcode.task.h1.p91;

import com.witalis.praxis.leetcode.task.LeetCodeTask;
import com.witalis.praxis.leetcode.task.h1.p91.option.*;
import com.witalis.praxis.leetcode.utils.LeetCode;
import com.witalis.praxis.leetcode.utils.TaskDifficulty;
import com.witalis.praxis.leetcode.utils.TaskRevision;

import lombok.extern.slf4j.Slf4j;
import java.util.concurrent.ThreadLocalRandom;

import static com.witalis.praxis.leetcode.utils.TaskTag.*;

@Slf4j
@LeetCode(
    id = 91,
    description = "Decode Ways",
    difficulty = TaskDifficulty.MEDIUM,
    tags = {STRING, DYNAMIC_PROGRAMMING}
)
public class DecodeWays extends LeetCodeTask<Integer> {
    public static final int LEN = 100;
    private String string;

    public static final String INFORMATION = """

        A message containing letters from A-Z can be encoded
            into numbers using the following mapping:
            'A' -> "1"
            'B' -> "2"
            ...
            'Z' -> "26"

        To decode an encoded message, all the digits must be grouped
            then mapped back into letters using the reverse
            of the mapping above (there may be multiple ways).

        For example, "11106" can be mapped into:
            * "AAJF" with the grouping (1 1 10 6)
            * "KJF" with the grouping (11 10 6)

        Note that the grouping (1 11 06) is invalid because "06"
            cannot be mapped into 'F' since "6" is different from "06".

        Given a string s containing only digits, return the number of ways to decode it.

        The test cases are generated so that the answer fits in a 32-bit integer.

        Example:
            Input: s = "226"
            Output: 3
            Explanation: "226" could be decoded as "BZ" (2 26), "VF" (22 6), or "BBF" (2 2 6).""";

    public DecodeWays(int id, String description, TaskRevision revision) {
        super(id, description, revision);
        initialization();
    }

    private void initialization() {
        var random = ThreadLocalRandom.current();
        var letter = random.ints(
                random.nextInt(1, LEN + 1),
                'A',
                1 + 'Z'
            )
            .mapToObj(i -> String.valueOf((char) i))
            .reduce((s1, s2) -> s1 + s2).orElse("");

        log.info("Letter is '{}'", letter);

        this.string = letter.chars()
            .mapToObj(c -> String.valueOf(c - 65 + 1))
            .reduce((s1, s2) -> s1 + s2).orElse("");

        log.info("String is '{}'", string);
    }

    @Override
    protected String getInformation() {
        return INFORMATION;
    }

    // time = 664 ms
    @Override
    protected Integer original() {
        var original = new Original(string);
        return original.process();
    }

    // time = 482 ms
    @Override
    protected Integer practice() {
        var practice = new Practice(string);
        return practice.process();
    }

    // time = 445 ms
    @Override
    protected Integer solution() {
        var solution = new Solution(string);
        return solution.process();
    }
}
