package com.witalis.praxis.leetcode.task.h24.p2390.option;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

/**
 * ID: 2390
 * Name: Removing Stars From a String
 * URL: <a href="https://leetcode.com/problems/removing-stars-from-a-string/">Removing Stars From a String</a>
 * Note: try to find the better solution (without timing)
 */
@Slf4j
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Practice {
    private String string;

    public String process() {
        return removeStars(string);
    }

    public String removeStars(String s) {
        if (s == null) return "";

        final StringBuilder builder = new StringBuilder();
        final char[] letters = s.toCharArray();

        int count = 0;
        for (int i = letters.length - 1; i >= 0; i--) {
            if (letters[i] == '*') {
                count++;
            } else {
                if (count == 0) {
                    builder.append(letters[i]);
                } else {
                    count--;
                }
            }
        }

        return builder.reverse().toString();
    }
}
