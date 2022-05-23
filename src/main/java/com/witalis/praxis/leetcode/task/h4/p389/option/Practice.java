package com.witalis.praxis.leetcode.task.h4.p389.option;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

/**
 * ID: 389
 * Name: Find the Difference
 * URL: <a href="https://leetcode.com/problems/find-the-difference/">Find the Difference</a>
 * Note: try to find the better solution (without timing)
 */
@Slf4j
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Practice {
    private String s;
    private String t;

    public Character process() {
        return findTheDifference(s, t);
    }

    public char findTheDifference(String s, String t) {
        if (s == null || t == null) throw new IllegalArgumentException("incorrect input data");

        int[] counters = new int[26];

        for (int i = 0; i < s.length(); i++) {
            counters[t.charAt(i) - 'a']++;
            counters[s.charAt(i) - 'a']--;
        }
        counters[t.charAt(t.length() - 1) - 'a']++;

        for (int i = 0; i < counters.length; i++) {
            if (counters[i] > 0) return (char) (i + 'a');
        }

        throw new IllegalArgumentException("incorrect input data");
    }
}
