package com.witalis.praxis.leetcode.task.h11.p1081.option;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.util.Stack;

/**
 * ID: 1081
 * Name: Smallest Subsequence of Distinct Characters
 * URL: <a href="https://leetcode.com/problems/smallest-subsequence-of-distinct-characters/">Smallest Subsequence of Distinct Characters</a>
 * Note: the best found solution (external programming)
 */
@Slf4j
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Solution {
    private String string;

    public String process() {
        return removeDuplicateLetters(string);
    }

    public String removeDuplicateLetters(String s) {
        int[] occurrences = new int[26];
        for (int i = 0; i < s.length(); i++) {
            occurrences[s.charAt(i) - 'a'] = i;
        }

        boolean[] used = new boolean[26];
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            char character = s.charAt(i);
            if (used[character - 'a']) continue;
            while (!stack.isEmpty() && character < stack.peek() && occurrences[stack.peek() - 'a'] > i) {
                char peek = stack.pop();
                used[peek - 'a'] = false;
            }
            stack.push(character);
            used[character - 'a'] = true;
        }

        StringBuilder builder = new StringBuilder();
        for (char character : stack) {
            builder.append(character);
        }

        return builder.toString();
    }
}
