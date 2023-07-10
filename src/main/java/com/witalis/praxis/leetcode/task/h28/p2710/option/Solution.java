package com.witalis.praxis.leetcode.task.h28.p2710.option;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

/**
 * ID: 2710
 * Name: Remove Trailing Zeros From a String
 * URL: <a href="https://leetcode.com/problems/remove-trailing-zeros-from-a-string/">Remove Trailing Zeros From a String</a>
 * Note: the best found solution (external programming)
 */
@Slf4j
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Solution {
    private String number;

    public String process() {
        return removeTrailingZeros(number);
    }

    public String removeTrailingZeros(String num) {
        for (int i = num.length() - 1; i >= 0; i--) {
            if (num.charAt(i) != '0') return num.substring(0, i + 1);
        }

        return num;
    }
}
