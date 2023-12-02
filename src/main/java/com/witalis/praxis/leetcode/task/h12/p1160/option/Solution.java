package com.witalis.praxis.leetcode.task.h12.p1160.option;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

/**
 * ID: 1160
 * Name: Find Words That Can Be Formed by Characters
 * URL: <a href="https://leetcode.com/problems/find-words-that-can-be-formed-by-characters/">Find Words That Can Be Formed by Characters</a>
 * Note: the best found solution (external programming)
 */
@Slf4j
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Solution {
    private String[] words;
    private String chars;

    public Integer process() {
        return countCharacters(words, chars);
    }

    public int countCharacters(String[] words, String chars) {
        int[] counts = new int[26];
        for (int i = 0; i < chars.length(); i++) {
            counts[chars.charAt(i) - 'a']++;
        }

        int res = 0;
        for (String s : words) {
            if (canForm(s, counts))
                res += s.length();
        }

        return res;
    }

    boolean canForm(String word, int[] counts) {
        int[] c = new int[26];

        for (int i = 0; i < word.length(); i++) {
            int x = word.charAt(i) - 'a';
            c[x]++;
            if (c[x] > counts[x])
                return false;
        }

        return true;
    }
}
