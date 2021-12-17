package com.witalis.praxis.leetcode.task.p145.option;

import com.witalis.praxis.leetcode.task.p145.content.TreeNode;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.util.*;

/**
 * ID: 145
 * Name: Binary Tree Postorder Traversal
 * URL: https://leetcode.com/problems/binary-tree-postorder-traversal/
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

        return recursiveTraversal(root, new ArrayList<>());
    }

    private List<Integer> recursiveTraversal(TreeNode node, List<Integer> traversal) {
        if (node == null) return traversal;

        recursiveTraversal(node.left, traversal);
        recursiveTraversal(node.right, traversal);
        traversal.add(node.val);

        return traversal;
    }

    /**
     * Traversal: DFS, depth-first postorder
     * Algorithm: iterative
     * Complexity: time -> O(N), space -> O(logN) when balanced, O(N) worst
     */
    private List<Integer> postorderIterative(TreeNode root) {
        if (root == null) return Collections.emptyList();

        List<Integer> traversal = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();

        stack.push(root);
        TreeNode previous = null;
        TreeNode current;

        while (!stack.isEmpty()) {
            current = stack.peek();
            if (previous == null || previous.left == current || previous.right == current) {
                if (current.left != null) {
                    stack.push(current.left);
                } else if (current.right != null) {
                    stack.push(current.right);
                } else {
                    stack.pop();
                    traversal.add(current.val);
                }
            } else if (current.left == previous) {
                if (current.right != null) {
                    stack.push(current.right);
                } else {
                    stack.pop();
                    traversal.add(current.val);
                }
            } else if (current.right == previous) {
                stack.pop();
                traversal.add(current.val);
            }

            previous = current;
        }

        return traversal;
    }
}
