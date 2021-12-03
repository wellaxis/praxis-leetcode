package com.witalis.praxis.leetcode.task.p20.option;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.util.ArrayDeque;

/**
 * ID: 20
 * Name: Valid Parentheses
 * URL: https://leetcode.com/problems/valid-parentheses/
 * Note: the real test solution (code writing with timing)
 */
@Slf4j
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Original {
    private String string;

    public Boolean process() {
        return isValid(string);
    }

    public boolean isValid(String s) {
        var stack = new ArrayDeque<Character>();

        int index = 0;
        while (index < s.length()) {
            char ch = s.charAt(index);

            var peek = stack.peekLast();

            switch (ch) {
                case '(' -> stack.addLast(ch);
                case ')' -> {
                    if (peek != null && peek == '(') {
                        stack.removeLast();
                    } else {
                        return false;
                    }
                }
                case '[' -> stack.addLast(ch);
                case ']' -> {
                    if (peek != null && peek == '[') {
                        stack.removeLast();
                    } else {
                        return false;
                    }
                }
                case '{' -> stack.addLast(ch);
                case '}' -> {
                    if (peek != null && peek == '{') {
                        stack.removeLast();
                    } else {
                        return false;
                    }
                }
                default -> throw new IllegalArgumentException(
                    "Illegal character has been detected: " + ch
                );
            }

            index++;
        }
        return stack.isEmpty();
    }
}
