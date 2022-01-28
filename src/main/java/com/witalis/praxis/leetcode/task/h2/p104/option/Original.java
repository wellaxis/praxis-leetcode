package com.witalis.praxis.leetcode.task.h2.p104.option;

import com.witalis.praxis.leetcode.task.h2.p104.content.TreeNode;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

/**
 * ID: 104
 * Name: Maximum Depth of Binary Tree
 * URL: https://leetcode.com/problems/maximum-depth-of-binary-tree/
 * Note: the real test solution (code writing with timing)
 */
@Slf4j
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Original {
    private TreeNode root;

    public Integer process() {
        return maxDepth(root);
    }

    public int maxDepth(TreeNode root) {
        return recursiveDepth(root, 0);
    }

    private int recursiveDepth(TreeNode node, int level) {
        if (node == null) return level;

        return Math.max(
            recursiveDepth(node.left, level + 1),
            recursiveDepth(node.right, level + 1)
        );
    }
}
