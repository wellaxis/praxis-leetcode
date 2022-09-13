package com.witalis.praxis.leetcode.task.h6.p589.option;

import com.witalis.praxis.leetcode.task.h6.p589.content.Node;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.util.*;

/**
 * ID: 589
 * Name: N-ary Tree Preorder Traversal
 * URL: <a href="https://leetcode.com/problems/n-ary-tree-preorder-traversal/">N-ary Tree Preorder Traversal</a>
 * Note: the real test solution (code writing with timing)
 */
@Slf4j
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Original {
    private Node root;

    public Original(Node root) {
        this.root = root;
    }

    public List<Integer> process() {
        return preorder(root);
    }

    private List<Integer> values = new ArrayList<>();

    public List<Integer> preorder(Node root) {
        if (root == null) return Collections.emptyList();

        recursivePreorder(root);

        return values;
    }

    private void recursivePreorder(Node node) {
        if (node == null) return;

        values.add(node.val);

        for (Node child : node.children) recursivePreorder(child);
    }
}
