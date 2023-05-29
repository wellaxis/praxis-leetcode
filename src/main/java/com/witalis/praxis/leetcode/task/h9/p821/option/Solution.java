package com.witalis.praxis.leetcode.task.h9.p821.option;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

/**
 * ID: 821
 * Name: Shortest Distance to a Character
 * URL: <a href="https://leetcode.com/problems/shortest-distance-to-a-character/">Shortest Distance to a Character</a>
 * Note: the best found solution (external programming)
 */
@Slf4j
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Solution {
    private String string;
    private char character;

    public int[] process() {
        return shortestToChar(string, character);
    }

    public int[] shortestToChar(String s, char c) {
        int n = s.length();
        int[] ans = new int[n];
        int prev = Integer.MIN_VALUE / 2;

        for (int i = 0; i < n; ++i) {
            if (s.charAt(i) == c) prev = i;
            ans[i] = i - prev;
        }

        prev = Integer.MAX_VALUE / 2;
        for (int i = n - 1; i >= 0; --i) {
            if (s.charAt(i) == c) prev = i;
            ans[i] = Math.min(ans[i], prev - i);
        }

        return ans;
    }
}
