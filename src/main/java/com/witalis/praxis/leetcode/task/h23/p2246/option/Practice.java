package com.witalis.praxis.leetcode.task.h23.p2246.option;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.util.*;

/**
 * ID: 2246
 * Name: Longest Path With Different Adjacent Characters
 * URL: <a href="https://leetcode.com/problems/longest-path-with-different-adjacent-characters/">Longest Path With Different Adjacent Characters</a>
 * Note: try to find the better solution (without timing)
 */
@Slf4j
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Practice {
    private int[] parents;
    private String labels;

    public Practice(int[] parents, String labels) {
        this.parents = parents;
        this.labels = labels;
    }

    public Integer process() {
        return longestPath(parents, labels);
    }

    private final Map<Integer, List<Integer>> tree = new HashMap<>();
    private int maxPath = 0;

    public int longestPath(int[] parent, String s) {
        if (parent == null || parent.length == 0 || s == null || s.isEmpty()) return 0;

        for (int child = 1; child < parent.length; child++)
            tree.computeIfAbsent(parent[child], node -> new LinkedList<>()).add(child);

        return Math.max(recursivePath(s.toCharArray(), 0), maxPath);
    }

    private int recursivePath(char[] labels, int node) {
        if (!tree.containsKey(node)) return 1;

        final int[] maxes = new int[] {0, 0};
        final Queue<Integer> maxPaths = new PriorityQueue<>(Comparator.reverseOrder());
        for (final int subNode : tree.get(node)) {
            int subPath = recursivePath(labels, subNode);
            if (labels[node] != labels[subNode]) maxPaths.offer(subPath);
        }
        for (int i = 0; i < 2; i++)
            if (!maxPaths.isEmpty())
                maxes[i] = maxPaths.poll();

        maxPath = Math.max(maxPath, maxes[0] + maxes[1] + 1);

        return maxes[0] + 1;
    }
}
