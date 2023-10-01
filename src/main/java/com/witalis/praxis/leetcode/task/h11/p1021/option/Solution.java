package com.witalis.praxis.leetcode.task.h11.p1021.option;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

/**
 * ID: 1021
 * Name: Remove Outermost Parentheses
 * URL: <a href="https://leetcode.com/problems/remove-outermost-parentheses/">Remove Outermost Parentheses</a>
 * Note: the best found solution (external programming)
 */
@Slf4j
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Solution {
    private String string;

    public String process() {
        return removeOuterParentheses(string);
    }

    public String removeOuterParentheses(String s) {
        StringBuilder sb = new StringBuilder();

        int opened = 0;
        for (final char c : s.toCharArray())
            if (c == '(') {
                if (++opened > 1)
                    sb.append(c);
            } else if (--opened > 0) {
                sb.append(c);
            }

        return sb.toString();
    }
}
