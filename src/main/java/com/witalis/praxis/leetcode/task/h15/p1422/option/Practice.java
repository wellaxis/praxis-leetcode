package com.witalis.praxis.leetcode.task.h15.p1422.option;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

/**
 * ID: 1422
 * Name: Maximum Score After Splitting a String
 * URL: <a href="https://leetcode.com/problems/maximum-score-after-splitting-a-string/">Maximum Score After Splitting a String</a>
 * Note: try to find the better solution (without timing)
 */
@Slf4j
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Practice {
    private String string;

    public Integer process() {
        return maxScore(string);
    }

    public int maxScore(String s) {
        if (s == null || s.isEmpty()) return 0;

        final char[] letters = s.toCharArray();
        final int n = letters.length;

        int totalOnes = 0;
        for (char letter : letters)
            if (letter == '1')
                totalOnes++;

        int maxScore = 0;

        int zeroes = 0;
        int ones = totalOnes;
        for (int i = 0; i < n - 1; i++) {
            if (letters[i] == '0')
                zeroes++;
            else
                ones--;

            if (zeroes + ones > maxScore)
                maxScore = zeroes + ones;
        }

        return maxScore;
    }
}
