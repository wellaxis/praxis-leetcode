package com.witalis.praxis.leetcode.task.h2.p115;

import com.witalis.praxis.leetcode.task.LeetCodeTask;
import com.witalis.praxis.leetcode.task.h2.p115.option.*;
import com.witalis.praxis.leetcode.utils.LeetCode;
import com.witalis.praxis.leetcode.utils.TaskDifficulty;
import com.witalis.praxis.leetcode.utils.TaskRevision;

import lombok.extern.slf4j.Slf4j;
import java.util.concurrent.ThreadLocalRandom;

import static com.witalis.praxis.leetcode.utils.TaskTag.*;

@Slf4j
@LeetCode(
    id = 115,
    description = "Distinct Subsequences",
    difficulty = TaskDifficulty.HARD,
    tags = {STRING, DYNAMIC_PROGRAMMING}
)
public class DistinctSubsequences extends LeetCodeTask<Integer> {
    public static final int LEN = 1_000;
    private String source;
    private String target;

    public static final String INFORMATION = """

        Given two strings s and t, return the number of distinct subsequences of s which equals t.

        A string's subsequence is a new string formed from the original string by deleting some (can be none)
            of the characters without disturbing the remaining characters' relative positions.
            (i.e., "ACE" is a subsequence of "ABCDE" while "AEC" is not).

        The test cases are generated so that the answer fits on a 32-bit signed integer.

        Example:
            Input: s = "rabbbit", t = "rabbit"
            Output: 3
            Explanation: As shown below, there are 3 ways you can generate "rabbit" from S.
                rabbbit
                rabbbit
                rabbbit""";

    public DistinctSubsequences(int id, String description, TaskRevision revision) {
        super(id, description, revision);
        initialization();
    }

    private void initialization() {
        this.target = generateString(1, LEN / 10);
        this.source = generateString(target.length(), LEN + 1);

        log.info("Source is '{}'", source);
        log.info("Target is '{}'", target);
    }

    private String generateString(int minLength, int maxLength) {
        var random = ThreadLocalRandom.current();

        int len = random.nextInt(minLength, maxLength);
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < len; i++) {
            if (random.nextBoolean()) {
                builder.append((char) random.nextInt('A', 'Z' + 1));
            } else {
                builder.append((char) random.nextInt('a', 'z' + 1));
            }
        }

        return builder.toString();
    }

    @Override
    protected String getInformation() {
        return INFORMATION;
    }

    // time = 2197 ms
    @Override
    protected Integer original() {
        var original = new Original(source, target);
        return original.process();
    }

    // time = 1627 ms
    @Override
    protected Integer practice() {
        var practice = new Practice(source, target);
        return practice.process();
    }

    // time = 613 ms
    @Override
    protected Integer solution() {
        var solution = new Solution(source, target);
        return solution.process();
    }
}
