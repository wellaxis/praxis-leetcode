package com.witalis.praxis.leetcode.task.h16.p1544.option;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.stream.Collectors;

/**
 * ID: 1544
 * Name: Make The String Great
 * URL: <a href="https://leetcode.com/problems/make-the-string-great/">Make The String Great</a>
 * Note: the real test solution (code writing with timing)
 */
@Slf4j
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Original {
    private String string;

    public String process() {
        return makeGood(string);
    }

    public String makeGood(String s) {
        if (s == null || s.isEmpty()) return s;

        char[] letters = s.toCharArray();
        Deque<Character> stack = new ArrayDeque<>();
        for (char letter : letters) {
            if (!stack.isEmpty() && isGood(stack.peek(), letter)) {
                stack.pop();
            } else {
                stack.push(letter);
            }
        }

        String goodString = stack.stream().map(String::valueOf).collect(Collectors.joining());
        return new StringBuilder(goodString).reverse().toString();
    }

    private static boolean isGood(char first, char second) {
        if (!String.valueOf(first).equalsIgnoreCase(String.valueOf(second))) return false;
        if (Character.isLowerCase(first) && Character.isLowerCase(second)) return false;
        if (Character.isUpperCase(first) && Character.isUpperCase(second)) return false;

        return true;
    }
}
