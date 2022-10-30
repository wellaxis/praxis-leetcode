package com.witalis.praxis.leetcode.task.h11.p1081.option;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * ID: 1081
 * Name: Smallest Subsequence of Distinct Characters
 * URL: <a href="https://leetcode.com/problems/smallest-subsequence-of-distinct-characters/">Smallest Subsequence of Distinct Characters</a>
 * Note: the real test solution (code writing with timing)
 */
@Slf4j
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Original {
    private String string;

    public String process() {
        return removeDuplicateLetters(string);
    }

    public String removeDuplicateLetters(String s) {
        if (s == null || s.isEmpty()) return s;

        Deque<Character> stack = new ArrayDeque<>();
        boolean[] statuses = new boolean[26];

        int[] positions = new int[26];
        for (int i = 0; i < s.length(); i++) {
            positions[s.charAt(i) - 'a'] = i;
        }

        for (int i = 0; i < s.length(); i++) {
            char character = s.charAt(i);
            if (statuses[character - 'a']) continue;

            while (!stack.isEmpty() && stack.peek() > character && positions[character - 'a'] > i) {
                char last = stack.pop();
                statuses[last - 'a'] = false;
            }

            stack.push(character);
            statuses[character - 'a'] = true;
        }

        StringBuilder builder = new StringBuilder();
        while (!stack.isEmpty()) {
            builder.append(stack.pop());
        }

        return builder.reverse().toString();
    }
}
