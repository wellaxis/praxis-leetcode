package com.witalis.praxis.leetcode.task.h5.p414.option;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

/**
 * ID: 414
 * Name: Third Maximum Number
 * URL: <a href="https://leetcode.com/problems/third-maximum-number/">Third Maximum Number</a>
 * Note: try to find the better solution (without timing)
 */
@Slf4j
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Practice {
    private int[] numbers;

    public Integer process() {
        return thirdMax(numbers);
    }

    public int thirdMax(int[] nums) {
        if (nums == null || nums.length == 0) throw new IllegalArgumentException("array should be specified");

        long[] maximums = new long[] {Long.MIN_VALUE, Long.MIN_VALUE, Long.MIN_VALUE};

        for (int n : nums) {
            if (n == maximums[0] || n == maximums[1] || n == maximums[2]) continue;
            for (int i = 0; i < 3; i++) {
                if (n > maximums[i]) {
                    switch (i) {
                        case 0 -> {
                            maximums[2] = maximums[1];
                            maximums[1] = maximums[0];
                            maximums[0] = n;
                        }
                        case 1 -> {
                            maximums[2] = maximums[1];
                            maximums[1] = n;
                        }
                        case 2 -> {
                            maximums[2] = n;
                        }
                    }
                    break;
                }
            }
        }

        return (maximums[2] != Long.MIN_VALUE) ? (int) maximums[2] : (int) maximums[0];
    }
}
