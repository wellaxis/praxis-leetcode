package com.witalis.praxis.leetcode.task.h6.p541.option;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

/**
 * ID: 541
 * Name: Reverse String II
 * URL: <a href="https://leetcode.com/problems/reverse-string-ii/">Reverse String II</a>
 * Note: try to find the better solution (without timing)
 */
@Slf4j
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Practice {
    private String string;
    private int index;

    public String process() {
        return reverseStr(string, index);
    }

    public String reverseStr(String s, int k) {
        if (s == null || s.length() == 0) return "";

        StringBuilder builder = new StringBuilder();
        StringBuilder segment = new StringBuilder();

        int limit;
        boolean reverse = true;
        for (int i = 0; i <= s.length(); i += k) {
            limit = Math.min(i + k, s.length());
            segment.append(s, i, limit);
            if (reverse) {
                builder.append(segment.reverse());
            } else {
                builder.append(segment);
            }
            reverse = !reverse;
            segment.setLength(0);
        }

        return builder.toString();
    }
}
