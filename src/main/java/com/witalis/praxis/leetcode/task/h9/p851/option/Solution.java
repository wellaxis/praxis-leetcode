package com.witalis.praxis.leetcode.task.h9.p851.option;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.util.*;

/**
 * ID: 851
 * Name: Loud and Rich
 * URL: <a href="https://leetcode.com/problems/loud-and-rich/">Loud and Rich</a>
 * Note: the best found solution (external programming)
 */
@Slf4j
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Solution {
    private int[][] richer;
    private int[] quiet;

    public int[] process() {
        return loudAndRich(richer, quiet);
    }

    public Solution(int[][] richer, int[] quiet) {
        this.richer = richer;
        this.quiet = quiet;
    }

    private List<Integer>[] graph;

    public int[] loudAndRich(int[][] richer, int[] quiet) {
        final int N = quiet.length;

        graph = new ArrayList[N];
        int[] answer = new int[N];

        for (int node = 0; node < N; ++node)
            graph[node] = new ArrayList<>();

        for (int[] edge: richer)
            graph[edge[1]].add(edge[0]);

        Arrays.fill(answer, -1);

        for (int node = 0; node < N; ++node)
            dfs(node, quiet, answer);

        return answer;
    }

    public int dfs(int node, int[] quiet, int[] answer) {
        if (answer[node] == -1) {
            answer[node] = node;
            for (int child: graph[node]) {
                int candidate = dfs(child, quiet, answer);
                if (quiet[candidate] < quiet[answer[node]])
                    answer[node] = candidate;
            }
        }
        return answer[node];
    }
}
