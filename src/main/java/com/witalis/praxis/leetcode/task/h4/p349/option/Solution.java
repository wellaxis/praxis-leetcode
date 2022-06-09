package com.witalis.praxis.leetcode.task.h4.p349.option;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.util.*;

/**
 * ID: 349
 * Name: Intersection of Two Arrays
 * URL: <a href="https://leetcode.com/problems/intersection-of-two-arrays/">Intersection of Two Arrays</a>
 * Note: the best found solution (external programming)
 */
@Slf4j
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Solution {
    private int[] numbers1;
    private int[] numbers2;

    public int[] process() {
        return intersection(numbers1, numbers2);
    }

    public int[] intersection(int[] nums1, int[] nums2) {
        HashSet<Integer> set1 = new HashSet<>();
        for (Integer n : nums1) set1.add(n);

        Set<Integer> set2 = new HashSet<>();
        for (Integer n : nums2) set2.add(n);

        set1.retainAll(set2);

        int[] output = new int[set1.size()];
        int index = 0;
        for (int num : set1) output[index++] = num;

        return output;
    }
}
