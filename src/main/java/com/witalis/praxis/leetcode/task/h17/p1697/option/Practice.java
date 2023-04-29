package com.witalis.praxis.leetcode.task.h17.p1697.option;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.util.Arrays;
import java.util.Comparator;

/**
 * ID: 1697
 * Name: Checking Existence of Edge Length Limited Paths
 * URL: <a href="https://leetcode.com/problems/checking-existence-of-edge-length-limited-paths/">Checking Existence of Edge Length Limited Paths</a>
 * Note: try to find the better solution (without timing)
 */
@Slf4j
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Practice {
    private int nodes;
    private int[][] edges;
    private int[][] queries;

    public boolean[] process() {
        return distanceLimitedPathsExist(nodes, edges, queries);
    }

    static class UnionFind {
        private final int[] ids;
        private final int[] ranks;
        private final int[] limits;

        public UnionFind(int n) {
            this.ids = new int[n];
            this.ranks = new int[n];
            this.limits = new int[n];

            for (var i = 0; i < n; ++i)
                ids[i] = i;
        }

        private int find(int p) {
            while (p != ids[p])
                p = ids[p];

            return p;
        }

        private int find(int p, int limit) {
            while (p != ids[p] && limits[p] < limit)
                p = ids[p];

            return p;
        }

        public void union(int p, int q, int limit) {
            final int pId = find(p);
            final int qId = find(q);

            if (pId == qId) return;

            if (ranks[pId] < ranks[qId]) {
                ids[pId] = qId;
                limits[pId] = limit;
            } else if (ranks[pId] > ranks[qId]) {
                ids[qId] = pId;
                limits[qId] = limit;
            } else {
                ids[qId] = pId;
                limits[qId] = limit;
                ranks[pId]++;
            }
        }

        public boolean connected(int p, int q, int limit) {
            return find(p, limit) == find(q, limit);
        }
    }

    public boolean[] distanceLimitedPathsExist(int n, int[][] edgeList, int[][] queries) {
        if (n < 2 || edgeList == null || queries == null) return new boolean[0];

        final UnionFind unionFind = new UnionFind(n);
        Arrays.sort(edgeList, Comparator.comparingInt(a -> a[2]));

        for (final int[] edge : edgeList)
            unionFind.union(edge[0], edge[1], edge[2]);

        final int len = queries.length;
        final boolean[] answer = new boolean[len];

        for (var i = 0; i < queries.length; ++i)
            answer[i] = unionFind.connected(queries[i][0], queries[i][1], queries[i][2]);

        return answer;
    }
}
