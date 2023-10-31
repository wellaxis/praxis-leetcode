package com.witalis.praxis.leetcode.task.h25.p2433.option;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

/**
 * ID: 2433
 * Name: Find The Original Array of Prefix Xor
 * URL: <a href="https://leetcode.com/problems/find-the-original-array-of-prefix-xor/">Find The Original Array of Prefix Xor</a>
 * Note: try to find the better solution (without timing)
 */
@Slf4j
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Practice {
    private int[] numbers;

    public int[] process() {
        return findArray(numbers);
    }

    public int[] findArray(int[] pref) {
        if (pref == null) return new int[0];

        final int n = pref.length;

        int[] arr = new int[n];
        arr[0] = pref[0];
        for (int i = 1; i < n; i++)
            arr[i] = pref[i] ^ pref[i - 1];

        return arr;
    }
}
