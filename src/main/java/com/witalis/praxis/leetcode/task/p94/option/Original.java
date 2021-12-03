package com.witalis.praxis.leetcode.task.p94.option;

import com.witalis.praxis.leetcode.task.p94.content.TreeNode;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * ID: 94
 * Name: Binary Tree Inorder Traversal
 * URL: https://leetcode.com/problems/binary-tree-inorder-traversal/
 * Note: the real test solution (code writing with timing)
 */
@Slf4j
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Original {
    private TreeNode root;

    public List<Integer> process() {
        return inorderTraversal(root);
    }

    public List<Integer> inorderTraversal(TreeNode root) {
        if (root == null) return Collections.emptyList();

        return recursiveTraversal(root, new ArrayList<>());
    }

    private List<Integer> recursiveTraversal(TreeNode node, List<Integer> values) {
        if (node == null) return values;

        recursiveTraversal(node.left, values);
        values.add(node.val);
        recursiveTraversal(node.right, values);

        return values;
    }
}
