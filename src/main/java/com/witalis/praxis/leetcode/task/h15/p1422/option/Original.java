package com.witalis.praxis.leetcode.task.h15.p1422.option;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

/**
 * ID: 1422
 * Name: Maximum Score After Splitting a String
 * URL: <a href="https://leetcode.com/problems/maximum-score-after-splitting-a-string/">Maximum Score After Splitting a String</a>
 * Note: the real test solution (code writing with timing)
 */
@Slf4j
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Original {
    private String string;

    public Integer process() {
        return maxScore(string);
    }

    public int maxScore(String s) {
        if (s == null || s.isEmpty()) return 0;

        final int n = s.length();

        int totalZeroes = 0;
        int totalOnes = 0;
        for (int i = 0; i < n; i++)
            if (s.charAt(i) == '0')
                totalZeroes++;
            else
                totalOnes++;

        int maxScore = 0;
        int zeroes = 0;
        int ones = totalOnes;
        for (int i = 0; i < n - 1; i++) {
            final char letter = s.charAt(i);

            if (letter == '0')
                zeroes++;
            else
                ones--;
            maxScore = Math.max(maxScore, zeroes + ones);
        }

        return maxScore;
    }
}
