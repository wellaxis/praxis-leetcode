package com.witalis.praxis.leetcode.task.h5.p485.option;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

/**
 * ID: 485
 * Name: Max Consecutive Ones
 * URL: <a href="https://leetcode.com/problems/max-consecutive-ones/">Max Consecutive Ones</a>
 * Note: try to find the better solution (without timing)
 */
@Slf4j
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Practice {
    private int[] numbers;

    public Integer process() {
        return findMaxConsecutiveOnes(numbers);
    }

    public int findMaxConsecutiveOnes(int[] nums) {
        if (nums == null || nums.length == 0) return 0;

        int max = 0;
        int counter = 0;
        for (int num : nums) {
            if (num == 1) {
                counter++;
            } else {
                max = Math.max(max, counter);
                counter = 0;
            }
        }

        return Math.max(max, counter);
    }
}
