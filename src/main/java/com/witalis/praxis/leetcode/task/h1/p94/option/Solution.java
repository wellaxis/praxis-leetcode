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
 * Note: the best found solution (external programming)
 */
@Slf4j
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Solution {
    private TreeNode root;

    public List<Integer> process() {
        return inorderTraversal(root);
    }

    // inorder: left -> root -> right
    public List<Integer> inorderTraversal(TreeNode root) {
        return inorderMorris(root);
    }

    /**
     * Traversal: DFS, depth-first inorder
     * Algorithm: Morris (without recursion & stack)
     * Complexity: time -> O(N), space -> O(1)
     */
    public List<Integer> inorderMorris(TreeNode root) {
        List<Integer> result = new ArrayList<>();

        if (root == null) return result;

        TreeNode current = root;
        TreeNode predecessor;

        while (current != null) {
            if (current.left == null) {
                // step 1
                result.add(current.val);
                current = current.right;
            } else {
                // step 2
                // find the inorder predecessor of current node
                predecessor = current.left;
                while (predecessor.right != null && predecessor.right != current) {
                    predecessor = predecessor.right;
                }

                // make current as right child of its inorder predecessor
                if (predecessor.right == null) {
                    predecessor.right = current;
                    current = current.left;
                } else {
                    // the only difference from preorder traversal
                    result.add(current.val);
                    // revert the changes & restore the original tree
                    // i.e., fix the right child of predecessor
                    predecessor.right = null;
                    current = current.right;
                }
            }
        }

        return result;
    }
}
