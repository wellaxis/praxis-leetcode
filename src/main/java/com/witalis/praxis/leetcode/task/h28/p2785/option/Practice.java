package com.witalis.praxis.leetcode.task.h28.p2785.option;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.util.*;

/**
 * ID: 2785
 * Name: Sort Vowels in a String
 * URL: <a href="https://leetcode.com/problems/sort-vowels-in-a-string/">Sort Vowels in a String</a>
 * Note: try to find the better solution (without timing)
 */
@Slf4j
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Practice {
    private String string;

    public String process() {
        return sortVowels(string);
    }

    public static final Set<Character> VOWELS = Set.of('a', 'e', 'i', 'o', 'u', 'A', 'E', 'I', 'O', 'U');

    public String sortVowels(String s) {
        if (s == null || s.isEmpty()) return "";

        final List<Character> vowels = new ArrayList<>();
        final List<Integer> indexes = new ArrayList<>();

        char[] letters = s.toCharArray();
        final int n = letters.length;
        for (int i = 0; i < n; i++)
            if (VOWELS.contains(letters[i])) {
                vowels.add(letters[i]);
                indexes.add(i);
            }

        vowels.sort(Comparator.naturalOrder());

        int count = 0;
        for (int index : indexes)
            letters[index] = vowels.get(count++);

        return new String(letters);
    }
}
