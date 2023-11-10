package com.witalis.praxis.leetcode.task.h18.p1743.option;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * ID: 1743
 * Name: Restore the Array From Adjacent Pairs
 * URL: <a href="https://leetcode.com/problems/restore-the-array-from-adjacent-pairs/">Restore the Array From Adjacent Pairs</a>
 * Note: try to find the better solution (without timing)
 */
@Slf4j
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Practice {
    private int[][] pairs;

    public int[] process() {
        return restoreArray(pairs);
    }

    public int[] restoreArray(int[][] adjacentPairs) {
        Map<Integer, List<Integer>> graph = new HashMap<>();
        List<Integer> array = new ArrayList<>();

        for (int[] edge : adjacentPairs) {
            graph.computeIfAbsent(edge[0], e -> new ArrayList<>()).add(edge[1]);
            graph.computeIfAbsent(edge[1], e -> new ArrayList<>()).add(edge[0]);
        }

        for (Map.Entry<Integer, List<Integer>> entry : graph.entrySet()) {
            if (entry.getValue().size() == 1) {
                array.add(entry.getKey());
                array.add(entry.getValue().get(0));
                break;
            }
        }

        while (array.size() < graph.size()) {
            int lastElement = array.get(array.size() - 1);
            int secondLastElement = array.get(array.size() - 2);

            List<Integer> count = graph.get(lastElement);

            if (count.get(0) != secondLastElement) {
                array.add(count.get(0));
            } else {
                array.add(count.get(1));
            }
        }

        return array.stream().mapToInt(i -> i).toArray();
    }
}
