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
 * Note: the real test solution (code writing with timing)
 */
@Slf4j
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Original {
    private int[] numbers1;
    private int[] numbers2;
    private int pairs;

    public List<List<Integer>> process() {
        return kSmallestPairs(numbers1, numbers2, pairs);
    }

    record Pair (int number1, int number2) {}

    public List<List<Integer>> kSmallestPairs(int[] nums1, int[] nums2, int k) {
        if (nums1 == null || nums2 == null || k <= 0) return Collections.emptyList();

        final Comparator<Pair> byMinSum = Comparator.comparingInt(p -> p.number1 + p.number2);
        final Queue<Pair> heap = new PriorityQueue<>(byMinSum);

        for (int num1 : nums1)
            for (int num2 : nums2)
                heap.offer(new Pair(num1, num2));

        final List<List<Integer>> pairs = new ArrayList<>();
        while (k-- > 0 && !heap.isEmpty()) {
            final Pair pair = heap.poll();
            pairs.add(List.of(pair.number1, pair.number2));
        }

        return pairs;
    }
}
