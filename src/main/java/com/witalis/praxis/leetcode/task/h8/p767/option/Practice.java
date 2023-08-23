package com.witalis.praxis.leetcode.task.h8.p767.option;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.util.Comparator;
import java.util.Deque;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * ID: 767
 * Name: Reorganize String
 * URL: <a href="https://leetcode.com/problems/reorganize-string/">Reorganize String</a>
 * Note: try to find the better solution (without timing)
 */
@Slf4j
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Practice {
    private String string;

    public String process() {
        return reorganizeString(string);
    }

    public String reorganizeString(String s) {
        if (s == null || s.isEmpty()) return "";

        int n = s.length();

        final int[] frequencies = new int[26];
        final char[] letters = s.toCharArray();
        for (char letter : letters)
            frequencies[letter - 'a']++;

        StringBuilder builder = new StringBuilder();
        int previousIndex = -1;
        while (n-- > 0) {
            int index = maxFrequencyIndex(frequencies, previousIndex);

            if (index == -1) return "";

            builder.append((char) (index + 'a'));
            frequencies[index]--;
            previousIndex = index;
        }

        return builder.toString();
    }

    private int maxFrequencyIndex(int[] frequencies, int previousIndex) {
        int n = frequencies.length;

        int index = -1;
        int maxFrequency = 0;
        for (int i = 0; i < n; i++) {
            if (i == previousIndex) continue;

            if (frequencies[i] > maxFrequency) {
                index = i;
                maxFrequency = frequencies[i];
            }
        }

        return index;
    }
}
