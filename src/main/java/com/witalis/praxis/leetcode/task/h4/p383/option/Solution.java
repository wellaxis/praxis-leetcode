package com.witalis.praxis.leetcode.task.h4.p383.option;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

/**
 * ID: 383
 * Name: Ransom Note
 * URL: <a href="https://leetcode.com/problems/ransom-note/">Ransom Note</a>
 * Note: the best found solution (external programming)
 */
@Slf4j
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Solution {
    private String ransomNote;
    private String magazine;

    public Boolean process() {
        return canConstruct(ransomNote, magazine);
    }

    public boolean canConstruct(String ransomNote, String magazine) {
        int[] count = new int[128];

        for (final char c : magazine.toCharArray())
            ++count[c];

        for (final char c : ransomNote.toCharArray())
            if (--count[c] < 0)
                return false;

        return true;
    }
}
