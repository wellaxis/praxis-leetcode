package com.witalis.praxis.leetcode.task.p14;

import com.witalis.praxis.leetcode.task.LeetCodeTask;
import com.witalis.praxis.leetcode.task.p14.option.*;
import com.witalis.praxis.leetcode.utils.LeetCode;
import com.witalis.praxis.leetcode.utils.TaskRevision;

import lombok.extern.slf4j.Slf4j;

import java.util.Arrays;

@Slf4j
@LeetCode(id = 14, description = "Longest Common Prefix")
public class LongestCommonPrefix extends LeetCodeTask<String> {
    private String[] strings;

    public static final String INFORMATION = """

        Write a function to find the longest common prefix string amongst an array of strings.
        If there is no common prefix, return an empty string ""

        Example:
            Input: strs = ["flower","flow","flight"]
            Output: "fl" """;

    public LongestCommonPrefix(int id, String description, TaskRevision revision) {
        super(id, description, revision);
        initialization();
    }

    private void initialization() {
        this.strings = new String[] {
            "flower","flow","flight"
        };
        log.info("Strings are {}", Arrays.toString(strings));
    }

    @Override
    protected String getInformation() {
        return INFORMATION;
    }

    // time = 984 ms
    @Override
    protected String original() {
        var original = new Original(strings.clone());
        return original.process();
    }

    // time = 954 ms
    @Override
    protected String practice() {
        var practice = new Practice(strings.clone());
        return practice.process();
    }

    // time = 938 ms
    @Override
    protected String solution() {
        var solution = new Solution(strings.clone());
        return solution.process();
    }
}
