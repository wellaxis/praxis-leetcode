package com.witalis.praxis.leetcode.task.h6.p502.option;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.util.*;

/**
 * ID: 502
 * Name: IPO
 * URL: <a href="https://leetcode.com/problems/ipo/">IPO</a>
 * Note: the real test solution (code writing with timing)
 */
@Slf4j
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Original {
    private int projects;
    private int capital;
    private int[] profits;
    private int[] capitals;

    public Integer process() {
        return findMaximizedCapital(projects, capital, profits, capitals);
    }

    public int findMaximizedCapital(int k, int w, int[] profits, int[] capital) {
        if (k < 0 || w < 0 || profits == null || capital == null) return 0;

        final int n = profits.length;
        final int[][] data = new int[n][2];
        for (int i = 0; i < n; i++) {
            data[i] = new int[] {capital[i], profits[i]};
        }

        final Queue<Integer> queue = new PriorityQueue<>(Collections.reverseOrder());
        Arrays.sort(data, Comparator.comparingInt(a -> a[0]));

        int i = 0;
        for (; i < n; i++) {
            if (data[i][0] <= w) {
                queue.offer(data[i][1]);
            } else {
                if (k > 0 && !queue.isEmpty()) {
                    w += queue.peek();
                    queue.poll();
                    k--;
                    i--;
                }
            }
        }

        while (!queue.isEmpty() && k > 0) {
            w += queue.peek();
            queue.poll();
            k--;
        }

        return w;
    }
}
