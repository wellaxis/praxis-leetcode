package com.witalis.praxis.leetcode.task.h18.p1704.option;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.util.Set;
import java.util.function.IntPredicate;

/**
 * ID: 1704
 * Name: Determine if String Halves Are Alike
 * URL: <a href="https://leetcode.com/problems/determine-if-string-halves-are-alike/">Determine if String Halves Are Alike</a>
 * Note: the real test solution (code writing with timing)
 */
@Slf4j
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Original {
    private String string;

    public Boolean process() {
        return halvesAreAlike(string);
    }

    private static final Set<Character> VOWELS = Set.of('a', 'e', 'i', 'o', 'u', 'A', 'E', 'I', 'O', 'U');

    public boolean halvesAreAlike(String s) {
        if (s == null) return false;

        return s.substring(0, s.length() / 2).chars().filter(isVowel()).count() ==
            s.substring(s.length() / 2).chars().filter(isVowel()).count();
    }

    private static IntPredicate isVowel() {
        return i -> VOWELS.contains((char) i);
    }
}
