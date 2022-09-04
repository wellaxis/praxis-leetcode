package com.witalis.praxis.leetcode.task.h3.p215.option;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

/**
 * ID: 215
 * Name: Kth Largest Element in an Array
 * URL: <a href="https://leetcode.com/problems/kth-largest-element-in-an-array/">Kth Largest Element in an Array</a>
 * Note: the best found solution (external programming)
 */
@Slf4j
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Solution {
    private int[] numbers;
    private int index;

    public Integer process() {
        return findKthLargest(numbers, index);
    }

    public int findKthLargest(int[] nums, int k) {
        int[] hash = new int[20001];

        for (int num : nums) hash[num + 10000]++;

        int kCount = 0;
        for (int i = 20000; i >= 0; i--) {
            if (hash[i] != 0) kCount += hash[i];
            if (kCount >= k) return i - 10000;
        }

        return -1;
    }
}
