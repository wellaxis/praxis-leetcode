package com.witalis.praxis.leetcode.task.h16.p1584.option;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * ID: 1584
 * Name: Min Cost to Connect All Points
 * URL: <a href="https://leetcode.com/problems/min-cost-to-connect-all-points/">Min Cost to Connect All Points</a>
 * Note: the best found solution (external programming)
 */
@Slf4j
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Solution {
    private int[][] points;

    public Integer process() {
        return minCostConnectPoints(points);
    }

    class DSU {
        int[] parent;
        int[] rank;

        public DSU(int n) {
            parent = new int[n];
            rank = new int[n];
            for (int i = 0; i < n; i++) {
                parent[i] = i;
            }
        }

        public int find(int x) {
            if (parent[x] != x)
                parent[x] = find(parent[x]);
            return parent[x];
        }

        public boolean union(int x, int y) {
            int px = find(x), py = find(y);
            if (px == py) return false;
            if (rank[px] > rank[py])
                parent[py] = px;
            else if (rank[py] > rank[px])
                parent[px] = py;
            else {
                parent[py] = px;
                rank[px]++;
            }
            return true;
        }
    }

    public int minCostConnectPoints(int[][] points) {
        int n = points.length;
        DSU dsu = new DSU(n);

        int min = 0;
        int connected = 1;
        Queue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(a -> a[0]));

        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                int cost = Math.abs(points[i][0] - points[j][0]) + Math.abs(points[i][1] - points[j][1]);
                pq.offer(new int[]{cost, i, j});
            }
        }

        while (!pq.isEmpty()) {
            int[] edge = pq.poll();
            if (dsu.union(edge[1], edge[2])) {
                min += edge[0];
                connected++;
            } else if (connected == n)
                return min;
        }

        return min;
    }
}
