package com.witalis.praxis.leetcode.task.h1.p12.option;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

/**
 * ID: 12
 * Name: Integer to Roman
 * URL: <a href="https://leetcode.com/problems/integer-to-roman/">Integer to Roman</a>
 * Note: the best found solution (external programming)
 */
@Slf4j
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Solution {
    private Integer number;

    public String process() {
        return intToRoman(number);
    }

    public String intToRoman(int num) {
        String[] romans = {"I", "IV", "V", "IX", "X", "XL", "L", "XC", "C", "CD", "D", "CM", "M"};
        int[] value = {1, 4, 5, 9, 10, 40, 50, 90, 100, 400, 500, 900, 1000};

        String ans = "";

        int seqSize = romans.length;
        int idx = seqSize - 1;
        while (num > 0) {
            while (value[idx] <= num) {
                ans += romans[idx];
                num -= value[idx];
            }
            idx--;
        }
        return ans;
    }
}
