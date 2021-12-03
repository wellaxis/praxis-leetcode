package com.witalis.praxis.leetcode.task.p6;

import com.witalis.praxis.leetcode.task.LeetCodeTask;
import com.witalis.praxis.leetcode.task.p6.option.*;
import com.witalis.praxis.leetcode.utils.LeetCode;
import com.witalis.praxis.leetcode.utils.TaskRevision;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@LeetCode(id = 6, description = "Zigzag Conversion")
public class ZigzagConversion extends LeetCodeTask<String> {
    private String string;
    private int numRows;

    public static final String INFORMATION = """

        The string "PAYPALISHIRING" is written in a zigzag pattern
            on a given number of rows like this:
            (you may want to display this pattern in a fixed font for better legibility)
                         
        P   A   H   N
        A P L S I I G
        Y   I   R

        And then read line by line: "PAHNAPLSIIGYIR"
                         
        Write the code that will take a string and make this conversion given a number of rows:
            string convert(string s, int numRows);
            
        Example:
            Input: s = "PAYPALISHIRING", numRows = 4
            Output: "PINALSIGYAHRPI"
            Explanation:
                P     I    N
                A   L S  I G
                Y A   H R
                P     I""";

    public ZigzagConversion(int id, String description, TaskRevision revision) {
        super(id, description, revision);
        initialization();
    }

    private void initialization() {
        this.string = "LeetCodeCodingInAction.";
        this.numRows = 4;
        log.info("String is {}, rows is {}", string, numRows);
    }

    @Override
    protected String getInformation() {
        return INFORMATION;
    }

    // time = 2742 ms
    @Override
    protected String original() {
        var original = new Original(string, numRows);
        return original.process();
    }

    // time = 1689 ms
    @Override
    protected String practice() {
        var practice = new Practice(string, numRows);
        return practice.process();
    }

    // time = 1029 ms
    @Override
    protected String solution() {
        var solution = new Solution(string, numRows);
        return solution.process();
    }
}
