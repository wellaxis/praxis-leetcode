package com.witalis.praxis.leetcode.task.h2.p167.option;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

/**
 * ID: 167
 * Name: Two Sum II - Input Array Is Sorted
 * URL: <a href="https://leetcode.com/problems/two-sum-ii-input-array-is-sorted/">Two Sum II - Input Array Is Sorted</a>
 * Note: the best found solution (external programming)
 */
@Slf4j
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Solution {
    private int[] numbers;
    private int target;

    public int[] process() {
        return twoSum(numbers, target);
    }

    public int[] twoSum(int[] numbers, int target) {
        int low = 0;
        int high = numbers.length - 1;

        int sum = numbers[low] + numbers[high];
        while (sum != target) {
            if (sum < target) low++;
            else high--;
            sum = numbers[low] + numbers[high];
        }

        return new int[] {low + 1, high + 1};
    }
}
