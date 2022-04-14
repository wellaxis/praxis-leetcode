package com.witalis.praxis.leetcode.task.h1.p13.option;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

/**
 * ID: 13
 * Name: Roman to Integer
 * URL: <a href="https://leetcode.com/problems/roman-to-integer/">Roman to Integer</a>
 * Note: the real test solution (code writing with timing)
 */
@Slf4j
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Original {
    private String string;

    public Integer process() {
        return romanToInt(string);
    }

    public int romanToInt(String s) {
        var len = s.length();

        int index = 0;
        int counter = 0;

        while (index < len) {
            var ch = s.charAt(index);
            switch (ch) {
                case 'M' -> {
                    counter += 1000;
                }
                case 'D' -> {
                    counter += 500;
                }
                case 'C' -> {
                    if (index + 1 == len) {
                        counter += 100;
                    } else {
                        var next = s.charAt(index + 1);
                        if (next == 'M') {
                            counter += 900;
                            index++;
                        } else if (next == 'D') {
                            counter += 400;
                            index++;
                        } else {
                            counter += 100;
                        }
                    }
                }
                case 'L' -> {
                    counter += 50;
                }
                case 'X' -> {
                    if (index + 1 == len) {
                        counter += 10;
                    } else {
                        var next = s.charAt(index + 1);
                        if (next == 'C') {
                            counter += 90;
                            index++;
                        } else if (next == 'L') {
                            counter += 40;
                            index++;
                        } else {
                            counter += 10;
                        }
                    }
                }
                case 'V' -> {
                    counter += 5;
                }
                case 'I' -> {
                    if (index + 1 == len) {
                        counter += 1;
                    } else {
                        var next = s.charAt(index + 1);
                        if (next == 'X') {
                            counter += 9;
                            index++;
                        } else if (next == 'V') {
                            counter += 4;
                            index++;
                        } else {
                            counter += 1;
                        }
                    }
                }
                default -> throw new IllegalArgumentException("It is not a Roman symbol: " + ch);
            }
            index++;
        }
        return counter;
    }
}
