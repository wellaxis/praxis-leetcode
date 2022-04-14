package com.witalis.praxis.leetcode.task.h2.p111.option;

import com.witalis.praxis.leetcode.task.h2.p111.content.TreeNode;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

/**
 * ID: 111
 * Name: Minimum Depth of Binary Tree
 * URL: <a href="https://leetcode.com/problems/minimum-depth-of-binary-tree/">Minimum Depth of Binary Tree</a>
 * Note: the real test solution (code writing with timing)
 */
@Slf4j
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Original {
    private TreeNode root;

    public Integer process() {
        return minDepth(root);
    }

    public int minDepth(TreeNode root) {
        if (root == null) return 0;
        return recursiveDepth(root, 1);
    }

    private int recursiveDepth(TreeNode node, int depth) {
        if (node == null) return depth;

        if (node.left == null && node.right == null) {
            return depth;
        } else if (node.left == null) {
            return recursiveDepth(node.right, depth + 1);
        } else if (node.right == null) {
            return recursiveDepth(node.left, depth + 1);
        } else {
            return Math.min(
                recursiveDepth(node.left, depth + 1),
                recursiveDepth(node.right, depth + 1)
            );
        }
    }
}
