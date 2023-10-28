package com.witalis.praxis.leetcode.task.h13.p1220.option;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.util.Arrays;

/**
 * ID: 1220
 * Name: Count Vowels Permutation
 * URL: <a href="https://leetcode.com/problems/count-vowels-permutation/">Count Vowels Permutation</a>
 * Note: try to find the better solution (without timing)
 */
@Slf4j
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Practice {
    private int number;

    public Integer process() {
        return countVowelPermutation(number);
    }

    public static final int MOD = (int) 1e9 + 7;

    public int countVowelPermutation(int n) {
        if (n <= 0) return 0;

        long[][] dp = new long[n + 1][5];

        Arrays.fill(dp[1], 1);

        for (int len = 2; len <= n; len++) {
            dp[len][0] = (dp[len - 1][1] + dp[len - 1][2] + dp[len - 1][4]) % MOD;
            dp[len][1] = (dp[len - 1][0] + dp[len - 1][2]) % MOD;
            dp[len][2] = (dp[len - 1][1] + dp[len - 1][3]) % MOD;
            dp[len][3] = dp[len - 1][2];
            dp[len][4] = (dp[len - 1][2] + dp[len - 1][3]) % MOD;
        }

        long count = 0;
        for (int i = 0; i < 5; i++) {
            count = (count + dp[n][i]) % MOD;
        }

        return (int) count;
    }
}
