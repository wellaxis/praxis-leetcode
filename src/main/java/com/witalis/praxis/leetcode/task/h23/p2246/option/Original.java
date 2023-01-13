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
 * Note: the real test solution (code writing with timing)
 */
@Slf4j
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Original {
    private int[] parents;
    private String labels;

    public Integer process() {
        return longestPath(parents, labels);
    }

    public int longestPath(int[] parent, String s) {
        if (parent == null || parent.length == 0 || s.isEmpty()) return 0;

        Map<Integer, List<Integer>> tree = new HashMap<>();
        for (int child = 1; child < parent.length; child++) {
            tree.putIfAbsent(parent[child], new ArrayList<>());
            tree.get(parent[child]).add(child);
        }

        int[] maxPath = {0};
        int path = recursivePath(tree, s, 0, maxPath);

        return Math.max(path, maxPath[0]);
    }

    private int recursivePath(Map<Integer, List<Integer>> tree, String labels, int node, int[] maxPath) {
        if (!tree.containsKey(node)) return 1;

        int[] maxes = new int[] {0, 0};
        List<Integer> subNodes = tree.getOrDefault(node, Collections.emptyList());
        Queue<Integer> maxPaths = new PriorityQueue<>((o1, o2) -> o2 - o1);
        for (int subNode : subNodes) {
            int subPath = recursivePath(tree, labels, subNode, maxPath);
            boolean equality = labels.charAt(node) == labels.charAt(subNode);
            if (!equality) {
                maxPaths.offer(subPath);
            }
        }
        for (int i = 0; i < 2; i++) {
            if (!maxPaths.isEmpty()) maxes[i] = maxPaths.poll();
        }

        maxPath[0] = Math.max(maxPath[0], maxes[0] + maxes[1] + 1);

        return maxes[0] + 1;
    }
}
