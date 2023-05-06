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
 * Note: the real test solution (code writing with timing)
 */
@Slf4j
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Original {
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
        long count = 0;

        for (int l = 0; l < n; l++) {
            final int left = nums[l];
            if (left * 2 > target) break;

            int r = n - 1;
            while (r >= l && left + nums[r] > target) r--;
            if (r >= l) {
                count += powerMod(2, r - l, MOD);
                count %= MOD;
            }
        }

        return (int) (count % MOD);
    }

    public static long powerMod(long base, long exp, long mod) {
        long result = 1;
        base %= mod;
        while (exp > 0) {
            if ((exp & 1) != 0)
                result = (result * base) % mod;
            exp >>= 1;
            base = base * base % mod;
        }
        return result < 0 ? result + mod : result;
    }
}
