package com.witalis.praxis.leetcode.task.h11.p1071.option;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

/**
 * ID: 1071
 * Name: Greatest Common Divisor of Strings
 * URL: <a href="https://leetcode.com/problems/greatest-common-divisor-of-strings/">Greatest Common Divisor of Strings</a>
 * Note: the best found solution (external programming)
 */
@Slf4j
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Solution {
    private String string1;
    private String string2;

    public String process() {
        return gcdOfStrings(string1, string2);
    }

    public String gcdOfStrings(String str1, String str2) {
        return "";
    }
}
