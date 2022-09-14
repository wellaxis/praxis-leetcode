package com.witalis.praxis.leetcode.task.h6.p590.option;

import com.witalis.praxis.leetcode.task.h6.p590.content.Node;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * ID: 590
 * Name: N-ary Tree Postorder Traversal
 * URL: <a href="https://leetcode.com/problems/n-ary-tree-postorder-traversal/">N-ary Tree Postorder Traversal</a>
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
        return postorder(root);
    }

    private List<Integer> values = new ArrayList<>();

    public List<Integer> postorder(Node root) {
        if (root == null) return Collections.emptyList();

        recursivePostorder(root);

        return values;
    }

    private void recursivePostorder(Node node) {
        if (node == null) return;

        for (Node child : node.children) recursivePostorder(child);

        values.add(node.val);
    }
}
