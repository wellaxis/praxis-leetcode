package com.witalis.praxis.leetcode.task.h24.p2359.option;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.util.HashSet;
import java.util.Set;

/**
 * ID: 2359
 * Name: Find Closest Node to Given Two Nodes
 * URL: <a href="https://leetcode.com/problems/find-closest-node-to-given-two-nodes/">Find Closest Node to Given Two Nodes</a>
 * Note: try to find the better solution (without timing)
 */
@Slf4j
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Practice {
    private int[] edges;
    private int node1;
    private int node2;

    public Integer process() {
        return closestMeetingNode(edges, node1, node2);
    }

    public int closestMeetingNode(int[] edges, int node1, int node2) {
        if (edges == null || edges.length == 0) return -1;
        if (node1 == node2) return node1;

        int n = edges.length;
        int index = -1;

        final boolean[] seen1 = new boolean[n];
        final boolean[] seen2 = new boolean[n];
        seen1[node1] = true;
        seen2[node2] = true;

        boolean move1 = true;
        boolean move2 = true;
        while (move1 || move2) {
            if (move1) {
                int next1 = edges[node1];
                if (next1 == -1 || seen1[next1]) {
                    move1 = false;
                } else if (seen2[next1]) {
                    index = next1;
                } else {
                    seen1[next1] = true;
                    node1 = next1;
                }
            }
            if (move2) {
                int next2 = edges[node2];
                if (next2 == -1 || seen2[next2]) {
                    move2 = false;
                } else if (seen1[next2]) {
                    index = index < 0 ? next2 : Math.min(index, next2);
                } else {
                    seen2[next2] = true;
                    node2 = next2;
                }
            }
            if (index >= 0) return index;
        }

        return -1;
    }
}
