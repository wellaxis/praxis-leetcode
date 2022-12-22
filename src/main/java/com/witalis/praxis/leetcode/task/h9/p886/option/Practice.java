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
 * Note: try to find the better solution (without timing)
 */
@Slf4j
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Practice {
    private int number;
    private int[][] dislikes;

    public Practice(int number, int[][] dislikes) {
        this.number = number;
        this.dislikes = dislikes;
    }

    public Boolean process() {
        return possibleBipartition(number, dislikes);
    }

    enum Color {
        INIT, RED, BLUE;

        public static Color negate(Color color) {
            return switch (color) {
                case RED -> BLUE;
                case BLUE -> RED;
                default -> null;
            };
        }
    }

    private final Map<Integer, Set<Integer>> relations = new HashMap<>();
    private Color[] colors;

    public boolean possibleBipartition(int n, int[][] dislikes) {
        if (n < 0 || dislikes == null) return false;
        if (dislikes.length == 0) return true;

        for (int[] relation : dislikes) {
            final int forward = relation[0] - 1;
            final int backward = relation[1] - 1;
            // forward
            relations.computeIfPresent(forward, (i, l) -> {l.add(backward); return l;});
            relations.putIfAbsent(forward, new HashSet<>(Set.of(backward)));
            // backward
            relations.computeIfPresent(backward, (i, l) -> {l.add(forward); return l;});
            relations.putIfAbsent(backward, new HashSet<>(Set.of(forward)));
        }

        colors = new Color[n];
        Arrays.fill(colors, Color.INIT);
        for (int i = 0; i < n; i++)
            if (relations.get(i) != null && colors[i] == Color.INIT && !dfs(i, Color.RED))
                return false;

        return true;
    }

    private boolean dfs(int index, Color color) {
        if (colors[index] != Color.INIT) return color == colors[index];

        colors[index] = color;
        for (var nextIndex : relations.get(index))
            if (!dfs(nextIndex, Color.negate(color)))
                return false;

        return true;
    }
}
