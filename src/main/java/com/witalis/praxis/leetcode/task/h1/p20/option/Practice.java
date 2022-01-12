package com.witalis.praxis.leetcode.task.h1.p20.option;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.util.ArrayDeque;

/**
 * ID: 20
 * Name: Valid Parentheses
 * URL: https://leetcode.com/problems/valid-parentheses/
 * Note: try to find the better solution (without timing)
 */
@Slf4j
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Practice {
    private String string;

    public Boolean process() {
        return isValid(string);
    }

    public boolean isValid(String s) {
        var stack = new ArrayDeque<Character>();

        for (char ch : s.toCharArray()) {
            if (ch == '(' || ch == '[' || ch == '{') {
                stack.addLast(ch);
            } else {
                var peek = stack.peekLast();
                if (peek == null) return false;
                if ((peek == '(' && ch == ')') || (peek == '[' && ch == ']') || (peek == '{' && ch == '}')) {
                    stack.removeLast();
                } else {
                    return false;
                }
            }
        }
        return stack.isEmpty();
    }
}
