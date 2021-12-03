package com.witalis.praxis.leetcode.task.p31.option;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

/**
 * ID: 31
 * Name: Next Permutation
 * URL: https://leetcode.com/problems/next-permutation/
 * Note: the real test solution (code writing with timing)
 */
@Slf4j
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Original {
    private int[] numbers;

    public int[] process() {
        nextPermutation(numbers);
        return numbers;
    }

    public void nextPermutation(int[] nums) {
        if (nums == null || nums.length <= 1) return;

        for (int i = nums.length - 2; i >= 0; i--) {
            int num = nums[i];
            if (nums[i] < nums[nums.length - 1]) {
                for (int j = i + 1; j <= nums.length - 1; j++) {
                    if (nums[i] < nums[j]) {
                        nums[i] = nums[j];
                        nums[j] = num;
                        return;
                    }
                }
                return;
            } else {
                for (int j = i; j < nums.length - 1; j++) {
                    nums[j] = nums[j + 1];
                }
                nums[nums.length - 1] = num;
            }
        }
    }
}
