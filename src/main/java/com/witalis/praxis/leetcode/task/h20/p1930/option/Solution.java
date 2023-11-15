package com.witalis.praxis.leetcode.task.h20.p1930.option;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.util.*;

/**
 * ID: 1930
 * Name: Unique Length-3 Palindromic Subsequences
 * URL: <a href="https://leetcode.com/problems/unique-length-3-palindromic-subsequences/">Unique Length-3 Palindromic Subsequences</a>
 * Note: the best found solution (external programming)
 */
@Slf4j
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Solution {
    private String string;

    public Integer process() {
        return countPalindromicSubsequence(string);
    }

    public int countPalindromicSubsequence(String s) {
        final int n = s.length();
        final byte[] sc = new byte[n];
        s.getBytes(0, n, sc, 0);

        final int[][] firstCounts = new int[26][26];
        final int[] firstIdx = new int[26];
        final int[] charCounts = new int[26];

        int foundLettersCount = 0;
        for (int i = 0; i < n; i++) {
            final int c = sc[i] - 'a';
            charCounts[c]++;
            if (firstIdx[c] == 0) {
                firstIdx[c] = i + 1;
                final int[] firsts = firstCounts[c];
                System.arraycopy(charCounts, 0, firsts, 0, 26);
                foundLettersCount++;
            }
        }

        int palindromeCount = 0;
        final boolean[] foundLast = new boolean[128];
        for (int i = n - 1; i >= 2; i--) {
            final int c = sc[i] - 'a';
            charCounts[c]--;
            if (!foundLast[c]) {
                foundLast[c] = true;
                if (i - firstIdx[c] >= 1) {
                    final int[] firsts = firstCounts[c];
                    for (int j = 0; j < 26; j++)
                        if (charCounts[j] > firsts[j])
                            palindromeCount++;
                }
                if (--foundLettersCount == 0)  break;
            }
        }

        return palindromeCount;
    }
}
