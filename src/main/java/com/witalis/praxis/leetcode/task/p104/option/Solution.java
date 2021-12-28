package com.witalis.praxis.leetcode.task.p104.option;

import com.witalis.praxis.leetcode.task.p104.content.TreeNode;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

/**
 * ID: 104
 * Name: Maximum Depth of Binary Tree
 * URL: https://leetcode.com/problems/maximum-depth-of-binary-tree/
 * Note: the best found solution (external programming)
 */
@Slf4j
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Solution {
    private TreeNode root;

    public Integer process() {
        return maxDepth(root);
    }

    public int maxDepth(TreeNode root) {
        if (root == null) return 0;

        return Math.max(
            maxDepth(root.left),
            maxDepth(root.right)
        ) + 1;
    }
}
