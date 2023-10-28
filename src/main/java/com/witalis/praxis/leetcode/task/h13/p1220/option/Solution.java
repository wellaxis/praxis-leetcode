package com.witalis.praxis.leetcode.task.h13.p1220.option;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

/**
 * ID: 1220
 * Name: Count Vowels Permutation
 * URL: <a href="https://leetcode.com/problems/count-vowels-permutation/">Count Vowels Permutation</a>
 * Note: the best found solution (external programming)
 */
@Slf4j
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Solution {
    private int number;

    public Integer process() {
        return countVowelPermutation(number);
    }

    public int countVowelPermutation(int n) {
        final int MOD = 1000000007;

        long a = 1, e = 1, i = 1, o = 1, u = 1;

        for (int j = 1; j < n; j++) {
            long aNext = e;
            long eNext = (a + i) % MOD;
            long iNext = (a + e + o + u) % MOD;
            long oNext = (i + u) % MOD;
            long uNext = a;

            a = aNext;
            e = eNext;
            i = iNext;
            o = oNext;
            u = uNext;
        }

        return (int) ((a + e + i + o + u) % MOD);
    }
}
