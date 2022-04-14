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
 * Note: try to find the better solution (without timing)
 */
@Slf4j
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Practice {
    private TreeNode root;

    public Integer process() {
        return minDepth(root);
    }

    public int minDepth(TreeNode root) {
        if (root == null) return 0;

        int issue = 0x0;
        if (root.left != null) issue |= 0x1;
        if (root.right != null) issue |= 0x2;

        return switch (issue) {
            case 0 -> 1;
            case 1 -> 1 + minDepth(root.left);
            case 2 -> 1 + minDepth(root.right);
            case 3 -> 1 + Math.min(minDepth(root.left), minDepth(root.right));
            default -> throw new IllegalStateException("Unexpected issue: " + issue);
        };
    }
}
