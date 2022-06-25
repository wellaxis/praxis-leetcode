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
public class Practice {
    private Node node;

    public Practice(Node node) {
        this.node = node;
    }

    public Node process() {
        return cloneGraph(node);
    }

    private Map<Integer, Node> clones = new HashMap<>();

    public Node cloneGraph(Node node) {
        if (node == null) return node;
        if (clones.containsKey(node.val)) return clones.get(node.val);

        Node clone = new Node(node.val, new ArrayList<>());
        clones.put(node.val, clone);
        for (Node neighbor: node.neighbors) {
            clone.neighbors.add(cloneGraph(neighbor));
        }

        return clone;
    }
}
