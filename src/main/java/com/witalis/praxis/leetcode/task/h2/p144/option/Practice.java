package com.witalis.praxis.leetcode.task.h2.p144.option;

import com.witalis.praxis.leetcode.task.h2.p144.content.TreeNode;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.util.*;

/**
 * ID: 144
 * Name: Binary Tree Preorder Traversal
 * URL: https://leetcode.com/problems/binary-tree-preorder-traversal/
 * Note: try to find the better solution (without timing)
 */
@Slf4j
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Practice {
    private static boolean recursiveMode = true;
    private TreeNode root;

    public List<Integer> process() {
        return preorderTraversal(root);
    }

    // preorder: root -> left -> right
    public List<Integer> preorderTraversal(TreeNode root) {
        return recursiveMode
            ? preorderRecursive(root)
            : preorderIterative(root);
    }

    /**
     * Traversal: DFS, depth-first preorder
     * Algorithm: recursive
     * Complexity: time -> O(N), space -> O(logN) when balanced, O(N) worst
     */
    private List<Integer> preorderRecursive(TreeNode root) {
        if (root == null) return Collections.emptyList();

        List<Integer> preorder = new ArrayList<>();
        recursiveTraversal(root, preorder);
        return preorder;
    }

    private void recursiveTraversal(TreeNode node, List<Integer> traversal) {
        if (node == null) return;

        traversal.add(node.val);
        recursiveTraversal(node.left, traversal);
        recursiveTraversal(node.right, traversal);
    }

    /**
     * Traversal: DFS, depth-first preorder
     * Algorithm: iterative
     * Complexity: time -> O(N), space -> O(logN) when balanced, O(N) worst
     */
    private List<Integer> preorderIterative(TreeNode root) {
        if (root == null) return Collections.emptyList();

        List<Integer> traversal = new ArrayList<>();
        Deque<TreeNode> stack = new ArrayDeque<>();

        stack.push(root);
        while (!stack.isEmpty()) {
            TreeNode node = stack.pop();
            traversal.add(node.val);

            if (node.right != null) stack.push(node.right);
            if (node.left != null) stack.push(node.left);
        }

        return traversal;
    }
}
