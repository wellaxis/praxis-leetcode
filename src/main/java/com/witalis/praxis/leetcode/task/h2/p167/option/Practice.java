package com.witalis.praxis.leetcode.task.h2.p167.option;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

/**
 * ID: 167
 * Name: Two Sum II - Input Array Is Sorted
 * URL: <a href="https://leetcode.com/problems/two-sum-ii-input-array-is-sorted/">Two Sum II - Input Array Is Sorted</a>
 * Note: try to find the better solution (without timing)
 */
@Slf4j
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Practice {
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
            if (numbers[left] + numbers[right] == target) return new int[] {left + 1, right + 1};

            if (numbers[left] + numbers[right] < target) {
                left++;
            } else {
                right--;
            }
        }

        return new int[] {-1, -1};
    }
}
