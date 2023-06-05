package com.witalis.praxis.leetcode.task.h9.p859.option;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

/**
 * ID: 859
 * Name: Buddy Strings
 * URL: <a href="https://leetcode.com/problems/buddy-strings/">Buddy Strings</a>
 * Note: try to find the better solution (without timing)
 */
@Slf4j
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Practice {
    private String source;
    private String target;

    public Boolean process() {
        return buddyStrings(source, target);
    }

    public boolean buddyStrings(String s, String goal) {
        if (s == null || goal == null) return false;

        final char[] cs = s.toCharArray();
        final char[] cg = goal.toCharArray();

        final int n = cs.length;
        final int m = cg.length;

        if (n != m) return false;

        int status = 0;
        final char[] swap = new char[2];
        final int[] frequencies = new int[26];
        for (int i = 0; i < n; i++) {
            final char si = cs[i];
            final char gi = cg[i];

            frequencies[si - 'a']++;

            if (si == gi) continue;

            if (status == 0) {
                swap[0] = si;
                swap[1] = gi;

                status = 1;
            } else if (status == 1) {
                if (swap[0] != gi || swap[1] != si) return false;

                status = 2;
            } else {
                return false;
            }
        }

        return switch (status) {
            case 0 -> checkFrequency(frequencies);
            case 1 -> false;
            case 2 -> true;
            default -> false;
        };
    }

    private static boolean checkFrequency(int[] frequencies) {
        for (int frequency : frequencies)
            if (frequency > 1)
                return true;
        return false;
    }
}
