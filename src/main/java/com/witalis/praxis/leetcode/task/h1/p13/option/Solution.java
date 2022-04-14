package com.witalis.praxis.leetcode.task.h1.p13.option;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

/**
 * ID: 13
 * Name: Roman to Integer
 * URL: <a href="https://leetcode.com/problems/roman-to-integer/">Roman to Integer</a>
 * Note: the best found solution (external programming)
 */
@Slf4j
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Solution {
    private String string;

    public Integer process() {
        return romanToInt(string);
    }

    public int romanToInt(String s) {
        int finalResult = 0;
        for (int i = 0; i < s.length(); i++) {
            int current = getValue(s.charAt(i));
            if (i > 0) {
                int previous = getValue(s.charAt(i - 1));
                if (current > previous) {
                    finalResult += current - previous * 2 ;
                } else {
                    finalResult += current;
                }
            } else {
                finalResult += current;
            }
        }
        return finalResult;
    }

    private int getValue(char c) {
        switch(c) {
            case 'I' : return 1;
            case 'V' : return 5;
            case 'X' : return 10;
            case 'L' : return 50;
            case 'C' : return 100;
            case 'D' : return 500;
            case 'M' : return 1000;
            default : return 0;
        }
    }
}
