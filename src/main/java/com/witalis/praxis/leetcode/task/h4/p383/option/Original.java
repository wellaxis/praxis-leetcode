package com.witalis.praxis.leetcode.task.h4.p383.option;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

/**
 * ID: 383
 * Name: Ransom Note
 * URL: <a href="https://leetcode.com/problems/ransom-note/">Ransom Note</a>
 * Note: the real test solution (code writing with timing)
 */
@Slf4j
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Original {
    private String ransomNote;
    private String magazine;

    public Boolean process() {
        return canConstruct(ransomNote, magazine);
    }

    public boolean canConstruct(String ransomNote, String magazine) {
        if (ransomNote == null || magazine == null) return false;

        int n = ransomNote.length();
        int m = magazine.length();

        if (m < n) return false;

        int[] letters = new int[26];
        for (int i = 0; i < m; i++) {
            letters[magazine.charAt(i) - 'a']++;
        }

        for (int i = 0; i < n; i++) {
            int index = ransomNote.charAt(i) - 'a';
            letters[index]--;
            if (letters[index] < 0) return false;
        }

        return true;
    }
}
