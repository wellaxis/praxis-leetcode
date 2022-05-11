package com.witalis.praxis.leetcode.task.h3.p260.option;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

/**
 * ID: 260
 * Name: Single Number III
 * URL: <a href="https://leetcode.com/problems/single-number-iii/">Single Number III</a>
 * Note: the real test solution (code writing with timing)
 */
@Slf4j
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Original {
    private int[] numbers;

    public int[] process() {
        return singleNumber(numbers);
    }

    public int[] singleNumber(int[] nums) {
        if (nums == null || nums.length == 0) return new int[2];

        // xor: a^a = 0. and: a&a = a.
        int one = 0;
        int two = 0;

        int xor = 0;
        for (int num : nums) {
            xor ^= num;
        }

        int bit = xor & (-xor);

        for (int i = 0; i < nums.length; i++) {
            if ((bit & nums[i]) > 0) {
                one ^= nums[i];
            } else {
                two ^= nums[i];
            }
        }

        return new int[] {one, two};
    }
}
