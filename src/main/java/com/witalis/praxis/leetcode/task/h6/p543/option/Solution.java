package com.witalis.praxis.leetcode.task.h6.p543.option;

import com.witalis.praxis.leetcode.task.h6.p543.content.TreeNode;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

/**
 * ID: 543
 * Name: Diameter of Binary Tree
 * URL: <a href="https://leetcode.com/problems/diameter-of-binary-tree/">Diameter of Binary Tree</a>
 * Note: the best found solution (external programming)
 */
@Slf4j
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Solution {
    private TreeNode root;

    public Integer process() {
        return diameterOfBinaryTree(root);
    }

    public int diameterOfBinaryTree(TreeNode root) {
        return dfs(root)[0];
    }

    private int[] dfs(TreeNode node) {
        if (node == null) return new int[] {0, 0};

        int[] left = dfs(node.left);
        int[] right = dfs(node.right);

        int best = Math.max(left[1] + right[1], Math.max(left[0], right[0]));
        int height = 1 + Math.max(left[1], right[1]);

        return new int[] {best, height};
    }
}
