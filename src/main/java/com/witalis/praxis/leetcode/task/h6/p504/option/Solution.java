package com.witalis.praxis.leetcode.task.h6.p504.option;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

/**
 * ID: 504
 * Name: Base 7
 * URL: https://leetcode.com/problems/base-7/
 * Note: the best found solution (external programming)
 */
@Slf4j
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Solution {
    private int number;

    public String process() {
        return convertToBase7(number);
    }

    public String convertToBase7(int num) {
        if (num < 0) return '-' + convertToBase7(-num);
        if (num < 7) return Integer.toString(num);

        return convertToBase7(num / 7) + num % 7;
    }
}
