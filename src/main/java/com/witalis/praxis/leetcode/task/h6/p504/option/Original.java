package com.witalis.praxis.leetcode.task.h6.p504.option;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

/**
 * ID: 504
 * Name: Base 7
 * URL: <a href="https://leetcode.com/problems/base-7/">Base 7</a>
 * Note: the real test solution (code writing with timing)
 */
@Slf4j
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Original {
    private int number;

    public String process() {
        return convertToBase7(number);
    }

    public String convertToBase7(int num) {
        if (Math.abs(num) < 7) return String.valueOf(num);

        StringBuilder base7 = new StringBuilder();
        int sign = Integer.signum(num);
        num = Math.abs(num);

        while (num > 0) {
            int mod = num % 7;
            base7.append(mod);
            num /= 7;
        }

        String result = base7.reverse().toString();
        return (sign > 0) ? result : "-" + result;
    }
}
