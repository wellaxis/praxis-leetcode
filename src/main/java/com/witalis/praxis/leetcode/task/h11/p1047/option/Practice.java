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
 * Note: try to find the better solution (without timing)
 */
@Slf4j
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Practice {
    private String string;

    public String process() {
        return removeDuplicates(string);
    }

    public String removeDuplicates(String s) {
        if (s == null || s.isEmpty()) return s;

        Deque<Character> stack = new ArrayDeque<>();
        for (char character : s.toCharArray())
            if (!stack.isEmpty() && stack.peek() == character)
                stack.pop();
            else
                stack.push(character);

        StringBuilder builder = new StringBuilder();
        while (!stack.isEmpty())
            builder.append(stack.pop());

        return builder.reverse().toString();
    }
}
