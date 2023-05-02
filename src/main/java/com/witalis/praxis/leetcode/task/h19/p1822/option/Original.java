package com.witalis.praxis.leetcode.task.h19.p1822.option;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

/**
 * ID: 1822
 * Name: Sign of the Product of an Array
 * URL: <a href="https://leetcode.com/problems/sign-of-the-product-of-an-array/">Sign of the Product of an Array</a>
 * Note: the real test solution (code writing with timing)
 */
@Slf4j
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Original {
    private int[] numbers;

    public Integer process() {
        return arraySign(numbers);
    }

    public int arraySign(int[] nums) {
        if (nums == null || nums.length == 0) return 0;

        int negatives = 0;
        for (int num : nums) {
            if (num == 0) return 0;
            if (num < 0) negatives++;
        }

        return (negatives % 2 == 0) ? 1 : -1;
    }
}
