package com.witalis.praxis.leetcode.task.h11.p1003.option;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.util.Stack;

/**
 * ID: 1003
 * Name: Check If Word Is Valid After Substitutions
 * URL: <a href="https://leetcode.com/problems/check-if-word-is-valid-after-substitutions/">Check If Word Is Valid After Substitutions</a>
 * Note: the best found solution (external programming)
 */
@Slf4j
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Solution {
    private String string;

    public Boolean process() {
        return isValid(string);
    }

    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        for (char c: s.toCharArray()) {
            if (c == 'c') {
                if (stack.isEmpty() || stack.pop() != 'b') return false;
                if (stack.isEmpty() || stack.pop() != 'a') return false;
            } else {
                stack.push(c);
            }
        }

        return stack.isEmpty();
    }
}
