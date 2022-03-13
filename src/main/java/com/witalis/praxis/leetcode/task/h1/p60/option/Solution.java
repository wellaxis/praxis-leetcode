package com.witalis.praxis.leetcode.task.h1.p60.option;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

/**
 * ID: 60
 * Name: Permutation Sequence
 * URL: https://leetcode.com/problems/permutation-sequence/
 * Note: the best found solution (external programming)
 */
@Slf4j
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Solution {
    private int number;
    private int position;

    public String process() {
        return getPermutation(number, position);
    }

    public String getPermutation(int n, int k) {
        boolean[] output = new boolean[n];
        StringBuilder buffer = new StringBuilder("");

        int[] res = new int[n];
        res[0] = 1;

        for (int i = 1; i < n; i++)
            res[i] = res[i - 1] * i;

        for (int i = n - 1; i >= 0; i--) {
            int s = 1;

            while (k > res[i]) {
                s++;
                k = k - res[i];
            }

            for (int j = 0; j < n; j++) {
                if (j + 1 <= s && output[j]) {
                    s++;
                }
            }

            output[s - 1] = true;
            buffer.append(s);
        }

        return buffer.toString();
    }
}
