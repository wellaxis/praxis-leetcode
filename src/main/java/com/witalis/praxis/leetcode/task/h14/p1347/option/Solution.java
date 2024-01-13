package com.witalis.praxis.leetcode.task.h14.p1347.option;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

/**
 * ID: 1347
 * Name: Minimum Number of Steps to Make Two Strings Anagram
 * URL: <a href="https://leetcode.com/problems/minimum-number-of-steps-to-make-two-strings-anagram/">Minimum Number of Steps to Make Two Strings Anagram</a>
 * Note: the best found solution (external programming)
 */
@Slf4j
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Solution {
    private String source;
    private String target;

    public Integer process() {
        return minSteps(source, target);
    }

    public int minSteps(String s, String t) {
        int[] count = new int[26];

        byte[] sb = s.getBytes();
        byte[] tb = t.getBytes();
        for (byte b : sb) {
            count[b - 'a']++;
        }
        for (byte b : tb) {
            count[b - 'a']--;
        }

        int res = 0;
        for (int i : count) {
            res += Math.abs(i);
        }

        return res / 2;
    }
}
