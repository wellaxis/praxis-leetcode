package com.witalis.praxis.leetcode.task.h6.p567;

import com.witalis.praxis.leetcode.task.LeetCodeTask;
import com.witalis.praxis.leetcode.task.h6.p567.option.*;
import com.witalis.praxis.leetcode.utils.LeetCode;
import com.witalis.praxis.leetcode.utils.TaskDifficulty;
import com.witalis.praxis.leetcode.utils.TaskRevision;

import lombok.extern.slf4j.Slf4j;
import java.util.concurrent.ThreadLocalRandom;

import static com.witalis.praxis.leetcode.utils.TaskTag.*;

@Slf4j
@LeetCode(
    id = 567,
    description = "Permutation in String",
    difficulty = TaskDifficulty.EASY,
    tags = {HASH_TABLE, TWO_POINTERS, STRING, SLIDING_WINDOW}
)
public class PermutationInString extends LeetCodeTask<Boolean> {
    public static final int LEN = 10_000;

    private String string1;
    private String string2;

    public static final String INFORMATION = """

        Description:
            Given two strings s1 and s2, return true if s2 contains a permutation of s1, or false otherwise.

            In other words, return true if one of s1's permutations is the substring of s2.

        Example:
            Input: s1 = "ab", s2 = "eidbaooo"
            Output: true
            Explanation: s2 contains one permutation of s1 ("ba").""";

    public PermutationInString(int id, String description, TaskRevision revision) {
        super(id, description, revision);
        initialization();
    }

    private void initialization() {
        this.string1 = generate();
        this.string2 = generate();

        log.info("String #1: '{}'", string1);
        log.info("String #2: '{}'", string2);
    }

    private String generate() {
        final var random = ThreadLocalRandom.current();

        int len = random.nextInt(1, LEN + 1);
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

    // time = 85501 ms
    @Override
    protected Boolean original() {
        var original = new Original(string1, string2);
        return original.process();
    }

    // time = 11736 ms
    @Override
    protected Boolean practice() {
        var practice = new Practice(string1, string2);
        return practice.process();
    }

    // time = 2683 ms
    @Override
    protected Boolean solution() {
        var solution = new Solution(string1, string2);
        return solution.process();
    }
}
