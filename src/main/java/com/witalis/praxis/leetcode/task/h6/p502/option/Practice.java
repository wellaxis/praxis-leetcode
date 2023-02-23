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
 * Note: try to find the better solution (without timing)
 */
@Slf4j
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Practice {
    private int projects;
    private int capital;
    private int[] profits;
    private int[] capitals;

    public Integer process() {
        return findMaximizedCapital(projects, capital, profits, capitals);
    }

    record Project(int capital, int profit) {}

    public int findMaximizedCapital(int k, int w, int[] profits, int[] capital) {
        if (k < 0 || w < 0 || profits == null || capital == null) return 0;

        final int n = profits.length;
        final Project[] projects = new Project[n];
        for (int i = 0; i < n; i++) {
            projects[i] = new Project(capital[i], profits[i]);
        }

        final Queue<Integer> queue = new PriorityQueue<>(Collections.reverseOrder());
        Arrays.sort(projects, Comparator.comparingInt(Project::capital));

        for (int i = 0; i < n; i++) {
            if (projects[i].capital <= w) {
                queue.offer(projects[i].profit);
            } else {
                if (k > 0 && !queue.isEmpty()) {
                    w += queue.poll();
                    k--;
                    i--;
                }
            }
        }

        while (!queue.isEmpty() && k > 0) {
            w += queue.poll();
            k--;
        }

        return w;
    }
}
