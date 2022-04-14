package com.witalis.praxis.leetcode.task.h14.p1309.option;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

/**
 * ID: 1309
 * Name: Decrypt String from Alphabet to Integer Mapping
 * URL: <a href="https://leetcode.com/problems/decrypt-string-from-alphabet-to-integer-mapping/">Decrypt String from Alphabet to Integer Mapping</a>
 * Note: the real test solution (code writing with timing)
 */
@Slf4j
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Original {
    private String string;

    public String process() {
        return freqAlphabets(string);
    }

    public String freqAlphabets(String s) {
        if (s == null || s.isEmpty()) return "";

        StringBuilder builder = new StringBuilder();
        String[] groups = s.split("#");

        boolean hashableEnd = s.endsWith("#");
        for (int gr = 0; gr < groups.length; gr++) {
            String group = groups[gr];
            String last = null;
            if (group.length() >= 2 && !(gr == groups.length - 1 && !hashableEnd)) {
                last = group.substring(group.length() - 2);
                group = group.substring(0, group.length() - 2);
            }
            for (int i = 0; i < group.length(); i++) {
                int n = group.charAt(i) - '0';
                char ch = (char) ('a' + n - 1);
                builder.append(ch);
            }
            if (last != null) {
                int n = Integer.parseInt(last);
                char ch = (char) ('a' + n - 1);
                builder.append(ch);
            }
        }

        return builder.toString();
    }
}
