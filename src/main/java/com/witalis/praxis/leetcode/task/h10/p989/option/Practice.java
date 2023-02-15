package com.witalis.praxis.leetcode.task.h10.p989.option;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * ID: 989
 * Name: Add to Array-Form of Integer
 * URL: <a href="https://leetcode.com/problems/add-to-array-form-of-integer/">Add to Array-Form of Integer</a>
 * Note: try to find the better solution (without timing)
 */
@Slf4j
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Practice {
    private int[] numbers;
    private int summand;

    public List<Integer> process() {
        return addToArrayForm(numbers, summand);
    }

    public List<Integer> addToArrayForm(int[] num, int k) {
        if (num == null) return Collections.emptyList();

        final List<Integer> digits = new ArrayList<>();

        int position = num.length - 1;
        int overflow = 0;
        while (k > 0 || position >= 0) {
            int sum = overflow;
            if (k > 0) {
                sum += k % 10;
                k /= 10;
            }
            if (position >= 0) {
                sum += num[position--];
            }
            overflow = sum > 9 ? 1 : 0;
            digits.add(sum % 10);
        }
        if (overflow == 1) digits.add(1);
        Collections.reverse(digits);

        return digits;
    }
}
