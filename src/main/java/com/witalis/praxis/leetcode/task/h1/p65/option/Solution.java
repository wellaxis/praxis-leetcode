package com.witalis.praxis.leetcode.task.h1.p65.option;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

/**
 * ID: 65
 * Name: Valid Number
 * URL: https://leetcode.com/problems/valid-number/
 * Note: the best found solution (external programming)
 */
@Slf4j
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Solution {
    private String string;

    public Boolean process() {
        return isNumber(string);
    }

    public boolean isNumber(String s) {
        if (s == null) return false;

        final String regex = "[-+]?(\\d+\\.?|\\.\\d+)\\d*(e[-+]?\\d+)?";
        return s.trim().toLowerCase().matches(regex);
    }
}
