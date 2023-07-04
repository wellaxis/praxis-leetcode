package com.witalis.praxis.leetcode.task.h27.p2605.option;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.util.BitSet;

/**
 * ID: 2605
 * Name: Form Smallest Number From Two Digit Arrays
 * URL: <a href="https://leetcode.com/problems/form-smallest-number-from-two-digit-arrays/">Form Smallest Number From Two Digit Arrays</a>
 * Note: try to find the better solution (without timing)
 */
@Slf4j
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Practice {
    private int[] numbers1;
    private int[] numbers2;

    public Integer process() {
        return minNumber(numbers1, numbers2);
    }

    public int minNumber(int[] nums1, int[] nums2) {
        if (nums1 == null || nums2 == null) return 0;

        int minNumber = Integer.MAX_VALUE;

        final BitSet bits = new BitSet(10);

        int min1 = 10;
        for (int num : nums1) {
            if (num < min1) min1 = num;
            bits.set(num);
        }

        int min2 = 10;
        for (int num : nums2) {
            if (num < min2) min2 = num;
            if (num < minNumber && bits.get(num)) minNumber = num;
        }

        if (minNumber != Integer.MAX_VALUE) return minNumber;

        return (min1 < min2) ? min1 * 10 + min2 : min2 * 10 + min1;
    }
}
