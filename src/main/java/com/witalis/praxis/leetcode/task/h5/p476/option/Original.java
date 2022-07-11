package com.witalis.praxis.leetcode.task.h5.p476.option;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

/**
 * ID: 476
 * Name: Number Complement
 * URL: <a href="https://leetcode.com/problems/number-complement/">Number Complement</a>
 * Note: the real test solution (code writing with timing)
 */
@Slf4j
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Original {
    private int number;

    public Integer process() {
        return findComplement(number);
    }

    public int findComplement(int num) {
        if (num < 0) throw new IllegalArgumentException("Incorrect input number");

        int ans = 0;
        int pow = 0;
        while (num > 0) {
            if (num % 2 == 0) {
                ans += (int) Math.pow(2, pow);
            }
            pow++;
            num /= 2;
        }

        return ans;
    }
}
