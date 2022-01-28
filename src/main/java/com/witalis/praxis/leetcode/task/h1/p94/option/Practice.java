package com.witalis.praxis.leetcode.task.h1.p94.option;

import com.witalis.praxis.leetcode.task.h1.p94.content.TreeNode;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.util.*;

/**
 * ID: 94
 * Name: Binary Tree Inorder Traversal
 * URL: https://leetcode.com/problems/binary-tree-inorder-traversal/
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
        return inorderTraversal(root);
    }

    // inorder: left -> root -> right
    public List<Integer> inorderTraversal(TreeNode root) {
        return recursiveMode
            ? inorderRecursive(root)
            : inorderIterative(root);
    }

    /**
     * Traversal: DFS, depth-first inorder
     * Algorithm: recursive
     * Complexity: time -> O(N), space -> O(logN) when balanced, O(N) worst
     */
    private List<Integer> inorderRecursive(TreeNode root) {
        if (root == null) return Collections.emptyList();

        var inorder = new ArrayList<Integer>();
        recursiveTraversal(root, inorder);
        return inorder;
    }

    private void recursiveTraversal(TreeNode node, List<Integer> traversal) {
        if (node == null) return;

        recursiveTraversal(node.left, traversal);
        traversal.add(node.val);
        recursiveTraversal(node.right, traversal);
    }

    /**
     * Traversal: DFS, depth-first inorder
     * Algorithm: iterative
     * Complexity: time -> O(N), space -> O(logN) when balanced, O(N) worst
     */
    private List<Integer> inorderIterative(TreeNode root) {
        if (root == null) return Collections.emptyList();

        List<Integer> traversal = new ArrayList<>();
        Deque<TreeNode> stack = new ArrayDeque<>();

        TreeNode node = root;
        while (node != null || !stack.isEmpty()) {
            while (node != null) {
                stack.push(node);
                node = node.left;
            }
            node = stack.pop();
            traversal.add(node.val);
            node = node.right;
        }

        return traversal;
    }
}
