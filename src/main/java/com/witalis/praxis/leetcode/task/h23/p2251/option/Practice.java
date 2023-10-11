package com.witalis.praxis.leetcode.task.h23.p2251.option;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * ID: 2251
 * Name: Number of Flowers in Full Bloom
 * URL: <a href="https://leetcode.com/problems/number-of-flowers-in-full-bloom/">Number of Flowers in Full Bloom</a>
 * Note: try to find the better solution (without timing)
 */
@Slf4j
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Practice {
    private int[][] flowers;
    private int[] people;

    public int[] process() {
        return fullBloomFlowers(flowers, people);
    }

    public int[] fullBloomFlowers(int[][] flowers, int[] people) {
        if (flowers == null || people == null) return new int[0];

        int n = people.length;
        final int[] answer = new int[n];

        final Comparator<int[]> byMinPeriod = Comparator.comparingInt(e -> e[0]);
        final Comparator<int[]> byMinPosition = Comparator.comparingInt(e -> e[1]);
        final Queue<int[]> heap = new PriorityQueue<>(byMinPeriod.thenComparing(byMinPosition));

        for (int i = 0; i < n; i++)
            heap.offer(new int[] {people[i], i});

        for (int[] flower : flowers) {
            heap.offer(new int[] {flower[0], Integer.MIN_VALUE});
            heap.offer(new int[] {flower[1], Integer.MAX_VALUE});
        }

        int counter = 0;
        while (n > 0 && !heap.isEmpty()) {
            int[] event = heap.poll();

            switch (event[1]) {
                case Integer.MIN_VALUE -> counter++;
                case Integer.MAX_VALUE -> counter--;
                default -> {
                    answer[event[1]] = counter;
                    n--;
                }
            }
        }

        return answer;
    }
}
