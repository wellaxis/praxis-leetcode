package com.witalis.praxis.leetcode.task.p125;

import com.witalis.praxis.leetcode.task.LeetCodeTask;
import com.witalis.praxis.leetcode.task.p125.option.*;
import com.witalis.praxis.leetcode.utils.LeetCode;
import com.witalis.praxis.leetcode.utils.TaskRevision;

import lombok.extern.slf4j.Slf4j;

import static com.witalis.praxis.leetcode.utils.TaskTag.*;

@Slf4j
@LeetCode(
    id = 125,
    description = "Valid Palindrome",
    tags = {STRING, TWO_POINTERS}
)
public class ValidPalindrome extends LeetCodeTask<Boolean> {
    public static final int LEN = 200_000;
    private String string;

    public static final String INFORMATION = """

        A phrase is a palindrome if, after converting
            all uppercase letters into lowercase letters
            and removing all non-alphanumeric characters,
            it reads the same forward and backward.
            Alphanumeric characters include letters and numbers.

        Given a string s, return true if it is a palindrome,
            or false otherwise.

        Example:
            Input: s = "A man, a plan, a canal: Panama"
            Output: true
            Explanation: "amanaplanacanalpanama" is a palindrome.""";

    public ValidPalindrome(int id, String description, TaskRevision revision) {
        super(id, description, revision);
        initialization();
    }

    private void initialization() {
        this.string = "A man, a plan, a canal: Panama";

        log.info("String is {}", string);
    }

    @Override
    protected String getInformation() {
        return INFORMATION;
    }

    // time = 518 ms
    @Override
    protected Boolean original() {
        var original = new Original(string);
        return original.process();
    }

    // time = 404 ms
    @Override
    protected Boolean practice() {
        var practice = new Practice(string);
        return practice.process();
    }

    // time = 395 ms
    @Override
    protected Boolean solution() {
        var solution = new Solution(string);
        return solution.process();
    }
}
