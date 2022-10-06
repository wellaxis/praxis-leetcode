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
 * Note: the real test solution (code writing with timing)
 */
@Slf4j
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Original {
    private int[] numbers;

    public int[] process() {
        return findErrorNums(numbers);
    }

    public int[] findErrorNums(int[] nums) {
        if (nums == null || nums.length == 0) return new int[0];

        int[] errorNums = new int[2];

        Arrays.sort(nums);

        boolean equality;
        boolean erroneous = false;
        for (int i = 0; i < nums.length; i++) {
            equality = (nums[i] ^ (i + 1)) == 0;
            if (!erroneous && !equality) {
                if (nums[i] > i + 1) {
                    // loss
                    errorNums[1] = i + 1;
                } else {
                    // duplicate
                    errorNums[0] = i;
                }
                erroneous = true;
            } else if (erroneous && equality) {
                if (errorNums[0] == 0) {
                    // duplicate
                    errorNums[0] = i + 1;
                } else {
                    // loss
                    errorNums[1] = i;
                }
                return errorNums;
            }
        }
        if (errorNums[1] == 0) errorNums[1] = nums[0] == 1 ? nums.length : 1;

        return errorNums;
    }
}
