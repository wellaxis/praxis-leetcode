package com.witalis.praxis.leetcode.task.h18.p1704.option;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.util.Set;

/**
 * ID: 1704
 * Name: Determine if String Halves Are Alike
 * URL: <a href="https://leetcode.com/problems/determine-if-string-halves-are-alike/">Determine if String Halves Are Alike</a>
 * Note: try to find the better solution (without timing)
 */
@Slf4j
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Practice {
    private String string;

    public Boolean process() {
        return halvesAreAlike(string);
    }

    private static final Set<Character> VOWELS = Set.of('a', 'e', 'i', 'o', 'u', 'A', 'E', 'I', 'O', 'U');

    public boolean halvesAreAlike(String s) {
        if (s == null) return false;

        int vowelCount = 0;

        int half = s.length() / 2;
        for (int i = 0; i < half; i++) {
            if (VOWELS.contains(s.charAt(i))) vowelCount++;
            if (VOWELS.contains(s.charAt(i + half))) vowelCount--;
        }

        return vowelCount == 0;
    }
}
