package com.witalis.praxis.leetcode.task.h7.p680;

import com.witalis.praxis.leetcode.task.LeetCodeTask;
import com.witalis.praxis.leetcode.task.h7.p680.option.*;
import com.witalis.praxis.leetcode.utils.LeetCode;
import com.witalis.praxis.leetcode.utils.TaskDifficulty;
import com.witalis.praxis.leetcode.utils.TaskRevision;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.ThreadLocalRandom;

import static com.witalis.praxis.leetcode.utils.TaskTag.*;

@Slf4j
@LeetCode(
    id = 680,
    description = "Valid Palindrome II",
    difficulty = TaskDifficulty.EASY,
    tags = {STRING, TWO_POINTERS, GREEDY}
)
public class ValidPalindromeII extends LeetCodeTask<Boolean> {
    public static final int LEN = 100_000;
    private String string;

    public static final String INFORMATION = """

        Description:
            Given a string s, return true if the s can be palindrome
                after deleting at most one character from it.

        Example:
            Input: s = "abca"
            Output: true
            Explanation: You could delete the character 'c'.""";

    public ValidPalindromeII(int id, String description, TaskRevision revision) {
        super(id, description, revision);
        initialization();
    }

    private void initialization() {
        final var random = ThreadLocalRandom.current();

        int len = random.nextInt(1, LEN + 1);

        StringBuilder builder = new StringBuilder();
        for (int s = 0; s < len; s++) {
            builder.append((char) random.nextInt('a', 'z' + 1));
        }

        this.string = builder.toString();

        log.info("String 's' is {}", string);
    }

    @Override
    protected String getInformation() {
        return INFORMATION;
    }

    // time = 6837 ms
    @Override
    protected Boolean original() {
        var original = new Original(string);
        return original.process();
    }

    // time = 720 ms
    @Override
    protected Boolean practice() {
        var practice = new Practice(string);
        return practice.process();
    }

    // time = 419 ms
    @Override
    protected Boolean solution() {
        var solution = new Solution(string);
        return solution.process();
    }
}
