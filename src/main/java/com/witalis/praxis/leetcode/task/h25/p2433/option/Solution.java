package com.witalis.praxis.leetcode.task.h25.p2433.option;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

/**
 * ID: 2433
 * Name: Find The Original Array of Prefix Xor
 * URL: <a href="https://leetcode.com/problems/find-the-original-array-of-prefix-xor/">Find The Original Array of Prefix Xor</a>
 * Note: the best found solution (external programming)
 */
@Slf4j
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Solution {
    private int[] numbers;

    public int[] process() {
        return findArray(numbers);
    }

    public int[] findArray(int[] pref) {
        int n = pref.length;

        for (int i = n - 1; i > 0; i--) {
            pref[i] = pref[i] ^ pref[i - 1];
        }

        return pref;
    }
}
