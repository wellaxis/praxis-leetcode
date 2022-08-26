package com.witalis.praxis.leetcode.task.h6.p557.option;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

/**
 * ID: 557
 * Name: Reverse Words in a String III
 * URL: <a href="https://leetcode.com/problems/reverse-words-in-a-string-iii/">Reverse Words in a String III</a>
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
        if (s == null || s.length() == 0) return "";

        StringBuilder builder = new StringBuilder();
        StringBuilder segment = new StringBuilder();

        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == ' ') {
                builder.append(segment.reverse()).append(' ');
                segment.setLength(0);
            } else {
                segment.append(s.charAt(i));
            }
        }
        builder.append(segment.reverse());

        return builder.toString();
    }
}
