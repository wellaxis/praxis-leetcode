package com.witalis.praxis.leetcode.task.h6.p507.option;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

/**
 * ID: 507
 * Name: Perfect Number
 * URL: <a href="https://leetcode.com/problems/perfect-number/">Perfect Number</a>
 * Note: try to find the better solution (without timing)
 */
@Slf4j
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Practice {
    private int number;

    public Boolean process() {
        return checkPerfectNumber(number);
    }

    public boolean checkPerfectNumber(int num) {
        if (num <= 1) return false;

        int sum = 1;

        int counter = 2;
        int limit = num / 2;
        while (counter < limit) {
            if (num % counter == 0) {
                sum += counter + (num / counter);
                if (sum > num) return false;
                limit = num / counter;
            }
            counter++;
        }

        return sum == num;
    }
}
