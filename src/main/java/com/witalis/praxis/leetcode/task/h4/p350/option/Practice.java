package com.witalis.praxis.leetcode.task.h4.p350.option;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.util.*;

/**
 * ID: 350
 * Name: Intersection of Two Arrays II
 * URL: <a href="https://leetcode.com/problems/intersection-of-two-arrays-ii/">Intersection of Two Arrays II</a>
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
        return intersect(numbers1, numbers2);
    }

    public int[] intersect(int[] nums1, int[] nums2) {
        if (nums1 == null || nums2 == null || nums1.length == 0 || nums2.length == 0) return new int[] {};

        Map<Integer, Integer> quantity = new HashMap<>();
        List<Integer> intersection = new ArrayList<>();

        for (int num : nums1) {
            quantity.put(num, quantity.getOrDefault(num, 0) + 1);
        }
        for (int num : nums2) {
            quantity.put(num, quantity.getOrDefault(num, 0) - 1);
            if (quantity.get(num) >= 0) intersection.add(num);
        }

        return intersection.stream().mapToInt(Integer::intValue).toArray();
    }
}
