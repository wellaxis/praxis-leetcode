package com.witalis.praxis.leetcode.task.h1.p88.option;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.util.Arrays;

/**
 * ID: 88
 * Name: Merge Sorted Array
 * URL: <a href="https://leetcode.com/problems/merge-sorted-array/">Merge Sorted Array</a>
 * Note: the real test solution (code writing with timing)
 */
@Slf4j
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Original {
    private int[] nums1;
    private int m;
    private int[] nums2;
    private int n;

    public int[] process() {
        merge(nums1, m, nums2, n);
        return nums1;
    }

    public void merge(int[] nums1, int m, int[] nums2, int n) {
        System.arraycopy(nums2, 0, nums1, m, n);
        Arrays.sort(nums1);
    }
}
