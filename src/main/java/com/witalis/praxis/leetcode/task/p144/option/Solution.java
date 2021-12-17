package com.witalis.praxis.leetcode.task.p144.option;

import com.witalis.praxis.leetcode.task.p144.content.TreeNode;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.util.*;

/**
 * ID: 144
 * Name: Binary Tree Preorder Traversal
 * URL: https://leetcode.com/problems/binary-tree-preorder-traversal/
 * Note: the best found solution (external programming)
 */
@Slf4j
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Solution {
    private TreeNode root;

    public List<Integer> process() {
        return preorderTraversal(root);
    }

    // preorder: root -> left -> right
    public List<Integer> preorderTraversal(TreeNode root) {
        return preorderMorris(root);
    }

    /**
     * Traversal: depth-first preorder
     * Algorithm: Morris (without recursion & stack)
     * Complexity: time -> O(N), space -> O(1)
     */
    public List<Integer> preorderMorris(TreeNode root) {
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
                    // the only difference from inorder traversal
                    result.add(current.val);
                    predecessor.right = current;
                    current = current.left;
                } else {
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
