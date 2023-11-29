package com.witalis.praxis.leetcode.task.h30.p2903.option;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

/**
 * ID: 2903
 * Name: Find Indices With Index and Value Difference I
 * URL: <a href="https://leetcode.com/problems/find-indices-with-index-and-value-difference-i/">Find Indices With Index and Value Difference I</a>
 * Note: try to find the better solution (without timing)
 */
@Slf4j
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Practice {
    private int[] numbers;
    private int indexDifference;
    private int valueDifference;

    public int[] process() {
        return findIndices(numbers, indexDifference, valueDifference);
    }

    public int[] findIndices(int[] nums, int indexDifference, int valueDifference) {
        if (nums == null || indexDifference < 0 || valueDifference < 0) return new int[0];

        final int n = nums.length;

        for (int i = 0; i < n - indexDifference; i++)
            for (int j = i + indexDifference; j < n; j++)
                if (Math.abs(nums[i] - nums[j]) >= valueDifference)
                    return new int[] {i, j};

        return new int[] {-1, -1};
    }
}
