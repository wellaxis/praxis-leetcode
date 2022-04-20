package com.witalis.praxis.leetcode.task.h2.p165.option;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

/**
 * ID: 165
 * Name: Compare Version Numbers
 * URL: <a href="https://leetcode.com/problems/compare-version-numbers/">Compare Version Numbers</a>
 * Note: the best found solution (external programming)
 */
@Slf4j
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Solution {
    private String version1;
    private String version2;

    public Integer process() {
        return compareVersion(version1, version2);
    }

    public int compareVersion(String version1, String version2) {
        // num stores each numeric part of version
        int num1 = 0;
        int num2 = 0;

        // loop until both versions are processed
        int i = 0;
        int j = 0;
        while (i < version1.length() || j < version2.length()) {

            // storing numeric part of version 1 in num1
            while (i < version1.length() && version1.charAt(i) != '.') {
                num1 = num1 * 10 + (version1.charAt(i) - '0');
                i++;
            }

            // storing numeric part of version 2 in num2
            while (j < version2.length() && version2.charAt(j) != '.') {
                num2 = num2 * 10 + (version2.charAt(j) - '0');
                j++;
            }

            if (num1 > num2) return 1;
            if (num2 > num1) return -1;

            // if equal, reset variables and go for next numeric part
            num1 = 0;
            num2 = 0;

            i++;
            j++;
        }

        return 0;
    }
}
