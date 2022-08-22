package com.witalis.praxis.leetcode.task.h6.p541.option;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

/**
 * ID: 541
 * Name: Reverse String II
 * URL: <a href="https://leetcode.com/problems/reverse-string-ii/">Reverse String II</a>
 * Note: the real test solution (code writing with timing)
 */
@Slf4j
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Original {
    private String string;
    private int index;

    public String process() {
        return reverseStr(string, index);
    }

    public String reverseStr(String s, int k) {
        if (s == null || s.length() == 0) return "";

        StringBuilder builder = new StringBuilder();
        StringBuilder segment = new StringBuilder();

        int i;
        boolean reverse = true;
        for (i = 0; i + k <= s.length(); i += k) {
            if (reverse) {
                builder.append(segment.append(s, i, i + k).reverse());
                segment.setLength(0);
            } else {
                builder.append(s, i, i + k);
            }
            reverse = !reverse;
        }
        if (reverse) {
            builder.append(segment.append(s, i, s.length()).reverse());
        } else {
            builder.append(s, i, s.length());
        }

        return builder.toString();
    }
}
