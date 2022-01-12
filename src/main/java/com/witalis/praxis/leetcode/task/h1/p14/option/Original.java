package com.witalis.praxis.leetcode.task.h1.p14.option;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

/**
 * ID: 14
 * Name: Longest Common Prefix
 * URL: https://leetcode.com/problems/longest-common-prefix/
 * Note: the real test solution (code writing with timing)
 */
@Slf4j
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Original {
    private String[] strings;

    public String process() {
        return longestCommonPrefix(strings);
    }

    public String longestCommonPrefix(String[] strs) {
        var builder = new StringBuilder();

        int counter = 0;
        while (true) {
            Character ch = null;
            for (String str: strs) {
                if (counter >= str.length()) {
                    return builder.toString();
                }
                if (ch == null) {
                    ch = str.charAt(counter);
                } else if (ch != str.charAt(counter)) {
                    return builder.toString();
                }
            }
            builder.append(ch);
            counter++;
        }
    }
}
