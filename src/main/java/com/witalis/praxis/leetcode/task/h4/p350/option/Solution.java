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
        return intersect(numbers1, numbers2);
    }

    public int[] intersect(int[] nums1, int[] nums2) {
        HashMap<Integer, Integer> data = new HashMap<>();
        for (int i = 0; i < nums1.length; i++) {
            if (!data.containsKey(nums1[i])) {
                data.put(nums1[i], 1);
            } else {
                data.put(nums1[i], data.get(nums1[i]) + 1);
            }
        }

        List<Integer> res = new LinkedList<>();
        for (int i = 0; i < nums2.length; i++) {
            if (data.containsKey(nums2[i]) && data.get(nums2[i]) != 0) {
                res.add(nums2[i]);
                data.put(nums2[i], data.get(nums2[i]) - 1);
            }
        }

        int[] result = new int[res.size()];
        int i = 0;
        for (Integer j : res) {
            result[i++] = j;
        }

        return result;
    }
}
