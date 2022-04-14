package com.witalis.praxis.leetcode.task.h3.p242.option;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.util.Arrays;

/**
 * ID: 242
 * Name: Valid Anagram
 * URL: <a href="https://leetcode.com/problems/valid-anagram/">Valid Anagram</a>
 * Note: try to find the better solution (without timing)
 */
@Slf4j
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Practice {
    private String source;
    private String target;

    public Boolean process() {
        return isAnagram(source, target);
    }

    public boolean isAnagram(String s, String t) {
        if (s == null || t == null || s.length() != t.length()) return false;

        char[] sArray = s.toCharArray();
        char[] tArray = t.toCharArray();

        Arrays.sort(sArray);
        Arrays.sort(tArray);

        return Arrays.equals(sArray, tArray);
    }
}
