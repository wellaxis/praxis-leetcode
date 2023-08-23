package com.witalis.praxis.leetcode.task.h8.p767.option;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

/**
 * ID: 767
 * Name: Reorganize String
 * URL: <a href="https://leetcode.com/problems/reorganize-string/">Reorganize String</a>
 * Note: the best found solution (external programming)
 */
@Slf4j
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Solution {
    private String string;

    public String process() {
        return reorganizeString(string);
    }

    public String reorganizeString(String s) {
        var charCounts = new int[26];
        for (char c : s.toCharArray()) {
            charCounts[c - 'a']++;
        }

        int maxCount = 0;
        int letter = 0;
        for (int i = 0; i < charCounts.length; i++) {
            if (charCounts[i] > maxCount) {
                maxCount = charCounts[i];
                letter = i;
            }
        }
        if (maxCount > (s.length() + 1) / 2) {
            return "";
        }

        var ans = new char[s.length()];
        int index = 0;

        // place the most frequent letter
        while (charCounts[letter] != 0) {
            ans[index] = (char) (letter + 'a');
            index += 2;
            charCounts[letter]--;
        }

        // place rest of the letters in any order
        for (int i = 0; i < charCounts.length; i++) {
            while (charCounts[i] > 0) {
                if (index >= s.length()) {
                    index = 1;
                }
                ans[index] = (char) (i + 'a');
                index += 2;
                charCounts[i]--;
            }
        }

        return String.valueOf(ans);
    }
}
