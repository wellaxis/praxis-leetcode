package com.witalis.praxis.leetcode.task.h1.p12;

import com.witalis.praxis.leetcode.task.LeetCodeTask;
import com.witalis.praxis.leetcode.task.h1.p12.option.*;
import com.witalis.praxis.leetcode.utils.LeetCode;
import com.witalis.praxis.leetcode.utils.TaskDifficulty;
import com.witalis.praxis.leetcode.utils.TaskRevision;

import lombok.extern.slf4j.Slf4j;

import static com.witalis.praxis.leetcode.utils.TaskTag.*;

@Slf4j
@LeetCode(
    id = 12,
    description = "Integer to Roman",
    difficulty = TaskDifficulty.MEDIUM,
    tags = {HASH_TABLE, MATH, STRING}
)
public class IntegerToRoman extends LeetCodeTask<String> {
    private Integer number;

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
            
            Given an integer, convert it to a roman numeral.
            
            Example:
                Input: num = 1994
                Output: "MCMXCIV"
                Explanation: M = 1000, CM = 900, XC = 90 and IV = 4.""";

    public IntegerToRoman(int id, String description, TaskRevision revision) {
        super(id, description, revision);
        initialization();
    }

    private void initialization() {
        this.number = 1994;
        log.info("Integer number is {}", number);
    }

    @Override
    protected String getInformation() {
        return INFORMATION;
    }

    // time = 1178 ms
    @Override
    protected String original() {
        var original = new Original(number);
        return original.process();
    }

    // time = 1063 ms
    @Override
    protected String practice() {
        var practice = new Practice(number);
        return practice.process();
    }

    // time = 1007 ms
    @Override
    protected String solution() {
        var solution = new Solution(number);
        return solution.process();
    }
}
