package com.witalis.praxis.leetcode.task.h1.p14.option;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

/**
 * ID: 14
 * Name: Longest Common Prefix
 * URL: https://leetcode.com/problems/longest-common-prefix/
 * Note: try to find the better solution (without timing)
 */
@Slf4j
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Practice {
    private String[] strings;

    public String process() {
        return longestCommonPrefix(strings);
    }

    public String longestCommonPrefix(String[] strs) {
        if (strs == null || strs.length == 0) return "";

        int counter = 0;
        while (true) {
            if (counter == strs[0].length()) {
                return strs[0].substring(0, counter);
            }
            char ch = strs[0].charAt(counter);
            for (String str: strs) {
                if (counter == str.length() || ch != str.charAt(counter)) {
                    return strs[0].substring(0, counter);
                }
            }
            counter++;
        }
    }
}
