package com.witalis.praxis.leetcode.task.h24.p2390.option;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

/**
 * ID: 2390
 * Name: Removing Stars From a String
 * URL: <a href="https://leetcode.com/problems/removing-stars-from-a-string/">Removing Stars From a String</a>
 * Note: the real test solution (code writing with timing)
 */
@Slf4j
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Original {
    private String string;

    public String process() {
        return removeStars(string);
    }

    public String removeStars(String s) {
        if (s == null) return "";

        var builder = new StringBuilder();
        int index = s.length() - 1;
        int count = 0;
        while (index >= 0) {
            final char letter = s.charAt(index);
            if (Character.isLetter(letter)) {
                if (count == 0) {
                    builder.append(letter);
                } else {
                    count--;
                }
            } else {
                count++;
            }
            index--;
        }

        return builder.reverse().toString();
    }
}
