package com.witalis.praxis.leetcode.task.h5.p414.option;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

/**
 * ID: 414
 * Name: Third Maximum Number
 * URL: <a href="https://leetcode.com/problems/third-maximum-number/">Third Maximum Number</a>
 * Note: the best found solution (external programming)
 */
@Slf4j
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Solution {
    private int[] numbers;

    public Integer process() {
        return thirdMax(numbers);
    }

    public int thirdMax(int[] nums) {
        long max = Long.MIN_VALUE, mid = max, min = max;

        for (int num : nums) {
            if (num > max) {
                min = mid;
                mid = max;
                max = num;
            } else if (max > num && num > mid) {
                min = mid;
                mid = num;
            } else if (mid > num && num > min) {
                min = num;
            }
        }

        return (int) (min != Long.MIN_VALUE ? min : max);
    }
}
