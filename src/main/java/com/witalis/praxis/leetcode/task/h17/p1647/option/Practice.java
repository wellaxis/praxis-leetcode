package com.witalis.praxis.leetcode.task.h17.p1647.option;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.util.HashSet;
import java.util.Set;

/**
 * ID: 1647
 * Name: Minimum Deletions to Make Character Frequencies Unique
 * URL: <a href="https://leetcode.com/problems/minimum-deletions-to-make-character-frequencies-unique/">Minimum Deletions to Make Character Frequencies Unique</a>
 * Note: try to find the better solution (without timing)
 */
@Slf4j
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Practice {
    private String string;

    public Integer process() {
        return minDeletions(string);
    }

    public int minDeletions(String s) {
        if (s == null || s.isEmpty()) return 0;

        char[] letters = s.toCharArray();
        final int n = letters.length;
        int[] frequencies = new int[26];
        Set<Integer> seen = new HashSet<>();

        int deletions = 0;

        for (int i = 0; i < n; i++)
            frequencies[letters[i] - 'a']++;

        for (int frequency : frequencies) {
            int quantity = frequency;
            while (quantity > 0 && seen.contains(quantity)) {
                quantity--;
                deletions++;
            }
            seen.add(quantity);
        }

        return deletions;
    }
}
