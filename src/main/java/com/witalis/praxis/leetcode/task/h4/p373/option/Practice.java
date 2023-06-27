package com.witalis.praxis.leetcode.task.h4.p373.option;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.util.*;

/**
 * ID: 373
 * Name: Find K Pairs with Smallest Sums
 * URL: <a href="https://leetcode.com/problems/find-k-pairs-with-smallest-sums/">Find K Pairs with Smallest Sums</a>
 * Note: try to find the better solution (without timing)
 */
@Slf4j
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Practice {
    private int[] numbers1;
    private int[] numbers2;
    private int pairs;

    public List<List<Integer>> process() {
        return kSmallestPairs(numbers1, numbers2, pairs);
    }

    record Pair (int index1, int index2, int sum) {}

    public List<List<Integer>> kSmallestPairs(int[] nums1, int[] nums2, int k) {
        if (nums1 == null || nums2 == null || k <= 0) return Collections.emptyList();

        final int n = nums1.length;
        final int m = nums2.length;

        final Comparator<Pair> byMinSum = Comparator.comparingInt(p -> p.sum);
        final Queue<Pair> heap = new PriorityQueue<>(byMinSum);

        for (int i = 0; i < k && i < n; i++)
            heap.offer(new Pair(i, 0, nums1[i] + nums2[0]));

        final List<List<Integer>> pairs = new ArrayList<>();

        while (k-- > 0 && !heap.isEmpty()) {
            final Pair pair = heap.poll();

            pairs.add(List.of(nums1[pair.index1], nums2[pair.index2]));
            if (pair.index2 + 1 < m)
                heap.offer(new Pair(pair.index1, pair.index2 + 1, nums1[pair.index1] + nums2[pair.index2 + 1]));
        }

        return pairs;
    }
}
