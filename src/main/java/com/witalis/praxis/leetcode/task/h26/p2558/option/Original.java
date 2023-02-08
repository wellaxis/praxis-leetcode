package com.witalis.praxis.leetcode.task.h26.p2558.option;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * ID: 2558
 * Name: Take Gifts From the Richest Pile
 * URL: <a href="https://leetcode.com/problems/take-gifts-from-the-richest-pile/">Take Gifts From the Richest Pile</a>
 * Note: the real test solution (code writing with timing)
 */
@Slf4j
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Original {
    private int[] gifts;
    private int seconds;

    public Long process() {
        return pickGifts(gifts, seconds);
    }

    public long pickGifts(int[] gifts, int k) {
        if (gifts == null || k <= 0) return 0;

        Comparator<Integer> intComparator = Integer::compareTo;
        Queue<Integer> heap = new PriorityQueue<>(intComparator.reversed());
        for (int gift : gifts) heap.offer(gift);

        while (k > 0) {
            int gift = heap.poll();
            heap.offer((int) Math.floor(Math.sqrt(gift)));
            k--;
        }

        return heap.stream().mapToLong(Integer::longValue).sum();
    }
}
