package com.witalis.praxis.leetcode.task.h2.p151.option;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

/**
 * ID: 151
 * Name: Reverse Words in a String
 * URL: <a href="https://leetcode.com/problems/reverse-words-in-a-string/">Reverse Words in a String</a>
 * Note: the real test solution (code writing with timing)
 */
@Slf4j
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Original {
    private String string;

    public String process() {
        return reverseWords(string);
    }

    public String reverseWords(String s) {
        if (s == null || s.length() == 0) return s;

        StringBuilder builder = new StringBuilder();
        StringBuilder word = new StringBuilder();

        s = s.trim();
        for (int i = 0; i < s.length(); i++) {
            char letter = s.charAt(i);
            if (letter == ' ') continue;

            builder.append(' ');
            word.append(letter);
            while (i < s.length() - 1 && s.charAt(i + 1) != ' ') {
                word.append(s.charAt(i + 1));
                i++;
            }
            builder.append(word.reverse());
            word.setLength(0);
        }
        builder.reverse();

        return builder.toString().trim();
    }
}
