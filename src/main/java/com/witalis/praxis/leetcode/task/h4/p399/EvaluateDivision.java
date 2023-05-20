package com.witalis.praxis.leetcode.task.h4.p399;

import com.witalis.praxis.leetcode.task.LeetCodeTask;
import com.witalis.praxis.leetcode.task.h4.p399.option.*;
import com.witalis.praxis.leetcode.utils.LeetCode;
import com.witalis.praxis.leetcode.utils.TaskDifficulty;
import com.witalis.praxis.leetcode.utils.TaskRevision;

import lombok.extern.slf4j.Slf4j;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

import static com.witalis.praxis.leetcode.utils.TaskTag.*;

@Slf4j
@LeetCode(
    id = 399,
    description = "Evaluate Division",
    difficulty = TaskDifficulty.MEDIUM,
    tags = {ARRAY, DEPTH_FIRST_SEARCH, BREADTH_FIRST_SEARCH, UNION_FIND, GRAPH, SHORTEST_PATH}
)
public class EvaluateDivision extends LeetCodeTask<double[]> {
    public static final int LEN = 20;
    public static final int SIZE = 5;
    public static final int VALUE = 20;

    private List<List<String>> equations;
    private double[] values;
    private List<List<String>> queries;

    public static final String INFORMATION = """

        Description:
            You are given an array of variable pairs equations and an array of real numbers values,
                where equations[i] = [Ai, Bi] and values[i] represent the equation Ai / Bi = values[i].
                Each Ai or Bi is a string that represents a single variable.

            You are also given some queries, where queries[j] = [Cj, Dj] represents
                the j^th query where you must find the answer for Cj / Dj = ?.

            Return the answers to all queries. If a single answer cannot be determined, return -1.0.

            Note: The input is always valid. You may assume that evaluating the queries
                will not result in division by zero and that there is no contradiction.

        Example:
            Input: equations = [["a","b"],["b","c"]], values = [2.0,3.0], queries = [["a","c"],["b","a"],["a","e"],["a","a"],["x","x"]]
            Output: [6.00000,0.50000,-1.00000,1.00000,-1.00000]
            Explanation:
                Given: a / b = 2.0, b / c = 3.0
                queries are: a / c = ?, b / a = ?, a / e = ?, a / a = ?, x / x = ?
                return: [6.0, 0.5, -1.0, 1.0, -1.0 ]""";

    public EvaluateDivision(int id, String description, TaskRevision revision) {
        super(id, description, revision);
        initialization();
    }

    private void initialization() {
        final var random = ThreadLocalRandom.current();

        int len = random.nextInt(1, LEN + 1);
        this.equations = new ArrayList<>();
        this.values = new double[len];
        for (int i = 0; i < len; i++) {
            List<String> equation = new ArrayList<>();
            equation.add(generate());
            equation.add(generate());
            equations.add(equation);
            values[i] = random.nextInt(1, LEN + 1) / 10D;
        }

        len = random.nextInt(1, LEN + 1);
        this.queries = new ArrayList<>();
        for (int i = 0; i < len; i++) {
            List<String> query = new ArrayList<>();
            query.add(generate());
            query.add(generate());
            queries.add(query);
        }

        log.info("Equations: {}", equations);
        log.info("Values: {}", Arrays.toString(values));
        log.info("Queries: {}", queries);
    }

    private String generate() {
        final var random = ThreadLocalRandom.current();

        int size = random.nextInt(1, SIZE + 1);
        var letters = new StringBuilder();
        char letter;
        for (int i = 0; i < size; i++) {
            if (random.nextInt(0, 4) == 0) {
                letter = (char) random.nextInt('1', '1' + 9);
            } else {
                letter = (char) random.nextInt('a', 'a' + size);
            }
            letters.append(letter);
        }

        return letters.toString();
    }

    @Override
    protected String getInformation() {
        return INFORMATION;
    }

    // time = 884 ms
    @Override
    protected double[] original() {
        var original = new Original(equations, values, queries);
        return original.process();
    }

    // time = 786 ms
    @Override
    protected double[] practice() {
        var practice = new Practice(equations, values, queries);
        return practice.process();
    }

    // time = 705 ms
    @Override
    protected double[] solution() {
        var solution = new Solution(equations, values, queries);
        return solution.process();
    }
}
