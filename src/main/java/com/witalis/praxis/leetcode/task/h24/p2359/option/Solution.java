package com.witalis.praxis.leetcode.task.h24.p2359.option;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.util.Arrays;

/**
 * ID: 2359
 * Name: Find Closest Node to Given Two Nodes
 * URL: <a href="https://leetcode.com/problems/find-closest-node-to-given-two-nodes/">Find Closest Node to Given Two Nodes</a>
 * Note: the best found solution (external programming)
 */
@Slf4j
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Solution {
    private int[] edges;
    private int node1;
    private int node2;

    public Integer process() {
        return closestMeetingNode(edges, node1, node2);
    }

    public int closestMeetingNode(int[] edges, int node1, int node2) {
        int n = edges.length;

        int[] dist1 = new int[n];
        Arrays.fill(dist1, -1);

        int[] dist2 = new int[n];
        Arrays.fill(dist2, -1);

        dist1[node1] = 0;
        dist2[node2] = 0;

        int dist = 0;
        int i = node1;
        do {
            dist1[i] = dist++;
            i = edges[i];
        } while (i != -1 && dist1[i] == -1);

        dist = 0;
        i = node2;
        do {
            dist2[i] = dist++;
            i = edges[i];
        } while (i != -1 && dist2[i] == -1);

        int ans = -1;
        int mini = Integer.MAX_VALUE;
        for (i = 0; i < n; i++) {
            if (dist1[i] == -1 || dist2[i] == -1) continue;

            var max = Math.max(dist1[i], dist2[i]);
            if (mini > max) {
                mini = max;
                ans = i;
            }
        }

        return ans;
    }
}
