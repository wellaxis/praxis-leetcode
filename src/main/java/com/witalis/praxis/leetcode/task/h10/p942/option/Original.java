package com.witalis.praxis.leetcode.task.h10.p942.option;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

/**
 * ID: 942
 * Name: DI String Match
 * URL: <a href="https://leetcode.com/problems/di-string-match/">DI String Match</a>
 * Note: the real test solution (code writing with timing)
 */
@Slf4j
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Original {
    private String string;

    public int[] process() {
        return diStringMatch(string);
    }

    public int[] diStringMatch(String s) {
        if (s == null) return new int[0];

        final int len = s.length();
        final int[] answer = new int[s.length() + 1];

        int min = 0;
        int max = len;
        for (int i = 0; i < answer.length; i++) {
            if (i == answer.length - 1) {
                answer[i] = min;
            } else {
                final char letter = s.charAt(i);
                if (letter == 'D') {
                    answer[i] = max--;
                } else if (letter == 'I') {
                    answer[i] = min++;
                }
            }
        }

        return answer;
    }
}
