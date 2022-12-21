package com.witalis.praxis.leetcode.task.h9.p886.option;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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

        final Map<Integer, List<Integer>> relations = new HashMap<>();
        for (int[] relation : dislikes) {
            // forward
            relations.computeIfPresent(relation[0], (i, l) -> {l.add(relation[1]); return l;});
            relations.putIfAbsent(relation[0], new ArrayList<>(List.of(relation[1])));
            // backward
            relations.computeIfPresent(relation[1], (i, l) -> {l.add(relation[0]); return l;});
            relations.putIfAbsent(relation[1], new ArrayList<>(List.of(relation[0])));
        }

        return false;
    }
}
