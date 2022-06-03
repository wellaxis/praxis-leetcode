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
 * Note: the real test solution (code writing with timing)
 */
@Slf4j
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Original {
    private Node root;

    public Node process() {
        return connect(root);
    }

    public Node connect(Node root) {
        return recursiveConnect(root, 0, new HashMap<>());
    }

    private Node recursiveConnect(Node node, int level, Map<Integer, Node> pointers) {
        if (node == null) return node;

        pointers.putIfAbsent(level, null);
        node.next = pointers.get(level);
        pointers.put(level, node);

        if (node.right != null) recursiveConnect(node.right, level + 1, pointers);
        if (node.left != null) recursiveConnect(node.left, level + 1, pointers);

        return node;
    }
}
