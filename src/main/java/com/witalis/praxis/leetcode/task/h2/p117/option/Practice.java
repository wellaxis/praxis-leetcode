package com.witalis.praxis.leetcode.task.h2.p117.option;

import com.witalis.praxis.leetcode.task.h2.p117.content.Node;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.util.*;

/**
 * ID: 117
 * Name: Populating Next Right Pointers in Each Node II
 * URL: <a href="https://leetcode.com/problems/populating-next-right-pointers-in-each-node-ii/">Populating Next Right Pointers in Each Node II</a>
 * Note: try to find the better solution (without timing)
 */
@Slf4j
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Practice {
    private Node root;

    public Practice(Node root) {
        this.root = root;
    }

    public Node process() {
        return connect(root);
    }

    private Map<Integer, Node> pointers = new HashMap<>();

    public Node connect(Node root) {
        return recursiveConnect(root, 0);
    }

    private Node recursiveConnect(Node node, int level) {
        if (node == null) return node;

        pointers.putIfAbsent(level, null);
        node.next = pointers.get(level);
        pointers.put(level, node);

        if (node.right != null) recursiveConnect(node.right, level + 1);
        if (node.left != null) recursiveConnect(node.left, level + 1);

        return node;
    }
}
