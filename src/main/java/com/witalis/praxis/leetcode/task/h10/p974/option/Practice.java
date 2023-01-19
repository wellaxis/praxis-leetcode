package com.witalis.praxis.leetcode.task.h10.p974.option;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.util.HashMap;
import java.util.Map;

/**
 * ID: 974
 * Name: Subarray Sums Divisible by K
 * URL: <a href="https://leetcode.com/problems/subarray-sums-divisible-by-k/">Subarray Sums Divisible by K</a>
 * Note: try to find the better solution (without timing)
 */
@Slf4j
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Practice {
    private int[] numbers;
    private int denominator;

    public Integer process() {
        return subarraysDivByK(numbers, denominator);
    }

    public int subarraysDivByK(int[] nums, int k) {
        if (nums == null || nums.length == 0) return 0;

        int len = nums.length;
        final int[] prefixes = new int[len];
        prefixes[0] = nums[0];
        for (int i = 1; i < len; i++) {
            prefixes[i] = nums[i] + prefixes[i - 1];
        }

        final int[] groups = new int[k];
        groups[0] = 1;
        int count = 0;
        for (int prefix : prefixes) {
            int mod = prefix % k;
            if (mod < 0) mod += k;
            count += groups[mod];
            groups[mod]++;
        }

        return count;
    }
}