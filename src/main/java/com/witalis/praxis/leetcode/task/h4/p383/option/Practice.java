package com.witalis.praxis.leetcode.task.h4.p383.option;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

/**
 * ID: 383
 * Name: Ransom Note
 * URL: <a href="https://leetcode.com/problems/ransom-note/">Ransom Note</a>
 * Note: try to find the better solution (without timing)
 */
@Slf4j
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Practice {
    private String ransomNote;
    private String magazine;

    public Boolean process() {
        return canConstruct(ransomNote, magazine);
    }

    public boolean canConstruct(String ransomNote, String magazine) {
        if (ransomNote == null || magazine == null) return false;
        if (magazine.length() < ransomNote.length()) return false;

        int[] letters = new int[26];

        for (char letter : magazine.toCharArray()) {
            letters[letter - 'a']++;
        }
        for (char letter : ransomNote.toCharArray()) {
            if (--letters[letter - 'a'] < 0) return false;
        }

        return true;
    }
}
