package com.witalis.praxis.leetcode.task.h4.p345.option;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.util.HashSet;
import java.util.Set;

/**
 * ID: 345
 * Name: Reverse Vowels of a String
 * URL: <a href="https://leetcode.com/problems/reverse-vowels-of-a-string/">Reverse Vowels of a String</a>
 * Note: try to find the better solution (without timing)
 */
@Slf4j
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Practice {
    private String string;

    public String process() {
        return reverseVowels(string);
    }

    public String reverseVowels(String s) {
        if (s == null || s.length() == 0) return s;

        Set<Character> vowels = new HashSet<>(
            Set.of('A', 'E', 'I', 'O', 'U', 'a', 'e', 'i', 'o', 'u')
        );
        char[] characters = s.toCharArray();

        int l = 0;
        int r = s.length() - 1;
        while (l < r) {
            // find
            while (l < r && !vowels.contains(characters[l])) l++;
            while (r > l && !vowels.contains(characters[r])) r--;
            // swap
            if (l < r) {
                characters[l] ^= characters[r];
                characters[r] ^= characters[l];
                characters[l] ^= characters[r];
            }
            // increment
            l++;
            r--;
        }

        return String.valueOf(characters);
    }
}
