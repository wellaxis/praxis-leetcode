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
 * Note: try to find the better solution (without timing)
 */
@Slf4j
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Practice {
    private String string;

    public Integer process() {
        return countPalindromicSubsequence(string);
    }

    public int countPalindromicSubsequence(String s) {
        if (s == null || s.isEmpty()) return 0;

        final char[] letters = s.toCharArray();
        final int n = letters.length;

        Map<Character, List<Integer>> indexes = new HashMap<>();
        for (int i = 0; i < n; i++) {
            indexes.computeIfAbsent(letters[i], k -> new ArrayList<>());
            indexes.get(letters[i]).add(i);
        }

        int count = 0;
        Set<Character> characters = indexes.keySet();
        for (char c1 : characters) {
            int min = indexes.get(c1).get(0);
            int max = indexes.get(c1).get(indexes.get(c1).size() - 1);

            if (min + 1 >= max) continue;

            for (char c2 : characters) {
                List<Integer> index = indexes.get(c2);
                for (int i : index) {
                    if (i > min && i < max) {
                        count++;
                        break;
                    }
                }
            }
        }

        return count;
    }
}
