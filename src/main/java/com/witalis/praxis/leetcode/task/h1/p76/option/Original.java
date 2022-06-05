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
 * Note: the real test solution (code writing with timing)
 */
@Slf4j
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Original {
    private String source;
    private String target;

    public String process() {
        return minWindow(source, target);
    }

    public String minWindow(String s, String t) {
        if (s == null || t == null || t.length() > s.length()) return "";

        String minWindow = "";

        int[] targetFrequencies = new int[52];
        Arrays.fill(targetFrequencies, 0);
        for (int i = 0; i < t.length(); i++) {
            char ch = t.charAt(i);
            int index = Character.isUpperCase(ch) ? ch - 'A' : ch - 'a' + 26;
            targetFrequencies[index]++;
        }

        int position = 0;
        int[] sourceFrequencies = new int[52];
        Arrays.fill(sourceFrequencies, 0);
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            int index = Character.isUpperCase(ch) ? ch - 'A' : ch - 'a' + 26;
            if (targetFrequencies[index] == 0) continue;
            sourceFrequencies[index]++;
            while (checkFrequencies(targetFrequencies, sourceFrequencies)) {
                String window = s.substring(position, i + 1);
                if (window.length() < minWindow.length() || minWindow.isEmpty()) minWindow = window;
                char chRemove = s.charAt(position);
                int indexRemove = Character.isUpperCase(chRemove) ? chRemove - 'A' : chRemove - 'a' + 26;
                if (targetFrequencies[indexRemove] != 0) sourceFrequencies[indexRemove]--;
                position++;
            }
        }

        return minWindow;
    }

    private boolean checkFrequencies(int[] targetFrequencies, int[] sourceFrequencies) {
        for (int i = 0; i < targetFrequencies.length; i++) {
            if (targetFrequencies[i] == 0) continue;
            if (sourceFrequencies[i] < targetFrequencies[i]) return false;
        }

        return true;
    }
}
