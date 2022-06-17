package com.witalis.praxis.leetcode.task.h4.p387.option;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.util.HashMap;
import java.util.Map;

/**
 * ID: 387
 * Name: First Unique Character in a String
 * URL: <a href="https://leetcode.com/problems/first-unique-character-in-a-string/">First Unique Character in a String</a>
 * Note: the best found solution (external programming)
 */
@Slf4j
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Solution {
    private String string;

    public Integer process() {
        return firstUniqChar(string);
    }

    public int firstUniqChar(String s) {
        Map<Character, Integer> count = new HashMap<>();
        int n = s.length();

        // build hash map : character and how often it appears
        for (int i = 0; i < n; i++) {
            char c = s.charAt(i);
            count.put(c, count.getOrDefault(c, 0) + 1);
        }

        // find the index
        for (int i = 0; i < n; i++) {
            if (count.get(s.charAt(i)) == 1)
                return i;
        }

        return -1;
    }
}
