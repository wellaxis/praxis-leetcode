package com.witalis.praxis.leetcode.task.h10.p942.option;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

/**
 * ID: 942
 * Name: DI String Match
 * URL: <a href="https://leetcode.com/problems/di-string-match/">DI String Match</a>
 * Note: try to find the better solution (without timing)
 */
@Slf4j
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Practice {
    private String string;

    public int[] process() {
        return diStringMatch(string);
    }

    public int[] diStringMatch(String s) {
        if (s == null) return new int[0];

        final int n = s.length();
        final int[] answer = new int[n + 1];
        final char[] letters = s.toCharArray();

        int min = 0;
        int max = n;
        int index = 0;
        for (final char letter : letters) {
            switch (letter) {
                case 'D' -> answer[index++] = max--;
                case 'I' -> answer[index++] = min++;
                default -> throw new IllegalStateException("Unexpected letter: " + letter);
            }
        }
        answer[index] = min;

        return answer;
    }
}
