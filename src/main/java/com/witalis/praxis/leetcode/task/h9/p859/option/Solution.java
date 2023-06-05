package com.witalis.praxis.leetcode.task.h9.p859.option;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

/**
 * ID: 859
 * Name: Buddy Strings
 * URL: <a href="https://leetcode.com/problems/buddy-strings/">Buddy Strings</a>
 * Note: the best found solution (external programming)
 */
@Slf4j
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Solution {
    private String source;
    private String target;

    public Boolean process() {
        return buddyStrings(source, target);
    }

    public boolean buddyStrings(String s, String goal) {
        if (s.length() != goal.length()) {
            return false;
        }

        if (s.equals(goal)) {
            int[] frequency = new int[26];
            for (char ch : s.toCharArray()) {
                frequency[ch - 'a'] += 1;
                if (frequency[ch - 'a'] == 2) {
                    return true;
                }
            }

            return false;
        }

        int firstIndex = -1;
        int secondIndex = -1;

        for (int i = 0; i < s.length(); ++i) {
            if (s.charAt(i) != goal.charAt(i)) {
                if (firstIndex == -1) {
                    firstIndex = i;
                } else if (secondIndex == -1) {
                    secondIndex = i;
                } else {
                    return false;
                }
            }
        }

        if (secondIndex == -1) {
            return false;
        }

        return s.charAt(firstIndex) == goal.charAt(secondIndex) &&
            s.charAt(secondIndex) == goal.charAt(firstIndex);
    }
}
