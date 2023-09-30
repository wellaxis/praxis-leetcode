package com.witalis.praxis.leetcode.task.h5.p456.option;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

/**
 * ID: 456
 * Name: 132 Pattern
 * URL: <a href="https://leetcode.com/problems/132-pattern/">132 Pattern</a>
 * Note: the real test solution (code writing with timing)
 */
@Slf4j
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Original {
    private int[] numbers;

    public Boolean process() {
        return find132pattern(numbers);
    }

    public boolean find132pattern(int[] nums) {
        if (nums == null || nums.length < 3) return false;

        final int n = nums.length;
        for (int i = 0; i < n; i++) {
            int a = nums[i];

            int max = Integer.MIN_VALUE;
            for (int j = i + 1; j < n; j++) {
                int b = nums[j];

                if (b <= a) continue;
                if (b < max) return true;

                max = b;
            }
        }

        return false;
    }
}
