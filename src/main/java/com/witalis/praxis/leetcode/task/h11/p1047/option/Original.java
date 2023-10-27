package com.witalis.praxis.leetcode.task.h11.p1047.option;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.stream.Collectors;

/**
 * ID: 1047
 * Name: Remove All Adjacent Duplicates In String
 * URL: <a href="https://leetcode.com/problems/remove-all-adjacent-duplicates-in-string/">Remove All Adjacent Duplicates In String</a>
 * Note: the real test solution (code writing with timing)
 */
@Slf4j
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Original {
    private String string;

    public String process() {
        return removeDuplicates(string);
    }

    public String removeDuplicates(String s) {
        if (s == null || s.isEmpty()) return s;

        Deque<Character> stack = new ArrayDeque<>();
        char[] letters = s.toCharArray();
        for (char character : letters) {
            if (!stack.isEmpty() && stack.peek() == character) {
                stack.pop();
            } else {
                stack.push(character);
            }
        }

        return new StringBuilder(stack.stream().map(String::valueOf).collect(Collectors.joining())).reverse().toString();
    }
}
