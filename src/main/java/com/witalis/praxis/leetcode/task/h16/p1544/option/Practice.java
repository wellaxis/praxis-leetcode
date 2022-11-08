package com.witalis.praxis.leetcode.task.h16.p1544.option;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.util.*;

/**
 * ID: 1544
 * Name: Make The String Great
 * URL: <a href="https://leetcode.com/problems/make-the-string-great/">Make The String Great</a>
 * Note: try to find the better solution (without timing)
 */
@Slf4j
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Practice {
    private String string;

    public String process() {
        return makeGood(string);
    }

    public String makeGood(String s) {
        if (s == null || s.isEmpty()) return s;

        Deque<Character> stack = new ArrayDeque<>();

        char[] letters = s.toCharArray();
        for (char letter : letters) {
            if (!stack.isEmpty() && Math.abs(stack.peek() - letter) == 32) {
                stack.pop();
            } else {
                stack.push(letter);
            }
        }

        StringBuilder builder = new StringBuilder();
        for (char letter : stack) builder.append(letter);

        return builder.reverse().toString();
    }
}
