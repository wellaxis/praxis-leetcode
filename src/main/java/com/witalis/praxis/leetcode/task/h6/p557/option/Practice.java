package com.witalis.praxis.leetcode.task.h6.p557.option;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

/**
 * ID: 557
 * Name: Reverse Words in a String III
 * URL: <a href="https://leetcode.com/problems/reverse-words-in-a-string-iii/">Reverse Words in a String III</a>
 * Note: try to find the better solution (without timing)
 */
@Slf4j
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Practice {
    private String string;

    public String process() {
        return reverseWords(string);
    }

    public String reverseWords(String s) {
        if (s == null || s.length() == 0) return "";

        StringBuilder builder = new StringBuilder();

        int slow = -1;
        int fast = 0;
        while (fast < s.length()) {
            while (fast < s.length() && s.charAt(fast) != ' ') fast++;
            for (int i = fast - 1; i > slow; i--) builder.append(s.charAt(i));
            if (fast >= s.length()) break;
            builder.append(' ');
            slow = fast;
            fast++;
        }

        return builder.toString();
    }
}
