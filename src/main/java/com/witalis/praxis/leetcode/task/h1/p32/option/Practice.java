package com.witalis.praxis.leetcode.task.h1.p32.option;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * ID: 32
 * Name: Longest Valid Parentheses
 * URL: https://leetcode.com/problems/longest-valid-parentheses/
 * Note: try to find the better solution (without timing)
 */
@Slf4j
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Practice {
    private String string;

    public Integer process() {
        return longestValidParentheses(string);
    }

    public int longestValidParentheses(String s) {
        if (s == null || s.isEmpty()) return 0;

        Deque<Integer> stack = new ArrayDeque<>();
        stack.push(-1);

        int max = 0;
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);

            switch (ch) {
                case '(' -> stack.push(i);
                case ')' -> {
                    stack.pop();
                    if (stack.isEmpty()) {
                        stack.push(i);
                    } else {
                        max = Math.max(max, i - stack.peek());
                    }
                }
                default -> throw new IllegalArgumentException(
                    "Incorrect symbol has been detected: " + ch
                );
            }
        }

        return max;
    }
}
