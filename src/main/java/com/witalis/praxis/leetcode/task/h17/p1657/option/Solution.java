package com.witalis.praxis.leetcode.task.h17.p1657.option;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.util.*;

/**
 * ID: 1657
 * Name: Determine if Two Strings Are Close
 * URL: <a href="https://leetcode.com/problems/determine-if-two-strings-are-close/">Determine if Two Strings Are Close</a>
 * Note: the best found solution (external programming)
 */
@Slf4j
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Solution {
    private String word1;
    private String word2;

    public Boolean process() {
        return closeStrings(word1, word2);
    }

    public boolean closeStrings(String word1, String word2) {
        if (word1.length() != word2.length()) return false;

        Map<Character, Integer> count1 = new HashMap<>();
        Map<Character, Integer> count2 = new HashMap<>();

        for (final char c : word1.toCharArray())
            count1.put(c, count1.getOrDefault(c, 0) + 1);

        for (final char c : word2.toCharArray())
            count2.put(c, count2.getOrDefault(c, 0) + 1);

        if (!count1.keySet().equals(count2.keySet()))
            return false;

        List<Integer> frequency1 = new ArrayList<>(count1.values());
        List<Integer> frequency2 = new ArrayList<>(count2.values());

        Collections.sort(frequency1);
        Collections.sort(frequency2);

        return frequency1.equals(frequency2);
    }
}
