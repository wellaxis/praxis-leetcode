package com.witalis.praxis.leetcode.task.h2.p145.option;

import com.witalis.praxis.leetcode.task.h2.p145.content.TreeNode;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.util.*;

/**
 * ID: 145
 * Name: Binary Tree Postorder Traversal
 * URL: <a href="https://leetcode.com/problems/binary-tree-postorder-traversal/">Binary Tree Postorder Traversal</a>
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
        return postorderTraversal(root);
    }

    // postorder: left -> right -> root
    public List<Integer> postorderTraversal(TreeNode root) {
        return recursiveMode
            ? postorderRecursive(root)
            : postorderIterative(root);
    }

    /**
     * Traversal: DFS, depth-first postorder
     * Algorithm: recursive
     * Complexity: time -> O(N), space -> O(logN) when balanced, O(N) worst
     */
    private List<Integer> postorderRecursive(TreeNode root) {
        if (root == null) return Collections.emptyList();

        List<Integer> postorder = new ArrayList<>();
        recursiveTraversal(root, postorder);
        return postorder;
    }

    private void recursiveTraversal(TreeNode node, List<Integer> traversal) {
        if (node == null) return;

        recursiveTraversal(node.left, traversal);
        recursiveTraversal(node.right, traversal);
        traversal.add(node.val);
    }

    /**
     * Traversal: DFS, depth-first postorder
     * Algorithm: iterative
     * Complexity: time -> O(N), space -> O(logN) when balanced, O(N) worst
     */
    private List<Integer> postorderIterative(TreeNode root) {
        if (root == null) return Collections.emptyList();

        List<Integer> traversal = new ArrayList<>();
        Deque<TreeNode> stack = new ArrayDeque<>();

        TreeNode node = root;
        while (true) {
            while (node != null) {
                stack.push(node);
                stack.push(node);
                node = node.left;
            }

            if (stack.isEmpty()) return traversal;

            node = stack.pop();
            if (!stack.isEmpty() && stack.peek() == node) {
                node = node.right;
            } else {
                traversal.add(node.val);
                node = null;
            }
        }
    }
}
