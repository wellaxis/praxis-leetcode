package com.witalis.praxis.leetcode.task.h19.p1877.option;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

/**
 * ID: 1877
 * Name: Minimize Maximum Pair Sum in Array
 * URL: <a href="https://leetcode.com/problems/minimize-maximum-pair-sum-in-array/">Minimize Maximum Pair Sum in Array</a>
 * Note: the best found solution (external programming)
 */
@Slf4j
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Solution {
    private int[] numbers;

    public Integer process() {
        return minPairSum(numbers);
    }

    public int minPairSum(int[] nums) {
        int max = Integer.MIN_VALUE;

        int sum = 0;
        for (int i : nums) {
            max = Math.max(max, i);
        }

        int[] buckets = new int[max + 1];
        for (int i : nums) {
            buckets[i]++;
        }

        int l = 1;
        int r = max;
        while (l <= r) {
            while (buckets[l] == 0) l++;
            while (buckets[r] == 0) r--;

            sum = Math.max(sum, l + r);

            if (buckets[l] > buckets[r]) {
                buckets[l] = buckets[l] - buckets[r];
                r--;
            } else if (buckets[l] < buckets[r]) {
                buckets[r] = buckets[r] - buckets[l];
                l++;
            } else {
                l++;
                r--;
            }
        }

        return sum;
    }
}
