package com.witalis.praxis.leetcode.task.h10.p974.option;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

/**
 * ID: 974
 * Name: Subarray Sums Divisible by K
 * URL: <a href="https://leetcode.com/problems/subarray-sums-divisible-by-k/">Subarray Sums Divisible by K</a>
 * Note: the real test solution (code writing with timing)
 */
@Slf4j
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Original {
    private int[] numbers;
    private int denominator;

    public Integer process() {
        return subarraysDivByK(numbers, denominator);
    }

    public int subarraysDivByK(int[] nums, int k) {
        if (nums == null || nums.length == 0) return 0;

        int len = nums.length;
        int[] prefixes = new int[len];
        prefixes[0] = nums[0];
        for (int i = 1; i < len; i++) {
            prefixes[i] = nums[i] + prefixes[i - 1];
        }

        int count = 0;
        for (int i = 0; i < len; i++) {
            for (int j = i; j < len; j++) {
                int sum = prefixes[j] - ((i == 0) ? 0 : prefixes[i - 1]);
                if (sum % k == 0) count++;
            }
        }

        return count;
    }
}