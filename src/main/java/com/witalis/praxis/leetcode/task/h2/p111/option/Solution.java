package com.witalis.praxis.leetcode.task.h2.p111.option;

import com.witalis.praxis.leetcode.task.h2.p111.content.TreeNode;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

/**
 * ID: 111
 * Name: Minimum Depth of Binary Tree
 * URL: https://leetcode.com/problems/minimum-depth-of-binary-tree/
 * Note: the best found solution (external programming)
 */
@Slf4j
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Solution {
    private TreeNode root;

    public Integer process() {
        return minDepth(root);
    }

    public int minDepth(TreeNode root) {
        if (root == null) return 0;

        int left = minDepth(root.left);
        int right = minDepth(root.right);
        if (left == 0 || right == 0) {
            // has at most 1 child
            return 1 + Math.max(left, right);
        } else {
            // has 2 children
            return 1 + Math.min(left, right);
        }
    }
}
