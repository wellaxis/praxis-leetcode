package com.witalis.praxis.leetcode.task.h7.p645.option;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.util.Arrays;

/**
 * ID: 645
 * Name: Set Mismatch
 * URL: <a href="https://leetcode.com/problems/set-mismatch/">Set Mismatch</a>
 * Note: try to find the better solution (without timing)
 */
@Slf4j
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Practice {
    private int[] numbers;

    public int[] process() {
        return findErrorNums(numbers);
    }

    public int[] findErrorNums(int[] nums) {
        if (nums == null || nums.length == 0) return new int[0];

        int[] errorNums = new int[2];

        Arrays.sort(nums);
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] == nums[i - 1]) errorNums[0] = nums[i];
            if (nums[i] == nums[i - 1] + 2) errorNums[1] = nums[i] - 1;
            if (errorNums[0] != 0 && errorNums[1] != 0) return errorNums;
        }
        if (errorNums[1] == 0) errorNums[1] = nums[0] == 1 ? nums.length : 1;

        return errorNums;
    }
}
