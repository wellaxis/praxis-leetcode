package com.witalis.praxis.leetcode.task.h6.p561.option;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

/**
 * ID: 561
 * Name: Array Partition
 * URL: <a href="https://leetcode.com/problems/array-partition/">Array Partition</a>
 * Note: the best found solution (external programming)
 */
@Slf4j
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Solution {
    private int[] numbers;

    public Integer process() {
        return arrayPairSum(numbers);
    }

    public static final int K = 10000;

    public int arrayPairSum(int[] nums) {
        int[] elementToCount = new int[2 * K + 1];

        for (int element : nums) {
            elementToCount[element + K]++;
        }

        int maxSum = 0;
        boolean isEvenIndex = true;
        for (int element = 0; element <= 2 * K; element++) {
            while (elementToCount[element] > 0) {
                maxSum += (isEvenIndex ? element - K : 0);
                isEvenIndex = !isEvenIndex;
                elementToCount[element]--;
            }
        }

        return maxSum;
    }
}
