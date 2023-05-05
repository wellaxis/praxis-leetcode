package com.witalis.praxis.leetcode.task.h15.p1456.option;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * ID: 1456
 * Name: Maximum Number of Vowels in a Substring of Given Length
 * URL: <a href="https://leetcode.com/problems/maximum-number-of-vowels-in-a-substring-of-given-length/">Maximum Number of Vowels in a Substring of Given Length</a>
 * Note: the real test solution (code writing with timing)
 */
@Slf4j
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Original {
    private String string;
    private int limit;

    public Integer process() {
        return maxVowels(string, limit);
    }

    public static final Set<Character> vowels = Set.of('a', 'e', 'i', 'o', 'u');

    public int maxVowels(String s, int k) {
        if (s == null || s.isEmpty() || k <= 0) return 0;

        final int n = s.length();
        final Map<Character, Integer> map = new HashMap<>();
        vowels.forEach(vowel -> map.put(vowel, 1));

        int counter = 0;
        int count = 0;
        for (int i = 0; i < n; i++) {
            if (i < k) {
                count += map.getOrDefault(s.charAt(i), 0);
            } else {
                count += map.getOrDefault(s.charAt(i), 0) - map.getOrDefault(s.charAt(i - k), 0);
            }
            counter = Math.max(counter, count);
        }

        return counter;
    }
}
