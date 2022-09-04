package com.witalis.praxis.leetcode.task.h3.p215.option;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.util.Arrays;

/**
 * ID: 215
 * Name: Kth Largest Element in an Array
 * URL: <a href="https://leetcode.com/problems/kth-largest-element-in-an-array/">Kth Largest Element in an Array</a>
 * Note: the real test solution (code writing with timing)
 */
@Slf4j
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Original {
    private int[] numbers;
    private int index;

    public Integer process() {
        return findKthLargest(numbers, index);
    }

    public int findKthLargest(int[] nums, int k) {
        if (nums == null || nums.length == 0) return 0;
        if (k > nums.length) throw new IllegalArgumentException("Incorrect index k");

        Arrays.sort(nums);
        return nums[nums.length - k];
    }
}
