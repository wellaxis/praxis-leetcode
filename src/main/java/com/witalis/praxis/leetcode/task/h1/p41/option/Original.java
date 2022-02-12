package com.witalis.praxis.leetcode.task.h1.p41.option;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

/**
 * ID: 41
 * Name: First Missing Positive
 * URL: https://leetcode.com/problems/first-missing-positive/
 * Note: the real test solution (code writing with timing)
 */
@Slf4j
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Original {
    private int[] numbers;

    public Integer process() {
        return firstMissingPositive(numbers);
    }

    public int firstMissingPositive(int[] nums) {
        if (nums == null || nums.length == 0) return 1;

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] <= 0 || nums[i] > nums.length) {
                nums[i] = 0;
            }
        }

        for (int i = 0; i < nums.length; i++) {
            int value = nums[i];

            while (value > 0 && value != nums[value - 1]) {
                int next = nums[value - 1];
                nums[value - 1] = value;
                value = next;
                nums[i] = value;
            }
        }

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != i + 1) return i + 1;
        }

        return nums.length + 1;
    }
}
