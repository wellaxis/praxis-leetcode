package com.witalis.praxis.leetcode.task.h23.p2215.option;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * ID: 2215
 * Name: Find the Difference of Two Arrays
 * URL: <a href="https://leetcode.com/problems/find-the-difference-of-two-arrays/">Find the Difference of Two Arrays</a>
 * Note: the best found solution (external programming)
 */
@Slf4j
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Solution {
    private int[] numbers1;
    private int[] numbers2;

    public List<List<Integer>> process() {
        return findDifference(numbers1, numbers2);
    }

    public List<List<Integer>> findDifference(int[] nums1, int[] nums2) {
        int first = 0;
        int second = 0;

        final List<Integer> n1 = new ArrayList<>();
        final List<Integer> n2 = new ArrayList<>();

        Arrays.sort(nums1);
        Arrays.sort(nums2);
        while (first < nums1.length && second < nums2.length) {
            if (nums1[first] == nums2[second]) {
                second++;
                first++;
                continue;
            }

            if (nums1[first] < nums2[second]) {
                if (first == 0 || nums1[first - 1] != nums1[first]) {
                    n1.add(nums1[first]);
                }
                first++;
                continue;
            }

            if (second == 0 || nums2[second - 1] != nums2[second]) {
                n2.add(nums2[second]);
            }
            second++;
        }

        if (first < nums1.length) {
            for (int i = first;  i < nums1.length; i++) {
                if (i == 0 || nums1[i - 1] != nums1[i]) {
                    n1.add(nums1[i]);
                }
            }
        }

        if (second < nums2.length) {
            for (int i = second;  i < nums2.length; i++) {
                if (i == 0 || nums2[i - 1] != nums2[i]) {
                    n2.add(nums2[i]);
                }
            }
        }

        return List.of(n1, n2);
    }
}
