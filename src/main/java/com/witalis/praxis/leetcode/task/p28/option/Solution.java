package com.witalis.praxis.leetcode.task.p28.option;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

/**
 * ID: 28
 * Name: Implement strStr()
 * URL: https://leetcode.com/problems/implement-strstr/
 * Note: the best found solution (external programming)
 */
@Slf4j
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Solution {
    private String haystack;
    private String needle;

    public Integer process() {
        return strStr(haystack, needle);
    }

    public int strStr(String haystack, String needle) {
        if (needle.equals("")) return 0;
        int[] next = new int[needle.length()];

        // next
        getNext(next, needle);

        // i-haystack, j-needle
        int i = 0, j = 0;
        while (i < haystack.length() && j < needle.length()) {
            if (j == -1 || haystack.charAt(i) == needle.charAt(j)) {
                i++;
                j++;
            } else {
                j = next[j];
            }
        }
        return j == needle.length() ? i - j : -1;
    }

    private void getNext(int[] next, String needle) {
        int k = -1, j = 0;

        next[0] = -1;
        while (j < needle.length() - 1) {
            if (k == -1 || needle.charAt(j) == needle.charAt(k)) {
                k++;
                j++;
                if (needle.charAt(j) != needle.charAt(k)) {
                    next[j] = k;
                } else {
                    next[j] = next[k];
                }
            } else {
                k = next[k];
            }
        }
    }
}
