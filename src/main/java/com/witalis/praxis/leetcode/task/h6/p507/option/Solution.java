package com.witalis.praxis.leetcode.task.h6.p507.option;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

/**
 * ID: 507
 * Name: Perfect Number
 * URL: <a href="https://leetcode.com/problems/perfect-number/">Perfect Number</a>
 * Note: the best found solution (external programming)
 */
@Slf4j
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Solution {
    private int number;

    public Boolean process() {
        return checkPerfectNumber(number);
    }

    public boolean checkPerfectNumber(int num) {
        if (num <= 0) return false;

        int sum = 0;
        for (int i = 1; i * i <= num; i++) {
            if (num % i == 0) {
                sum += i;
                if (i * i != num) sum += num / i;
            }
        }

        return sum - num == num;
    }

    // Euclid-Euler Theorem
    public boolean checkPerfectNumberEuler(int num) {
        int[] primes = new int[] {2, 3, 5, 7, 13, 17, 19, 31};
        for (int prime : primes) {
            if (pn(prime) == num) return true;
        }
        return false;
    }

    private int pn(int p) {
        return (1 << (p - 1)) * ((1 << p) - 1);
    }
}
