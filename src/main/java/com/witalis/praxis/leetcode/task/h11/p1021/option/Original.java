package com.witalis.praxis.leetcode.task.h11.p1021.option;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

/**
 * ID: 1021
 * Name: Remove Outermost Parentheses
 * URL: <a href="https://leetcode.com/problems/remove-outermost-parentheses/">Remove Outermost Parentheses</a>
 * Note: the real test solution (code writing with timing)
 */
@Slf4j
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Original {
    private String string;

    public String process() {
        return removeOuterParentheses(string);
    }

    public String removeOuterParentheses(String s) {
        if (s == null || s.isEmpty()) return "";

        StringBuilder builder = new StringBuilder();

        int index = 0;
        for (char letter : s.toCharArray()) {
            switch (letter) {
                case '(':
                    if (index++ > 0) builder.append(letter);
                    break;
                case ')':
                    if (index-- > 1) builder.append(letter);
                    break;
            }
        }

        return builder.toString();
    }
}
