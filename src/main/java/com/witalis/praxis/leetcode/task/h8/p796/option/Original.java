package com.witalis.praxis.leetcode.task.h8.p796.option;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

/**
 * ID: 796
 * Name: Rotate String
 * URL: <a href="https://leetcode.com/problems/rotate-string/">Rotate String</a>
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
        return rotateString(source, target);
    }

    public boolean rotateString(String s, String goal) {
        if (s == null || goal == null) return false;

        final int sLen = s.length();
        final int gLen = goal.length();

        if (sLen == 0 && gLen == 0) return true;
        if (sLen != gLen) return false;

        for (int i = 0; i < sLen; i++) {
            if (s.equals(goal.substring(i, gLen) + goal.substring(0, i)))
                return true;
        }

        return false;
    }
}
