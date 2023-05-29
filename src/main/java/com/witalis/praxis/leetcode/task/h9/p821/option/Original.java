package com.witalis.praxis.leetcode.task.h9.p821.option;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

/**
 * ID: 821
 * Name: Shortest Distance to a Character
 * URL: <a href="https://leetcode.com/problems/shortest-distance-to-a-character/">Shortest Distance to a Character</a>
 * Note: the real test solution (code writing with timing)
 */
@Slf4j
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Original {
    private String string;
    private char character;

    public int[] process() {
        return shortestToChar(string, character);
    }

    public int[] shortestToChar(String s, char c) {
        if (s == null || s.isEmpty()) return new int[0];

        final int n = s.length();
        final int[] answer = new int[n];

        // direct traverse
        int distance = Integer.MAX_VALUE;
        for (int i = 0; i < n; i++) {
            if (s.charAt(i) == c) distance = 0;
            answer[i] = distance;
            if (distance != Integer.MAX_VALUE) distance++;
        }

        // reverse traverse
        distance = Integer.MAX_VALUE;
        for (int i = n - 1; i >= 0; i--) {
            if (s.charAt(i) == c) distance = 0;
            answer[i] = Math.min(answer[i], distance);
            if (distance != Integer.MAX_VALUE) distance++;
        }

        return answer;
    }
}
