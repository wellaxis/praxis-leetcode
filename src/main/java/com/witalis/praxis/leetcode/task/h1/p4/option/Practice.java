package com.witalis.praxis.leetcode.task.h1.p4.option;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

/**
 * ID: 4
 * Name: Median of Two Sorted Arrays
 * URL: <a href="https://leetcode.com/problems/median-of-two-sorted-arrays/">Median of Two Sorted Arrays</a>
 * Note: try to find the better solution (without timing)
 */
@Slf4j
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Practice {
    private int[] numbers1;
    private int[] numbers2;

    public Double process() {
        return findMedianSortedArrays(numbers1, numbers2);
    }

    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        var len1 = nums1.length;
        var len2 = nums2.length;

        if (len1 == 0 && len2 == 0) return 0;
        if (len1 == 0) return findMedianSortedArray(nums2);
        if (len2 == 0) return findMedianSortedArray(nums1);

        if (len1 > len2) {
            return findMedianSortedArrays(nums2, nums1);
        }

        int min = 0;
        int max = len1;

        while (min <= max) {
            int index1 = ((max - min) / 2) + min;
            int index2 = (len1 + len2 + 1) / 2 - index1;

            if (index1 > 0 && nums1[index1 - 1] > nums2[index2]) {
                max = index1 - 1;
            } else if (index1 < len1 && nums2[index2 - 1] > nums1[index1]) {
                min = index1 + 1;
            } else {

                int leftHalfEnd;
                if (index1 == 0) {
                    leftHalfEnd = nums2[index2 - 1];
                } else if (index2 == 0) {
                    leftHalfEnd = nums1[index1 - 1];
                } else {
                    leftHalfEnd = Math.max(nums1[index1 - 1], nums2[index2 - 1]);
                }

                if ((len1 + len2) % 2 != 0) {
                    return leftHalfEnd;
                }

                int rightHalfStart;
                if (index1 == len1) {
                    rightHalfStart = nums2[index2];
                } else if (index2 == len2) {
                    rightHalfStart = nums1[index1];
                } else {
                    rightHalfStart = Math.min(nums1[index1], nums2[index2]);
                }

                return (leftHalfEnd + rightHalfStart) / 2.0;
            }
        }
        return -1;
    }

    public double findMedianSortedArray(int[] nums) {
        if (nums.length == 0) return 0;
        if (nums.length == 1) return nums[0];
        if (nums.length % 2 == 0) {
            return (double) (nums[nums.length/2 - 1] + nums[nums.length/2]) / 2;
        } else {
            return nums[nums.length/2];
        }
    }
}
