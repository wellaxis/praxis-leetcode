package com.witalis.praxis.leetcode.task.h1.p76.option;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.util.Arrays;

/**
 * ID: 76
 * Name: Minimum Window Substring
 * URL: <a href="https://leetcode.com/problems/minimum-window-substring/">Minimum Window Substring</a>
 * Note: try to find the better solution (without timing)
 */
@Slf4j
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Practice {
    private String source;
    private String target;

    public String process() {
        return minWindow(source, target);
    }

    public String minWindow(String s, String t) {
        if (s == null || t == null || t.length() > s.length()) return "";

        int[] minRange = new int[] {-1, s.length()};

        int[] targetFrequencies = new int[52];
        for (int i = 0; i < t.length(); i++) {
            char ch = t.charAt(i);
            int index = ch >= 'a' ? ch - 'a' + 26 : ch - 'A';

            targetFrequencies[index]++;
        }

        int permissions = 0;
        for (int targetFrequency : targetFrequencies) {
            if (targetFrequency > 0) permissions++;
        }

        int position = 0;
        int permission = 0;
        int[] sourceFrequencies = new int[52];
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            int index = ch >= 'a' ? ch - 'a' + 26 : ch - 'A';

            if (targetFrequencies[index] == 0) continue;
            sourceFrequencies[index]++;
            if (targetFrequencies[index] == sourceFrequencies[index]) permission++;

            while (permission == permissions && position <= i) {
                if (minRange[1] - minRange[0] > i + 1 - position) {
                    minRange[0] = position;
                    minRange[1] = i + 1;
                }

                char chRemove = s.charAt(position);
                int indexRemove = chRemove >= 'a' ? chRemove - 'a' + 26 : chRemove - 'A';

                if (targetFrequencies[indexRemove] != 0) {
                    sourceFrequencies[indexRemove]--;
                    if (targetFrequencies[indexRemove] > sourceFrequencies[indexRemove]) permission--;
                }
                position++;
            }
        }

        return (minRange[0] < 0) ? "" : s.substring(minRange[0], minRange[1]);
    }
}
