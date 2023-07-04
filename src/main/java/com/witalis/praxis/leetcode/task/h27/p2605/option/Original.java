package com.witalis.praxis.leetcode.task.h27.p2605.option;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

/**
 * ID: 2605
 * Name: Form Smallest Number From Two Digit Arrays
 * URL: <a href="https://leetcode.com/problems/form-smallest-number-from-two-digit-arrays/">Form Smallest Number From Two Digit Arrays</a>
 * Note: the real test solution (code writing with timing)
 */
@Slf4j
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Original {
    private int[] numbers1;
    private int[] numbers2;

    public Integer process() {
        return minNumber(numbers1, numbers2);
    }

    public int minNumber(int[] nums1, int[] nums2) {
        if (nums1 == null || nums2 == null) return 0;

        int minNumber = Integer.MAX_VALUE;

        final boolean[] values = new boolean[10];

        int min1 = 10;
        for (int num : nums1) {
            min1 = Math.min(min1, num);
            values[num] = true;
        }

        int min2 = 10;
        for (int num : nums2) {
            min2 = Math.min(min2, num);
            if (values[num]) {
                minNumber = Math.min(minNumber, num);
            }
        }

        if (minNumber == Integer.MAX_VALUE) {
            minNumber = Math.min(min1, min2) * 10 + Math.max(min1, min2);
        }

        return minNumber;
    }
}
