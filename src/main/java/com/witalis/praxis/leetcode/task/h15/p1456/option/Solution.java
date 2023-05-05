package com.witalis.praxis.leetcode.task.h15.p1456.option;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

/**
 * ID: 1456
 * Name: Maximum Number of Vowels in a Substring of Given Length
 * URL: <a href="https://leetcode.com/problems/maximum-number-of-vowels-in-a-substring-of-given-length/">Maximum Number of Vowels in a Substring of Given Length</a>
 * Note: the best found solution (external programming)
 */
@Slf4j
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Solution {
    private String string;
    private int limit;

    public Integer process() {
        return maxVowels(string, limit);
    }

    public int maxVowels(String s, int k) {
        int n = s.length();
        int[] arr = new int[n];
        int count = 0;
        for (int i = 0; i < n; i++) {
            char c = s.charAt(i);
            if (c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u') {
                count++;
            }
            arr[i] = count;
        }

        int max = 0;
        for (int i = 0; i <= n - k; i++) {
            int end = i + k - 1;
            if (i == 0) {
                max = Math.max(max, arr[end]);
            } else {
                max = Math.max(max, arr[end] - arr[i - 1]);
            }
        }

        return max;
    }
}
