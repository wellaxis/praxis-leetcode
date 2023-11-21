package com.witalis.praxis.leetcode.task.h19.p1814.option;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.util.HashMap;
import java.util.Map;

/**
 * ID: 1814
 * Name: Count Nice Pairs in an Array
 * URL: <a href="https://leetcode.com/problems/count-nice-pairs-in-an-array/">Count Nice Pairs in an Array</a>
 * Note: the real test solution (code writing with timing)
 */
@Slf4j
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Original {
    private int[] numbers;

    public Integer process() {
        return countNicePairs(numbers);
    }

    public int countNicePairs(int[] nums) {
        if (nums == null) return 0;

        final int MOD = (int) 1e9 + 7;

        int pairs = 0;

        Map<Integer, Integer> frequencies = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int difference = nums[i] - reverse(nums[i]);
            pairs = (pairs % MOD + frequencies.getOrDefault(difference, 0) % MOD) % MOD;
            frequencies.put(difference, frequencies.getOrDefault(difference, 0) + 1);
        }

        return pairs;
    }

    private int reverse(int num) {
        int reversed = 0;
        while (num > 0) {
            int digit = num % 10;
            reversed = reversed * 10 + digit;
            num /= 10;
        }

        return reversed;
    }
}
