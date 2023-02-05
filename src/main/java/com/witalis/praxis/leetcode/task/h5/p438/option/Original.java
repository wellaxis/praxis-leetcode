package com.witalis.praxis.leetcode.task.h5.p438.option;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * ID: 438
 * Name: Find All Anagrams in a String
 * URL: <a href="https://leetcode.com/problems/find-all-anagrams-in-a-string/">Find All Anagrams in a String</a>
 * Note: the real test solution (code writing with timing)
 */
@Slf4j
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Original {
    private String source;
    private String pattern;

    public List<Integer> process() {
        return findAnagrams(source, pattern);
    }

    public List<Integer> findAnagrams(String s, String p) {
        if (s == null || p == null) return Collections.emptyList();
        if (s.equals(p)) return Collections.singletonList(0);

        final List<Integer> indices = new ArrayList<>();

        int sourceLen = s.length();
        int patternLen = p.length();
        if (patternLen > sourceLen) return indices;

        char[] patternLetters = p.toCharArray();
        Arrays.sort(patternLetters);

        char[] sourceLetters;
        for (int i = 0; i <= sourceLen - patternLen; i++) {
            sourceLetters = s.substring(i, i + patternLen).toCharArray();
            Arrays.sort(sourceLetters);
            if (Arrays.equals(sourceLetters, patternLetters)) indices.add(i);
        }

        return indices;
    }
}
