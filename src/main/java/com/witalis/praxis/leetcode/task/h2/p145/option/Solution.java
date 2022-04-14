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
 * Note: the best found solution (external programming)
 */
@Slf4j
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Solution {
    private TreeNode root;

    public List<Integer> process() {
        return postorderTraversal(root);
    }

    // postorder: left -> right -> root
    public List<Integer> postorderTraversal(TreeNode root) {
        return postorderMorris(root);
    }

    /**
     * Traversal: DFS, depth-first postorder
     * Algorithm: Morris (without recursion & stack)
     * Complexity: time -> O(N), space -> O(1)
     */
    public List<Integer> postorderMorris(TreeNode root) {
        List<Integer> result = new ArrayList<>();


        if (root == null) return result;

        // create a dummy node
        TreeNode dummy = new TreeNode(0);
        dummy.left = root;
        TreeNode current = dummy;

        // define some useful variables
        TreeNode parent;
        TreeNode middle;
        TreeNode predecessor;
        TreeNode back;

        // iterating tree nodes
        while (current != null) {
            if (current.left == null) {
                // step 1
                current = current.right;
            } else {
                // step 2
                // find the postorder predecessor of current node
                predecessor = current.left;
                while (predecessor.right != null && predecessor.right != current) {
                    predecessor = predecessor.right;
                }

                // make current as left child of its postorder predecessor
                if (predecessor.right != current) {
                    predecessor.right = current;
                    current = current.left;
                } else {
                    parent = current;
                    middle = current.left;
                    // update new path
                    while (middle != current) {
                        back = middle.right;
                        middle.right = parent;
                        parent = middle;
                        middle = back;
                    }
                    parent = current;
                    middle = predecessor;
                    // correct node link in current path
                    while (middle != current) {
                        result.add(middle.val);
                        back = middle.right;
                        middle.right = parent;
                        parent = middle;
                        middle = back;
                    }
                    // unlink previous bind element
                    predecessor.right = null;
                    // visit to right child
                    current = current.right;
                }
            }
        }

        return result;
    }
}
