package com.witalis.praxis.leetcode.task.h20.p1962.option;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * ID: 1962
 * Name: Remove Stones to Minimize the Total
 * URL: <a href="https://leetcode.com/problems/remove-stones-to-minimize-the-total/">Remove Stones to Minimize the Total</a>
 * Note: try to find the better solution (without timing)
 */
@Slf4j
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Practice {
    private int[] piles;
    private int operations;

    public Integer process() {
        return minStoneSum(piles, operations);
    }

    public int minStoneSum(int[] piles, int k) {
        if (piles == null || piles.length == 0 || k <= 0) return 0;

        Queue<Integer> heap = new PriorityQueue<>(Comparator.reverseOrder());
        heap.addAll(Arrays.stream(piles).boxed().toList());
        while (k-- > 0) heap.offer((heap.poll() + 1) / 2);

        return heap.stream().mapToInt(Integer::intValue).sum();
    }
}
