package com.witalis.praxis.leetcode.task.h8.p796.option;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

/**
 * ID: 796
 * Name: Rotate String
 * URL: <a href="https://leetcode.com/problems/rotate-string/">Rotate String</a>
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
        return rotateString(source, target);
    }

    public boolean rotateString(String s, String goal) {
        if (s == null || goal == null) return false;
        if (s.length() == 0 && goal.length() == 0) return true;
        if (s.length() != goal.length()) return false;

        for (int i = 0; i < s.length(); i++)
            if (s.equals(goal.substring(i) + goal.substring(0, i)))
                return true;

        return false;
    }
}
