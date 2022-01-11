package com.witalis.praxis.leetcode.task.h1.p9;

import com.witalis.praxis.leetcode.task.LeetCodeTask;
import com.witalis.praxis.leetcode.task.h1.p9.option.*;
import com.witalis.praxis.leetcode.utils.LeetCode;
import com.witalis.praxis.leetcode.utils.TaskDifficulty;
import com.witalis.praxis.leetcode.utils.TaskRevision;

import lombok.extern.slf4j.Slf4j;

import static com.witalis.praxis.leetcode.utils.TaskTag.*;

@Slf4j
@LeetCode(
    id = 9,
    description = "Palindrome Number",
    difficulty = TaskDifficulty.EASY,
    tags = {MATH}
)
public class PalindromeNumber extends LeetCodeTask<Boolean> {
    private int number;

    public static final String INFORMATION = """

        Given an integer x, return true if x is palindrome integer.
            An integer is a palindrome when it reads the same backward as forward.
            For example, 121 is palindrome while 123 is not.
                                                                        
        Follow up:
            Could you solve it without converting the integer to a string?
        
        Example:
            Input: x = 121
            Output: true""";

    public PalindromeNumber(int id, String description, TaskRevision revision) {
        super(id, description, revision);
        initialization();
    }

    private void initialization() {
        this.number = 1234554321;
        log.info("Number is {}", number);
    }

    @Override
    protected String getInformation() {
        return INFORMATION;
    }

    // time = 928 ms
    @Override
    protected Boolean original() {
        var original = new Original(number);
        return original.process();
    }

    // time = 907 ms
    @Override
    protected Boolean practice() {
        var practice = new Practice(number);
        return practice.process();
    }

    // time = 952 ms
    @Override
    protected Boolean solution() {
        var solution = new Solution(number);
        return solution.process();
    }
}
