package com.witalis.praxis.leetcode.task.h3.p238.option;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

/**
 * ID: 238
 * Name: Product of Array Except Self
 * URL: <a href="https://leetcode.com/problems/product-of-array-except-self/">Product of Array Except Self</a>
 * Note: the best found solution (external programming)
 */
@Slf4j
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Solution {
    private int[] numbers;

    public int[] process() {
        return productExceptSelf(numbers);
    }

    public int[] productExceptSelf(int[] nums) {
        int[] answer = new int[nums.length];

        answer[0] = 1;
        for (int i = 1; i < nums.length; i++) {
            answer[i] = answer[i - 1] * nums[i - 1];
        }

        int product = 1;
        for (int i = nums.length - 1; i >= 0; i--) {
            answer[i] = answer[i] * product;
            product *= nums[i];
        }

        return answer;
    }
}
