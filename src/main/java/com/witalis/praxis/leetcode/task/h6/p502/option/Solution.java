package com.witalis.praxis.leetcode.task.h6.p502.option;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * ID: 502
 * Name: IPO
 * URL: <a href="https://leetcode.com/problems/ipo/">IPO</a>
 * Note: the best found solution (external programming)
 */
@Slf4j
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Solution {
    private int projects;
    private int capital;
    private int[] profits;
    private int[] capitals;

    public Integer process() {
        return findMaximizedCapital(projects, capital, profits, capitals);
    }

    public int findMaximizedCapital(int k, int w, int[] profits, int[] capital) {
        final int n = capital.length;

        final PriorityQueue<int[]> can = new PriorityQueue<>((a,b)-> (b[1] - a[1]));
        final PriorityQueue<int[]> cannot = new PriorityQueue<>(Comparator.comparingInt(a -> a[0]));

        for (int i = 0; i < n; i++) {
            if (profits[i] > 0) {
                if (w >= capital[i]) {
                    can.add(new int[] {capital[i], profits[i]});
                } else {
                    cannot.add(new int[] {capital[i], profits[i]});
                }
            }
        }

        while (k-- > 0) {
            if (can.isEmpty()) break;

            w += can.poll()[1];
            while (!cannot.isEmpty() && w >= cannot.peek()[0]) {
                can.add(cannot.poll());
            }
        }

        return w;
    }
}
