package com.witalis.praxis.leetcode.task.h9.p859.option;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

/**
 * ID: 859
 * Name: Buddy Strings
 * URL: <a href="https://leetcode.com/problems/buddy-strings/">Buddy Strings</a>
 * Note: the real test solution (code writing with timing)
 */
@Slf4j
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Original {
    private String source;
    private String target;

    public Boolean process() {
        return buddyStrings(source, target);
    }

    public enum Status { mismatch0, mismatch1, mismatch2 }

    public boolean buddyStrings(String s, String goal) {
        if (s == null || goal == null) return false;

        final int n = s.length();
        final int m = goal.length();

        if (n != m) return false;

        Status status = Status.mismatch0;
        char[] swap = new char[2];
        int[] frequencies = new int[26];
        for (int i = 0; i < n; i++) {
            final char si = s.charAt(i);
            final char gi = goal.charAt(i);

            frequencies[si - 'a']++;

            if (si == gi) continue;

            switch (status) {
                case mismatch0 -> {
                    swap[0] = si;
                    swap[1] = gi;
                    status = Status.mismatch1;
                }
                case mismatch1 -> {
                    if (swap[0] == gi && swap[1] == si)
                        status = Status.mismatch2;
                    else
                        return false;
                }
                case mismatch2 -> {
                    return false;
                }
            }
        }

        if (status == Status.mismatch1) return false;
        if (!s.equals(goal)) return true;

        for (int frequency : frequencies)
            if (frequency > 1)
                return true;

        return false;
    }
}
