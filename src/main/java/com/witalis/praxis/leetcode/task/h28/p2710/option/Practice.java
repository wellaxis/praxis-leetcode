package com.witalis.praxis.leetcode.task.h28.p2710.option;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

/**
 * ID: 2710
 * Name: Remove Trailing Zeros From a String
 * URL: <a href="https://leetcode.com/problems/remove-trailing-zeros-from-a-string/">Remove Trailing Zeros From a String</a>
 * Note: try to find the better solution (without timing)
 */
@Slf4j
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Practice {
    private String number;

    public String process() {
        return removeTrailingZeros(number);
    }

    public String removeTrailingZeros(String num) {
        if (num == null || num.isEmpty()) return num;

        int index = num.length() - 1;
        while (index >= 0 && num.charAt(index) == '0')
            index--;

        return num.substring(0, index + 1);
    }
}
