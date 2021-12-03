package com.witalis.praxis.leetcode.task.p4.option;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.util.Arrays;

/**
 * ID: 4
 * Name: Median of Two Sorted Arrays
 * URL: https://leetcode.com/problems/median-of-two-sorted-arrays/
 * Note: the real test solution (code writing with timing)
 */
@Slf4j
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Original {
    private int[] numbers1;
    private int[] numbers2;

    public Double process() {
        return findMedianSortedArrays(numbers1, numbers2);
    }

    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int[] array = new int[nums1.length + nums2.length];
        System.arraycopy(nums1, 0, array, 0, nums1.length);
        System.arraycopy(nums2, 0, array, nums1.length, nums2.length);
        Arrays.sort(array);

        if (array.length == 0) return 0;
        if (array.length == 1) return array[0];
        if (array.length % 2 == 0) {
            return (double) (array[array.length/2 - 1] + array[array.length/2]) / 2;
        } else {
            return (double) array[array.length/2];
        }
    }
}
