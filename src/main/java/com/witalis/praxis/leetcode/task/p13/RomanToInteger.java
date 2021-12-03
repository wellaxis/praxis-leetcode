package com.witalis.praxis.leetcode.task.p13;

import com.witalis.praxis.leetcode.task.LeetCodeTask;
import com.witalis.praxis.leetcode.task.p13.option.*;
import com.witalis.praxis.leetcode.utils.LeetCode;
import com.witalis.praxis.leetcode.utils.TaskRevision;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@LeetCode(id = 13, description = "Roman to Integer")
public class RomanToInteger extends LeetCodeTask<Integer> {
    private String string;

    public static final String INFORMATION = """

            Roman numerals are represented by seven different symbols:
                I, V, X, L, C, D and M.

                ------------
                Symbol Value
                ------------
                   I       1
                   V       5
                   X      10
                   L      50
                   C     100
                   D     500
                   M    1000
                ------------
            
            For example, 2 is written as II in Roman numeral,
                just two one's added together.
                12 is written as XII, which is simply X + II.
                The number 27 is written as XXVII, which is XX + V + II.
            Roman numerals are usually written largest to smallest
                from left to right. However, the numeral for four is not IIII.
                Instead, the number four is written as IV.
                Because the one is before the five we subtract it making four.
                The same principle applies to the number nine, which is written as IX.
                There are six instances where subtraction is used:
                
            * I can be placed before V (5) and X (10) to make 4 and 9.
            * X can be placed before L (50) and C (100) to make 40 and 90.
            * C can be placed before D (500) and M (1000) to make 400 and 900.
            
            Given a roman numeral, convert it to an integer.
            
            Example:
                Input: s = "MCMXCIV"
                Output: 1994
                Explanation: M = 1000, CM = 900, XC = 90 and IV = 4.""";

    public RomanToInteger(int id, String description, TaskRevision revision) {
        super(id, description, revision);
        initialization();
    }

    private void initialization() {
        this.string = "MCMXCIV";
        log.info("Roman number is {}", string);
    }

    @Override
    protected String getInformation() {
        return INFORMATION;
    }

    // time = 1083 ms
    @Override
    protected Integer original() {
        var original = new Original(string);
        return original.process();
    }

    // time = 1036 ms
    @Override
    protected Integer practice() {
        var practice = new Practice(string);
        return practice.process();
    }

    // time = 1021 ms
    @Override
    protected Integer solution() {
        var solution = new Solution(string);
        return solution.process();
    }
}
