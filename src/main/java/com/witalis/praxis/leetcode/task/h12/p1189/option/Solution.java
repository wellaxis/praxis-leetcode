package com.witalis.praxis.leetcode.task.h12.p1189.option;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

/**
 * ID: 1189
 * Name: Maximum Number of Balloons
 * URL: <a href="https://leetcode.com/problems/maximum-number-of-balloons/">Maximum Number of Balloons</a>
 * Note: the best found solution (external programming)
 */
@Slf4j
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Solution {
    private String text;

    public Integer process() {
        return maxNumberOfBalloons(text);
    }

    public int maxNumberOfBalloons(String text) {
        char[] bal = "balloon".toCharArray();
        int[] counts = new int[26];

        char[] chars = text.toCharArray();
        for (char c : chars) counts[c - 'a']++;

        int maxCount = 10000;
        for (char c : bal) {
            if (c == 'l' || c == 'o') {
                maxCount = Math.min(maxCount, counts[c - 'a'] / 2);
            }
            maxCount = Math.min(maxCount, counts[c - 'a']);
        }

        return maxCount;
    }
}
