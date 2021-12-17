package com.witalis.praxis.leetcode.task.p94.option;

import com.witalis.praxis.leetcode.task.p94.content.TreeNode;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.util.*;

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

        return recursiveTraversal(root, new ArrayList<>());
    }

    private List<Integer> recursiveTraversal(TreeNode node, List<Integer> traversal) {
        if (node == null) return traversal;

        recursiveTraversal(node.left, traversal);
        traversal.add(node.val);
        recursiveTraversal(node.right, traversal);

        return traversal;
    }

    /**
     * Traversal: DFS, depth-first inorder
     * Algorithm: iterative
     * Complexity: time -> O(N), space -> O(logN) when balanced, O(N) worst
     */
    private List<Integer> inorderIterative(TreeNode root) {
        if (root == null) return Collections.emptyList();

        List<Integer> traversal = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();

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
