package com.witalis.praxis.leetcode.task.h4.p349.option;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.util.HashSet;
import java.util.Set;

/**
 * ID: 349
 * Name: Intersection of Two Arrays
 * URL: <a href="https://leetcode.com/problems/intersection-of-two-arrays/">Intersection of Two Arrays</a>
 * Note: try to find the better solution (without timing)
 */
@Slf4j
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Practice {
    private int[] numbers1;
    private int[] numbers2;

    public int[] process() {
        return intersection(numbers1, numbers2);
    }

    public int[] intersection(int[] nums1, int[] nums2) {
        if (nums1 == null || nums2 == null || nums1.length == 0 || nums2.length == 0) return new int[] {};

        Set<Integer> intersection1 = new HashSet<>();
        Set<Integer> intersection2 = new HashSet<>();

        for (int num : nums1) intersection1.add(num);
        for (int num : nums2) intersection2.add(num);

        intersection1.removeIf(num -> !intersection2.contains(num));

        return intersection1.stream().mapToInt(Integer::intValue).toArray();
    }
}
