package com.witalis.praxis.leetcode.task.h15.p1456.option;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.util.Set;

/**
 * ID: 1456
 * Name: Maximum Number of Vowels in a Substring of Given Length
 * URL: <a href="https://leetcode.com/problems/maximum-number-of-vowels-in-a-substring-of-given-length/">Maximum Number of Vowels in a Substring of Given Length</a>
 * Note: try to find the better solution (without timing)
 */
@Slf4j
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Practice {
    private String string;
    private int limit;

    public Integer process() {
        return maxVowels(string, limit);
    }

    public static final Set<Character> vowels = Set.of('a', 'e', 'i', 'o', 'u');

    public int maxVowels(String s, int k) {
        if (s == null || s.isEmpty() || k <= 0) return 0;

        final int n = s.length();
        final char[] letters = s.toCharArray();

        int counter = 0;
        int count = 0;
        for (int i = 0; i < n; i++) {
            if (vowels.contains(letters[i])) count++;
            if (i >= k && vowels.contains(letters[i - k])) count--;
            counter = Math.max(counter, count);
        }

        return counter;
    }
}
