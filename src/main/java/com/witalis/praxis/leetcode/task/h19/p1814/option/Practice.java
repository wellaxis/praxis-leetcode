package com.witalis.praxis.leetcode.task.h19.p1814.option;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.util.HashMap;

/**
 * ID: 1814
 * Name: Count Nice Pairs in an Array
 * URL: <a href="https://leetcode.com/problems/count-nice-pairs-in-an-array/">Count Nice Pairs in an Array</a>
 * Note: try to find the better solution (without timing)
 */
@Slf4j
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Practice {
    private int[] numbers;

    public Integer process() {
        return countNicePairs(numbers);
    }

    public static final int MOD = 1_000_000_007;

    public int countNicePairs(int[] nums) {
        if (nums == null) return 0;

        int pairs = 0;

        final var frequencies = new HashMap<Integer, Integer>();
        for (int num : nums) {
            int difference = num - reverse(num);
            pairs = (pairs % MOD + frequencies.getOrDefault(difference, 0) % MOD) % MOD;
            frequencies.put(difference, frequencies.getOrDefault(difference, 0) + 1);
        }

        return pairs;
    }

    private static int reverse(int num) {
        int reversed = 0;
        while (num > 0) {
            int digit = num % 10;
            reversed = reversed * 10 + digit;
            num /= 10;
        }

        return reversed;
    }
}
