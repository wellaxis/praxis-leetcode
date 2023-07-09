package com.witalis.praxis.leetcode.task.h23.p2272.option;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

/**
 * ID: 2272
 * Name: Substring With Largest Variance
 * URL: <a href="https://leetcode.com/problems/substring-with-largest-variance/">Substring With Largest Variance</a>
 * Note: the best found solution (external programming)
 */
@Slf4j
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Solution {
    private String string;

    public Integer process() {
        return largestVariance(string);
    }

    public int largestVariance(String s) {
        int[] counter = new int[26];
        for (char ch : s.toCharArray()) {
            counter[(ch - 'a')]++;
        }
        int globalMax = 0;

        for (int i = 0; i < 26; i++) {
            for (int j = 0; j < 26; j++) {
                // major and minor cannot be the same, and both must appear in s
                if (i == j || counter[i] == 0 || counter[j] == 0) {
                    continue;
                }

                // find the maximum variance of major - minor
                char major = (char) ('a' + i);
                char minor = (char) ('a' + j);
                int majorCount = 0;
                int minorCount = 0;

                // the remaining minor in the rest of s
                int restMinor = counter[j];

                for (char ch : s.toCharArray()) {
                    if (ch == major) {
                        majorCount++;
                    }
                    if (ch == minor) {
                        minorCount++;
                        restMinor--;
                    }

                    // only update the variance if there is at least one minor
                    if (minorCount > 0)
                        globalMax = Math.max(globalMax, majorCount - minorCount);

                    // we can discard the previous string if there is at least one remaining minor
                    if (majorCount < minorCount && restMinor > 0) {
                        majorCount = 0;
                        minorCount = 0;
                    }
                }
            }
        }

        return globalMax;
    }
}
