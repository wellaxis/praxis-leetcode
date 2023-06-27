package com.witalis.praxis.leetcode.task.h4.p373.option;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

/**
 * ID: 373
 * Name: Find K Pairs with Smallest Sums
 * URL: <a href="https://leetcode.com/problems/find-k-pairs-with-smallest-sums/">Find K Pairs with Smallest Sums</a>
 * Note: the best found solution (external programming)
 */
@Slf4j
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Solution {
    private int[] numbers1;
    private int[] numbers2;
    private int pairs;

    public List<List<Integer>> process() {
        return kSmallestPairs(numbers1, numbers2, pairs);
    }

    public List<List<Integer>> kSmallestPairs(int[] nums1, int[] nums2, int k) {
        List<List<Integer>> pairs = new ArrayList<>();
        PriorityQueue<int[]> heap = new PriorityQueue<>((a1, a2) -> a1[0] + a1[1] - a2[0] - a2[1]);

        for (int i = 0; i < nums1.length && i < k; i++) {
            heap.add(new int[]{nums1[i], nums2[0], 0});
        }

        for (int i = 0; i < k && !heap.isEmpty(); i++) {
            int[] curr = heap.poll();
            pairs.add(List.of(curr[0], curr[1]));
            if (curr[2] < nums2.length - 1)
                heap.add(new int[]{curr[0], nums2[curr[2] + 1], curr[2] + 1});
        }

        return pairs;
    }
}
