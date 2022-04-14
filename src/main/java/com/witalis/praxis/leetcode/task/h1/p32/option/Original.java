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
 * URL: <a href="https://leetcode.com/problems/longest-valid-parentheses/">Longest Valid Parentheses</a>
 * Note: the real test solution (code writing with timing)
 */
@Slf4j
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Original {
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

            if (ch == '(') {
                stack.push(i);
            } else if (ch == ')') {
                stack.pop();
                if (stack.isEmpty()) {
                    stack.push(i);
                } else {
                    max = Math.max(max, i - stack.peek());
                }
            }
        }

        return max;
    }
}
