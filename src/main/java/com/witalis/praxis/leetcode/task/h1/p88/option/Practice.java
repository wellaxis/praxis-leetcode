package com.witalis.praxis.leetcode.task.h1.p88.option;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

/**
 * ID: 88
 * Name: Merge Sorted Array
 * URL: https://leetcode.com/problems/merge-sorted-array/
 * Note: try to find the better solution (without timing)
 */
@Slf4j
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Practice {
    private int[] nums1;
    private int m;
    private int[] nums2;
    private int n;

    public int[] process() {
        merge(nums1, m, nums2, n);
        return nums1;
    }

    public void merge(int[] nums1, int m, int[] nums2, int n) {
        while (m > 0 || n > 0) {
            if (n == 0) {
                break;
            } else if (m == 0) {
                nums1[m + n - 1] = nums2[n - 1];
                n--;
            } else {
                if (nums2[n - 1] > nums1[m - 1]) {
                    nums1[m + n - 1] = nums2[n - 1];
                    n--;
                } else {
                    nums1[m + n - 1] = nums1[m - 1];
                    m--;
                }
            }
        }
    }
}
