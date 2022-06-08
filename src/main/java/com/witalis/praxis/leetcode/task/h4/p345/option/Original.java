package com.witalis.praxis.leetcode.task.h4.p345.option;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

/**
 * ID: 345
 * Name: Reverse Vowels of a String
 * URL: <a href="https://leetcode.com/problems/reverse-vowels-of-a-string/">Reverse Vowels of a String</a>
 * Note: the real test solution (code writing with timing)
 */
@Slf4j
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Original {
    private String string;

    public String process() {
        return reverseVowels(string);
    }

    public String reverseVowels(String s) {
        if (s == null || s.length() == 0) return s;

        String vowels = "AEIOUaeiou";
        char[] characters = s.toCharArray();

        int l = 0;
        int r = s.length() - 1;
        char buffer;
        while (l < r) {
            while (l < r && vowels.indexOf(characters[l]) < 0) l++;
            while (r > l && vowels.indexOf(characters[r]) < 0) r--;
            if (l < r) {
                buffer = characters[l];
                characters[l] = characters[r];
                characters[r] = buffer;
            }
            l++;
            r--;
        }

        return String.valueOf(characters);
    }
}
