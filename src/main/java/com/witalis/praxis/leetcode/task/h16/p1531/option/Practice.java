package com.witalis.praxis.leetcode.task.h16.p1531.option;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.util.Arrays;

/**
 * ID: 1531
 * Name: String Compression II
 * URL: <a href="https://leetcode.com/problems/string-compression-ii/">String Compression II</a>
 * Note: try to find the better solution (without timing)
 */
@Slf4j
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Practice {
    private String string;
    private int removes;

    public Practice(String string, int removes) {
        this.string = string;
        this.removes = removes;
    }

    public Integer process() {
        return getLengthOfOptimalCompression(string, removes);
    }

    private int[][] dp;

    public int getLengthOfOptimalCompression(String s, int k) {
        if (s == null || s.isEmpty() || k < 0) return 0;

        final char[] letters = s.toCharArray();
        final int n = letters.length;
        this.dp = new int[n][k + 1];
        for (int[] row : dp)
            Arrays.fill(row, -1);

        return solver(letters, k, 0);
    }

    private int solver(char[] letters, int removes, int index) {
        final int n = letters.length;

        if (removes < 0) return n;
        if (n <= index + removes) return 0;

        int minLength = dp[index][removes];
        if (minLength != -1) return minLength;

        minLength = solver(letters, removes - 1, index + 1);

        int length = 0;
        int same = 0;
        int diff = 0;
        for (int i = index; i < n && diff <= removes; i++) {
            if (letters[i] == letters[index]) {
                same++;
                if (same <= 2 || same == 10 || same == 100) length++;
            } else {
                diff++;
            }
            int nextLength = solver(letters, removes - diff, i + 1);
            minLength = Math.min(minLength, length + nextLength);
        }
        dp[index][removes] = minLength;

        return minLength;
    }
}
