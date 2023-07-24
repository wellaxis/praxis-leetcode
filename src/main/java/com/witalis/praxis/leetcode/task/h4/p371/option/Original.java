package com.witalis.praxis.leetcode.task.h4.p371.option;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

/**
 * ID: 371
 * Name: Sum of Two Integers
 * URL: <a href="https://leetcode.com/problems/sum-of-two-integers/">Sum of Two Integers</a>
 * Note: the real test solution (code writing with timing)
 */
@Slf4j
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Original {
    private int number1;
    private int number2;

    public Integer process() {
        return getSum(number1, number2);
    }

    public int getSum(int a, int b) {
        while (b != 0) {
            int carry = (a & b);
            a = a ^ b;
            b = carry << 1;
        }

        return a;
    }
}
