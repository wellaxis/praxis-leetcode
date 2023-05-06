package com.witalis.praxis.leetcode.task.h15.p1498.option;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.util.Arrays;

/**
 * ID: 1498
 * Name: Number of Subsequences That Satisfy the Given Sum Condition
 * URL: <a href="https://leetcode.com/problems/number-of-subsequences-that-satisfy-the-given-sum-condition/">Number of Subsequences That Satisfy the Given Sum Condition</a>
 * Note: try to find the better solution (without timing)
 */
@Slf4j
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Practice {
    private int[] numbers;
    private int target;

    public Integer process() {
        return numSubseq(numbers, target);
    }

    public static final int MOD = 1_000_000_007;

    public int numSubseq(int[] nums, int target) {
        if (nums == null || target <= 0) return 0;

        Arrays.sort(nums);

        final int n = nums.length;
        final int[] powers = powerMod(2, n, MOD);

        int count = 0;
        int l = 0;
        int r = n - 1;
        while (l <= r) {
            if (nums[l] * 2 > target) break;

            while (r >= l && nums[l] + nums[r] > target) r--;
            if (r >= l) {
                count += powers[r - l];
                count %= MOD;
                l++;
            }
        }

        return (count % MOD);
    }

    public static int[] powerMod(int base, int exp, int mod) {
        int[] powers = new int[exp];
        powers[0] = 1;
        for (int i = 1; i < exp; ++i)
            powers[i] = (powers[i - 1] * base) % mod;

        return powers;
    }
}
