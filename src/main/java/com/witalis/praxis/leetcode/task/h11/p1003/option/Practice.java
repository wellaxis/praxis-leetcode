package com.witalis.praxis.leetcode.task.h11.p1003.option;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * ID: 1003
 * Name: Check If Word Is Valid After Substitutions
 * URL: <a href="https://leetcode.com/problems/check-if-word-is-valid-after-substitutions/">Check If Word Is Valid After Substitutions</a>
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
        if (s == null) return false;
        if (s.isEmpty()) return true;

        Deque<Character> stack = new ArrayDeque<>();
        for (char character : s.toCharArray()) {
            if (character == 'c') {
                if (stack.isEmpty() || stack.peek() != 'b') return false; else stack.pop();
                if (stack.isEmpty() || stack.peek() != 'a') return false; else stack.pop();
            } else {
                stack.push(character);
            }
        }

        return stack.isEmpty();
    }
}
