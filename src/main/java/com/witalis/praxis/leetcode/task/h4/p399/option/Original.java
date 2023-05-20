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
 * Note: the real test solution (code writing with timing)
 */
@Slf4j
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Original {
    private List<List<String>> equations;
    private double[] values;
    private List<List<String>> queries;

    public double[] process() {
        return calcEquation(queries, values, queries);
    }

    public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {
        if (equations == null || values == null || queries == null) return new double[0];

        final Map<String, Map<String, Double>> expressions = new HashMap<>();
        for (int i = 0; i < equations.size(); i++) {
            final List<String> equation = equations.get(i);
            expressions.putIfAbsent(equation.get(0), new HashMap<>());
            expressions.putIfAbsent(equation.get(1), new HashMap<>());
            expressions.get(equation.get(0)).put(equation.get(1), values[i]);
            expressions.get(equation.get(1)).put(equation.get(0), 1 / values[i]);
        }

        final int n = queries.size();
        final double[] calculations = new double[n];
        Arrays.fill(calculations, -1);

        for (int i = 0; i < n; i++) {
            final List<String> query = queries.get(i);
            if (expressions.containsKey(query.get(0)) && expressions.containsKey(query.get(1))) {
                calculations[i] = dfs(expressions, new HashSet<>(), query.get(0), query.get(1), 1);
            }
        }

        return calculations;
    }

    private double dfs(Map<String, Map<String, Double>> expressions, Set<String> seen, String source, String target, double value) {
        if (source.equals(target)) return value;
        if (seen.contains(source)) return -1;

        seen.add(source);
        for (Map.Entry<String, Double> entry : expressions.get(source).entrySet()) {
            double result = dfs(expressions, seen, entry.getKey(), target, value * entry.getValue());
            if (result != -1) return result;
        }

        return -1;
    }
}
