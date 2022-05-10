package com.witalis.praxis.leetcode.task.h3.p238.option;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

/**
 * ID: 238
 * Name: Product of Array Except Self
 * URL: <a href="https://leetcode.com/problems/product-of-array-except-self/">Product of Array Except Self</a>
 * Note: the real test solution (code writing with timing)
 */
@Slf4j
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Original {
    private int[] numbers;

    public int[] process() {
        return productExceptSelf(numbers);
    }

    public int[] productExceptSelf(int[] nums) {
        if (nums == null || nums.length == 0) return nums;

        int[] answer = new int[nums.length];

        int[] prefix = new int[nums.length + 1];
        int[] suffix = new int[nums.length + 1];

        prefix[0] = 1;
        for (int i = 0; i < nums.length; i++) {
            prefix[i + 1] = prefix[i] * nums[i];
        }

        suffix[nums.length] = 1;
        for (int i = nums.length - 1; i >= 0; i--) {
            suffix[i] = suffix[i + 1] * nums[i];
        }

        for (int i = 0; i < nums.length; i++) {
            answer[i] = prefix[i] * suffix[i + 1];
        }

        return answer;
    }
}
