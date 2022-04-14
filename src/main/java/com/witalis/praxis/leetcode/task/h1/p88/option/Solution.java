package com.witalis.praxis.leetcode.task.h1.p88.option;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

/**
 * ID: 88
 * Name: Merge Sorted Array
 * URL: <a href="https://leetcode.com/problems/merge-sorted-array/">Merge Sorted Array</a>
 * Note: the best found solution (external programming)
 */
@Slf4j
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Solution {
    private int[] nums1;
    private int m;
    private int[] nums2;
    private int n;

    public int[] process() {
        merge(nums1, m, nums2, n);
        return nums1;
    }

    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int i = m - 1;
        int j = n - 1;
        int k = m + n - 1;

        while (k >= 0) {
            if (j < 0 || (i >= 0 && nums1[i] > nums2[j]))
                nums1[k--] = nums1[i--];
            else
                nums1[k--] = nums2[j--];
        }
    }
}
