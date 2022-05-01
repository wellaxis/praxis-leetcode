package com.witalis.praxis.leetcode.task.h7.p650.option;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

/**
 * ID: 650
 * Name: 2 Keys Keyboard
 * URL: <a href="https://leetcode.com/problems/2-keys-keyboard/">2 Keys Keyboard</a>
 * Note: try to find the better solution (without timing)
 */
@Slf4j
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Practice {
    private int number;

    public Integer process() {
        return minSteps(number);
    }

    public int minSteps(int n) {
        if (n <= 1) return 0;

        int sum = 0;
        int div = 2;
        while (n > 1 && div <= n) {
            while (n % div == 0) {
                sum += div;
                n /= div;
            }
            div++;
        }

        return sum;
    }
}
