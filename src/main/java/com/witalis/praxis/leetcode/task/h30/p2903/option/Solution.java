package com.witalis.praxis.leetcode.task.h30.p2903.option;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

/**
 * ID: 2903
 * Name: Find Indices With Index and Value Difference I
 * URL: <a href="https://leetcode.com/problems/find-indices-with-index-and-value-difference-i/">Find Indices With Index and Value Difference I</a>
 * Note: the best found solution (external programming)
 */
@Slf4j
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Solution {
    private int[] numbers;
    private int indexDifference;
    private int valueDifference;

    public int[] process() {
        return findIndices(numbers, indexDifference, valueDifference);
    }

    public int[] findIndices(int[] nums, int indexDifference, int valueDifference) {
        final int n = nums.length;

        int minIndex = 0;
        int maxIndex = 0;
        for (int i = indexDifference; i < n; i++) {
            if (nums[i - indexDifference] < nums[minIndex]) minIndex = i - indexDifference;
            if (nums[i - indexDifference] > nums[maxIndex]) maxIndex = i - indexDifference;

            if (nums[i] - nums[minIndex] >= valueDifference) return new int[] {minIndex, i};
            if (nums[maxIndex] - nums[i] >= valueDifference) return new int[] {maxIndex, i};
        }

        return new int[] {-1, -1};
    }
}
