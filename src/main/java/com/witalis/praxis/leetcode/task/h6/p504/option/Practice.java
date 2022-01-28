package com.witalis.praxis.leetcode.task.h6.p504.option;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

/**
 * ID: 504
 * Name: Base 7
 * URL: https://leetcode.com/problems/base-7/
 * Note: try to find the better solution (without timing)
 */
@Slf4j
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Practice {
    private int number;

    public String process() {
        return convertToBase7(number);
    }

    public String convertToBase7(int num) {
        if (Math.abs(num) < 7) return Integer.toString(num);

        StringBuilder builder = new StringBuilder();
        int sign = Integer.signum(num);
        num = Math.abs(num);

        while (num > 0) {
            int mod = num % 7;
            builder.append(mod);
            num /= 7;
        }

        String base7 = builder.reverse().toString();
        return (sign > 0) ? base7 : "-" + base7;
    }
}
