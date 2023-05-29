package com.witalis.praxis.leetcode.task.h9.p821.option;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.util.Arrays;

/**
 * ID: 821
 * Name: Shortest Distance to a Character
 * URL: <a href="https://leetcode.com/problems/shortest-distance-to-a-character/">Shortest Distance to a Character</a>
 * Note: try to find the better solution (without timing)
 */
@Slf4j
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Practice {
    private String string;
    private char character;

    public int[] process() {
        return shortestToChar(string, character);
    }

    public int[] shortestToChar(String s, char c) {
        if (s == null || s.isEmpty()) return new int[0];

        final int n = s.length();
        final int[] answer = new int[n];
        Arrays.fill(answer, Integer.MAX_VALUE);

        // direct traverse
        int distance = -1;
        int i = 0;
        while (s.charAt(i) != c) i++;
        while (i < n) {
            if (s.charAt(i) == c) distance = 0;
            answer[i] = distance++;
            i++;
        }

        // reverse traverse
        distance = -1;
        i = n - 1;
        while (s.charAt(i) != c) i--;
        while (i >= 0) {
            if (s.charAt(i) == c) distance = 0;
            answer[i] = Math.min(answer[i], distance++);
            i--;
        }

        return answer;
    }
}
