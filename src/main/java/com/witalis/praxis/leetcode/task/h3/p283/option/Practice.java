package com.witalis.praxis.leetcode.task.h3.p283.option;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

/**
 * ID: 283
 * Name: Move Zeroes
 * URL: https://leetcode.com/problems/move-zeroes/
 * Note: try to find the better solution (without timing)
 */
@Slf4j
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Practice {
    private int[] numbers;

    public int[] process() {
        moveZeroes(numbers);
        return numbers;
    }

    public void moveZeroes(int[] nums) {
        if (nums == null || nums.length <= 1) return;

        int index = -1;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0) {
                if (index < 0) index = i;
            } else {
                if (index >= 0) {
                    nums[index] = nums[i];
                    index++;
                }
            }
        }
        if (index > 0) {
            while (index < nums.length) nums[index++] = 0;
        }
    }
}
