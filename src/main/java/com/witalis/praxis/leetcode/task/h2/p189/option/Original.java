package com.witalis.praxis.leetcode.task.h2.p189.option;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

/**
 * ID: 189
 * Name: Rotate Array
 * URL: <a href="https://leetcode.com/problems/rotate-array/">Rotate Array</a>
 * Note: the real test solution (code writing with timing)
 */
@Slf4j
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Original {
    private int[] numbers;
    private int steps;

    public int[] process() {
        rotate(numbers, steps);
        return numbers;
    }

    public void rotate(int[] nums, int k) {
        if (nums == null || nums.length <= 1 || k <= 0 || k == nums.length) return;

        int len = nums.length;
        k %= len;
        if (k <= len / 2) {
            reverse(nums, 0, k - 1);
            reverse(nums, k, len - 1);
            reverse(nums, 0, 2 * k - 1);
            reverse(nums, 2 * k, len - 1);
        } else {
            reverse(nums, k, len - 1);
            reverse(nums, 0, k - 1);
            reverse(nums, 2 * k - len, len - 1);
            reverse(nums, 0, 2 * k - len - 1);
        }
    }

    private static void reverse(int[] nums, int i, int j) {
        while (i < j) {
            int tmp = nums[i];
            nums[i] = nums[j];
            nums[j] = tmp;
            i++;
            j--;
        }
    }
}
