package com.witalis.praxis.leetcode.task.h3.p268.option;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.util.Arrays;

/**
 * ID: 268
 * Name: Missing Number
 * URL: <a href="https://leetcode.com/problems/missing-number/">Missing Number</a>
 * Note: try to find the better solution (without timing)
 */
@Slf4j
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Practice {
    private int[] numbers;

    public Integer process() {
        return missingNumber(numbers);
    }

    public int missingNumber(int[] nums) {
        if (nums == null) return 0;

        int progression = nums.length * (1 + nums.length) / 2;
        int sum = Arrays.stream(nums).sum();

        return progression - sum;
    }
}
