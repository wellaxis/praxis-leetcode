package com.witalis.praxis.leetcode.task.h1.p32;

import com.witalis.praxis.leetcode.task.LeetCodeTask;
import com.witalis.praxis.leetcode.task.h1.p32.option.*;
import com.witalis.praxis.leetcode.utils.LeetCode;
import com.witalis.praxis.leetcode.utils.TaskDifficulty;
import com.witalis.praxis.leetcode.utils.TaskRevision;

import lombok.extern.slf4j.Slf4j;
import java.util.concurrent.ThreadLocalRandom;

import static com.witalis.praxis.leetcode.utils.TaskTag.*;

@Slf4j
@LeetCode(
    id = 32,
    description = "Longest Valid Parentheses",
    difficulty = TaskDifficulty.HARD,
    tags = {STRING, DYNAMIC_PROGRAMMING, STACK}
)
public class LongestValidParentheses extends LeetCodeTask<Integer> {
    public static final int LEN = 30_000;
    private String string;

    public static final String INFORMATION = """

        Given a string containing just the characters '(' and ')',
            find the length of the longest valid (well-formed) parentheses substring.

        Example:
            Input: s = ")()())"
            Output: 4
            Explanation: The longest valid parentheses substring is "()()".""";

    public LongestValidParentheses(int id, String description, TaskRevision revision) {
        super(id, description, revision);
        initialization();
    }

    private void initialization() {
        var random = ThreadLocalRandom.current();
        var length = random.nextInt(0, LEN + 1);
        var builder = new StringBuilder();

        while (length > 0) {
            builder.append(random.nextBoolean() ? ")" : "(");
            length--;
        }
        this.string = builder.toString();

        log.info("String is {}", string);
    }

    @Override
    protected String getInformation() {
        return INFORMATION;
    }

    // time = 4077 ms
    @Override
    protected Integer original() {
        var original = new Original(string);
        return original.process();
    }

    // time = 3992 ms
    @Override
    protected Integer practice() {
        var practice = new Practice(string);
        return practice.process();
    }

    // time = 2615 ms
    @Override
    protected Integer solution() {
        var solution = new Solution(string);
        return solution.process();
    }
}
