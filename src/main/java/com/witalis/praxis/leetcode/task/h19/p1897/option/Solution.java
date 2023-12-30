package com.witalis.praxis.leetcode.task.h19.p1897.option;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

/**
 * ID: 1897
 * Name: Redistribute Characters to Make All Strings Equal
 * URL: <a href="https://leetcode.com/problems/redistribute-characters-to-make-all-strings-equal/">Redistribute Characters to Make All Strings Equal</a>
 * Note: the best found solution (external programming)
 */
@Slf4j
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Solution {
    private String[] words;

    public Boolean process() {
        return makeEqual(words);
    }

    public boolean makeEqual(String[] words) {
        if (words.length == 1) {
            return true;
        }

        int totalCharCount = 0;
        for (String s : words) {
            totalCharCount += s.length();
        }

        if (totalCharCount % words.length != 0) {
            return false;
        }

        int[] myMap = new int[26];
        for (String s : words) {
            for (char c : s.toCharArray()) {
                myMap[c - 'a']++;
            }
        }
        for (int i : myMap) {
            if (i % words.length != 0) {
                return false;
            }
        }

        return true;
    }
}
