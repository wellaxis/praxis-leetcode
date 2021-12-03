package com.witalis.praxis.leetcode.task.p13.option;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

/**
 * ID: 13
 * Name: Roman to Integer
 * URL: https://leetcode.com/problems/roman-to-integer/
 * Note: try to find the better solution (without timing)
 */
@Slf4j
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Practice {
    private String string;

    public Integer process() {
        return romanToInt(string);
    }

    public int romanToInt(String s) {
        int index = 0;
        int counter = 0;

        while (index < s.length()) {
            var current = s.charAt(index);
            int integer = getInteger(current);
            if (index + 1 == s.length() || current == 'M' || current == 'D' || current == 'L' || current == 'V') {
                counter += integer;
            } else {
                var next = getInteger(s.charAt(index + 1));
                if (next > integer) {
                    counter += next - integer;
                    index++;
                } else {
                    counter += integer;
                }
            }
            index++;
        }
        return counter;
    }

    private int getInteger(char c) {
        return switch (c) {
            case 'I' -> 1;
            case 'V' -> 5;
            case 'X' -> 10;
            case 'L' -> 50;
            case 'C' -> 100;
            case 'D' -> 500;
            case 'M' -> 1000;
            default -> 0;
        };
    }
}
