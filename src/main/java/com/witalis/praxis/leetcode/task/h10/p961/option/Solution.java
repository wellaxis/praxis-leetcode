package com.witalis.praxis.leetcode.task.h10.p961.option;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

/**
 * ID: 961
 * Name: N-Repeated Element in Size 2N Array
 * URL: <a href="https://leetcode.com/problems/n-repeated-element-in-size-2n-array/">N-Repeated Element in Size 2N Array</a>
 * Note: the best found solution (external programming)
 */
@Slf4j
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Solution {
    private int[] numbers;

    public Integer process() {
        return repeatedNTimes(numbers);
    }

    public int repeatedNTimes(int[] nums) {
        for (int k = 1; k <= 3; ++k)
            for (int i = 0; i < nums.length - k; ++i)
                if (nums[i] == nums[i+k])
                    return nums[i];

        throw new IllegalArgumentException("Nums array is incorrect");
    }
}
