package com.witalis.praxis.leetcode.task.h1.p87.option;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.util.*;

/**
 * ID: 87
 * Name: Scramble String
 * URL: <a href="https://leetcode.com/problems/scramble-string/">Scramble String</a>
 * Note: the real test solution (code writing with timing)
 */
@Slf4j
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Original {
    private String string1;
    private String string2;

    public Original(String string1, String string2) {
        this.string1 = string1;
        this.string2 = string2;
    }

    public Boolean process() {
        return isScramble(string1, string2);
    }

    private Map<String, Set<String>> cache = new HashMap<>();

    public boolean isScramble(String s1, String s2) {
        if (s1 == null || s2 == null || s1.length() != s2.length()) return false;

        char[] chars1 = s1.toCharArray();
        char[] chars2 = s2.toCharArray();
        Arrays.sort(chars1);
        Arrays.sort(chars2);
        if (!Arrays.equals(chars1, chars2)) return false;

        Set<String> permutations = recursiveScramble(s1, new HashSet<>(Set.of("")));
        return permutations.contains(s2);
    }

    private Set<String> recursiveScramble(String s, Set<String> candidates) {
        if (cache.containsKey(s)) return cache.get(s);

        Set<String> permutations = new HashSet<>();

        if (s.length() == 1) {
            for (String candidate : candidates) {
                permutations.add(candidate + s);
            }
            return permutations;
        }

        for (int i = 1; i < s.length(); i++) {
            // prefix
            Set<String> prefixCandidates = recursiveScramble(s.substring(0, i), candidates);
            // suffix
            Set<String> suffixCandidates = recursiveScramble(s.substring(i), candidates);

            for (String prefixCandidate : prefixCandidates) {
                for (String suffixCandidate : suffixCandidates) {
                    // direct
                    permutations.add(prefixCandidate + suffixCandidate);
                    // reverse
                    permutations.add(suffixCandidate + prefixCandidate);
                }
            }
        }

        cache.put(s, permutations);

        return permutations;
    }
}
