package com.witalis.praxis.leetcode.task.h14.p1309.option;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

/**
 * ID: 1309
 * Name: Decrypt String from Alphabet to Integer Mapping
 * URL: <a href="https://leetcode.com/problems/decrypt-string-from-alphabet-to-integer-mapping/">Decrypt String from Alphabet to Integer Mapping</a>
 * Note: try to find the better solution (without timing)
 */
@Slf4j
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Practice {
    private String string;

    public String process() {
        return freqAlphabets(string);
    }

    public String freqAlphabets(String s) {
        if (s == null || s.isEmpty()) return "";

        StringBuilder builder = new StringBuilder();

        int index = 0;
        while (index < s.length()) {
            if (index + 2 < s.length() && s.charAt(index + 2) == '#') {
                String group = s.substring(index, index + 2);
                int n = Integer.parseInt(group);
                char ch = (char) ('a' + n - 1);
                builder.append(ch);
                index += 2;
            } else {
                int n = s.charAt(index) - '0';
                char ch = (char) ('a' + n - 1);
                builder.append(ch);
            }
            index++;
        }

        return builder.toString();
    }
}
