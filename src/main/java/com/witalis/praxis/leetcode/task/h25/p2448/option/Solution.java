package com.witalis.praxis.leetcode.task.h25.p2448.option;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

/**
 * ID: 2448
 * Name: Minimum Cost to Make Array Equal
 * URL: <a href="https://leetcode.com/problems/minimum-cost-to-make-array-equal/">Minimum Cost to Make Array Equal</a>
 * Note: the best found solution (external programming)
 */
@Slf4j
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Solution {
    private int[] numbers;
    private int[] costs;

    public Long process() {
        return minCost(numbers, costs);
    }

    public static final int MAX_VALUE = 1_000_000;

    public long minCost(int[] nums, int[] cost) {
        // initialize the left and the right boundary of the binary search
        int left = MAX_VALUE + 1;
        int right = 0;
        for (int num : nums) {
            left = Math.min(left, num);
            right = Math.max(right, num);
        }
        long answer = getCost(nums, cost, nums[0]);

        // as shown in the previous picture, if F(mid) > F(mid + 1), then the minimum
        // is to the right of mid, otherwise, the minimum is to the left of mid
        while (left < right) {
            int mid = (right + left) / 2;
            long cost1 = getCost(nums, cost, mid);
            long cost2 = getCost(nums, cost, mid + 1);
            answer = Math.min(cost1, cost2);

            if (cost1 > cost2)
                left = mid + 1;
            else
                right = mid;
        }

        return answer;
    }

    private long getCost(int[] nums, int[] cost, int base) {
        long result = 0L;
        for (int i = 0; i < nums.length; ++i)
            result += (long) Math.abs(nums[i] - base) * cost[i];

        return result;
    }
}
