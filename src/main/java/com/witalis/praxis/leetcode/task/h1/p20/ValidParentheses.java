package com.witalis.praxis.leetcode.task.h1.p20;

import com.witalis.praxis.leetcode.task.LeetCodeTask;
import com.witalis.praxis.leetcode.task.h1.p20.option.*;
import com.witalis.praxis.leetcode.utils.LeetCode;
import com.witalis.praxis.leetcode.utils.TaskDifficulty;
import com.witalis.praxis.leetcode.utils.TaskRevision;

import lombok.extern.slf4j.Slf4j;

import static com.witalis.praxis.leetcode.utils.TaskTag.*;

@Slf4j
@LeetCode(
    id = 20,
    description = "Valid Parentheses",
    difficulty = TaskDifficulty.EASY,
    tags = {STRING, STACK}
)
public class ValidParentheses extends LeetCodeTask<Boolean> {
    private String string;

    public static final String INFORMATION = """

        Given a string s containing just the characters
            '(', ')', '{', '}', '[' and ']',
            determine if the input string is valid.
                                                                          
        An input string is valid if:
            1. Open brackets must be closed by the same type of brackets.
            2. Open brackets must be closed in the correct order.
        
        Example:
            Input: s = "([)]"
            Output: false""";

    public ValidParentheses(int id, String description, TaskRevision revision) {
        super(id, description, revision);
        initialization();
    }

    private void initialization() {
        this.string = "()[{[]([])}]([{}[[[{}]]]{}([])([])]){}";
        log.info("String is {}", string);
    }

    @Override
    protected String getInformation() {
        return INFORMATION;
    }

    // time = 1028 ms
    @Override
    protected Boolean original() {
        var original = new Original(string);
        return original.process();
    }

    // time = 962 ms
    @Override
    protected Boolean practice() {
        var practice = new Practice(string);
        return practice.process();
    }

    // time = 967 ms
    @Override
    protected Boolean solution() {
        var solution = new Solution(string);
        return solution.process();
    }
}
