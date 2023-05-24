package com.witalis.praxis.leetcode.task.h26.p2542.option;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.util.*;

/**
 * ID: 2542
 * Name: Maximum Subsequence Score
 * URL: <a href="https://leetcode.com/problems/maximum-subsequence-score/">Maximum Subsequence Score</a>
 * Note: try to find the better solution (without timing)
 */
@Slf4j
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Practice {
    private int[] numbers1;
    private int[] numbers2;
    private int quantity;

    public Long process() {
        return maxScore(numbers1, numbers2, quantity);
    }

    record Item(int value2, int value1, int index) {}

    public long maxScore(int[] nums1, int[] nums2, int k) {
        if (nums1 == null || nums2 == null || k <= 0) return 0L;

        long score = 0L;

        final int n = nums1.length;
        final int m = nums2.length;

        if (n != m) return score;

        final Comparator<Item> byMaxValue = Comparator.comparingInt(i -> i.value2);
        final Comparator<Item> byMinIndex = Comparator.comparingInt(i -> i.index);

        final List<Item> items = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            items.add(new Item(nums2[i], nums1[i], i));
        }
        items.sort(byMaxValue.reversed().thenComparing(byMinIndex));

        final Comparator<Integer> byMinValue = Comparator.comparingInt(i -> i);
        final Queue<Integer> buffer = new PriorityQueue<>(k, byMinValue);

        long sum = 0L;
        for (Item item : items) {
            if (--k >= 0) {
                // top elements from nums2
                sum += item.value1;
                buffer.offer(item.value1);
                // calculate max score
                score = sum * item.value2;
            } else {
                // rest nums2 elements
                sum += item.value1 - buffer.poll();
                buffer.offer(item.value1);
                // calculate max score
                score = Math.max(score, sum * item.value2);
            }
        }

        return score;
    }
}
