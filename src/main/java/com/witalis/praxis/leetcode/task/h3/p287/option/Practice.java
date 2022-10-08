package com.witalis.praxis.leetcode.task.h3.p287.option;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

/**
 * ID: 287
 * Name: Find the Duplicate Number
 * URL: <a href="https://leetcode.com/problems/find-the-duplicate-number/">Find the Duplicate Number</a>
 * Note: try to find the better solution (without timing)
 */
@Slf4j
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Practice {
    private int[] numbers;

    public Integer process() {
        return findDuplicate(numbers);
    }

    // Floyd's tortoise and hare cycle algorithm
    public int findDuplicate(int[] nums) {
        if (nums == null || nums.length == 0) return 0;

        // find the intersection point of the two runners.
        int tortoise = nums[0];
        int hare = nums[0];
        do {
            tortoise = nums[tortoise];
            hare = nums[nums[hare]];
        } while (tortoise != hare);

        // find the beginning of the cycle.
        tortoise = nums[0];
        while (tortoise != hare) {
            tortoise = nums[tortoise];
            hare = nums[hare];
        }

        return hare;
    }
}
