package com.witalis.praxis.leetcode.task.h23.p2256.option;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.util.Arrays;
import java.util.IntSummaryStatistics;

/**
 * ID: 2256
 * Name: Minimum Average Difference
 * URL: <a href="https://leetcode.com/problems/minimum-average-difference/">Minimum Average Difference</a>
 * Note: the real test solution (code writing with timing)
 */
@Slf4j
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Original {
    private int[] numbers;

    public Integer process() {
        return minimumAverageDifference(numbers);
    }

    public int minimumAverageDifference(int[] nums) {
        if (nums == null || nums.length == 0) return -1;

        int index = -1;

        IntSummaryStatistics statistics = Arrays.stream(nums).summaryStatistics();
        long sum = statistics.getSum();
        long count = statistics.getCount();

        long currentSum = 0;
        long minDifference = Long.MAX_VALUE;
        for (int i = 0; i < count; i++) {
            currentSum += nums[i];

            long left = currentSum / (i + 1);
            long right = (sum - currentSum) / ((i == count - 1) ? 1 : (count - i - 1));

            int difference = (int) Math.abs(left - right);
            if (difference < minDifference) {
                minDifference = difference;
                index = i;
            }
        }

        return index;
    }
}
