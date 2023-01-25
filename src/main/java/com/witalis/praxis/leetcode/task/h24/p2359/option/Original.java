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
 * Note: the real test solution (code writing with timing)
 */
@Slf4j
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Original {
    private int[] edges;
    private int node1;
    private int node2;

    public Integer process() {
        return closestMeetingNode(edges, node1, node2);
    }

    public int closestMeetingNode(int[] edges, int node1, int node2) {
        if (edges == null || edges.length == 0 || node1 < 0 || node2 < 0) return -1;
        if (node1 == node2) return node1;

        Set<Integer> nodes1 = new HashSet<>();
        nodes1.add(node1);
        Set<Integer> nodes2 = new HashSet<>();
        nodes2.add(node2);

        int index = -1;
        boolean move1 = true;
        boolean move2 = true;
        while (move1 || move2) {
            if (move1) {
                int next1 = edges[node1];
                if (next1 == -1 || nodes1.contains(next1)) {
                    move1 = false;
                } else {
                    if (nodes2.contains(next1)) {
                        index = next1;
                    } else {
                        nodes1.add(next1);
                        node1 = next1;
                    }
                }
            }
            if (move2) {
                int next2 = edges[node2];
                if (next2 == -1 || nodes2.contains(next2)) {
                    move2 = false;
                } else {
                    if (nodes1.contains(next2)) {
                        index = index < 0 ? next2 : Math.min(index, next2);
                    } else {
                        nodes2.add(next2);
                        node2 = next2;
                    }
                }
            }
            if (index >= 0) return index;
        }

        return -1;
    }
}
