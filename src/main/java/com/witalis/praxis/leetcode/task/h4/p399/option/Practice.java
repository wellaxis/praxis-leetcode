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
 * Note: try to find the better solution (without timing)
 */
@Slf4j
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Practice {
    private List<List<String>> equations;
    private double[] values;
    private List<List<String>> queries;

    public Practice(List<List<String>> equations, double[] values, List<List<String>> queries) {
        this.equations = equations;
        this.values = values;
        this.queries = queries;
    }

    public double[] process() {
        return calcEquation(queries, values, queries);
    }

    private Map<String, Map<String, Double>> expressions = new HashMap<>();

    public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {
        if (equations == null || values == null || queries == null || queries.isEmpty()) return new double[0];

        final int n1 = equations.size();
        for (int i = 0; i < n1; i++) {
            final List<String> equation = equations.get(i);

            expressions.putIfAbsent(equation.get(0), new HashMap<>());
            expressions.putIfAbsent(equation.get(1), new HashMap<>());
            expressions.get(equation.get(0)).put(equation.get(1), values[i]);
            expressions.get(equation.get(1)).put(equation.get(0), 1 / values[i]);
        }

        final int n2 = queries.size();
        final double[] calculations = new double[n2];
        Arrays.fill(calculations, -1);

        for (int i = 0; i < n2; i++) {
            final List<String> query = queries.get(i);
            if (expressions.containsKey(query.get(0)) && expressions.containsKey(query.get(1))) {
                double result = dfs(new HashSet<>(), query.get(0), query.get(1), 1);
                if (calculations[i] != -1) {
                    expressions.get(query.get(0)).put(query.get(1), result);
                    expressions.get(query.get(1)).put(query.get(0), 1 / result);
                }
                calculations[i] = result;
            }
        }

        return calculations;
    }

    private double dfs(Set<String> seen, String source, String target, double value) {
        if (source.equals(target)) return value;
        if (seen.contains(source)) return -1;

        seen.add(source);
        for (String interim : expressions.get(source).keySet()) {
            double result = dfs(seen, interim, target, value * expressions.get(source).get(interim));
            if (result != -1) return result;
        }

        return -1;
    }
}
