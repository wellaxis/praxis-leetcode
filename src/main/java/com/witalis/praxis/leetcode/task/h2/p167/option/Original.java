package com.witalis.praxis.leetcode.task.h2.p167.option;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

/**
 * ID: 167
 * Name: Two Sum II - Input Array Is Sorted
 * URL: <a href="https://leetcode.com/problems/two-sum-ii-input-array-is-sorted/">Two Sum II - Input Array Is Sorted</a>
 * Note: the real test solution (code writing with timing)
 */
@Slf4j
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Original {
    private int[] numbers;
    private int target;

    public int[] process() {
        return twoSum(numbers, target);
    }

    public int[] twoSum(int[] numbers, int target) {
        if (numbers == null || numbers.length < 2) return new int[0];

        int left = 0;
        int right = numbers.length - 1;
        while (left <= right) {
            int sum = numbers[left] + numbers[right];
            if (sum < target) {
                left++;
            } else if (sum > target) {
                right--;
            } else {
                return new int[] {left + 1, right + 1};
            }
        }

        return new int[0];
    }
}
