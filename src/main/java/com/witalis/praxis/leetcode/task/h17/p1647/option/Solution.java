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
 * Note: the best found solution (external programming)
 */
@Slf4j
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Solution {
    private String string;

    public Integer process() {
        return minDeletions(string);
    }

    public int minDeletions(String s) {
        int[] freqs = new int[26];
        for (char c : s.toCharArray()) {
            freqs[c - 'a']++;
        }

        int deletions = 0;
        Set<Integer> uniqueIntegers = new HashSet();
        for (int freq : freqs) {
            while (freq != 0 && !uniqueIntegers.add(freq)) {
                deletions++;
                freq--;
            }
        }

        return deletions;
    }
}
