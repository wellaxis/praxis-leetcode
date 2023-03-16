package com.witalis.praxis.leetcode.task.h8.p796.option;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

/**
 * ID: 796
 * Name: Rotate String
 * URL: <a href="https://leetcode.com/problems/rotate-string/">Rotate String</a>
 * Note: the best found solution (external programming)
 */
@Slf4j
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Solution {
    private String source;
    private String target;

    public Boolean process() {
        return rotateString(source, target);
    }

    public boolean rotateString(String s, String goal) {
        return s.length() == goal.length() && (s + s).contains(goal);
    }
}
