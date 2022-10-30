package com.witalis.praxis.leetcode.task.h4.p316.option;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * ID: 316
 * Name: Remove Duplicate Letters
 * URL: <a href="https://leetcode.com/problems/remove-duplicate-letters/">Remove Duplicate Letters</a>
* Note: try to find the better solution (without timing)
 */
@Slf4j
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Practice {
    private String string;

    public String process() {
        return removeDuplicateLetters(string);
    }

    public String removeDuplicateLetters(String s) {
        if (s == null || s.isEmpty()) return s;

        Deque<Integer> stack = new ArrayDeque<>();
        boolean[] statuses = new boolean[26];

        int[] positions = new int[26];
        char[] characters = s.toCharArray();
        for (int i = 0; i < characters.length; i++) {
            positions[characters[i] - 'a'] = i;
        }

        for (int i = 0; i < characters.length; i++) {
            int index = characters[i] - 'a';
            if (statuses[index]) continue;

            while (!stack.isEmpty() && stack.peek() > index && positions[stack.peek()] > i) {
                int last = stack.pop();
                statuses[last] = false;
            }

            stack.push(index);
            statuses[index] = true;
        }

        StringBuilder builder = new StringBuilder();
        stack.stream().map(i -> (char) (i + 'a')).forEach(builder::append);

        return builder.reverse().toString();
    }
}
