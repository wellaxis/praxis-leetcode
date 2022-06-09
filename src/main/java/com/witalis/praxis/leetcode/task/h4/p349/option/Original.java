package com.witalis.praxis.leetcode.task.h4.p349.option;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * ID: 349
 * Name: Intersection of Two Arrays
 * URL: <a href="https://leetcode.com/problems/intersection-of-two-arrays/">Intersection of Two Arrays</a>
 * Note: the real test solution (code writing with timing)
 */
@Slf4j
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Original {
    private int[] numbers1;
    private int[] numbers2;

    public int[] process() {
        return intersection(numbers1, numbers2);
    }

    public int[] intersection(int[] nums1, int[] nums2) {
        if (nums1 == null || nums2 == null || nums1.length == 0 || nums2.length == 0) return new int[] {};

        Set<Integer> intersection = new HashSet<>();

        Arrays.sort(nums1);
        Arrays.sort(nums2);

        int n1 = 0;
        int n2 = 0;
        while (n1 < nums1.length && n2 < nums2.length) {
            if (nums1[n1] == nums2[n2]) {
                intersection.add(nums1[n1]);
                n1++;
                n2++;
                while (n1 < nums1.length && nums1[n1] == nums1[n1 - 1]) n1++;
                while (n2 < nums2.length && nums2[n2] == nums2[n2 - 1]) n2++;
            } else {
                if (nums1[n1] > nums2[n2]) {
                    n2++;
                } else {
                    n1++;
                }
            }
        }

        return intersection.stream().mapToInt(Integer::intValue).toArray();
    }
}
