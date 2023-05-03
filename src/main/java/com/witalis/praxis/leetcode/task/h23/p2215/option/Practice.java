package com.witalis.praxis.leetcode.task.h23.p2215.option;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.util.*;
import java.util.stream.Collectors;

/**
 * ID: 2215
 * Name: Find the Difference of Two Arrays
 * URL: <a href="https://leetcode.com/problems/find-the-difference-of-two-arrays/">Find the Difference of Two Arrays</a>
 * Note: try to find the better solution (without timing)
 */
@Slf4j
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Practice {
    private int[] numbers1;
    private int[] numbers2;

    public List<List<Integer>> process() {
        return findDifference(numbers1, numbers2);
    }

    public List<List<Integer>> findDifference(int[] nums1, int[] nums2) {
        if (nums1 == null || nums2 == null) return Collections.emptyList();

        final Set<Integer> set1 = Arrays.stream(nums1).boxed().collect(Collectors.toSet());
        final Set<Integer> set2 = Arrays.stream(nums2).boxed().collect(Collectors.toSet());

        Arrays.stream(nums1).forEach(set2::remove);
        Arrays.stream(nums2).forEach(set1::remove);

        return List.of(set1.stream().toList(), set2.stream().toList());
    }
}
