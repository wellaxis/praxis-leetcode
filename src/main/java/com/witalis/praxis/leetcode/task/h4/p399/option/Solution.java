package com.witalis.praxis.leetcode.task.h4.p399.option;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.util.*;

/**
 * ID: 399
 * Name: Evaluate Division
 * URL: <a href="https://leetcode.com/problems/evaluate-division/">Evaluate Division</a>
 * Note: the best found solution (external programming)
 */
@Slf4j
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Solution {
    private List<List<String>> equations;
    private double[] values;
    private List<List<String>> queries;

    public double[] process() {
        return calcEquation(queries, values, queries);
    }

    public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {
        double[] ans = new double[queries.size()];

        Map<String, Map<String, Double>> graph = new HashMap<>();
        for (int i = 0; i < equations.size(); ++i) {
            final String a = equations.get(i).get(0);
            final String b = equations.get(i).get(1);
            graph.putIfAbsent(a, new HashMap<>());
            graph.putIfAbsent(b, new HashMap<>());
            graph.get(a).put(b, values[i]);
            graph.get(b).put(a, 1.0 / values[i]);
        }

        for (int i = 0; i < queries.size(); ++i) {
            final String a = queries.get(i).get(0);
            final String c = queries.get(i).get(1);
            if (!graph.containsKey(a) || !graph.containsKey(c))
                ans[i] = -1.0;
            else
                ans[i] = dfs(graph, a, c, new HashSet<>());
        }

        return ans;
    }

    private double dfs(Map<String, Map<String, Double>> graph, final String a, final String c, Set<String> seen) {
        if (a.equals(c)) return 1.0;

        seen.add(a);
        for (final String b : graph.get(a).keySet()) {
            if (seen.contains(b)) continue;

            final double res = dfs(graph, b, c, seen);
            if (res > 0) return graph.get(a).get(b) * res;
        }

        return -1.0;
    }
}
