package com.witalis.praxis.leetcode.task.h20.p1962.option;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * ID: 1962
 * Name: Remove Stones to Minimize the Total
 * URL: <a href="https://leetcode.com/problems/remove-stones-to-minimize-the-total/">Remove Stones to Minimize the Total</a>
 * Note: the real test solution (code writing with timing)
 */
@Slf4j
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Original {
    private int[] piles;
    private int operations;

    public Integer process() {
        return minStoneSum(piles, operations);
    }

    public int minStoneSum(int[] piles, int k) {
        if (piles == null || piles.length == 0 || k <= 0) return 0;

        Comparator<Integer> minElement = Integer::compareTo;
        Queue<Integer> heap = new PriorityQueue<>(minElement.reversed());

        for (int pile: piles) heap.offer(pile);
        while (k > 0) {
            int stones = heap.poll();
            heap.offer(stones - (int) Math.floor(stones / 2));
            k--;
        }

        return heap.stream().mapToInt(Integer::intValue).sum();
    }
}
