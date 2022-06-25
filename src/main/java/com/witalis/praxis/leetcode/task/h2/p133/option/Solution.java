package com.witalis.praxis.leetcode.task.h2.p133.option;

import com.witalis.praxis.leetcode.task.h2.p133.content.Node;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 * ID: 133
 * Name: Clone Graph
 * URL: <a href="https://leetcode.com/problems/clone-graph/">Clone Graph</a>
 * Note: the real test solution (code writing with timing)
 */
@Slf4j
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Solution {
    private Node node;

    public Solution(Node node) {
        this.node = node;
    }

    public Node process() {
        return cloneGraph(node);
    }

    private Map<Node, Node> visited = new HashMap<>();

    public Node cloneGraph(Node node) {
        if (node == null) {
            return node;
        }

        if (visited.containsKey(node)) {
            return visited.get(node);
        }

        Node cloneNode = new Node(node.val, new ArrayList());
        visited.put(node, cloneNode);

        for (Node neighbor: node.neighbors) {
            cloneNode.neighbors.add(cloneGraph(neighbor));
        }

        return cloneNode;
    }
}
