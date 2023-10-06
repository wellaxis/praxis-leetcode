package com.witalis.praxis.leetcode.task.h2.p132.option;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

/**
 * ID: 132
 * Name: Palindrome Partitioning II
 * URL: <a href="https://leetcode.com/problems/palindrome-partitioning-ii/">Palindrome Partitioning II</a>
 * Note: the best found solution (external programming)
 */
@Slf4j
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Solution {
    private String string;

    public Integer process() {
        return minCut(string);
    }

    public int minCut(String s) {
        char[] letters = s.toCharArray();
        int n = letters.length;
        int[] cuts = new int[n];
        boolean[][] palindromes = new boolean[n][n];
        for (int i = 0; i < n; i++) {
            int min = i;
            for (int j = 0; j <= i; j++) {
                if (letters[j] == letters[i] && (j + 1 > i - 1 || palindromes[j + 1][i - 1])) {
                    palindromes[j][i] = true;
                    min = j == 0 ? 0 : Math.min(min, cuts[j - 1] + 1);
                }
            }
            cuts[i] = min;
        }

        return cuts[n - 1];
    }
}
