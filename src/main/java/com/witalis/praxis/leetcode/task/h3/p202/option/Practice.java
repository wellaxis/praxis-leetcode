package com.witalis.praxis.leetcode.task.h3.p202.option;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.util.HashSet;
import java.util.Set;

/**
 * ID: 202
 * Name: Happy Number
 * URL: https://leetcode.com/problems/happy-number/
 * Note: try to find the better solution (without timing)
 */
@Slf4j
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Practice {
    private int number;

    public Boolean process() {
        return isHappy(number);
    }

    public boolean isHappy(int n) {
        if (n < 1) return false;

        Set<Integer> cache = new HashSet<>();

        while (true) {
            int sum = 0;

            while (n > 0) {
                int digit = n % 10;
                sum += digit * digit;
                n /= 10;
            }

            n = sum;

            if (n == 1) return true;
            if (cache.contains(n)) return false;

            cache.add(n);
        }
    }
}
