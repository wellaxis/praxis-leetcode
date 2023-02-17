package com.witalis.praxis.leetcode.task.h8.p783.option;

import com.witalis.praxis.leetcode.task.h8.p783.content.TreeNode;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * ID: 783
 * Name: Minimum Distance Between BST Nodes
 * URL: <a href="https://leetcode.com/problems/minimum-distance-between-bst-nodes/">Minimum Distance Between BST Nodes</a>
 * Note: try to find the better solution (without timing)
 */
@Slf4j
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Practice {
    private TreeNode root;

    public Integer process() {
        return minDiffInBST(root);
    }

    public int minDiffInBST(TreeNode root) {
        if (root == null) return 0;

        int min = Integer.MAX_VALUE;
        final Deque<TreeNode> stack = new ArrayDeque<>();

        TreeNode previous = null;
        while (root != null || !stack.isEmpty()) {
            if (root != null) {
                stack.push(root);
                root = root.left;
            } else {
                TreeNode current = stack.pop();
                if (previous != null) min = Math.min(min, current.val - previous.val);
                previous = current;
                root = current.right;
            }
        }

        return min;
    }
}
