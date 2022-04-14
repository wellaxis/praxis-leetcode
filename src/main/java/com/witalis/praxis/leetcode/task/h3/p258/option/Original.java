package com.witalis.praxis.leetcode.task.h3.p258.option;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

/**
 * ID: 258
 * Name: Add Digits
 * URL: <a href="https://leetcode.com/problems/add-digits/">Add Digits</a>
 * Note: the real test solution (code writing with timing)
 */
@Slf4j
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Original {
    private int number;

    public Integer process() {
        return addDigits(number);
    }

    public int addDigits(int num) {
        if (num <= 9) return num;

        while (num > 9) {
            num = num / 10 + num % 10;
        }

        return num;
    }
}
