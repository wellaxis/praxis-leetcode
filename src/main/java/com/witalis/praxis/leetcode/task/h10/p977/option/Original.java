package com.witalis.praxis.leetcode.task.h10.p977.option;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.util.Arrays;

/**
 * ID: 977
 * Name: Squares of a Sorted Array
 * URL: <a href="https://leetcode.com/problems/squares-of-a-sorted-array/">Squares of a Sorted Array</a>
 * Note: the real test solution (code writing with timing)
 */
@Slf4j
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Original {
    private int[] numbers;

    public int[] process() {
        return sortedSquares(numbers);
    }

    public int[] sortedSquares(int[] nums) {
        if (nums == null) return new int[0];

        for (int i = 0; i < nums.length; i++) {
            nums[i] = nums[i] * nums[i];
        }
        Arrays.sort(nums);

        return nums;
    }
}
