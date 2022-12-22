package com.witalis.praxis.leetcode.task.h9.p886.option;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.util.*;

/**
 * ID: 886
 * Name: Possible Bipartition
 * URL: <a href="https://leetcode.com/problems/possible-bipartition/">Possible Bipartition</a>
 * Note: the real test solution (code writing with timing)
 */
@Slf4j
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Original {
    private int number;
    private int[][] dislikes;

    public Boolean process() {
        return possibleBipartition(number, dislikes);
    }

    public boolean possibleBipartition(int n, int[][] dislikes) {
        if (n < 0 || dislikes == null) return false;
        if (dislikes.length == 0) return true;

        final Map<Integer, List<Integer>> relations = new HashMap<>();
        for (int[] relation : dislikes) {
            // forward
            relations.computeIfPresent(relation[0], (i, l) -> {l.add(relation[1]); return l;});
            relations.putIfAbsent(relation[0], new ArrayList<>(List.of(relation[1])));
            // backward
            relations.computeIfPresent(relation[1], (i, l) -> {l.add(relation[0]); return l;});
            relations.putIfAbsent(relation[1], new ArrayList<>(List.of(relation[0])));
        }

        int[] colors = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            if (relations.get(i) == null) continue;
            if (colors[i] == 0) {
                boolean success = dfs(relations, colors, i, 1);
                if (!success) return false;
            }
        }

        return true;
    }

    private static boolean dfs(Map<Integer, List<Integer>> relations, int[] colors, int index, int color) {
        if (colors[index] != 0) return color == colors[index];

        int len = relations.get(index).size();
        colors[index] = color;
        for (int i = 0; i < len; i++) {
            int nextIndex = relations.get(index).get(i);
            boolean success = dfs(relations, colors, nextIndex, -color);
            if (!success) return false;
        }

        return true;
    }
}
