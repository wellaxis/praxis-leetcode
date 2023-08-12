package com.witalis.praxis.leetcode.task.h5.p413.option;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

/**
 * ID: 413
 * Name: Arithmetic Slices
 * URL: <a href="https://leetcode.com/problems/arithmetic-slices/">Arithmetic Slices</a>
 * Note: try to find the better solution (without timing)
 */
@Slf4j
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Practice {
    private int[] numbers;

    public Integer process() {
        return numberOfArithmeticSlices(numbers);
    }

    public int numberOfArithmeticSlices(int[] nums) {
        if (nums == null || nums.length < 3) return 0;

        int slices = 0;
        int difference = nums[1] - nums[0];
        int sequence = 2;
        for (int i = 2;  i < nums.length; i++) {
            if (nums[i] - nums[i - 1] == difference) {
                sequence++;
            } else {
                slices += (sequence - 1) * (sequence - 2) / 2;
                sequence = 2;
                difference = nums[i] - nums[i - 1];
            }
        }
        if (sequence > 2)
            slices += (sequence - 1) * (sequence - 2) / 2;

        return slices;
    }
}
