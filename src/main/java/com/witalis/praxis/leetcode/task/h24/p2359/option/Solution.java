package com.witalis.praxis.leetcode.task.h24.p2359.option;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

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
        return -1;
    }
}
